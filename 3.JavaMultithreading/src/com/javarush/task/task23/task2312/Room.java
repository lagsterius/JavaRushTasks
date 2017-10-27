package com.javarush.task.task23.task2312;


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

/**
 * Основной класс программы.
 */
public class Room extends JFrame {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    private Queue<KeyEvent> keyEvents = new PriorityQueue<>(100);

    public static Room game;

    private int initialDelay = 520;
    private int delayStep = 20;

    public static void main(String[] args) {
        game = new Room(20, 20, new Snake(10, 10));
        game.snake.setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }

    public Room(int width, int height, Snake snake) {
        super("Snake");
        this.width = width;
        this.height = height;
        this.snake = snake;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(114, 200, 62));
        setSize(250, 100);
        setVisible(true);

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }
            @Override
            public void focusLost(FocusEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                //do nothing
            }
            public void keyReleased(KeyEvent e) {
                //do nothing
            }
            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(new ImageIcon("C://users//lagster//desktop//snakehead.png").getImage(), 100, snake.getY(), this);
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void run() {
        while (snake.isAlive()) {
            if (hasKeyEvents()) {
                KeyEvent event = getEventFromTop();
                //Если равно символу 'q' - выйти из игры.
                if (event.getKeyChar() == 'q') return;

                //Если "стрелка влево" - сдвинуть фигурку влево
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                    //Если "стрелка вправо" - сдвинуть фигурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                    //Если "стрелка вверх" - сдвинуть фигурку вверх
                else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                    //Если "стрелка вниз" - сдвинуть фигурку вниз
                else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }

            //snake.move();   //двигаем змею
            //print();        //отображаем текущее состояние игры
            //sleep();        //пауза между ходами
        }

        System.out.println("Game Over!");
    }

    public boolean hasKeyEvents() {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() {
        return keyEvents.poll();
    }

/*
    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        int[][] matrix = new int[height + 2][width + 2];

        //Рисуем все кусочки змеи
        ArrayList<SnakeSection> sections = new ArrayList<SnakeSection>(snake.getSections());
        for (SnakeSection snakeSection : sections) {
            matrix[snakeSection.getY() + 1][snakeSection.getX() + 1] = 1;
        }


        //Рисуем голову змеи (4 - если змея мертвая)
        matrix[snake.getY() + 1][snake.getX() + 1] = snake.isAlive() ? 2 : 4;

        //Рисуем мышь
        matrix[mouse.getY() + 1][mouse.getX() + 1] = 3;

        //Выводим все это на экран
        String[] symbols = {"   ", " o ", " O ", "*_*", "RIP", " . "};
        for (int y = 0; y < height + 2; y++) {
            for (int x = 0; x < width + 2; x++) {
                if (y == 0 || y == height + 1 || x == 0 || x == width + 1)
                    System.out.print(symbols[5]);
                else
                    System.out.print(symbols[matrix[y][x]]);
            }
            System.out.println();
        }
        System.out.println();
    }
*/

    public void eatMouse() {
        createMouse();
    }

    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);

        mouse = new Mouse(x, y);
    }

    public void sleep() {
        try {
            int level = snake.getSections().size();
            int delay = level < 15 ? (initialDelay - delayStep * level) : 200;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}
