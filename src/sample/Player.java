package sample;
import java.util.ArrayList;

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

    public static ArrayList<String> playerChooseCard () {
        // User choose which card to play
        int index_number = 1;

        String chosen_card = playerHand.get(index_number);
        boolean validMove = true;
        if (validMove) {
            playCard(chosen_card);
            return currentCards;
        } else {
            System.out.println("Invalid Move");
        }
        return null;
    }

    public static void playCard(String Card) {
        currentCards.add(Card);
        playerHand.remove(Card);
    }
}