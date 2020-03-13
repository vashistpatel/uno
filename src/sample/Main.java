package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<String> CARDS = new ArrayList<String>();

        char[] tempC = new char[4];//temp array
        tempC[0] = 'R';
        tempC[1] = 'Y';
        tempC[2] = 'G';
        tempC[3] = 'B';

        //initializes new deck of cards
        for(int i=0;i<4;i++){
            for(int k =0;k<10;k++){
                CARDS.add(tempC[i]+"_"+k);
            }
        }

        ArrayList<String> playingCards = new ArrayList<String>(CARDS); //new list of cards that are being add
        Collections.shuffle(playingCards); //shuffles the cards
        System.out.println(playingCards);

        //how to set it up that each player has an hand.
    }


    public static void main(String[] args) {
        launch(args);
    }
}
