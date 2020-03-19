package sample;

import java.util.ArrayList;
import java.util.Scanner;

public class rules {
    public static int whoGoesFirst = deck.checkTurn();

    public static int getWhoGoesFirst(){
        return whoGoesFirst;
    }
    public static int setWhoGoesFirst(int x){
        whoGoesFirst = x;
        return whoGoesFirst;
    }
    public static void gameTurn(ArrayList<String> playerhand,ArrayList<String> computerHand, String chosenCard, ArrayList<String> deckPile,int index) {
        String[] chosenCardSplit = chosenCard.split("_", 2);
        int sizeOfDeck = deckPile.size();
        String t2 = deckPile.get(sizeOfDeck - 1);
        String[] topOfDeck = t2.split("_", 2);
        if (chosenCardSplit[0].equals(topOfDeck[0])) {
            deckPile.add(chosenCard);
            playerhand.remove(index);
            cardAction(playerhand,computerHand,chosenCard);
            //
        } else if (chosenCardSplit[1].equals(topOfDeck[1])) {

            deckPile.add(chosenCard);
            playerhand.remove(index);
            cardAction(playerhand,computerHand,chosenCard);
        }  else if (chosenCardSplit[0].charAt(0) == 'M' ) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter Color to Switch to");
            String newColor = input.nextLine();
            newColor += "_ ";
            if (chosenCardSplit[1].equals(13) ) {
                deckPile.add(chosenCard);
                deckPile.add(newColor);
                playerhand.remove(index);
                cardAction(playerhand, computerHand, chosenCard);
            }else {
                deckPile.add(chosenCard);
                deckPile.add(newColor);
                playerhand.remove(index);
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
            }else if(charSplit[0].equals("13")){//+
                computerHand.add((deck.drawCard(Player.PlayingCards(),playerhand,computerHand)));
                computerHand.add((deck.drawCard(Player.PlayingCards(),playerhand,computerHand)));
                computerHand.add((deck.drawCard(Player.PlayingCards(),playerhand,computerHand)));
                computerHand.add((deck.drawCard(Player.PlayingCards(),playerhand,computerHand)));

            }else if(charSplit[0].equals("14")){//Colour change

            }else{
                //Do Nothing
            }

        }

    }
}