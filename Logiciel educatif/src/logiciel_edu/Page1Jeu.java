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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author antoine dulhoste
 */
public class Page1Jeu extends Fenetre {
    
    public Page1Jeu(){
        String imageURI = new File("route.jpg").toURI().toString(); 
        Image image = new Image(imageURI);
        ImageView imageView = new ImageView(image); 
        imageView.setFitWidth(1200); 
        imageView.setFitHeight(675);
        String imageURIS = new File("smoke.png").toURI().toString(); 
        Image imageS = new Image(imageURIS);
        ImageView imageViewS = new ImageView(imageS); 
        imageViewS.setFitWidth(45); 
        imageViewS.setFitHeight(45);
        imageViewS.setRotate(65.0);
        imageViewS.setLayoutX(685);
        imageViewS.setLayoutY(480);
        String imageURIV = new File("voiture.png").toURI().toString(); 
        Image imageV = new Image(imageURIV);
        ImageView imageViewV = new ImageView(imageV); 
        imageViewV.setFitWidth(200); 
        imageViewV.setFitHeight(200);
        imageViewV.setLayoutX(500);
        imageViewV.setLayoutY(380);
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
        timeline.setCycleCount( Animation.INDEFINITE);
        timeline.play();
        root.getChildren().setAll(imageView);
        root.getChildren().add(imageViewV);
        root.getChildren().add(imageViewS);
        this.setScene(scene);s
    }
    
}
