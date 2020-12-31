package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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

        Image img = new Image("CARDS/trophy.png",541.5254,700,false, false);
        ImageView mv = new ImageView(img);
//        mv.setFitHeight(450);
//        mv.setFitWidth(348.1235);
        BackgroundImage bImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT , BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(bImage);

        Stage stage2 = new Stage();
        stage2.setTitle("Winner Winner Chiken Dinner!");
        stage2.setScene(new Scene(winnerPane, 541.5254, 700));

        Label p = new Label();

        try{

            if(won == true){
                System.out.println("player 1 won");
                p.setText("player 1 won");
                p.setTranslateX(205);
                p.setTranslateY(590);
                p.setTextFill(Color.BLACK);
                p.setFont(Font.font("Cooper Black",25));
                winnerPane.getChildren().addAll(p);
                winnerPane.setBackground(background);

            } else if (won == false){
                System.out.println("player 2 won");
                p.setText("player 2 won");
                p.setTranslateX(205);
                p.setTranslateY(590);
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
