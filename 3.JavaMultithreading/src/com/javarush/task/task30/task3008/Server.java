package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Map;

public class Server {
    private static Map<String, Connection> connectionMap = new java.util.concurrent.ConcurrentHashMap< >();

    public static void main(String[] args) throws Exception{
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(port);
        ConsoleHelper.writeMessage("Сервер запущен");

        while (true) {
            try {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            } catch (Exception e) {
                serverSocket.close();
                ConsoleHelper.writeMessage(e.getMessage());
                return;
            }
        }
    }

    static void sendBroadcastMessage(Message message) throws Exception{
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (Exception e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            if (socket != null && socket.getRemoteSocketAddress() != null)
                ConsoleHelper.writeMessage("Установлено соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
            try (Connection connection = new Connection(socket)){
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            } catch (Exception e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message receivedMessage;
            connection.send(new Message(MessageType.NAME_REQUEST));
            receivedMessage = connection.receive();

            if (receivedMessage.getType() != MessageType.USER_NAME || receivedMessage.getData() == "")
                return serverHandshake(connection);
            else {
                for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                    if (!entry.getKey().equals(receivedMessage.getData()))
                        continue;
                    return serverHandshake(connection);
                }
                connectionMap.put(receivedMessage.getData(), connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return receivedMessage.getData();
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (entry.getKey().equals(userName))
                    continue;
                connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException, Exception {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                else
                    ConsoleHelper.writeMessage("Error");
            }
        }
    }
}
