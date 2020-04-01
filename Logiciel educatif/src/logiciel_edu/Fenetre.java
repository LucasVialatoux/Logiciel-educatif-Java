/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public abstract class Fenetre extends Stage {
    
    public static Page1Jeu page1Jeu;
    public static PageFacile pageFacile;
    public static PageCours pageCours;
    public static JeuMoteur jeuMoteur;
    public Pane root;
    public Scene scene;
    static final String IDLE_STYLE_APPLI = "-fx-background-color: #a6afb3;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    static final String IDLE_STYLE_NIVEAUX = "-fx-selection-bar: #d7d9db ;-fx-background-color: #16a7e0;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    static final String IDLE_STYLE_AIDE = "-fx-background-color: #f58d42;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    
    
    public Fenetre() {
        root = new Pane(); 
        scene = new Scene(root, 1200, 675);
        this.setTitle("EcoCar");
        String imageURI = new File("Logo.png").toURI().toString(); 
        Image image = new Image(imageURI);
        this.getIcons().add(image);
        this.setScene(scene);
        this.show();
        
    }
    
}
