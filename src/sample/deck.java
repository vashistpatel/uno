package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
/*
 * Saenthuran & Vethushon worked on Deck.java
 *
 * */
public class deck {

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
    public static String drawCard(ArrayList<String> s){
        if(s.size()==0){
            upDateDeck(s);
        }else{
            String card = s.get(0);
            s.remove(0);
            return card;
        }
    }
    public String upDateDeck(ArrayList<String> s,Human player1, AI player2){
        ArrayList<String> CARDS = new ArrayList<String>();
        CARDS = initalizeDeck();
        for(int i =0;i<40;i++){
            //Create a function that puts both players cards into an array then checks that arary with new deck
            for(int j=0;j<human.deck.length()+ai.deck.length();j++){
                if(CARDS.get(i) ==totalDecks[j]){
                    CARDS.remove(i);
                }


            }
        }
        return drawCard(CARDS);
    }
    public ArrayList<String> pileCard(ArrayList<String> pilesCard, ArrayList<String> playerCards){

        return pilesCard;

    }
    public void pileCard(ArrayList<String> pCard, ArrayList<String> playerCards, int x){
        pCard.add(playerCards.get(x));
        playerCards.remove(x);
    }
}