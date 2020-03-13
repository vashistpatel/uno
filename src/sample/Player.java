package sample;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    public static ArrayList<String> playerHand (){
        ArrayList<String> playingcards = deck.initalizeDeck();
        ArrayList<String> playerHand = new ArrayList<>();
        ArrayList<String> computerHand = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            playerHand.add(deck.drawCard(playingcards));
            computerHand.add(deck.drawCard(playingcards));
        }
        return playerHand;
    }

    public static void playerchoosecard () {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter Index Number");
//        String index_number = input.nextLine();
        int index_number = 0;

        ArrayList<String> playerHand = playerHand();
        ArrayList<String> currentCard = new ArrayList<>();

        currentCard.add(playerHand.get(index_number));
        playerHand.remove(index_number);
    }

}