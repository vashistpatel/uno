package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class GameWinner {

    public static void GameWinner2(boolean won){
        Pane winnerPane = new Pane();
        Stage stage2 = new Stage();
        stage2.setTitle("Winner Winner Chiken Dinner!");
        stage2.setScene(new Scene(winnerPane, 450, 450));

        Label p = new Label();

        try{

            if(won == true){
                System.out.println("player 1 won");
                p.setText("player 1 won");
                p.setTranslateX(50);
                p.setTranslateY(250);
                p.setTextFill(Color.BLACK);
                p.setFont(Font.font("Cooper Black",25));
                winnerPane.getChildren().addAll(p);

            } else if (won == false){
                System.out.println("player 2 won");
                p.setText("player 2 won");
                p.setTranslateX(50);
                p.setTranslateY(250);
                p.setTextFill(Color.BLACK);
                p.setFont(Font.font("Cooper Black",25));
                winnerPane.getChildren().addAll(p);
            }

            stage2.showAndWait();
            stage2.close();
        }
        catch(Exception e){
            System.out.println("it has failed");
        }

    }
}
