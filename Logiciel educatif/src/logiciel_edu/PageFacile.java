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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author antoine dulhoste
 */
public class PageFacile extends Fenetre {
    
    private Text aide;
    private final Materials mat= new Materials();
    private final GridPane grid = new GridPane();
    private Timeline t, timeline, timeline2;
    private ImageView imageViewA;
    private StackPane imageViewV;
    //ImageViews
    private StackPane imageViewS =mat.createImageToClick("./image/smoke.png", 45, 45, 65.0, 685, 480,2,pageFacile,grid);
    private final ImageView imageViewR =mat.createImage("./image/route.jpg", 1200, 675, 0, 0, 0);
    
    public PageFacile(){
        //Grid
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        imageViewS.setOpacity(1);
        imageViewA =mat.createImage("./image/red arrow.png", 100, 53, 320.0, 685, 440);
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
    
    public void clearAndSetBackground(ImageView imageViewR,StackPane imageViewS){
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
                imageViewV =mat.createImageToClick("./image/voiture.png", 200, 200, 0, 500, 380,2,pageFacile,grid);
                imageViewS =mat.createImageToClick("./image/smoke.png", 45, 45, 65.0, 685, 480,51,pageFacile,grid);
                aide = mat.createText("Trouve la voiture, qui pollue l'environnement",Color.GREEN);
                grid.add(aide, 15,50,50, 2);
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
                break;
            case 2 :
                imageViewS.setOpacity(0);
                aide = mat.createText("Trouve la fumée, qui est dangereuse pour la santé",Color.GREEN);
                imageViewV =mat.createImageToClick("./image/voiture.png", 200, 200, 0, 500, 380,52,pageFacile,grid);
                imageViewS =mat.createImageToClick("./image/smoke.png", 45, 45, 65.0, 685, 480,3,pageFacile,grid);
                grid.add(aide, 15,50,50, 2);
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
            case 3 :
                imageViewA.setOpacity(0);
                imageViewS.setOpacity(0);
                StackPane imageViewV1 =mat.createImageToClick("./image/bike.png", 100, 100, 0, 250, 380,4,pageFacile,grid);
                imageViewS =mat.createImageToClick("./image/smoke.png", 45, 45, 65.0, 685, 480,53,pageFacile,grid);
                StackPane imageViewS2 =mat.createImageToClick("./image/smoke.png", 45, 45, 220.0, 40, 520,53,pageFacile,grid);
                imageViewV =mat.createImageToClick("./image/voiture.png", 200, 200, 0, 500, 380,54,pageFacile,grid);
                StackPane imageViewV2 =mat.createImageToClick("./image/scooter.png", 150, 150, 0, 50, 430,55,pageFacile,grid);
                aide = mat.createText("Clique sur ce qui est le plus écologique",Color.GREEN);
                grid.add(aide, 15,50,50, 2);
                timeline.play();
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
                imageViewS.setOpacity(0);
                clearAndSetBackground(imageViewR,imageViewS);
                timeline.play();
                imageViewS =mat.createImageToClick("./image/smoke.png", 45, 45, 65.0, 685, 480,59,pageFacile,grid);
                imageViewV2 =mat.createImageToClick("./image/dust.png", 60, 60, 0, 1020, 440,56,pageFacile,grid);
                imageViewV1 =mat.createImageToClick("./image/co2.png", 90, 90, 0, 750, 440,5,pageFacile,grid);
                imageViewS2 =mat.createImageToClick("./image/running.png", 150, 150, 0, 900, 350,57,pageFacile,grid);
                aide = mat.createText("Trouve le CO2",Color.GREEN);
                imageViewV =mat.createImageToClick("./image/voiture.png", 200, 200, 0, 500, 380,58,pageFacile,grid);
                
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
                imageViewV2 =mat.createImageToClick("./image/oxygen.png", 90, 90, 0, 500, 450,6,pageFacile,grid);
                imageViewV1 =mat.createImageToClick("./image/cave.png", 150, 150, 0, 600, 550,60,pageFacile,grid);
                imageViewS2 =mat.createImageToClick("./image/carbone.png", 60, 60, 0, 700, 550,61,pageFacile,grid);
                aide = mat.createText("Trouve l'oxygène",Color.GREEN);
                imageViewV =mat.createImageToClick("./image/tree.png", 150, 150, 0, 500, 500,62,pageFacile,grid);
                grid.add(aide, 15,50,50, 2);
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
            case 6:
                pageFacile.close();
                PageBravo pageBravo = new PageBravo("facile");
                break;
            case 99:
                pageFacile.close();
                PageAccueil pageAccueil = new PageAccueil();
                break;
            default:
                aide = mat.createText("Page par défault",Color.GREEN);
                grid.add(aide, 15,50,50, 4);
                break;
        }
    }
    
    
}
