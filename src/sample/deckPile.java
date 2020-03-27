package sample;

import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class deckPile {
    //Initializes variables
    private static ArrayList<String> Pile = new ArrayList<>();
    public static ImageView PlayedPile;

    //Method for accessing pile
    public static ArrayList<String> Pile(){
        return Pile;
    }

    //Get's the last card of the deckPile and outputs on the MainScreen
    public static void getLast(){

        //Gets the last card played and stores it into playedpile
        if (Pile.size() > 1){
            PlayedPile = new ImageView("/CARDS/" + Pile.get(Pile.size()-1));
        } else {
            PlayedPile = new ImageView("/CARDS/" + Pile.get(Pile.size()-1));
        }

        //Dimensions for pile deck output
        PlayedPile.setFitHeight(120);
        PlayedPile.setFitWidth(85);
        PlayedPile.setX(400);
        PlayedPile.setY(150);
        MainScreen.playPane.getChildren().addAll(PlayedPile);
    }

    //Initializes the pileDeck by drawing one card that is not of the special black cards.
    public static ArrayList<String> initializePile (ArrayList<String> Deck, ArrayList<String> Pile, ArrayList<String> player1,
                                                    ArrayList<String> computer) {
        Pile.add(deck.deckDrawCard(Deck,player1,computer));
        return Pile;
    }
}