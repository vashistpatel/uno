package sample;

import java.util.ArrayList;

//Important! Do not call this Statistics class anywhere else as it is only used for
//FileIO.java class. If called, it will give improper stats value.
public class Statistics {

    //Call and initialize the deckpile. Deckpile is the middle pile, contains
    //all the cards played.
    public static ArrayList<String> pile = deckPile.Pile();

    //Variables that stores in the stats
    public static int plus_2_cards;
    public static int plus_4_cards;
    public static int change_cards;
    public static int block_cards;
    public static int reverse_cards;
    public static int total_cards;


    //Method that calculates the stats.
    //Stats include +2, +4, change colour, block, reverse and skip turn cards played.
    public static void computeStats () {
        //Total cards played is equal to pile
        total_cards = pile.size();

        //Loops over all the cards played in the pile
        for (int i=0; i<pile.size(); i++) {
            String temp = pile.get(i);

            //When changing colours, the new colour changed is stored in the
            //deck pile. In order to get an accurate number of total cards, we
            //must subtract those cards for the accurate total cards played.
            if (temp.equals("B_") || temp.equals("G_") || temp.equals("R_") || temp.equals("Y_"))
                total_cards--;

            //Finds all the special cards and stores the occurrence of the cards.
            if ((temp.equals("B_10.png")) || (temp.equals("G_10.png")) || (temp.equals("R_10.png")) || (temp.equals("Y_10.png"))) {
                block_cards++;
            } else if ((temp.equals("B_11.png")) || (temp.equals("G_11.png")) || (temp.equals("R_11.png")) || (temp.equals("Y_11.png"))) {
                reverse_cards++;
            } else if ((temp.equals("B_12.png")) || (temp.equals("G_12.png")) || (temp.equals("R_12.png")) || (temp.equals("Y_12.png"))) {
                plus_2_cards++;
            } else if (temp.equals("M_13.png")) {
                plus_4_cards++;
            } else if (temp.equals("M_14.png")) {
                change_cards++;
            }
        }
    }
}
