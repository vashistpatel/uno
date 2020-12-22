package sample;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class playerDisplay{
    public static volatile Label p = new Label();
    public static void playerDisplay2(boolean i)
    {
        try{
            //Set number for timer
            System.out.println("playerDisplay:"+i);
            if (i == true){
                System.out.println("do i get ran?");
                p.setText("1's");
                p.setTranslateX(150);
                p.setTranslateY(200);
                p.setTextFill(Color.WHITE);
                p.setFont(Font.font("Cooper Black",25));
                MainScreen.playPane.getChildren().addAll(p);

            }
            else if(i == false ){
                p.setText("2's");
                p.setTranslateX(150);
                p.setTranslateY(200);
                p.setTextFill(Color.WHITE);
                p.setFont(Font.font("Cooper Black",25));
                MainScreen.playPane.getChildren().addAll(p);
            }

        }
        catch(Exception e){

        }
    }
}