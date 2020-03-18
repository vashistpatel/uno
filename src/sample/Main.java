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
        //testing

//        System.out.println(Player.PlayingCards());
        Player.playerHand();
//        System.out.println(Player.computerHand());
//        System.out.println(Player.PlayingCards());
        System.out.println("---------------------");
        //Initalizes Deck
        ArrayList<String> mainPile = deckPile.initializePile(Player.PlayingCards(),deckPile.Pile(),Player.playerHand,Player.computerHand);
        Player.computerHand();
       //System.out.println(Player.playerHand);
        //System.out.println(deckPile.Pile());
        int chooseWhoGoesFirst = checkTurn();
        while(Player.playerHand.size()>0|| Player.computerHand().size()>0){
            if(chooseWhoGoesFirst==1){
                System.out.println("Pile: "+deckPile.Pile());
                System.out.println("PlayerHand:"+Player.playerHand);
                Player.playerChooseCard(Player.playerHand,mainPile);



                ///COmputer turn
                System.out.println("Pile: "+deckPile.Pile());
                System.out.println("Computer Hand: "+Player.computerHand);
                Player.playerChooseCard(Player.computerHand,mainPile);


            }else{
                System.out.println("Pile: "+deckPile.Pile());
                System.out.println("Computer Hand: "+Player.computerHand);
                Player.playerChooseCard(Player.computerHand,mainPile);

                System.out.println("Pile: "+deckPile.Pile());
                System.out.println("PlayerHand:"+Player.playerHand);
                Player.playerChooseCard(Player.playerHand,mainPile);

            }

        }
        Player.playerChooseCard(Player.playerHand,mainPile);
        System.out.println(Player.playerHand);
        System.out.println(mainPile);



        //how to set it up that each player has an hand.*/
    }


    public static void main(String[] args) {
        launch(args);
    }
    public int checkTurn(){
        Random rand = new Random();
        int randomInt = rand.nextInt(2) + 1;
        return randomInt;
    }

}