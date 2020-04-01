/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import static logiciel_edu.PageAccueil.IDLE_BUTTON_STYLE;
import static logiciel_edu.PageAccueil.HOVERED_BUTTON_STYLE;

/**
 *
 * @author antoine dulhoste
 */
public class JeuMoteur extends Fenetre {
    public Text demande;
    public Text exD;
    public ImageView moteur;
    public ImageView fleche;
    private final Materials mat= new Materials();
    public boolean bp=false;
    public boolean bs=false;
    public boolean premierBtn =true;
    public GridPane grid=new GridPane();
    public Button btn;
    
    public JeuMoteur(){
        String imageURI = new File("bougie.png").toURI().toString(); 
        Image image = new Image(imageURI);
        ImageView Imb = new ImageView(image);
        Imb.setFitWidth(35);
        Imb.setFitHeight(116);
        imageURI = new File("soupape.png").toURI().toString(); 
        image = new Image(imageURI);
        ImageView Ims = new ImageView(image);
        Ims.setFitWidth(35); 
        Ims.setFitHeight(51);
        imageURI = new File("piston.png").toURI().toString(); 
        image = new Image(imageURI);
        ImageView Imp = new ImageView(image);
        Imp.setFitWidth(35); 
        Imp.setFitHeight(63);
        ImageView mecano=mat.createImage("mecano.png", 250, 400, 0, 20, 200);
        moteur=mat.createImage("Mpiston.png", 200, 435, 0, 450, 200);
        Button bougie = new Button("",Imb);
        bougie.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                    public void handle(MouseEvent event){
                        if(bp==true && bs==true){
                            root.getChildren().remove(grid);
                            String imageURI = new File("Mcomplet.png").toURI().toString(); 
                            Image image = new Image(imageURI);
                            moteur.setImage(image);
                            demande.setText("Merci je vais pouvoir t'expliquer comment\n"
                                    + "le moteur fonctionne.");
                                btnNext("Voir la vidéo");
                        }
                    }
                }
            );
        Button soupape = new Button("",Ims);
        Button continuer = new Button("",Ims);
        soupape.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                    public void handle(MouseEvent event){
                        if(bp==true && bs==false){
                            bs=true;
                            String imageURI = new File("Mbougie.png").toURI().toString(); 
                            Image image = new Image(imageURI);
                            moteur.setImage(image);
                            demande.setText("il ne me manque plus que la bougie\n"
                                    + "s'il te plait.");
                        }
                    }
                }
            );
        Button piston = new Button("",Imp);
        piston.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                    public void handle(MouseEvent event){
                        if(bp==false){
                            bp=true;
                            String imageURI = new File("Msoupape.png").toURI().toString(); 
                            Image image = new Image(imageURI);
                            moteur.setImage(image);
                            demande.setText("Parfait peux-tu me faire passer les soupapes ?");
                        }
                    }
                }
            );
        demande =mat.createText("Mon moteur ne fonctionne plus !\n"
                + "Peux-tu m'aider à le réparer ?\n"
                + "J'ai besoin du piston sur la droite.",Color.BLACK);
        demande.setLayoutX(350);
        demande.setLayoutY(100);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(bougie, 85, 40);
        grid.add(soupape, 90, 40);
        grid.add(piston, 95, 40);
        root.getChildren().add(demande);
        root.getChildren().add(mecano);
        root.getChildren().add(grid);
        root.getChildren().add(moteur);
    }
    
     public void btnNext(String name){
        btn = new Button(name);
        Materials mat = new Materials();
        btn.setPrefWidth(300);
        btn.setStyle(IDLE_BUTTON_STYLE);
        btn.setOnMouseEntered(e -> btn.setStyle(HOVERED_BUTTON_STYLE));
        btn.setOnMouseExited(e -> btn.setStyle(IDLE_BUTTON_STYLE));
        btn.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
               if(premierBtn){
                   premierBtn=false;
                   debutPhase();
               }else{
                   jeuMoteur.close();
                   PageAccueil pageAccueil = new PageAccueil();
               }
            }
        });
        String imageURIRoue = new File("next.png").toURI().toString();
        ImageView imageView = new ImageView(imageURIRoue);
        imageView.setFitWidth(45); 
        imageView.setFitHeight(45);
        btn.setLayoutX(850);
        btn.setLayoutY(550);
        btn.setGraphic(imageView);
        root.getChildren().add(btn);
    }
     
    public void debutPhase(){
        root.getChildren().remove(btn);
        demande.setText("C'est le mouvement du moteur \n"
                + "qui fait touner les roues de la voiture.\n"
                + "Ce mouvement se déroule en 4 phases.");
        exD =mat.createText("Le but est de faire touner ceci\n"
                + "pour faire avancer la voiture.",Color.BLACK);
        exD.setLayoutX(800);
        exD.setLayoutY(480);
        root.getChildren().add(exD);
        fleche =mat.createImage("red arrow.png", 300, 53, 0, 480, 460);
        root.getChildren().add(fleche);
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(10000), 
        		event-> {
                                p1();
        		}
		));
        t.play();
    }
     
    public void p1(){
        fleche.setLayoutY(400);
        exD.setText("Le piston est en bas\n"
                + "ce qui laise entrer de l'essence\n"
                + "(ici en bleu).");
        exD.setLayoutY(400);
        demande.setLayoutX(450);
        demande.setText("Première phase");
        String imageURI = new File("Mp1.png").toURI().toString(); 
        Image image = new Image(imageURI);
        moteur.setImage(image);
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(10000), 
        		event-> {
                                p2();
        		}
		));
        t.play();
    }
    public void p2(){
        fleche.setLayoutY(330);
        exD.setText("Le piston remonte\n"
                + "et vient compresser\n"
                + "l'essence.");
        exD.setLayoutY(330);
        demande.setLayoutX(450);
        demande.setText("Deuxième phase");
        String imageURI = new File("Mp2.png").toURI().toString(); 
        Image image = new Image(imageURI);
        moteur.setImage(image);
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(10000), 
        		event-> {
                                p3();
        		}
		));
        t.play();
    }
    
    public void p3(){
        fleche.setLayoutY(260);
        fleche.setLayoutX(470);
        exD.setText("La bougie d'allumage\n"
                + "met le feu à l'essence\n"
                + "ce qui provoque une explosion.");
        exD.setLayoutY(280);
        demande.setLayoutX(450);
        demande.setText("Troisième phase");
        String imageURI = new File("Mp3.png").toURI().toString(); 
        Image image = new Image(imageURI);
        moteur.setImage(image);
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(10000), 
        		event-> {
                                p4();
        		}
		));
        t.play();
    }
    
    public void p4(){
        fleche.setLayoutY(390);
        fleche.setLayoutX(460);
        exD.setText("Grâce à l'explosion\n"
                + "le piston redescent.");
        exD.setLayoutY(400);
        String imageURI = new File("Mp4.png").toURI().toString(); 
        Image image = new Image(imageURI);
        moteur.setImage(image);
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(10000), 
        		event-> {
                                p5();
        		}
		));
        t.play();
    }
    public void p5(){
        fleche.setLayoutY(360);
        fleche.setLayoutX(470);
        fleche.setFitWidth(270);
        exD.setText("Le piston remonte \n"
                + "tout en poussant les gaz (ici en jaune)\n"
                + "produits par la combustion de l'essence.\n"
                + "C'est du CO2 en grande partie.");
        exD.setLayoutY(360);
        exD.setLayoutX(750);
        demande.setLayoutX(450);
        demande.setText("Quatrième phase");
        String imageURI = new File("Mp5.png").toURI().toString(); 
        Image image = new Image(imageURI);
        moteur.setImage(image);
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(10000), 
        		event-> {
                                p6();
        		}
		));
        t.play();
    }
    public void p6(){
        root.getChildren().remove(fleche);
        root.getChildren().remove(exD);
        demande.setLayoutX(350);
        demande.setText("Et voilà! Maintenant mon moteur\n"
                + "peut fonctionner grâce aux pièces que tu m'a données\n"
                + "et à ces 4 temps.");
        String imageURI = new File("moteur.gif").toURI().toString(); 
        Image image = new Image(imageURI);
        moteur.setImage(image);
        Timeline t = new Timeline(new KeyFrame(
        		Duration.millis(5000), 
        		event-> {
                                btnNext("Menu");
        		}
		));
        t.play();
    }
}
 