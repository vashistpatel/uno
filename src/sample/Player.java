package sample;

import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static ArrayList<String> playerHand = new ArrayList<>();
    public static ArrayList<ImageView> player1Hand = new ArrayList<>();
    public static ArrayList<ImageView> player2Hand = new ArrayList<>();

    // playingcards is the main uno deck that players will pick up cards from
    public static ArrayList<String> playingcards = deck.initalizeDeck();
    public static ArrayList<String> computerHand = new ArrayList<>();
    // currentCards is
    public static ArrayList<String> currentCards = new ArrayList<>();

    //Initalize Player hand
    public static ArrayList<String> playerHand (){
        int x = 0;
        for(int i = 0; i < 5; i++) {
            playerHand.add(deck.drawCard(playingcards,playerHand,computerHand));
        }
        return playerHand;
    }

    public static void p1Hand (){
        int x = 0;
        for(int i = 0; i < 5; i++) {
            player1Hand.add(new ImageView("/CARDS/"+playerHand.get(i)));
            player1Hand.get(i).setFitHeight(120);
            player1Hand.get(i).setFitWidth(85);
            player1Hand.get(i).setX(x);
            player1Hand.get(i).setY(300);


            MainScreen.playPane.getChildren().addAll(player1Hand.get(i));
            x+=100;
        }
    }
    //Initalize Computer Hand
    public static ArrayList<String> computerHand (){

        for(int i = 0; i < 5; i++) {
            computerHand.add(deck.drawCard(playingcards,playerHand,computerHand));
        }
        return computerHand;
    }

    public static void p2Hand (){
        int x = 0;
        for(int i = 0; i < 5; i++) {

            player2Hand.add(new ImageView("/CARDS/"+computerHand.get(i)));
            player2Hand.get(i).setFitHeight(120);
            player2Hand.get(i).setFitWidth(85);
            player2Hand.get(i).setX(x);
            player2Hand.get(i).setY(20);

            MainScreen.playPane.getChildren().addAll(player2Hand.get(i));
            x+=100;
        }
    }

    //Playing cards
    public static ArrayList<String> PlayingCards(){
        return playingcards;
    }

    public static void playerChooseCard (ArrayList<String> playerHand,ArrayList<String> computerHand,ArrayList<String> deckPile) {
        int placement = deckPile.size();
        Scanner input = new Scanner(System.in);

        int take = 100;
        System.out.println("Enter Index Number");
        String index_number = input.nextLine();
        int index = Integer.parseInt(index_number);
        if(index == take){
            playerHand.add(deck.drawCard(Player.PlayingCards(),Player.playerHand,Player.computerHand));
            System.out.println("Current Hand: "+playerHand);
            System.out.println("Pile: "+deckPile);
            playerChooseCard(playerHand,computerHand,deckPile);
        }else {

            String chosen_card = playerHand.get(index);
            rules.gameTurn(playerHand,computerHand, chosen_card, deckPile, index);
            
            //System.out.println("working?");
            //System.out.println("Invalid Move");
            //  return playerChooseCard(playerHand,deckPile);
            //return playerChooseCard(playerHand,deckPile);
        }
    }


}