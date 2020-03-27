package sample;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class TimeDisplay {
    public static volatile Label t = new Label();
    public static void TimeDisplay2(int i)
    {
        try{
            //Set number for timer
            t.setText(Integer.toString(i));
            t.setTranslateX(120);
            t.setTranslateY(220);
            t.setTextFill(Color.WHITE);
            t.setFont(Font.font("Cooper Black",25));
            MainScreen.playPane.getChildren().addAll(t);}catch(Exception e){

        }
    }
}