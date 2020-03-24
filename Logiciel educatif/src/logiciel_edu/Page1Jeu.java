/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author antoine dulhoste
 */
public class Page1Jeu extends Fenetre {
    
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #3b7af7;-fx-font-size: 2em;-fx-text-fill: white;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #6898f7;-fx-font-size: 2em;-fx-text-fill: white;";
    private Text aide;
    private final Materials mat;
    private final GridPane grid;
    
    public Page1Jeu(){
        mat = new Materials();
        
        //Grid
        grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        //ImageViews
        ImageView imageViewR =mat.createImage("route.jpg", 1200, 675, 0, 0, 0);
        ImageView imageViewS =mat.createImage("smoke.png", 45, 45, 65.0, 685, 480);
        ImageView imageViewV =mat.createImage("voiture.png", 200, 200, 0, 500, 380);
        imageViewS.setOpacity(1);
        ImageView imageViewA =mat.createImage("red arrow.png", 100, 53, 320.0, 685, 440);
        imageViewA.setOpacity(0);
        
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
        
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(30000), 
        		event-> {
                                imageViewA.setOpacity(1);
        		}
		));
        t.play();
        
        
        root.getChildren().setAll(imageViewR);
        root.getChildren().addAll(imageViewA,imageViewV,imageViewS,grid);
        this.setScene(scene);
    }
    
    public void changer(int sousPage){
        grid.getChildren().clear();
        switch(sousPage){
            case 1 :
                Button bsmoke = mat.createBtn("La fumée","smoke.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,2,page1Jeu);
                Button bvitre = mat.createBtn("La vitre","vitre.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,51,page1Jeu);
                Button broue = mat.createBtn("La roue","roue.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,52,page1Jeu);
                aide = mat.createText("Qu'est-ce qui pollue dans une voiture ?");
                grid.add(bvitre, 5, 70);
                grid.add(bsmoke, 15, 70);
                grid.add(broue, 25, 70);
                grid.add(aide, 7,50,50, 4);
                
                break;
            case 2 :
                Button byes = mat.createBtn("Oui","good.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,3,page1Jeu);
                Button bno = mat.createBtn("Non","bad.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,53,page1Jeu);
                aide = mat.createText("Est-ce que la fumée est dangereuse pour la santé ?");
                grid.add(byes, 15, 70);
                grid.add(bno, 30, 70);
                grid.add(aide, 15,50,50, 4);
                break;
            default:
                aide = mat.createText("Page par défault");
                grid.add(aide, 15,50,50, 4);
                break;
        }
    }
    
    
}
