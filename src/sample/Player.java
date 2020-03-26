package sample;

import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public static ArrayList<String> playerHand = new ArrayList<>();
    public static ArrayList<String> computerHand = new ArrayList<>();
    public static ArrayList<ImageView> player1Hand = new ArrayList<>();
    public static ArrayList<ImageView> player2Hand = new ArrayList<>();
    public static int x;

    // playingcards is the main uno deck that players will pick up cards from
    public static ArrayList<String> playingcards = deck.initalizeDeck();

    //Initalize Player hand
    public static ArrayList<String> playerHand (){
        for(int i = 0; i < 5; i++) {
            playerHand.add(deck.drawCard(playingcards,playerHand,computerHand));
        }
        return playerHand;
    }

    public static void p1Hand (){
        x = 0;
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
        x = 0;
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


    public static void DrawCard(boolean turnChecker) {
        try {
            if (turnChecker == false) {
                x += 100;
                computerHand.add(deck.drawCard(playingcards, playerHand, computerHand));
                player2Hand.add(new ImageView("/CARDS/" + computerHand.get(computerHand.size() - 1)));
                player2Hand.get(computerHand.size() - 1).setFitHeight(120);
                player2Hand.get(computerHand.size() - 1).setFitWidth(85);
                player2Hand.get(computerHand.size() - 1).setX(x);
                player2Hand.get(computerHand.size() - 1).setY(20);

                System.out.println(computerHand.size() + " This is the index " + player2Hand.size());
                MainScreen.playPane.getChildren().addAll(player2Hand.get(computerHand.size() - 1));
                MainScreen.UpdateAfterDrawCardP2();

            } else {

                x += 100;
                playerHand.add(deck.drawCard(playingcards, playerHand, computerHand));
                player1Hand.add(new ImageView("/CARDS/" + playerHand.get(playerHand.size() - 1)));
                player1Hand.get(playerHand.size() - 1).setFitHeight(120);
                player1Hand.get(playerHand.size() - 1).setFitWidth(85);
                player1Hand.get(playerHand.size() - 1).setX(x);
                player1Hand.get(playerHand.size() - 1).setY(300);

                System.out.println(playerHand.size() + " THis is the index " + player1Hand.size());
                MainScreen.playPane.getChildren().addAll(player1Hand.get(playerHand.size() - 1));
                MainScreen.UpdateAfterDrawCardP1();
            }
        }catch(Exception exception){}
    }
    public static void playerChooseCard (ArrayList<String> playerHand,ArrayList<String> computerHand, ArrayList<String> deckPile, int x,MainScreen.timer timmer) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Index Number");
        String index_number = input.nextLine();
        int index = Integer.parseInt(index_number);


        if(index >= playerHand.size()){
            System.out.println("Invalid index");
            playerChooseCard(playerHand,computerHand,deckPile, x,timmer);
        }else {

            String chosen_card = playerHand.get(index);
            if (MainScreen.turnChecker==true){
                rules.gameTurn(playerHand,computerHand, player1Hand,player2Hand, chosen_card, deckPile, index,x,timmer);
            } else {
                rules.gameTurn(playerHand,computerHand, player2Hand,player1Hand, chosen_card, deckPile, index, x,timmer);
            }

        }
    }

}
