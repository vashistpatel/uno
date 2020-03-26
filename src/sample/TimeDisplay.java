package sample;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TimeDisplay {
    public static volatile Text t = new Text();
    public static void TimeDisplay2(int i)
    {


        try{//Text t = new Text();
            t.setText("   " +Integer.toString(i));

            t.setX(90);
            t.setY(225);
            t.setFont(Font.font("Apple Casual",25));

            MainScreen.playPane.getChildren().addAll(t);}catch(Exception e){

        }
    }
}