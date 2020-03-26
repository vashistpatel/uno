package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    public static File filename_gameStats = new File("Game_Stats.txt");
    public static File filename_allStats = new File("All_Stats.txt");

    public static List<String> readFile (File filename) {
        try {
            if (filename.exists()) {
                System.out.println("File Exists");
                Scanner reader = new Scanner(filename);
                List<String> data_array = new ArrayList<>();
                while(reader.hasNextLine()) {
                    String data = reader.nextLine();
                    data_array.add(data);
                }
                reader.close();
                return data_array;
            } else { System.out.println("File Not Found!"); }

        } catch (IOException e) {
            System.out.println("Error occurred while reading file.");
            e.printStackTrace();
        }
        return null;
    }

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
