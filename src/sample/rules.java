package sample;

import java.util.ArrayList;
public class rules {


    public static void gameTurn(ArrayList<String> playerhand, String chosenCard, ArrayList<String> deckPile, int index) {
        String[] chosenCardSplit = chosenCard.split("_", 2);
        int sizeOfDeck = deckPile.size();
        String t2 = deckPile.get(sizeOfDeck - 1);
        String[] topOfDeck = t2.split("_", 2);
        if (chosenCardSplit[0].equals(topOfDeck[0])) {
            System.out.println("ARE YOU WORKING?1");
            deckPile.add(chosenCard);
            playerhand.remove(index);
            System.out.println(deckPile);
            System.out.println(playerhand);
        } else if (chosenCardSplit[1].equals(topOfDeck[1])) {
            System.out.println("ARE YOU WORKING2?");

            deckPile.add(chosenCard);
            playerhand.remove(index);
        }
        System.out.println("ARE YOU WORKING?3");

    }
}