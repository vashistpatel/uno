package sample;
import javafx.application.Platform;
import static sample.MainScreen.*;

public class timer implements Runnable{

    private int playerVal;
    int timeLimit = 20; //sets the timer limit in seconds
    public static volatile int secs = 0;

    //constructor
    public timer(int playerVal){
        this.playerVal = playerVal;
    }

    public void run() {

        //iterates over each number from zero up
        while(secs<=timeLimit){

            try {
                Thread.sleep(1000); //pauses the thread for 1 second
            } catch (InterruptedException e) {e.printStackTrace();}

            Platform.runLater(callTD); //outputs the seconds
            secs++;

            //changes player turn and hands player a card, if time exceeded
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
        secs = 0; //resets the timer back to 0

    }
    //stops the while loop above
    public void stop(){
        secs = (timeLimit+1);
    }

}