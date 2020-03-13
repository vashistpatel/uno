import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScreen extends Application {
    Pane instructPane = new Pane();
    Pane playPane = new Pane();
    Pane scorePane = new Pane();
    Pane pane = new Pane();
    Button instructions = new Button("INSTRUCTIONS");
    Button play = new Button("PLAY");
    Button score = new Button("SCORE");
    Image image = new Image("background.png");
    BackgroundImage bImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT , BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
    Background background = new Background(bImage);

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("UNO");
        createInstructButton();
        createScoreButton();
        createPlayButton();

        play.setOnAction(event ->
                stage.setScene(playScreen())
        );

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
}
