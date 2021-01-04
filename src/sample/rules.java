package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import static sample.Player.player1Hand;
import static sample.Player.player2Hand;

public class rules {
    public static boolean whoGoesFirst = deck.checkTurn();
    public static int removal ;

//    public static void p2timer(int i){
//        String x = String.valueOf(i);
//        Label label = new Label(x);
//        MainScreen.playPane.getChildren().addAll((label));
//
//    }
public static void updatePlayer1(){//Without the .remove function
    int increment;
    if(Player.playerHand.size()>7){
        increment = 50;
    }else {
        increment = 100;
    }
    MainScreen.playPane.getChildren().removeAll(player1Hand);
    Player.x = 0;
    for(int i = 0; i < Player.playerHand.size(); i++) {
        player1Hand.set(i, new ImageView("/CARDS/" + Player.playerHand.get(i)));
        player1Hand.get(i).setFitHeight(120);
        player1Hand.get(i).setFitWidth(85);
        player1Hand.get(i).setX(Player.x);
        player1Hand.get(i).setY(300);
        final int temp = i;
        player1Hand.get(i).setOnMouseClicked (event -> {
            Player.playerChooseCard(Player.playerHand, Player.computerHand, MainScreen.mainPile, 1, temp);
            System.out.println("Player 1 Move");
        });
        MainScreen.playPane.getChildren().addAll(player1Hand.get(i));
        Player.x += increment;
    }
}
    public static void updatePlayer2(){//Without the .remove function
        MainScreen.playPane.getChildren().removeAll(player2Hand);
        Player.x = 0;
        int increment;
        if(Player.computerHand.size()>7){
            increment = 50;
        }else {
            increment = 100;
        }
        for(int i = 0; i < Player.computerHand.size(); i++) {
            player2Hand.set(i,new ImageView("/CARDS/"+ Player.computerHand.get(i)));
            player2Hand.get(i).setFitHeight(120);
            player2Hand.get(i).setFitWidth(85);
            player2Hand.get(i).setX(Player.x);
            player2Hand.get(i).setY(20);
            final int temp = i;
            player2Hand.get(i).setOnMouseClicked (event -> {
                Player.playerChooseCard(Player.computerHand, Player.playerHand, MainScreen.mainPile, 2, temp);
                System.out.println("Player 2 Move");
            });
            MainScreen.playPane.getChildren().addAll(player2Hand.get(i));
            Player.x+=increment;
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

                //Update cards on screen
                /*(if(playerVal==1){
                    Platform.runLater(MainScreen.updatePlayer1);
                }else if(playerVal ==2){
                    Platform.runLater(MainScreen.updatePlayer2);
                }*/

            }else if (chosenCardSplit[0].charAt(0) == 'M' ) {
                int buttonSquareSize = 50;
                System.out.println("Enter Color to Switch to");
                AtomicReference<String> ccolor = new AtomicReference<>("");

                //-----------------Creating Buttons-----------------------
                //Red Button
                Button red = new Button();
                red.setStyle("-fx-background-color: #ff0000; -fx-border-width: 5px;");
                red.setTranslateX(500);
                red.setTranslateY(225);
                red.setMinWidth(buttonSquareSize);
                red.setMinHeight(buttonSquareSize);
                MainScreen.playPane.getChildren().addAll(red);

                //Blue Button
                Button blue = new Button();
                blue.setStyle("-fx-background-color: #3498DB; -fx-border-width: 5px;");
                blue.setTranslateX(551);
                blue.setTranslateY(174);
                blue.setMinWidth(buttonSquareSize);
                blue.setMinHeight(buttonSquareSize);
                MainScreen.playPane.getChildren().addAll(blue);

                //Yellow Button
                Button yellow = new Button();
                yellow.setStyle("-fx-background-color: #F4D03F; -fx-border-width: 5px;");
                yellow.setTranslateX(500);
                yellow.setTranslateY(174);
                yellow.setMinWidth(buttonSquareSize);
                yellow.setMinHeight(buttonSquareSize);
                MainScreen.playPane.getChildren().addAll(yellow);

                //Green Button
                Button green = new Button();
                green.setStyle("-fx-background-color: #52BE80; -fx-border-width: 5px;");
                green.setTranslateX(551);
                green.setTranslateY(225);
                green.setMinWidth(buttonSquareSize);
                green.setMinHeight(buttonSquareSize);
                MainScreen.playPane.getChildren().addAll(green);


                //------------Button Actions---------------
                //Red Button Action
                red.setOnMouseClicked(event -> {
                    ccolor.set("r");

                    //Remove All buttons from screen
                    MainScreen.playPane.getChildren().remove(green);
                    MainScreen.playPane.getChildren().remove(blue);
                    MainScreen.playPane.getChildren().remove(red);
                    MainScreen.playPane.getChildren().remove(yellow);
                    String newColor = ccolor.get();


                    //Check for a pick up 4 and colorchange
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
                        // Check for just ColorChange
                    }else if(charSplit[0].equals("14")) {
                        System.out.println("CC");
                        deckPile.add(chosenCard);
                        playerhand.remove(index);
                        int size = deckPile.size()-2;
                        removal = index;
                        System.out.println("this is to seee whats going on: " + newColor);
                        colourChange(newColor,deckPile,size);
                    }

                    //Update cards on screen
                    /*if(playerVal==1){
                        Platform.runLater(MainScreen.updatePlayer1);
                        Platform.runLater(MainScreen.updatePane);
                    }else if(playerVal ==2){
                        Platform.runLater(MainScreen.updatePlayer2);
                        Platform.runLater(MainScreen.updatePane);
                    }*/

                });

                //Blue Button Action
                blue.setOnMouseClicked(event -> {
                    ccolor.set("b");

                    //Remove All buttons from screen
                    MainScreen.playPane.getChildren().remove(green);
                    MainScreen.playPane.getChildren().remove(blue);
                    MainScreen.playPane.getChildren().remove(red);
                    MainScreen.playPane.getChildren().remove(yellow);
                    String newColor = ccolor.get();


                    //Check for a pick up 4 and colorchange
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
                        // Check for just ColorChange
                    }else if(charSplit[0].equals("14")) {
                        System.out.println("CC");
                        deckPile.add(chosenCard);
                        playerhand.remove(index);
                        int size = deckPile.size()-2;
                        removal = index;
                        colourChange(newColor,deckPile,size);
                    }

                    //Update cards on screen
                    /*if(playerVal==1){
                        Platform.runLater(MainScreen.updatePlayer1);
                        Platform.runLater(MainScreen.updatePane);
                    }else if(playerVal ==2){
                        Platform.runLater(MainScreen.updatePlayer2);
                        Platform.runLater(MainScreen.updatePane);
                    }*/

                });

