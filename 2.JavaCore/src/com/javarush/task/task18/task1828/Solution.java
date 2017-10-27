package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int id;
        String curStr, fileName;
        StringBuilder fileSB = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        reader.close();

        while (file.ready()) {
            curStr = file.readLine();
            id = curStr.split(" ")[0].length() < 8 ?
                    Integer.parseInt(curStr.split(" ")[0]) :
                    Integer.parseInt(curStr.substring(0, 8));

            if (id == Integer.parseInt(args[1])) {
                if (args[0].equals("-u")) {
                    fileSB.append(genNewStr(args));
                    fileSB.append("\n");
                } else if (args[0].equals("-d")) {
                }
            }
            else {
                fileSB.append(curStr);
                fileSB.append("\n");
            }
        }
        file.close();

        BufferedWriter fileBW = new BufferedWriter(new FileWriter(fileName));
        fileBW.write(fileSB.toString());
        fileBW.close();
    }

    static String genNewStr(String[] args) {
        String newStr;
        if (args[1].length() < 8) {
            newStr = args[1];
            for (int i = 0; i < (8 - args[1].length()); i++)
                newStr+= " ";
        }
        else
            newStr = args[1].substring(0, 8);

        if (args[2].length() < 30) {
            newStr += args[2];
            for (int i = 0; i < (30 - args[2].length()); i++)
                newStr+= " ";
        }
        else
            newStr+= args[2].substring(0, 30);

        if (args[3].length() < 8) {
            newStr += args[3];
            for (int i = 0; i < (8 - args[3].length()); i++)
                newStr+= " ";
        }
        else
            newStr+= args[3].substring(0, 8);

        if (args[4].length() < 4) {
            newStr+= args[4];
            for (int i = 0; i < (4 - args[4].length()); i++)
                newStr+= " ";
        }
        else
            newStr+= args[4].substring(0, 4);

        return newStr;
    }
}
