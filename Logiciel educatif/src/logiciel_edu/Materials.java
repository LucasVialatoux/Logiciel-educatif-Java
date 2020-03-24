/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class Materials{
    public Fenetre fenetre;
    
    public Materials(){
        
    }
    
    public Button createBtn(String name, String image, String btnStyle, String btnHoverStyle, int pageToCall){
        Button btn = new Button(name);
        btn.setPrefWidth(300);
        btn.setStyle(btnStyle);
        btn.setOnMouseEntered(e -> btn.setStyle(btnHoverStyle));
        btn.setOnMouseExited(e -> btn.setStyle(btnStyle));
        btn.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                Stage stage = (Stage) btn.getScene().getWindow();
                // do what you have to do
                stage.close();
                switch (pageToCall){
                    case 1:
                        new Page1Jeu();
                    case 2:
                        new Page2Jeu();
                    default:
                        
                }
            }
        });
        String imageURIRoue = new File(image).toURI().toString();
        ImageView imageView = new ImageView(imageURIRoue);
        imageView.setFitWidth(45); 
        imageView.setFitHeight(45);
        imageView.setLayoutX(685);
        imageView.setLayoutY(480);
        btn.setGraphic(imageView);
        
        return btn;
    }
    
    public Text createText(String myText){
        //Creating a Text object 
        Text text = new Text();
        text.setText(myText);
        //Setting font to the text 
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        //Setting the color 
        text.setFill(Color.GREEN);
        
        return text;
    }
}
