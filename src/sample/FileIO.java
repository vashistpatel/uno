package sample;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileIO {
    public static File filename_gameStats = new File("Game_Stats.txt");
    public static File filename_allStats = new File("All_Stats.txt");

    public static void readFile (File filename) {
        try {
            if (filename.exists()) {
                System.out.println("File Exists");
                Scanner reader = new Scanner(filename);

                while(reader.hasNextLine()) {
                    String data = reader.nextLine();
                    System.out.println(data);
                }
                reader.close();
            } else { System.out.println("File Not Found!"); }

        } catch (IOException e) {
            System.out.println("Error occurred while reading file.");
            e.printStackTrace();
        }
    }

//    public static void writeFile (File filename) {
//        try {
//            if (filename.exists()) {
//                System.out.println("File Exists!");
//                // This will append to the file. Use False to not append.
//                if (filename.equals(filename_allStats)) {
//                    FileWriter fileWriter = new FileWriter(filename, true);
//                    PrintWriter printWriter = new PrintWriter(fileWriter);
//                    System.out.println("It is allStats");
//                } else if (filename.equals(filename_gameStats)) {
//                    FileWriter fileWriter = new FileWriter(filename, true);
//                    PrintWriter printWriter = new PrintWriter(fileWriter);
//                    System.out.println("It is gamestats");
//                }
//
//
//                Statistics.computeStats();
//                printWriter.println();
//                printWriter.println();
//                printWriter.println("Uno Game Statistics");
//                printWriter.println("------------------------------------------");
//                printWriter.println("+2 Cards Played: " + Statistics.plus_2_cards);
//                printWriter.println("+4 Cards Played: " + Statistics.plus_4_cards);
//                printWriter.println("Change Colour Cards Played: " + Statistics.change_cards);
//                printWriter.println("Block Cards Played: " + Statistics.block_cards);
//                printWriter.println("Reverse Cards Played: " + Statistics.reverse_cards);
//                printWriter.println("Total Cards Played: " + Statistics.total_cards);
//
//                printWriter.close();
//                fileWriter.close();
//            } else {
//                System.out.println("Creating New File!");
//                filename.createNewFile();
//            }
//
//        } catch (IOException e) {
//            System.out.println("Error occurred while writing file.");
//            e.printStackTrace();
//        }
//    }

    public static void writeFile () {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            // Compute the Game Statistics
            Statistics.computeStats();

            // This is a fileWriter and printWriter for the all stats file
            fileWriter = new FileWriter(filename_allStats, true);
            printWriter = new PrintWriter(fileWriter);
            // File Output
            printWriter.println();
            printWriter.println();
            printWriter.println("Uno Game Statistics");
            printWriter.println("------------------------------------------");
            printWriter.println("+2 Cards Played: " + Statistics.plus_2_cards);
            printWriter.println("+4 Cards Played: " + Statistics.plus_4_cards);
            printWriter.println("Change Colour Cards Played: " + Statistics.change_cards);
            printWriter.println("Block Cards Played: " + Statistics.block_cards);
            printWriter.println("Reverse Cards Played: " + Statistics.reverse_cards);
            printWriter.println("Total Cards Played: " + Statistics.total_cards);

            // Close PrinterWriter and FileWriter.
            printWriter.close();
            fileWriter.close();

            // This is a fileWriter and printWriter for the game stats file
            fileWriter = new FileWriter(filename_gameStats, false);
            printWriter = new PrintWriter(fileWriter);
            // File Output
            printWriter.println();
            printWriter.println();
            printWriter.println("Uno Game Statistics");
            printWriter.println("------------------------------------------");
            printWriter.println("+2 Cards Played: " + Statistics.plus_2_cards);
            printWriter.println("+4 Cards Played: " + Statistics.plus_4_cards);
            printWriter.println("Change Colour Cards Played: " + Statistics.change_cards);
            printWriter.println("Block Cards Played: " + Statistics.block_cards);
            printWriter.println("Reverse Cards Played: " + Statistics.reverse_cards);
            printWriter.println("Total Cards Played: " + Statistics.total_cards);

            // Close PrinterWriter and FileWriter.
            printWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
