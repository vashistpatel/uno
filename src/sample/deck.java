import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class DECK extends Application {

    public static void DECK(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

        ArrayList<String> CARDS = new ArrayList<String>();
        char[] tempC = new char[4];
        tempC[0] = 'R';
        tempC[1] = 'Y';
        tempC[2] = 'G';
        tempC[3] = 'B';

        for(int i =0;i<4;i++){
            for(int k =0;k<10;k++){
                CARDS.add(tempC[i]+"_"+k);

            }
        }
        ArrayList<String> playingCards = new ArrayList<String>(CARDS);
        System.out.println(playingCards);


    }
}
