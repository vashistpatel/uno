package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends Application {
    //initializing pane
    Pane instructPane = new Pane();
    public static Pane playPane = new Pane();
    Pane scorePane = new Pane();
    Pane pane = new Pane();

    //initialize "play" button
    Button instructions = new Button("INSTRUCTIONS");
    Button play = new Button("PLAY");
    Button score = new Button("SCORE");
    public static Button makeMove = new Button("Make Move");

    //Initialize background, and uno card back images
    Image image = new Image("CARDS/background.png");
    static Image back = new Image("CARDS/BACK.png");
    public static ImageView pile = new ImageView(back);

    static TextField userInput = new TextField("Positions start from 0");

    //sets the background and uno card back images
    BackgroundImage bImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT , BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    Background background = new Background(bImage);
    public static TextField UserInput = new TextField();

    public static boolean turnChecker = true;
    public static int count= 0;
    //keeps track of cards that have been played
    static ArrayList<String> mainPile = deckPile.initializePile(Player.PlayingCards(), deckPile.Pile(), Player.playerHand, Player.computerHand);


    @Override
    public void start(Stage stage) {
        stage.setTitle("UNO");
        createInstructButton();
        createScoreButton();
        createPlayButton();

        //Label for timer
//        Label TimeLabel = new Label("Player       Turn");
//        TimeLabel.setTextFill(Color.BLACK);
//        TimeLabel.setTranslateX(60);
//        TimeLabel.setTranslateY(200);
//        TimeLabel.setFont(Font.font("Cooper Black",25));
//        MainScreen.playPane.getChildren().addAll(TimeLabel);

        Thread game = new Thread(() -> gameplay());

        play.setOnAction(event ->{ //play button -> sets the images and starts the game.
            stage.setScene(playScreen());

            pile.setFitHeight(120);
            pile.setFitWidth(85);
            pile.setX(image.getWidth()*.35);
            pile.setY(image.getHeight()*.35);

            playPane.getChildren().addAll(pile);

            Player.playerHand();
            Player.computerHand();

            Platform.runLater(updateP1);
            Platform.runLater(updateP2);
            playerDisplay.playerDisplay2(turnChecker);

            game.start();
        });

        instructions.setOnAction(event -> { //instructions button
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

    //sets up the scene in main intro window
    public Scene mainScreen() {
        pane.getChildren().addAll(play, instructions, score);
        pane.setBackground(background);
        Scene iScene = new Scene(pane ,image.getWidth(),image.getHeight());
        return iScene;
    }
    //sets up the screen play screen.
    public Scene playScreen() {
        playPane.getChildren().addAll();
        playPane.setBackground(background);
        HBox hbox = new HBox(playPane);
        HBox.setHgrow(playPane, Priority.ALWAYS);
        hbox.setPrefSize(900, 700);
        hbox.getChildren().add(userInput);


        HBox ui = new HBox();
        ui.getChildren().add(new Label("Enter Position of Card      "));
        ui.getChildren().addAll(userInput, makeMove);
        ui.setLayoutY(image.getHeight()*1.03);
        ui.setLayoutX(image.getWidth()*.2);
        Scene playScene = new Scene(new Group(hbox,ui) ,image.getWidth(),image.getHeight()+50);
        return playScene;
    }
    //sets up the instructions window
    public Scene instructScreen() {
        instructPane.getChildren().addAll(play);
        instructPane.setBackground(background);
        Scene instructScene = new Scene(instructPane ,image.getWidth(),image.getHeight());
        createPlayButton();
        return instructScene;
    }
    //sets up the score screen
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
        for (int i = 0; i < stats_array.size(); i++) {
            Label label = new Label(stats_array.get(i));
            label.setText(stats_array.get(i));
            label.setTextFill(Color.BLACK);
            label.setFont(new Font("Arial", 25));
            label.setTranslateX(225);
            label.setTranslateY(temp);
            temp += 30;
            scorePane.getChildren().addAll(label);
        }

        // Creates the play button
        scorePane.getChildren().addAll(play);
        createPlayButton();

        Scene scoreScene = new Scene(scorePane, image.getWidth(), image.getHeight());
        return scoreScene;

    }
    //Button for instruction
    public void createInstructButton(){
        instructions.setLayoutX(image.getWidth()*.66);
        instructions.setLayoutY(image.getHeight()*.85);
        instructions.setStyle("-fx-background-color: linear-gradient(#ff9500, #be2d00); -fx-background-radius: 50;-fx-background-insets: 0;-fx-text-fill: white;");
        instructions.setMinSize(100, 50);
    }
    //Button for Entering te game
    public void createPlayButton() {
        play.setLayoutX(image.getWidth() * .45);
        play.setLayoutY(image.getHeight() * .85);
        play.setStyle("-fx-background-color: linear-gradient(#ff9500, #be2d00); -fx-background-radius: 50;-fx-background-insets: 0;-fx-text-fill: white;");
        play.setMinSize(100, 50);
    }
    //Button for Entering Scores page
    public void createScoreButton() {
        score.setLayoutX(image.getWidth() * .25);
        score.setLayoutY(image.getHeight() * .85);
        score.setStyle("-fx-background-color: linear-gradient(#ff9500, #be2d00); -fx-background-radius: 50;-fx-background-insets: 0;-fx-text-fill: white;");
        score.setMinSize(100, 50);
    }

    // Removes the cards once played from player 1's hand
    public static Runnable updatePlayer1 = () -> rules.updatePlayer1();

    // Removes the cards once played from player 2's hand
    public static Runnable updatePlayer2 = () -> rules.updatePlayer2();

    // Updates the played cards pile with the cards that are played
    static Runnable updatePane = () -> deckPile.getLast();

    //add 2 cards to player1 hand
    public static Runnable add2ToPlayer1 = () -> {
        for(int i=0;i<2;i++) {
            Player.DrawCard(true);
            rules.updatePlayer1();
        }
    };

    //add 2 cards to player2 hand
    public static Runnable add2ToPlayer2 = () -> {
        for(int i =0;i<2;i++) {
            Player.DrawCard(false);
            rules.updatePlayer2();
        }
    };

    // Outputs player 1's initial hand
    Runnable updateP1 = () -> Player.p1Hand();

    // Output's player 2's initial hand
    Runnable updateP2 = () -> Player.p2Hand();

    //function that runs the game
    public void gameplay(){
        //draw a card when linked on deck
        pile.setOnMouseClicked(event -> {
            Player.DrawCard(turnChecker);
        });

//        Platform.runLater(callP2);

        //Changing player turns
        while(Player.playerHand.size()>0 && Player.computerHand.size()>0){
            if(rules.whoGoesFirst==true){
                player1Move();
                if(Player.playerHand.size() == 0){Platform.runLater(callP1);}
                System.out.println(Player.playerHand.size());
                player2Move();
                if(Player.computerHand.size() == 0){Platform.runLater(callP2);}

            }else{
                player2Move();
                if(Player.computerHand.size() == 0){Platform.runLater(callP2);}
                player1Move();
                if(Player.playerHand.size() == 0){Platform.runLater(callP1);}

            }
        }

    }

    //call add 2 to player 1
    public static void plus2CardsP1(){
        Platform.runLater(add2ToPlayer1);
    }

    // call add 2 to player 2
    public static void plus2CardsP2(){
        Platform.runLater(add2ToPlayer2);
    }

    //update hand after card is drawn
    public static void UpdateAfterDrawCardP1(){
        Platform.runLater(updatePlayer1);
    }
    public static void UpdateAfterDrawCardP2(){
        Platform.runLater(updatePlayer2);
    }

    // takes player input and makes move
    public static void checkInput (ArrayList<String> playerHand,ArrayList<String> computerHand,
                                   ArrayList<String> deckPile, int x /*, timer t*/){
        count =0;
        userInput.clear();
        //button for entering player input
        while (count ==0){
            if(rules.whoGoesFirst==true) {
                makeMove.setOnMousePressed(event -> {
                    Platform.runLater(updatePlayer2);
                    Platform.runLater(updatePlayer1);
                    Platform.runLater(updatePane);
                    rules.whoGoesFirst=false;
                    count = 1;
                });
            }else{
                makeMove.setOnMousePressed(event -> {
                    Platform.runLater(updatePlayer1);
                    Platform.runLater(updatePlayer2);
                    Platform.runLater(updatePane);
                    rules.whoGoesFirst=true;
                    count = 1;
                });
            }
        }
        count = 0;
    }

    //Move for player one
    public static void player1Move(){
        //Start timer Thread
//        timer newTime = new timer(1);
//        Thread newTimeThread = new Thread(newTime);
        //update player hand
        UpdateAfterDrawCardP1();
//        newTimeThread.start();
//        int x =newTimeThread.getPriority();

        //show it is player 1
        turnChecker = true;
        pile.setDisable(true);
        Platform.runLater(updatePane);
        //Displays Player Turn on screen
        Platform.runLater(callTD);
        System.out.println("-------Player1-----------");
        System.out.println("Deck:"+ deckPile.Pile());
        pile.setDisable(false);
        //get player input and make move
        checkInput(Player.playerHand, Player.computerHand,mainPile,1 /*, newTime*/);


        /*This is if we need it for the future
        if (Player.chosen_card != ""){
            Platform.runLater(updatePlayer1);
        }*/
        //output to terminal
        System.out.println("Player Hand: "+ Player.playerHand);
        System.out.println("Deck: "+ deckPile.Pile());
        pile.setDisable(true);
    }
    // move for player two
    public static void player2Move() {
        //start timer thread
//        timer newTime2 = new timer(2);
//        Thread newTime2Thread = new Thread(newTime2);
        //update player hand
        UpdateAfterDrawCardP2();
//        newTime2Thread.start();
//        int x =newTime2Thread.getPriority();

        //show it is player 2
        turnChecker = false;
        pile.setDisable(true);
        //update pane
        Platform.runLater(updatePane);

        //Displays Player Turn on screen
        Platform.runLater(callTD);
        System.out.println("-------Player2-----------");
        System.out.println("Deck:"+ deckPile.Pile());
        System.out.println("Computer Hand: " + Player.computerHand);
        pile.setDisable(false);
        //player input and make move
        checkInput(Player.computerHand, Player.playerHand,mainPile,2 /*, newTime2*/);

        /*This is if we need it for the future
        if (Player.chosen_card != ""){
            Platform.runLater(updatePlayer2);
        }*/

        // print output to terminal
        System.out.println("Computer Hand: " + Player.computerHand);
        pile.setDisable(true);
    }
    //Runnable to display timer on Mainscreen
    public static Runnable callTD = new Runnable() {
        @Override
        public void run() {
            //System.out.println("Do i get printed at all???");
             //TimeDisplay.TimeDisplay2(timer.secs);
             playerDisplay.playerDisplay2(turnChecker);

        }
    };
    public static Runnable callP1 = new Runnable() {
        @Override
        public void run() {
            GameWinner.GameWinner2(true);
        }
    };
    public static Runnable callP2 = new Runnable() {
        @Override
        public void run() {
            GameWinner.GameWinner2(false);
        }
    };

}
