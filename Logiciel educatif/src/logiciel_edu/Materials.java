/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
    
    public Button createBtn(String name, String image, String btnStyle, String btnHoverStyle, int pageToCall,Page1Jeu page){
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
                //stage.close();
                switch (pageToCall){
                    case 1:
                        page.changer(1);
                        break;
                    case 2:
                        Alert alertB = createAlert("BRAVO !", 
                                "C'est bien la fumée, bravo !", 
                                "Allez, passe vite à la question suivante !",
                                AlertType.INFORMATION);
                        alertB.showAndWait();
                        page.changer(2);
                        break;
                    case 3:
                        Alert alertB1 = createAlert("BRAVO !", 
                                "La fumée est effectivement dangereuse pour nous !", 
                                "Allez, passe vite à la question suivante !",
                                AlertType.INFORMATION);
                        alertB1.showAndWait();
                        page.changer(2);
                        break;
                    case 51:
                        Alert alert1 = createAlert("Tu y es presque :-)", 
                                "Ce n'est pas la vitre, malheureusement", 
                                "La vitre est utile pour regarder dehors, mais ne pollue pas.\nEssaie encore ! Courage !",
                                AlertType.WARNING);
                        alert1.showAndWait();
                        break;
                    case 52:
                        Alert alert2 = createAlert("Tu y es presque :-)", 
                                "Ce n'est pas la roue, malheureusement", 
                                "La roue permet à la voiture de rouler mais ne polue pas.\nEssaie encore ! Courage !",
                                AlertType.WARNING);
                        alert2.showAndWait();
                        break;
                     case 53:
                        Alert alert3 = createAlert("Tu y es presque :-)", 
                                "Attention, la fumée est bien dangereuse pour la santé !", 
                                "Essaie encore ! Courage !",
                                AlertType.WARNING);
                        alert3.showAndWait();
                        break;
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
    public Alert createAlert(String title, String headerText, String content, AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(content);
        return alert;
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
    
    public ImageView createImage(String myImage,int width, int height, double rotate,int layoutX, int layoutY){
        String imageURI = new File(myImage).toURI().toString(); 
        Image image = new Image(imageURI);
        ImageView imageView = new ImageView(image); 
        imageView.setFitWidth(width); 
        imageView.setFitHeight(height);
        if(rotate!=0){
            imageView.setRotate(rotate);
        }
        if(layoutX != 0){
            imageView.setLayoutX(layoutX);
        }
        if (layoutY !=0){
            imageView.setLayoutY(layoutY);
        }
        
        return imageView;
    }
}
