/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import java.io.File;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author lucas
 */
public class Page2Jeu extends Fenetre{
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #3b7af7;-fx-font-size: 2em;-fx-text-fill: white;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #6898f7;-fx-font-size: 2em;-fx-text-fill: white;";
    
    public Page2Jeu(){
        
    
        Materials mat = new Materials();

        String imageURI = new File("route.jpg").toURI().toString(); 
        Image image = new Image(imageURI);
        ImageView imageView = new ImageView(image); 
        imageView.setFitWidth(1200); 
        imageView.setFitHeight(675);
        String imageURIS = new File("smoke.png").toURI().toString(); 
        Image imageS = new Image(imageURIS);
        ImageView imageViewS = new ImageView(imageS); 
        imageViewS.setFitWidth(90); 
        imageViewS.setFitHeight(90);
        imageViewS.setRotate(65.0);
        imageViewS.setLayoutX(685);
        imageViewS.setLayoutY(480);
        imageViewS.setOpacity(1);
        //timeline qui permet de faire clignoter le press to start
        Timeline timeline = new Timeline(new KeyFrame(
        		Duration.millis(500), 
        		event-> {
        			if (imageViewS.getOpacity()==1) {
        				imageViewS.setOpacity(0);	
        			} else {
        				imageViewS.setOpacity(1);
        			}
        		}
		));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        String imageURIA = new File("red arrow.png").toURI().toString(); 
        Image imageA = new Image(imageURIA);
        ImageView imageViewA = new ImageView(imageA); 
        imageViewA.setFitWidth(100); 
        imageViewA.setFitHeight(53);
        imageViewA.setRotate(320.0);
        imageViewA.setLayoutX(685);
        imageViewA.setLayoutY(440);
        imageViewA.setOpacity(0);
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(30000), 
        		event-> {
                                imageViewA.setOpacity(1);
        		}
		));
        t.play();
        
        Button byes = mat.createBtn("Oui","smoke.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,0);
        Button bno = mat.createBtn("Non","vitre.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,0);
        Text aide = mat.createText("Est-ce que la fumée est dangereuse pour la santé ?");
        
        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(byes, 15, 70);
        grid.add(bno, 30, 70);
        grid.add(aide, 7,50,50, 4);
        

        
        root.getChildren().setAll(imageView);
        root.getChildren().add(imageViewA);
        root.getChildren().add(imageViewS);
        root.getChildren().add(grid);
        this.setScene(scene);
    }
}
