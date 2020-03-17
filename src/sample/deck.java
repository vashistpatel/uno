package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
/*
 * Saenthuran & Vethushon worked on Deck.java
 *
 * */
public  class deck {

    public static ArrayList<String> initalizeDeck(){
        /**/
        ArrayList<String> CARDS = new ArrayList<String>();
        char[] tempC = new char[4];
        tempC[0] = 'R';
        tempC[1] = 'Y';
        tempC[2] = 'G';
        tempC[3] = 'B';

        for(int i =0;i<4;i++){
            for(int k =0;k<10;k++){
                CARDS.add(tempC[i]+"_"+k+".png");

            }
        }
        Collections.shuffle(CARDS);
        ArrayList<String> playingCards = new ArrayList<String>(CARDS);
        return playingCards;
    }


    public static String drawCard(ArrayList<String> s,ArrayList<String> player1, ArrayList<String> player2){
        String card = "temp";
        if(s.size()==0){
            upDateDeck(s,player1,player2);
        }else{
            card = s.get(0);
            s.remove(0);
        }
        return card;
    }


    public static String upDateDeck(ArrayList<String> s,ArrayList<String> player1, ArrayList<String> player2){
        ArrayList<String> CARDS = new ArrayList<String>();
        CARDS = initalizeDeck();
        ArrayList<String> totalDecks = new ArrayList<String>();
        for(int j=0;j<player1.size();j++){
            totalDecks.set(j,player1.get(j));
        }
        for(int i =0;i<40;i++){
            //Create a function that puts both players cards into an array then checks that arary with new deck
            for(int j=0;j<player1.size();j++){
                if(CARDS.get(i) ==totalDecks.get(j)){
                    CARDS.remove(i);
                }


            }
        }
        for(int j=0;j<player2.size();j++){
            totalDecks.set(j,player2.get(j));
        }
        for(int i =0;i<40;i++){
            //Create a function that puts both players cards into an array then checks that arary with new deck
            for(int j=0;j<player2.size();j++){
                if(CARDS.get(i) ==totalDecks.get(j)){
                    CARDS.remove(i);
                }


            }
        }
        return drawCard(CARDS,player1,player2);
    }




    public void addToPile(ArrayList<String> pCard, ArrayList<String> playerCards, int x){
        pCard.add(playerCards.get(x));
        playerCards.remove(x);
    }
}