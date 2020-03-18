package sample;


import java.util.ArrayList;


public class deckPile {

    private static ArrayList<String> Pile = new ArrayList<>();

    public static ArrayList<String> Pile(){
        return Pile;
    }

    public static ArrayList<String> initializePile (ArrayList<String> Deck, ArrayList<String> Pile, ArrayList<String> player1,
                                            ArrayList<String> computer) {
        Pile.add(deck.drawCard(Deck,player1,computer));
        return Pile;
    }

}
