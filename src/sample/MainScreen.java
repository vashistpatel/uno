package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainScreen extends Application {
    Pane instructPane = new Pane();
    public static Pane playPane = new Pane();
    Pane scorePane = new Pane();
    Pane pane = new Pane();

    Button instructions = new Button("INSTRUCTIONS");
    Button play = new Button("PLAY");
    Button score = new Button("SCORE");

    Image image = new Image("CARDS/background.png");
    static Image back = new Image("CARDS/BACK.png");
    public static ImageView pile = new ImageView(back);

    BackgroundImage bImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT , BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    Background background = new Background(bImage);

    public static boolean turnChecker = true;
    ArrayList<String> mainPile = deckPile.initializePile(Player.PlayingCards(),deckPile.Pile(),Player.playerHand,Player.computerHand);

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("UNO");
        createInstructButton();
        createScoreButton();
        createPlayButton();

        Thread game = new Thread(new Runnable() {
            @Override
            public void run() {
                gameplay();
            }
        });

        play.setOnAction(event ->{
            stage.setScene(playScreen());

            pile.setFitHeight(120);
            pile.setFitWidth(85);
            pile.setX(image.getWidth()*.35);
            pile.setY(image.getHeight()*.35);
            playPane.getChildren().addAll(pile);

            game.start();

        });

        instructions.setOnAction(event -> {
            Text heading = new Text("How To Play");
            heading.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 50));
            heading.setFill(Color.DARKRED);
            heading.setY(50);
            heading.setX(220);

            Rectangle textBox = new Rectangle(750.0, 75.0, Color.BLACK);
            instructPane.getChildren().addAll(textBox, heading);
            stage.setScene(instructScreen());
        });

        score.setOnAction(event ->
                stage.setScene(scoreScreen())
        );

        stage.setScene(mainScreen());
        stage.show();

    }
    public Scene mainScreen(){
        pane.getChildren().addAll(play, instructions, score);
        pane.setBackground(background);
        Scene iScene = new Scene(pane ,image.getWidth(),image.getHeight());
        return iScene;
    }
    public Scene playScreen(){
        playPane.getChildren().addAll();
        playPane.setBackground(background);
        Scene playScene = new Scene(playPane ,image.getWidth(),image.getHeight());
        return playScene;
    }
    public Scene instructScreen(){
        instructPane.getChildren().addAll(play);
        instructPane.setBackground(background);
        Scene instructScene = new Scene(instructPane ,image.getWidth(),image.getHeight());
        createPlayButton();
        return instructScene;
    }
    public Scene scoreScreen(){
        scorePane.setBackground(background);
        Scene scoreScene = new Scene(scorePane ,image.getWidth(),image.getHeight());
        createPlayButton();
        return scoreScene;
    }

    public void createInstructButton(){
        instructions.setLayoutX(image.getWidth()*.66);
        instructions.setLayoutY(image.getHeight()*.85);
        instructions.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00); -fx-background-radius: 30;-fx-background-insets: 0;-fx-text-fill: white;");
        instructions.setMinSize(100, 50);
    }
    public void createPlayButton() {
        play.setLayoutX(image.getWidth() * .45);
        play.setLayoutY(image.getHeight() * .85);
        play.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00); -fx-background-radius: 30;-fx-background-insets: 0;-fx-text-fill: white;");
        play.setMinSize(100, 50);
    }
    public void createScoreButton() {
        score.setLayoutX(image.getWidth() * .25);
        score.setLayoutY(image.getHeight() * .85);
        score.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00); -fx-background-radius: 30;-fx-background-insets: 0;-fx-text-fill: white;");
        score.setMinSize(100, 50);
    }

    // Removes the cards once played from player 1's hand
    Runnable updatePlayer1 = new Runnable() {
        @Override
        public void run() {
            rules.UpdatePlayer1();
        }
    };

    // Removes the cards once played from player 2's hand
    Runnable updatePlayer2 = new Runnable() {
        @Override
        public void run() {
            rules.UpdatePlayer2();
        }
    };
    // Updates the played cards pile with the cards that are played
    Runnable updatePane = new Runnable() {
        @Override
        public void run() {
            deckPile.getLast();
        }
    };

    // Outputs player 1's initial hand
    Runnable updateP1 = new Runnable() {
        @Override
        public void run() {
            Player.p1Hand();
        }
    };
    public static Runnable add4 = new Runnable() {
        @Override
        public void run() {
            rules.add4ToHand(Player.playerHand, Player.computerHand);
        }
    };


    // Output's player 2's initial hand
    Runnable updateP2 = new Runnable() {
        @Override
        public void run() {
            Player.p2Hand();
        }
    };
    public void gameplay(){
        Player.playerHand();
        Player.computerHand();

        int chooseWhoGoesFirst = rules.whoGoesFirst;

        Platform.runLater(updateP1);
        Platform.runLater(updateP2);

        pile.setOnMouseClicked(event -> {Player.DrawCard(turnChecker);});
        while(Player.playerHand.size()>0 && Player.computerHand.size()>0){
            if(chooseWhoGoesFirst==1){
                player1Move();
                player2Move();
            }else{
                player2Move();
                player1Move();
            }
        }
    }
    public void player1Move (){
        turnChecker = true;
        pile.setDisable(true);
        Platform.runLater(updatePane);
        System.out.println("-------Player1-----------");
        System.out.println("Deck:"+deckPile.Pile());
        System.out.println("Player Hand: "+Player.playerHand);
        pile.setDisable(false);
        Player.playerChooseCard(Player.playerHand,Player.computerHand,mainPile);
        Platform.runLater(updatePlayer1);
        System.out.println("Deck: "+deckPile.Pile());
        pile.setDisable(true);
    }
    public void player2Move (){
        turnChecker = false;
        pile.setDisable(true);
        Platform.runLater(updatePane);
        System.out.println("-------Player2-----------");
        System.out.println("Deck:"+deckPile.Pile());
        System.out.println("Computer Hand: " +Player.computerHand);
        pile.setDisable(false);
        Player.playerChooseCard(Player.computerHand,Player.playerHand,mainPile);
        Platform.runLater(updatePlayer2);
        System.out.println("Computer Hand: " +Player.computerHand);
        pile.setDisable(true);
    }
}
