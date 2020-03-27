package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    static ArrayList<String> mainPile = deckPile.initializePile(Player.PlayingCards(), deckPile.Pile(),Player.playerHand,Player.computerHand);
    public static int clickCount = 0;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("UNO");
        createInstructButton();
        createScoreButton();
        createPlayButton();

        //Label for timer
        Label TimeLabel = new Label("Timer:");
        TimeLabel.setTextFill(Color.WHITE);
        TimeLabel.setTranslateX(90);
        TimeLabel.setTranslateY(200);
        TimeLabel.setFont(Font.font("Cooper Black",25));
        MainScreen.playPane.getChildren().addAll(TimeLabel);


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
            //Creating Textfield for server
            TextField text1 = new TextField("Enter !Help");
            text1.setTranslateX(205);
            text1.setTranslateY(261);
            text1.setPrefWidth(400);
            text1.setOpacity(0.85);

            //Creating TextArea for server
            TextArea textArea = new TextArea();
            textArea.setTranslateX(205);
            textArea.setTranslateY(80);
            textArea.setOpacity(0.85);
            textArea.setMaxSize(400,200);
            //Adding TextArea & Text Field to pane
            instructPane.getChildren().add(textArea);
            instructPane.getChildren().add(text1);
            text1.setOnAction(e->{
                try {
                    //If person enters something in textfield calls client class
                    clientClass.sendMessages(text1,textArea);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            stage.setScene(instructScreen());
        });

        score.setOnAction(event -> {
            stage.setScene(scoreScreen());
        });

        stage.setScene(mainScreen());
        stage.show();

    }

    public Scene mainScreen() {
        pane.getChildren().addAll(play, instructions, score);
        pane.setBackground(background);
        Scene iScene = new Scene(pane ,image.getWidth(),image.getHeight());
        return iScene;
    }
    public Scene playScreen() {
        playPane.getChildren().addAll();
        playPane.setBackground(background);
        Scene playScene = new Scene(playPane ,image.getWidth(),image.getHeight());
        return playScene;
    }
    public Scene instructScreen() {
        instructPane.getChildren().addAll(play);
        instructPane.setBackground(background);
        Scene instructScene = new Scene(instructPane ,image.getWidth(),image.getHeight());
        createPlayButton();
        return instructScene;
    }
    public Scene scoreScreen() {
        scorePane.setBackground(background);

        Rectangle textBox = new Rectangle(450, 275, Color.WHITE);
        textBox.setTranslateX(175);
        textBox.setTranslateY(65);
        textBox.setOpacity(0.75);
        scorePane.getChildren().add(textBox);

        // Create a ArrayList that will store the data from the file.
        List<String> stats_array = new ArrayList<>();
        stats_array = FileIO.readFile(FileIO.filename_gameStats);
        int temp = 25;
        for (int i=0;i<stats_array.size(); i++) {
            Label label = new Label(stats_array.get(i));
            label.setText(stats_array.get(i));
            label.setTextFill(Color.BLACK);
            label.setFont(new Font("Arial",25));
            label.setTranslateX(225);
            label.setTranslateY(temp);
            temp += 30;
            scorePane.getChildren().addAll(label);
        }

        // Creates the play button
        scorePane.getChildren().addAll(play);
        createPlayButton();

        Scene scoreScene = new Scene(scorePane ,image.getWidth(),image.getHeight());
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
    public static Runnable updatePlayer1withoutRemove = new Runnable() {
        @Override
        public void run() {
            rules.updatePlayer1();
        }
    };
    public static Runnable updatePlayer2withoutRemove = new Runnable() {
        @Override
        public void run() {
            rules.updatePlayer2();
        }
    };
    public static Runnable updatePlayer1 = new Runnable() {
        @Override
        public void run() {
            rules.UpdatePlayer1();
        }
    };

    // Removes the cards once played from player 2's hand
    public static Runnable updatePlayer2 = new Runnable() {
        @Override
        public void run() {
            rules.UpdatePlayer2();
        }
    };
    // Updates the played cards pile with the cards that are played
    static Runnable updatePane = new Runnable() {
        @Override
        public void run() {
            deckPile.getLast();
        }
    };

    public static Runnable add2ToPlayer1 = new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<2;i++) {
                Player.DrawCard(true);
                rules.updatePlayer1();
            }
        }
    };

    public static Runnable add2ToPlayer2 = new Runnable() {
        @Override
        public void run() {
            for(int i =0;i<2;i++) {
                Player.DrawCard(false);
                rules.updatePlayer2();
            }
        }
    };

    // Outputs player 1's initial hand
    Runnable updateP1 = new Runnable() {
        @Override
        public void run() {
            Player.p1Hand();
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

        pile.setOnMouseClicked(event -> {
            Player.DrawCard(turnChecker);
        });
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
    public static void plus2CardsP1(){
        Platform.runLater(add2ToPlayer1);
    }


    public static void plus2CardsP2(){
        Platform.runLater(add2ToPlayer2);
    }


    public static void UpdateAfterDrawCardP1(){
        Platform.runLater(updatePlayer1withoutRemove);
    }
    public static void UpdateAfterDrawCardP2(){
        Platform.runLater(updatePlayer2withoutRemove);
    }

    public static void player1Move(){
        timer newTime = new timer(1);
        Thread newTimeThread = new Thread(newTime);
        int x =newTimeThread.getPriority();
        System.out.println("rU OF THE WORKING"+x);

        UpdateAfterDrawCardP1();
        newTimeThread.start();
        turnChecker = true;
        pile.setDisable(true);
        Platform.runLater(updatePane);

        System.out.println("-------Player1-----------");
        System.out.println("Deck:"+ deckPile.Pile());
        System.out.println("Player Hand: "+Player.playerHand);
        pile.setDisable(false);
        Player.playerChooseCard(Player.playerHand,Player.computerHand,mainPile,1,newTime);
        Platform.runLater(updatePlayer1);
        System.out.println("Player Hand: "+Player.playerHand);
        System.out.println("Deck: "+ deckPile.Pile());
        pile.setDisable(true);
    }

    public static void player2Move() {
        timer newTime2 = new timer(2);
        Thread newTime2Thread = new Thread(newTime2);
        UpdateAfterDrawCardP2();
        newTime2Thread.start();
        int x =newTime2Thread.getPriority();
        turnChecker = false;
        pile.setDisable(true);
        Platform.runLater(updatePane);

        System.out.println("-------Player2-----------");
        System.out.println("Deck:"+ deckPile.Pile());
        System.out.println("Computer Hand: " +Player.computerHand);
        pile.setDisable(false);
        Player.playerChooseCard(Player.computerHand,Player.playerHand,mainPile,2,newTime2);
        Platform.runLater(updatePlayer2);
        System.out.println("Computer Hand: " +Player.computerHand);
        pile.setDisable(true);
    }
    public static Runnable callTD = new Runnable() {
        @Override
        public void run() {
            TimeDisplay.TimeDisplay2(timer.secs);
        }
    };


}
