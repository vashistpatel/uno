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
import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        System.out.println(Player.PlayingCards());
        Player.playerHand();
//        System.out.println(Player.computerHand());
//        System.out.println(Player.PlayingCards());
        //System.out.println("---------------------");
        //Initalizes Deck
        ArrayList<String> mainPile = deckPile.initializePile(Player.PlayingCards(),deckPile.Pile(),Player.playerHand,Player.computerHand);
        Player.computerHand();
        //System.out.println(Player.playerHand);
        //System.out.println(deckPile.Pile());
        int chooseWhoGoesFirst = rules.whoGoesFirst;
        //System.out.println(chooseWhoGoesFirst);
        while(Player.playerHand.size()>0|| Player.computerHand.size()>0){
            if(chooseWhoGoesFirst==1){
                System.out.println("-------Player1-----------");
                //System.out.println(chooseWhoGoesFirst);
                System.out.println("Deck:"+deckPile.Pile());
                System.out.println("Player Hand: "+Player.playerHand);
                Player.playerChooseCard(Player.playerHand,Player.computerHand,mainPile);
                System.out.println("Deck: "+deckPile.Pile());
                ///COmputer turn
                System.out.println("-------Player2-----------");
                System.out.println("Computer Hand: " +Player.computerHand);
                Player.playerChooseCard(Player.computerHand,Player.playerHand,mainPile);
                System.out.println("Computer Hand: " +Player.computerHand);
                System.out.println("Deck: "+deckPile.Pile());

            }else{
                System.out.println("-------Player2-----------");
                System.out.println("Deck:"+deckPile.Pile());
                System.out.println("Computer Hand: " +Player.computerHand);
                Player.playerChooseCard(Player.computerHand,Player.playerHand,mainPile);
                System.out.println("Computer Hand: " +Player.computerHand);

                System.out.println("-------Player1-----------");
                System.out.println("Deck:"+deckPile.Pile());
                System.out.println("Player Hand: "+Player.playerHand);
                Player.playerChooseCard(Player.playerHand,Player.computerHand,mainPile);
                System.out.println("Deck: "+deckPile.Pile());
            }

        }

        //how to set it up that each player has an hand.*/

    }


    public static void main(String[] args) {
        launch(args);
    }


}