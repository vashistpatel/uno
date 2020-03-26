package sample;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public  class deck {

    //Figures out who goes first
    public static int checkTurn(){
        Random rand = new Random();
        int randomInt = rand.nextInt(2) + 1;
        return randomInt;
    }

    //initalize deck
    public static ArrayList<String> initalizeDeck(){
        //intialize array Cards
        ArrayList<String> CARDS = new ArrayList<String>();
        char[] tempC = new char[4];
        tempC[0] = 'R';
        tempC[1] = 'Y';
        tempC[2] = 'G';
        tempC[3] = 'B';
        int [] blackCTemp = new int[2];
        blackCTemp[0] = 13;
        blackCTemp[1] = 14;

        //Assign card to png
        for(int i =0;i<4;i++){
            for(int k =0;k<13;k++){
                CARDS.add(tempC[i]+"_"+k+".png");
            }
        }

        //Assign special card to png
        for(int i =0;i<2;i++){
            for(int k=0;k<4;k++){
                CARDS.add("M_"+blackCTemp[i]+".png");
            }
        }
        //shuffle cards
        Collections.shuffle(CARDS);
        //create new arraylist
        ArrayList<String> playingCards = new ArrayList<String>(CARDS);
        return playingCards;
    }


    //pick up a card
    public static String drawCard(ArrayList<String> s,ArrayList<String> player1, ArrayList<String> player2){
        String card = "temp";
        if(s.size()==0){
            upDateDeck(s,player1,player2);
        }else{
            //10-12,M OR 13-14
            card = s.get(0);
            s.remove(0);
        }
        return card;
    }
    public static String deckDrawCard(ArrayList<String> s,ArrayList<String> player1, ArrayList<String> player2){
        System.out.println("Old Deck");
        System.out.println(s);
        String tempCard = s.get(0);
        String[] cardSplit =  tempCard.split("_",2);
        String[] charSplit = cardSplit[1].split("\\.",2);
        int result = Integer.parseInt(charSplit[0]);
        int i =0;
        while(cardSplit[0].equals("M")||result>9){
            i++;
            tempCard = s.get(i);
            cardSplit =  tempCard.split("_",2);
            charSplit = cardSplit[1].split("\\.",2);
            result = Integer.parseInt(charSplit[0]);
        }
        String card =s.get(i);
        System.out.println("New Deck");
        System.out.println(s);

        s.remove(i);
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
                if(CARDS.get(i) == totalDecks.get(j)){
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



    //add card in player to the pile
    public static ArrayList<String> addToPile(ArrayList<String> pCard, ArrayList<String> playerCards, int x){
        pCard.add(playerCards.get(x));
        playerCards.remove(x);
        return playerCards;
    }


}