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
        System.out.println(CARDS);
        CARDS.add("R_0");
        CARDS.add("R_1");
        CARDS.add("R_2");
        CARDS.add("R_3");
        CARDS.add("R_4");
        CARDS.add("R_5");
        CARDS.add("R_6");
        CARDS.add("R_7");
        CARDS.add("R_8");
        CARDS.add("R_9");
        CARDS.add("B_1");
        CARDS.add("B_2");
        CARDS.add("B_3");
        CARDS.add("B_4");
        CARDS.add("B_5");
        CARDS.add("B_6");
        CARDS.add("B_7");
        CARDS.add("B_8");
        CARDS.add("B_9");
        CARDS.add("Y_1");
        CARDS.add("Y_2");
        CARDS.add("Y_3");
        CARDS.add("Y_4");
        CARDS.add("Y_5");
        CARDS.add("Y_6");
        CARDS.add("Y_7");
        CARDS.add("Y_8");
        CARDS.add("Y_9");
        CARDS.add("G_1");
        CARDS.add("G_2");
        CARDS.add("G_3");
        CARDS.add("G_4");
        CARDS.add("G_5");
        CARDS.add("G_6");
        CARDS.add("G_7");
        CARDS.add("G_8");
        CARDS.add("G_9");

        ArrayList<String> playingCards = new ArrayList<String>(CARDS); //initialize the working cards
        Collections.shuffle(playingCards); //shuffles the cards
        System.out.println(playingCards.get(0));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
