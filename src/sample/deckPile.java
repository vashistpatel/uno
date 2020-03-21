package sample;

import javafx.scene.image.ImageView;
import java.util.ArrayList;


public class deckPile {

    private static ArrayList<String> Pile = new ArrayList<>();

    public static ArrayList<String> Pile(){
        return Pile;
    }
    public static void getLast(){
        ArrayList<String> temp = new ArrayList<>();

        if (Pile.size() > 1){
            String arrayIndex = Pile.get(Pile.size()-1);
            temp.add(arrayIndex);
            ImageView PlayedPile = new ImageView("/CARDS/" + arrayIndex );
            PlayedPile.setFitHeight(120);
            PlayedPile.setFitWidth(85);
            PlayedPile.setX(400);
            PlayedPile.setY(150);
            MainScreen.playPane.getChildren().addAll(PlayedPile);
        }else {
            ImageView PlayedPile = new ImageView("/CARDS/" + Pile.get(Pile.size()-1));
            PlayedPile.setFitHeight(120);
            PlayedPile.setFitWidth(85);
            PlayedPile.setX(400);
            PlayedPile.setY(150);
            MainScreen.playPane.getChildren().addAll(PlayedPile);
        }
    }

    public static ArrayList<String> initializePile (ArrayList<String> Deck, ArrayList<String> Pile, ArrayList<String> player1,
                                            ArrayList<String> computer) {
        Pile.add(deck.drawCard(Deck,player1,computer));
        return Pile;
    }

}
