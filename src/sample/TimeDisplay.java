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

public class TimeDisplay {
    static Stage subStage = new Stage();
    public static volatile Text t = new Text();
    public static void TimeDisplay2(int i)
    {


       // subStage.setTitle("Timer");
        Text title = new Text();
        title.setText("Timer:");
        title.setX(100);
        title.setY(10);
        title.setFont(Font.font("Apple Casual",22));


        GridPane root = new GridPane();
        root.add(title,1,0);
        //root.getChildren().addAll(title);
        root.setAlignment(Pos.CENTER);
        subStage.setX(1225);
        subStage.setY(200);
        Scene scene = new Scene(root, 150, 100);

        //Text t = new Text();
        t.setText("   " +Integer.toString(i));
       /* t.setX(150);
        t.setY(50);
        t.setX(150);
        t.setY(300);*/
        t.setFont(Font.font("Apple Casual",22));

        //MainScreen.playPane.getChildren().addAll(t);

        root.add(t,1,1);
        subStage.setScene(scene);
        subStage.show();
    }
}