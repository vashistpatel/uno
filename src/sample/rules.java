package sample;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Scanner;

import static sample.Player.player1Hand;
import static sample.Player.player2Hand;

public class rules {
    public static int whoGoesFirst = deck.checkTurn();
    public static int getWhoGoesFirst(){
        return whoGoesFirst;
    }
    public static int removal ;

    public static int setWhoGoesFirst(int x){
        whoGoesFirst = x;
        return whoGoesFirst;
    }
    //Updates player hand after card is placed
    public static void UpdatePlayer1(){
        //remove all cards from playyer view
        for(int i = 0; i< player1Hand.size(); i++){
            MainScreen.playPane.getChildren().remove(player1Hand.get(i));
        }
        //delete card that was placed
        Player.player1Hand.remove(removal);
        Player.x = 0;
        //place cards in player view
        for(int i = 0; i < Player.playerHand.size(); i++) {
            player1Hand.add(new ImageView("/CARDS/"+Player.playerHand.get(i)));
            player1Hand.get(i).setFitHeight(120);
            player1Hand.get(i).setFitWidth(85);
            player1Hand.get(i).setX(Player.x);
            player1Hand.get(i).setY(300);
            MainScreen.playPane.getChildren().addAll(player1Hand.get(i));
            Player.x+=100;
        }

    }
    //Update player2 hand after card is placed
    public static void UpdatePlayer2(){
        //remove all cards from player view
        for(int i = 0; i< player2Hand.size(); i++){ MainScreen.playPane.getChildren().remove(player2Hand.get(i));}
        //delete card that was placed
        player2Hand.remove(removal);
        Player.x = 0;
        //place cards in player view
        for(int i = 0; i < Player.computerHand.size(); i++) {
            player2Hand.add(new ImageView("/CARDS/"+Player.computerHand.get(i)));
            player2Hand.get(i).setFitHeight(120);
            player2Hand.get(i).setFitWidth(85);
            player2Hand.get(i).setX(Player.x);
            player2Hand.get(i).setY(20);
            MainScreen.playPane.getChildren().addAll(player2Hand.get(i));
            Player.x+=100;
        }

    }

    /*public static void addingtwo()*/


    public static void gameTurn(ArrayList<String> playerhand,ArrayList<String> computerHand, ArrayList<ImageView> player1hand,
                                ArrayList<ImageView> player2Hand, String chosenCard, ArrayList<String> deckPile,int index,int playerVal) {

        String[] chosenCardSplit = chosenCard.split("_", 2);
        String[] charSplit = chosenCardSplit[1].split("\\.",2);
        System.out.println(charSplit[0]);
        System.out.println(charSplit[1]);
        int sizeOfDeck = deckPile.size();
        String t2 = deckPile.get(sizeOfDeck - 1);
        String[] topOfDeck = t2.split("_", 2);

        if (chosenCardSplit[0].equals(topOfDeck[0])) {
            deckPile.add(chosenCard);
            playerhand.remove(index);
            removal = index;
            cardAction(playerhand,computerHand,chosenCard,playerVal);

        } else if (chosenCardSplit[1].equals(topOfDeck[1])) {

            deckPile.add(chosenCard);
            playerhand.remove(index);
            player1hand.remove(index);
            removal = index;
            cardAction(playerhand,computerHand,chosenCard,playerVal);

        }  else if (chosenCardSplit[0].charAt(0) == 'M' ) {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter Color to Switch to");
            String newColor = input.nextLine();

            if (charSplit[0].equals("13")) {
                deckPile.add(chosenCard);
                int size = deckPile.size()-2;
                colourChange(newColor,deckPile,size);
                playerhand.remove(index);
                player1hand.remove(index);
                removal = index;
            }else {
                deckPile.add(chosenCard);
                int size = deckPile.size()-2;
                colourChange(newColor,deckPile,size);
                playerhand.remove(index);
                player1hand.remove(index);
                removal = index;
                cardAction(playerhand, computerHand, chosenCard,playerVal);
            }
        } else {
            Player.playerChooseCard(playerhand,computerHand, deckPile,playerVal);
        }
    }

    public static void cardAction(ArrayList<String> playerhand,ArrayList<String> computerHand, String chosenCard,int playerVal){

        String[] chosenCardSplit = chosenCard.split("_", 2);
        String[] charSplit = chosenCardSplit[1].split("\\.",2);

        int result = Integer.parseInt(charSplit[0]);
        System.out.println(result);

        if(result >9){
            if(charSplit[0].equals("10")){//Skip
                System.out.println("Opponent Turn Skipped");
                if(playerVal==1){
                    MainScreen.player1Move();
                }else if(playerVal ==2){
                    MainScreen.player2Move();
                }




            }else if(charSplit[0].equals("11")){//Reverse
                if(getWhoGoesFirst()==0){
                    setWhoGoesFirst(1);
                }else{
                    setWhoGoesFirst(0);
                }

            }else if(charSplit[0].equals("12")){//+2
                computerHand.add((deck.drawCard(Player.PlayingCards(),playerhand,computerHand)));
                computerHand.add((deck.drawCard(Player.PlayingCards(),playerhand,computerHand)));

            }else if(charSplit[0].equals("13") || charSplit[0].equals("15")){//+
//                MainScreen.callAdd4();
            }else if(charSplit[0].equals("14") || charSplit[0].equals("16")){//Colour change

            }

        }

    }
    public static void add4ToHand (ArrayList<String> playerhand,ArrayList<String> computerHand) {
        if (MainScreen.turnChecker == false) {
            for (int i = 0; i < 4; i++) {
                computerHand.add((deck.drawCard(Player.PlayingCards(), playerhand, computerHand)));
                Player.DrawCard(MainScreen.turnChecker);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                playerhand.add((deck.drawCard(Player.PlayingCards(), playerhand, computerHand)));
                Player.DrawCard(MainScreen.turnChecker);
            }
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
}