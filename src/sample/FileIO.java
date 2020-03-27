package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {
    //Initialize two files, Game_Stats.txt and All_Stats.txt.
    //Game_Stats.txt stores the current game score
    //All_Stats.txt stores all games played score
    public static File filename_gameStats = new File("Game_Stats.txt");
    public static File filename_allStats = new File("All_Stats.txt");

    //readFile method will read in any file.
    public static List<String> readFile (File filename) {
        try {
            //Check to see if file exists.
            if (filename.exists()) {
                Scanner reader = new Scanner(filename); //Read file

                //Stores each line from the file into an array list
                List<String> data_array = new ArrayList<>();
                while(reader.hasNextLine()) {
                    String data = reader.nextLine();
                    data_array.add(data);
                }

                //Close reader and return array list
                reader.close();
                return data_array;
            } else { System.out.println("File Not Found!"); }

            //Outputs error if file could not be found/read.
        } catch (IOException e) {
            System.out.println("Error occurred while reading file.");
            e.printStackTrace();
        }
        //Returns null only if file could not be read.
        return null;
    }

    //writeFile method will write the scores into both files
    public static void writeFile () {
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            //Compute the Game Statistics
            Statistics.computeStats();

            //fileWriter and printWriter for the All_Stats.txt file
            fileWriter = new FileWriter(filename_allStats, true);
            printWriter = new PrintWriter(fileWriter);

            //Write to the All_Stats.txt file. Data comes from Statistics file
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

            // Close PrinterWriter and FileWriter for All_Stats.txt file.
            printWriter.close();
            fileWriter.close();

            //fileWriter and printWriter for the Game_Stats.txt file
            fileWriter = new FileWriter(filename_gameStats, false);
            printWriter = new PrintWriter(fileWriter);

            //Write to the Game_Stats.txt file. Data comes from Statistics file
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

            // Close PrinterWriter and FileWriter for Game_Stats.txt file
            printWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
