package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.print.PageLayout;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //testing
        System.out.println("Initialize PlayingCards: " + Player.PlayingCards());
        System.out.println("Initialize Player Hand: " + Player.initializePlayerHand());
        System.out.println("Initialize PlayingCards: " +Player.initializeComputerHand());
        System.out.println("Show Playing Cards: " +Player.PlayingCards());
        System.out.println("Initialize DeckPile" +  deckPile.initializePile
                (Player.PlayingCards(),deckPile.Pile(),Player.playerHand(),Player.computerHand()));
        System.out.println("Show PlayingCards: " +Player.PlayingCards());
        //how to set it up that each player has an hand.
    }


    public static void main(String[] args) {
        launch(args);
    }
}