                //Green Button Action
                green.setOnMouseClicked(event -> {
                    ccolor.set("g");


                    //Remove All buttons from screen
                    MainScreen.playPane.getChildren().remove(green);
                    MainScreen.playPane.getChildren().remove(blue);
                    MainScreen.playPane.getChildren().remove(red);
                    MainScreen.playPane.getChildren().remove(yellow);
                    String newColor = ccolor.get();

                    //Check for a pick up 4 and colorchange
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
                        // Check for just ColorChange
                    }else if(charSplit[0].equals("14")) {
                        System.out.println("CC");
                        deckPile.add(chosenCard);
                        playerhand.remove(index);
                        int size = deckPile.size()-2;
                        removal = index;
                        colourChange(newColor,deckPile,size);
                    }

                    //Update cards on screen
                    if(playerVal==1){
                        Platform.runLater(MainScreen.updatePlayer1);
                        Platform.runLater(MainScreen.updatePane);
                    }else if(playerVal ==2){
                        Platform.runLater(MainScreen.updatePlayer2);
                        Platform.runLater(MainScreen.updatePane);
                    }

                });

                //Yellow Button Action
                yellow.setOnMouseClicked(event -> {
                    ccolor.set("y");
                    System.out.println(ccolor.get());

                    //Remove All buttons from screen
                    MainScreen.playPane.getChildren().remove(green);
                    MainScreen.playPane.getChildren().remove(blue);
                    MainScreen.playPane.getChildren().remove(red);
                    MainScreen.playPane.getChildren().remove(yellow);
                    String newColor = ccolor.get();
                    System.out.println("this is to seee whats going on: " + newColor);

                    //Check for a pick up 4 and colorchange
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
                     // Check for just ColorChange
                    }else if(charSplit[0].equals("14")) {
                        System.out.println("CC");
                        deckPile.add(chosenCard);
                        playerhand.remove(index);
                        int size = deckPile.size()-2;
                        removal = index;
                        colourChange(newColor,deckPile,size);
                    }

                    //Update cards on screen
                    /*if(playerVal==1){
                        Platform.runLater(MainScreen.updatePlayer1);
                        Platform.runLater(MainScreen.updatePane);
                    }else if(playerVal ==2){
                        Platform.runLater(MainScreen.updatePlayer2);
                        Platform.runLater(MainScreen.updatePane);
                    }*/

                });


            }else{
                //If input is wrong then do nothing and give player another chance
                System.out.println("------Wrong Input Try AGAIN------");
                whoGoesFirst = !whoGoesFirst;
            }

            //Switch player's turn
          //  whoGoesFirst = !whoGoesFirst;
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
                    //Switch player's turn
                    whoGoesFirst = !whoGoesFirst;

                }else if(playerVal ==2){
                    //Switch player's turn
                    whoGoesFirst = !whoGoesFirst;


                }


            }else if(charSplit[0].equals("11")){//Reverse
                System.out.println("Reverse");
                if(playerVal==1){
                    whoGoesFirst = !whoGoesFirst;

                }else if(playerVal ==2){
                    whoGoesFirst = !whoGoesFirst;


                }

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


