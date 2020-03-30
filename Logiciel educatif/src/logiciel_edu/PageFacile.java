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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author antoine dulhoste
 */
public class PageFacile extends Fenetre {
    
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #3b7af7;-fx-font-size: 2em;-fx-text-fill: white;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #6898f7;-fx-font-size: 2em;-fx-text-fill: white;";
    private Text aide;
    private final Materials mat= new Materials();;
    private final GridPane grid = new GridPane();;
    private Timeline t, timeline, timeline2;
    private ImageView imageViewA,imageViewV;
    //ImageViews
    private ImageView imageViewS =mat.createImageToClick("smoke.png", 45, 45, 65.0, 685, 480,2,pageFacile,grid);
    private final ImageView imageViewR =mat.createImage("route.jpg", 1200, 675, 0, 0, 0);
    
    public PageFacile(){
        //Grid
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        imageViewS.setOpacity(1);
        imageViewA =mat.createImage("red arrow.png", 100, 53, 320.0, 685, 440);
        imageViewA.setOpacity(0);
        
        //timeline qui permet de faire clignoter le press to start
        
        
        t = new Timeline(new KeyFrame(
        		Duration.millis(20000), 
        		event-> {
                                imageViewA.setOpacity(1);
        		}
		));
        
        root.getChildren().setAll(imageViewR);
        root.getChildren().addAll(imageViewA,imageViewS,grid);
        this.setScene(scene);
    }
    
    public void clearAndSetBackground(ImageView imageViewR,ImageView imageViewS){
        root.getChildren().clear();
        root.getChildren().setAll(imageViewR);
        root.getChildren().addAll(imageViewA,imageViewS,grid);
    }
    
    public void changer(int sousPage){
        grid.getChildren().clear();
        if(t != null)
            t.stop();
        if(timeline != null)
            timeline.stop();
        if(timeline2 != null)
            timeline2.stop();
        switch(sousPage){
            case 1 :
                imageViewS.setOpacity(0);
                imageViewV =mat.createImageToClick("voiture.png", 200, 200, 0, 500, 380,51,pageFacile,grid);
                imageViewS =mat.createImageToClick("smoke.png", 45, 45, 65.0, 685, 480,2,pageFacile,grid);
                aide = mat.createText("Clique sur ce qui pollue dans une voiture",Color.GREEN);
                grid.add(aide, 7,50,50, 2);
                timeline = new Timeline(new KeyFrame(
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
                root.getChildren().add(imageViewV);
                root.getChildren().add(imageViewS);
                t.play();
                break;
            case 2 :
                imageViewA.setOpacity(0);
                aide = mat.createText("Trouve la fumée, qui est dangereuse pour la santé",Color.GREEN);
                imageViewV =mat.createImageToClick("voiture.png", 200, 200, 0, 500, 380,52,pageFacile,grid);
                imageViewS =mat.createImageToClick("smoke.png", 45, 45, 65.0, 685, 480,3,pageFacile,grid);
                grid.add(aide, 7,50,50, 2);
                timeline.play();
                t.play();
                root.getChildren().add(imageViewV);
                root.getChildren().add(imageViewS);
                break;
            case 3 :
                timeline.play();
                imageViewV =mat.createImageToClick("bike.png", 200, 200, 0, 250, 380,4,pageFacile,grid);
                imageViewS =mat.createImageToClick("smoke.png", 45, 45, 65.0, 685, 480,53,pageFacile,grid);
                ImageView imageViewS2 =mat.createImageToClick("smoke.png", 45, 45, 220.0, 45, 500,53,pageFacile,grid);
                ImageView imageViewV1 =mat.createImageToClick("voiture.jpg", 200, 200, 0, 400, 380,54,pageFacile,grid);
                ImageView imageViewV2 =mat.createImageToClick("scooter.png", 200, 200, 0, 50, 380,55,pageFacile,grid);
                aide = mat.createText("Clique sur ce qui est le plus écologique",Color.GREEN);
                grid.add(aide, 15,50,50, 2);
                timeline2 = new Timeline(new KeyFrame(
                                Duration.millis(500), 
                                event-> {
                                        if (imageViewS2.getOpacity()==1) {
                                                imageViewS2.setOpacity(0);	
                                        } else {
                                                imageViewS2.setOpacity(1);
                                        }
                                }
                        ));
                timeline2.setCycleCount(Animation.INDEFINITE);
                timeline2.play();
                root.getChildren().add(imageViewV);
                root.getChildren().add(imageViewS);
                root.getChildren().add(imageViewS2);
                root.getChildren().add(imageViewV1);
                root.getChildren().add(imageViewV2);
                break;
            case 4 :
                clearAndSetBackground(imageViewR,imageViewS);
                imageViewS =mat.createImageToClick("smoke.png", 45, 45, 65.0, 685, 480,59,pageFacile,grid);
                imageViewV2 =mat.createImageToClick("dust.png", 60, 60, 0, 1020, 440,56,pageFacile,grid);
                imageViewV1 =mat.createImageToClick("co2.png", 90, 90, 0, 750, 440,5,pageFacile,grid);
                imageViewS2 =mat.createImageToClick("running.png", 150, 150, 0, 900, 350,57,pageFacile,grid);
                aide = mat.createText("Trouve le CO2",Color.GREEN);
                imageViewV =mat.createImageToClick("voiture.png", 200, 200, 0, 500, 380,58,pageFacile,grid);
                
                grid.add(aide, 15,50,50, 2);
                root.getChildren().add(imageViewV);
                root.getChildren().add(imageViewS);
                root.getChildren().add(imageViewV1);
                root.getChildren().add(imageViewV2);
                root.getChildren().add(imageViewS2);
                break;
            case 5 :
                clearAndSetBackground(imageViewR,imageViewS);
                imageViewS.setOpacity(0);
                imageViewA.setOpacity(0);
                imageViewV2 =mat.createImageToClick("oxygen.png", 90, 90, 0, 500, 450,5,pageFacile,grid);
                imageViewV1 =mat.createImageToClick("cave.png", 150, 150, 0, 600, 550,60,pageFacile,grid);
                imageViewS2 =mat.createImageToClick("carbone.png", 60, 60, 0, 700, 550,61,pageFacile,grid);
                aide = mat.createText("Trouve l'oxygène",Color.GREEN);
                imageViewV =mat.createImageToClick("tree.png", 150, 150, 0, 500, 500,62,pageFacile,grid);
                grid.add(aide, 6,50,50, 2);
                timeline2 = new Timeline(new KeyFrame(
                                Duration.millis(500), 
                                event-> {
                                        if (imageViewV2.getOpacity()==1) {
                                                imageViewV2.setOpacity(0);	
                                        } else {
                                                imageViewV2.setOpacity(1);
                                        }
                                }
                        ));
                timeline2.setCycleCount(Animation.INDEFINITE);
                timeline2.play();
                root.getChildren().add(imageViewV);
                root.getChildren().add(imageViewV1);
                root.getChildren().add(imageViewV2);
                root.getChildren().add(imageViewS2);
                break;
            default:
                aide = mat.createText("Page par défault",Color.GREEN);
                grid.add(aide, 15,50,50, 4);
                break;
        }
    }
    
    
}
