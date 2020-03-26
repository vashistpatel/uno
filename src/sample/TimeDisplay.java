package sample;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimeDisplay {
    static Stage subStage = new Stage();
    public static void TimeDisplay2(int i)
    {


        subStage.setTitle("New Stage");


        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        subStage.setX(1225);
        subStage.setY(200);
        Scene scene = new Scene(root, 100, 100);

        Text t = new Text();
        t.setText(Integer.toString(i));
        t.setX(50);
        t.setY(50);


        root.getChildren().addAll(t);
        subStage.setScene(scene);
        subStage.show();
    }
}