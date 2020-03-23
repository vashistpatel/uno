package sample;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Scanner;

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
    public static void UpdatePlayer1(){
        MainScreen.playPane.getChildren().remove(Player.player1Hand.get(removal));
    }
    public static void UpdatePlayer2(){
        MainScreen.playPane.getChildren().remove(Player.player2Hand.get(removal));
    }
    public static void gameTurn(ArrayList<String> playerhand,ArrayList<String> computerHand, ArrayList<ImageView> player1hand,
                                ArrayList<ImageView> player2Hand, String chosenCard, ArrayList<String> deckPile,int index) {

        String[] chosenCardSplit = chosenCard.split("_", 2);
        int sizeOfDeck = deckPile.size();
        String t2 = deckPile.get(sizeOfDeck - 1);
        String[] topOfDeck = t2.split("_", 2);

        if (chosenCardSplit[0].equals(topOfDeck[0])) {
            deckPile.add(chosenCard);
            playerhand.remove(index);
            removal = index;
            cardAction(playerhand,computerHand,chosenCard);

        } else if (chosenCardSplit[1].equals(topOfDeck[1])) {

            deckPile.add(chosenCard);
            playerhand.remove(index);
            player1hand.remove(index);
            removal = index;
            cardAction(playerhand,computerHand,chosenCard);

        }  else if (chosenCardSplit[0].charAt(0) == 'M' ) {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter Color to Switch to");
            String newColor = input.nextLine();

            if (chosenCardSplit[1].equals(13) || chosenCardSplit[1].equals(15) ) {
                deckPile.add(chosenCard);
                deckPile.add(newColor);
                playerhand.remove(index);
                player1hand.remove(index);
                removal = index;
                cardAction(playerhand, computerHand, chosenCard);
            }else {
                deckPile.add(chosenCard);
                deckPile.add(newColor);
                playerhand.remove(index);
                player1hand.remove(index);
                removal = index;
                cardAction(playerhand, computerHand, chosenCard);
            }
        } else {
            Player.playerChooseCard(playerhand,computerHand, deckPile);
        }
    }

    public static void cardAction(ArrayList<String> playerhand,ArrayList<String> computerHand, String chosenCard){

        String[] chosenCardSplit = chosenCard.split("_", 2);
        String[] charSplit = chosenCardSplit[1].split("\\.",2);

        int result = Integer.parseInt(charSplit[0]);
        System.out.println(result);

        if(result >9){
            if(charSplit[0].equals("10")){//Skip

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
    public static void add4ToHand (ArrayList<String> playerhand,ArrayList<String> computerHand){
        if (MainScreen.turnChecker == false){
            for (int i = 0; i < 4; i++){
                computerHand.add((deck.drawCard(Player.PlayingCards(),playerhand,computerHand)));
                Player.DrawCard(MainScreen.turnChecker);
            }
        } else {
            for (int i = 0; i < 4; i++){
                playerhand.add((deck.drawCard(Player.PlayingCards(),playerhand,computerHand)));
                Player.DrawCard(MainScreen.turnChecker);
            }
        }

    }
}