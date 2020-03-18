package sample;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static ArrayList<String> playerHand = new ArrayList<>();

    // playingcards is the main uno deck that players will pick up cards from
    public static ArrayList<String> playingcards = deck.initalizeDeck();
    public static ArrayList<String> computerHand = new ArrayList<>();
    // currentCards is
    public static ArrayList<String> currentCards = new ArrayList<>();

    //Initalize Player hand
    public static ArrayList<String> playerHand (){

        for(int i = 0; i < 5; i++) {
            playerHand.add(deck.drawCard(playingcards,playerHand,computerHand));
        }
        return playerHand;
    }


    //Initalize Computer Hand
    public static ArrayList<String> computerHand (){

        for(int i = 0; i < 5; i++) {
            computerHand.add(deck.drawCard(playingcards,playerHand,computerHand));
        }
        return computerHand;
    }

    //Playing cards
    public static ArrayList<String> PlayingCards(){
        return playingcards;
    }

    public static void playerChooseCard (ArrayList<String> playerHand,ArrayList<String> deckPile) {
        // User choose which card to play
        int placement = deckPile.size();
        Scanner input = new Scanner(System.in);
        //System.out.println(deckPile.get(placement-1));
       // System.out.println(playerHand);
        System.out.println("Enter Index Number");
        String index_number = input.nextLine();
        int index = Integer.parseInt(index_number);
        String chosen_card = playerHand.get(index);;
       // System.out.println(chosen_card);
        boolean validMove = true;
        System.out.println("working?");
        rules.gameTurn(playerHand,chosen_card,deckPile,index);
        System.out.println("working?");
        //System.out.println("Invalid Move");
        //  return playerChooseCard(playerHand,deckPile);
        //return playerChooseCard(playerHand,deckPile);

    }

    public static void playCard(String Card) {
        currentCards.add(Card);
        playerHand.remove(Card);
    }
}