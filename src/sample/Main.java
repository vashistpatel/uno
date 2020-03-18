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

//        System.out.println(Player.PlayingCards());
        System.out.println(Player.playerHand());
//        System.out.println(Player.computerHand());
//        System.out.println(Player.PlayingCards());
        ArrayList<String> mainPile = deckPile.initializePile(Player.PlayingCards(),deckPile.Pile(),Player.playerHand,Player.computerHand);
        System.out.println(mainPile);
        System.out.println("---------------------");

        Player.playerChooseCard(Player.playerHand,mainPile);

        System.out.println(mainPile);
        System.out.println(Player.playerHand);


        //how to set it up that each player has an hand.*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
