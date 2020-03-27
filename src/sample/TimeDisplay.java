package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class TimeDisplay {
    static Stage subStage = new Stage();
    public static volatile Text t = new Text();
    public static void TimeDisplay2(int i)
    {




        try{//Text t = new Text();
            t.setText("   " +Integer.toString(i));

            t.setX(150);
            t.setY(300);
            t.setFont(Font.font("Apple Casual",22));

            MainScreen.playPane.getChildren().addAll(t);}catch(Exception e){

        }
    }
}