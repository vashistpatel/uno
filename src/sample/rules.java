package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Scanner;

import static sample.Player.player1Hand;
import static sample.Player.player2Hand;

public class rules {
    public static boolean whoGoesFirst = deck.checkTurn();
    public static int removal ;

    public static void UpdatePlayer1(){
        if(Player.playerHand.size()>7){
            MainScreen.playPane.getChildren().removeAll(player1Hand);
            Player.player1Hand.remove(removal);

            Player.x = 0;
            for(int i = 0; i < Player.playerHand.size(); i++) {
                player1Hand.set(i,new ImageView("/CARDS/"+ Player.playerHand.get(i)));
                player1Hand.get(i).setFitHeight(120);
                player1Hand.get(i).setFitWidth(85);
                player1Hand.get(i).setX(Player.x);
                player1Hand.get(i).setY(300);

                MainScreen.playPane.getChildren().addAll(player1Hand.get(i));
                Player.x+=50;
            }
        }else{

        MainScreen.playPane.getChildren().removeAll(player1Hand);
        Player.player1Hand.remove(removal);

        Player.x = 0;
        for(int i = 0; i < Player.playerHand.size(); i++) {
            player1Hand.set(i, new ImageView("/CARDS/" + Player.playerHand.get(i)));
            player1Hand.get(i).setFitHeight(120);
            player1Hand.get(i).setFitWidth(85);
            player1Hand.get(i).setX(Player.x);
            player1Hand.get(i).setY(300);

            MainScreen.playPane.getChildren().addAll(player1Hand.get(i));
            Player.x += 100;
        }
        }

    }
//    public static void p2timer(int i){
//        String x = String.valueOf(i);
//        Label label = new Label(x);
//        MainScreen.playPane.getChildren().addAll((label));
//
//    }
    public static void updatePlayer1(){//Without the .remove function
        if(Player.playerHand.size()>7){
            MainScreen.playPane.getChildren().removeAll(player1Hand);
            Player.x = 0;
            for(int i = 0; i < Player.playerHand.size(); i++) {
                player1Hand.set(i, new ImageView("/CARDS/" + Player.playerHand.get(i)));
                player1Hand.get(i).setFitHeight(120);
                player1Hand.get(i).setFitWidth(85);
                player1Hand.get(i).setX(Player.x);
                player1Hand.get(i).setY(300);

                MainScreen.playPane.getChildren().addAll(player1Hand.get(i));
                Player.x += 50;


        }
        }else{

        MainScreen.playPane.getChildren().removeAll(player1Hand);
        Player.x = 0;
        for(int i = 0; i < Player.playerHand.size(); i++) {
            player1Hand.set(i, new ImageView("/CARDS/" + Player.playerHand.get(i)));
            player1Hand.get(i).setFitHeight(120);
            player1Hand.get(i).setFitWidth(85);
            player1Hand.get(i).setX(Player.x);
            player1Hand.get(i).setY(300);

            MainScreen.playPane.getChildren().addAll(player1Hand.get(i));
            Player.x += 100;
        }
        }

    }
    public static void UpdatePlayer2(){
        if(Player.computerHand.size()>7){
            MainScreen.playPane.getChildren().removeAll(player2Hand);
            player2Hand.remove(removal);
            Player.x = 0;
            for (int i = 0; i < Player.computerHand.size(); i++) {
                player2Hand.set(i, new ImageView("/CARDS/" + Player.computerHand.get(i)));
                player2Hand.get(i).setFitHeight(120);
                player2Hand.get(i).setFitWidth(85);
                player2Hand.get(i).setX(Player.x);
                player2Hand.get(i).setY(20);

                MainScreen.playPane.getChildren().addAll(player2Hand.get(i));
                Player.x += 50;
        }
        }else {


            MainScreen.playPane.getChildren().removeAll(player2Hand);
            player2Hand.remove(removal);
            Player.x = 0;
            for (int i = 0; i < Player.computerHand.size(); i++) {
                player2Hand.set(i, new ImageView("/CARDS/" + Player.computerHand.get(i)));
                player2Hand.get(i).setFitHeight(120);
                player2Hand.get(i).setFitWidth(85);
                player2Hand.get(i).setX(Player.x);
                player2Hand.get(i).setY(20);

                MainScreen.playPane.getChildren().addAll(player2Hand.get(i));
                Player.x += 100;
            }
        }

    }
    public static void updatePlayer2(){//Without the .remove function
        MainScreen.playPane.getChildren().removeAll(player2Hand);
        Player.x = 0;
        if(Player.computerHand.size()>7){
            for(int i = 0; i < Player.computerHand.size(); i++) {
                player2Hand.set(i,new ImageView("/CARDS/"+ Player.computerHand.get(i)));
                player2Hand.get(i).setFitHeight(120);
                player2Hand.get(i).setFitWidth(85);
                player2Hand.get(i).setX(Player.x);
                player2Hand.get(i).setY(20);

                MainScreen.playPane.getChildren().addAll(player2Hand.get(i));
                Player.x+=50;
            }
        }else{
        for(int i = 0; i < Player.computerHand.size(); i++) {
            player2Hand.set(i, new ImageView("/CARDS/" + Player.computerHand.get(i)));
            player2Hand.get(i).setFitHeight(120);
            player2Hand.get(i).setFitWidth(85);
            player2Hand.get(i).setX(Player.x);
            player2Hand.get(i).setY(20);

            MainScreen.playPane.getChildren().addAll(player2Hand.get(i));
            Player.x += 100;
        }
        }

    }
    public static void gameTurn(ArrayList<String> playerhand, ArrayList<String> computerHand, ArrayList<ImageView> player1hand,
                                ArrayList<ImageView> player2Hand, String chosenCard, ArrayList<String> deckPile, int index, int playerVal /*, timer timmmer*/) {
        if (chosenCard != ""){
            String[] chosenCardSplit = chosenCard.split("_", 2);
            String[] charSplit = chosenCardSplit[1].split("\\.",2);
            int sizeOfDeck = deckPile.size();
            String t2 = deckPile.get(sizeOfDeck - 1);
            String[] topOfDeck = t2.split("_", 2);

            if (chosenCardSplit[0].equals(topOfDeck[0]) || chosenCardSplit[1].equals(topOfDeck[1])) {
                deckPile.add(chosenCard);
                playerhand.remove(index);
                removal = index;
                cardAction(playerhand,computerHand,chosenCard,playerVal);
            }else if (chosenCardSplit[0].charAt(0) == 'M' ) {
                Scanner input = new Scanner(System.in);
                System.out.println("Enter Color to Switch to");
                String newColor = input.nextLine();

                if (charSplit[0].equals("13")) {
                    System.out.println("+4");
                    deckPile.add(chosenCard);
                    playerhand.remove(index);
                    int size = deckPile.size()-2;
                    removal = index;
                    colourChange(newColor,deckPile,size);
                    if(playerVal==1){
                        for(int i =0;i<2;i++){
                            MainScreen.plus2CardsP2();
                        }

                    }else{
                        for(int i =0;i<2;i++){
                            MainScreen.plus2CardsP1();
                        }
                    }
                }else if(charSplit[0].equals("14")) {
                    System.out.println("CC");
                    deckPile.add(chosenCard);
                    playerhand.remove(index);
                    int size = deckPile.size()-2;
                    removal = index;
                    colourChange(newColor,deckPile,size);
                }

            }
            whoGoesFirst = !whoGoesFirst;
        }
    }
    public static void colourChange(String colour, ArrayList<String> deckPile,int deckSize ){
        if(colour.equals("g")){
            String temp = deckPile.get(deckSize);
            String[] chosenCardSplit = temp.split("_", 2);
            String changC = "G_"+chosenCardSplit[1];
            deckPile.add(changC);


        }else if(colour.equals("b")){
            String temp = deckPile.get(deckSize);
            String[] chosenCardSplit = temp.split("_", 2);
            String changC = "B_"+chosenCardSplit[1];
            deckPile.add(changC);
        }else if(colour.equals("r")){
            String temp = deckPile.get(deckSize);
            String[] chosenCardSplit = temp.split("_", 2);
            String changC = "R_"+chosenCardSplit[1];
            deckPile.add(changC);
        }else{
            String temp = deckPile.get(deckSize);
            String[] chosenCardSplit = temp.split("_", 2);
            String changC = "Y_"+chosenCardSplit[1];

            deckPile.add(changC);        }
    }
    public static void cardAction(ArrayList<String> playerhand,ArrayList<String> computerHand, String chosenCard,int playerVal){

        String[] chosenCardSplit = chosenCard.split("_", 2);
        String[] charSplit = chosenCardSplit[1].split("\\.",2);

        int result = Integer.parseInt(charSplit[0]);
        System.out.println(result);

        if(result >9|| result!=14 || result!=13){
            if(charSplit[0].equals("10")){//Skip
                System.out.println("Opponent Turn Skipped");
                if(playerVal==1){
                    whoGoesFirst = !whoGoesFirst;
                   //MainScreen.player1Move();
                }else if(playerVal ==2){
                    whoGoesFirst = !whoGoesFirst;

                    //MainScreen.player2Move();
                }


            }else if(charSplit[0].equals("11")){//Reverse
               /* if(getWhoGoesFirst()==0){
                    setWhoGoesFirst(1);
                }else{
                    setWhoGoesFirst(0);
                }*/

            }else if(charSplit[0].equals("12")){//+2
                if(playerVal==1){
                    MainScreen.plus2CardsP2();

                }else{
                    MainScreen.plus2CardsP1();

                }

            }else if(charSplit[0].equals("13")){
                if (playerVal == 1){
                    MainScreen.plus2CardsP2();
                }else{
                    MainScreen.plus2CardsP1();
                }
            }

        }

    }


}


