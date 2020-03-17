package sample;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private static ArrayList<String> playerHand = new ArrayList<>();
    private static ArrayList<String> playingcards = deck.initalizeDeck();
    private static ArrayList<String> computerHand = new ArrayList<>();

    //Initalize Player hand
    public static ArrayList<String> initializePlayerHand (){

        for(int i = 0; i < 5; i++) {
            playerHand.add(deck.drawCard(playingcards,playerHand,computerHand));
        }
        return playerHand;
    }

    //Initalize Computer Hand
    public static ArrayList<String> initializeComputerHand (){

        for(int i = 0; i < 5; i++) {
            computerHand.add(deck.drawCard(playingcards,playerHand,computerHand));
        }
        return computerHand;
    }

    //Player Hand
    public static ArrayList<String> playerHand(){
        return playerHand;
    }

    //Computer Hand
    public static ArrayList<String> computerHand(){
        return computerHand;
    }
    //Playing cards
    public static ArrayList<String> PlayingCards(){
        return playingcards;
    }

    public static void playerchoosecard () {
      //  Scanner input = new Scanner(System.in);
     //   System.out.println("Enter Index Number");
    //    String index_number = input.nextLine();
        int index_number = 0;

        ArrayList<String> playerHand = playerHand();
        ArrayList<String> currentCard = new ArrayList<>();

        currentCard.add(playerHand.get(index_number));
        playerHand.remove(index_number);
    }

}