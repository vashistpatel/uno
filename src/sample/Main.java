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
        System.out.println("---------------------");
        System.out.println(Player.playerChooseCard());
        System.out.println(Player.playerHand);

        //how to set it up that each player has an hand.
    }


    public static void main(String[] args) {
        launch(args);
    }
}
