package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimeDisplay {
    public static void TimeDisplay2()
    {
        Stage subStage = new Stage();

        subStage.setTitle("New Stage");
//        Stage subStage = new Stage();
//        subStage.setTitle("New Stage");

        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 200);


        int i = 99;
        Text t = new Text();
        t.setText(Integer.toString(i));
        t.setX(50);
        t.setY(50);


        root.getChildren().addAll(t);
        subStage.setScene(scene);
        subStage.show();
    }
}