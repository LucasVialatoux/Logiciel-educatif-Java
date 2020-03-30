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
public class Page1Jeu extends Fenetre {
    
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #3b7af7;-fx-font-size: 2em;-fx-text-fill: white;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #6898f7;-fx-font-size: 2em;-fx-text-fill: white;";
    private Text aide;
    private final Materials mat= new Materials();;
    private final GridPane grid;
    private Timeline t, timeline, timeline2;
    private ImageView imageViewA,imageViewV;
    //ImageViews
    private final ImageView imageViewS =mat.createImage("smoke.png", 45, 45, 65.0, 685, 480);
    private final ImageView imageViewR =mat.createImage("route.jpg", 1200, 675, 0, 0, 0);
    
    public Page1Jeu(){
        //Grid
        grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        
        
        imageViewS.setOpacity(1);
        imageViewA =mat.createImage("red arrow.png", 100, 53, 320.0, 685, 440);
        imageViewA.setOpacity(0);
        
        //timeline qui permet de faire clignoter le press to start
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
        Button bnothing = mat.createBtn("Rien","",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,2,page1Jeu,grid);
        bnothing.setVisible(false);
        grid.getChildren().clear();
        if(t != null)
            t.stop();
        if(timeline != null)
            timeline.stop();
        if(timeline2 != null)
            timeline2.stop();
        switch(sousPage){
            case 1 :
                timeline.play();
                t.play();
                Button bsmoke = mat.createBtn("La fumée","smoke.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,2,page1Jeu,grid);
                Button bvitre = mat.createBtn("La vitre","vitre.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,51,page1Jeu,grid);
                Button broue = mat.createBtn("La roue","roue.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,52,page1Jeu,grid);
                imageViewV =mat.createImage("voiture.png", 200, 200, 0, 500, 380);
                aide = mat.createText("Qu'est-ce qui pollue dans une voiture ?",Color.GREEN);
                grid.add(bvitre, 5, 60);
                grid.add(bsmoke, 15, 60);
                grid.add(broue, 25, 60);
                grid.add(aide, 7,50,50, 2);
                root.getChildren().add(imageViewV);
                break;
            case 2 :
                timeline.play();
                imageViewA.setOpacity(0);
                Button byes = mat.createBtn("Oui","good.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,3,page1Jeu,grid);
                Button bno = mat.createBtn("Non","bad.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,53,page1Jeu,grid);
                aide = mat.createText("Est-ce que la fumée est dangereuse pour la santé ?",Color.GREEN);
                imageViewV =mat.createImage("voiture.png", 200, 200, 0, 500, 380);
                grid.add(byes, 5, 60);
                grid.add(bnothing, 15, 60);
                grid.add(bno, 25, 60);
                grid.add(aide, 7,50,50, 2);
                root.getChildren().add(imageViewV);
                break;
            case 3 :
                timeline.play();
                imageViewV =mat.createImage("bike.png", 200, 200, 0, 250, 380);
                ImageView imageViewS2 =mat.createImage("smoke.png", 45, 45, 220.0, 45, 500);
                ImageView imageViewV1 =mat.createImage("voiture.jpg", 200, 200, 0, 400, 380);
                ImageView imageViewV2 =mat.createImage("scooter.png", 200, 200, 0, 50, 380);
                Button bvoiture = mat.createBtn("La voiture","voiture.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,54,page1Jeu,grid);
                Button bvelo = mat.createBtn("Le vélo","bike.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,4,page1Jeu,grid);
                Button bscooter = mat.createBtn("Le scooter","scooter.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,55,page1Jeu,grid);
                aide = mat.createText("Qu'est-ce qui est plus écologique ?",Color.GREEN);
                grid.add(bscooter, 5, 60);
                grid.add(bvoiture, 15, 60);
                grid.add(bvelo, 25, 60);
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
                root.getChildren().add(imageViewS2);
                root.getChildren().add(imageViewV1);
                root.getChildren().add(imageViewV2);
                break;
            case 4 :
                clearAndSetBackground(imageViewR,imageViewS);
                timeline.play();
                imageViewA.setOpacity(0);
                imageViewV2 =mat.createImage("dust.png", 60, 60, 0, 1020, 440);
                imageViewV1 =mat.createImage("co2.png", 90, 90, 0, 750, 440);
                imageViewS2 =mat.createImage("running.png", 150, 150, 0, 900, 350);
                Button bco2 = mat.createBtn("Je pense que c'est ça","cO2.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,5,page1Jeu,grid);
                Button bdust = mat.createBtn("Je pense que c'est ça","dust.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,56,page1Jeu,grid);
                aide = mat.createText("La fumée de la voiture produit du CO2, c'est ça qui pollue.\n"
                        + "Sais-tu reconnaître le C02 ?",Color.GREEN);
                imageViewV =mat.createImage("voiture.png", 200, 200, 0, 500, 380);
                grid.add(bco2, 5, 60);
                grid.add(bnothing, 15, 60);
                grid.add(bdust, 25, 60);
                grid.add(aide, 15,50,50, 2);
                root.getChildren().add(imageViewV);
                root.getChildren().add(imageViewV1);
                root.getChildren().add(imageViewV2);
                root.getChildren().add(imageViewS2);
                break;
            case 5 :
                clearAndSetBackground(imageViewR,imageViewS);
                imageViewS.setOpacity(0);
                imageViewA.setOpacity(0);
                imageViewV2 =mat.createImage("oxygen.png", 90, 90, 0, 500, 450);
                imageViewV1 =mat.createImage("cave.png", 150, 150, 0, 700, 550);
                imageViewS2 =mat.createImage("carbone.png", 60, 60, 0, 700, 550);
                Button bo2carbone = mat.createBtn("Je pense que c'est ça","o2carbone.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,5,page1Jeu,grid);
                Button bo2 = mat.createBtn("Je pense que c'est ça","o2.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,57,page1Jeu,grid);
                Button bcarbone = mat.createBtn("Je pense que c'est ça","carbone.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,58,page1Jeu,grid);
                aide = mat.createText("Le CO2 est constituée de carbone et d'oxygène.\n"
                        + "L'oxygène provient de la végétation et le carbone provient des rochers.\n"
                        + "De quoi se compose le C02 ?",Color.GREEN);
                imageViewV =mat.createImage("tree.png", 150, 150, 0, 500, 500);
                grid.add(bo2carbone, 5, 60);
                grid.add(bo2, 15, 60);
                grid.add(bcarbone, 25, 60);
                grid.add(aide, 6,50,50, 2);
                timeline = new Timeline(new KeyFrame(
                                Duration.millis(500), 
                                event-> {
                                        if (imageViewS2.getOpacity()==1) {
                                                imageViewS2.setOpacity(0);	
                                        } else {
                                                imageViewS2.setOpacity(1);
                                        }
                                }
                        ));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
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
