package sample;
import javafx.application.Platform;

import static sample.MainScreen.*;


public class timer implements Runnable{

    private int playerVal;
    int timeLimit = 20;
    public static volatile int secs = 0;

    public timer(int playerVal){
        this.playerVal = playerVal;
    }

    public void run() {

        while(secs<=timeLimit){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {e.printStackTrace();}

            Platform.runLater(callTD);
            secs++;

            if(secs==(timeLimit+1)){
                if(playerVal==1){
                    secs = 1;
                    Player.DrawCard(true);
                    UpdateAfterDrawCardP1();
                    MainScreen.player2Move();
                }else if(playerVal==2){
                    secs = 1;
                    Player.DrawCard(false);
                    UpdateAfterDrawCardP2();
                    MainScreen.player1Move();
                }
            }

        }
        secs = 0;

    }
    public void stop(){
        secs = (timeLimit+1);
    }

}