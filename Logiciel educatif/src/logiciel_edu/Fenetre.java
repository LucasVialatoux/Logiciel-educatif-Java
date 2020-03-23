/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public abstract class Fenetre  {
    
    public Stage stage;
    public BorderPane root;
    static final String IDLE_STYLE_APPLI = "-fx-background-color: #a6afb3;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    static final String IDLE_STYLE_NIVEAUX = "-fx-background-color: #16a7e0;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    static final String IDLE_STYLE_AIDE = "-fx-background-color: #f58d42;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    private static final String IDLE_STYLE_FACILE = "-fx-background-color: #2EAB4A;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    private static final String IDLE_STYLE_MOYEN = "-fx-background-color: #e6b420;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    private static final String IDLE_STYLE_DIFFICILE = "-fx-background-color: #e03b16;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    
    
    public Fenetre() {
        this.stage=new Stage();
        this.root = new BorderPane(); 
        Scene scene = new Scene(this.root, 1200, 675);
        this.stage.setTitle("Voiture");
        String imageURI = new File("icone.jpg").toURI().toString(); 
        Image image = new Image(imageURI);
        this.stage.getIcons().add(image);
        this.stage.setScene(scene);
        root.setStyle("-fx-background-color: #efefef;");
        menu();
        this.stage.show(); 
        
    }
    
    public void menu(){
        MenuBar mainMenu = new MenuBar();  
        
        Menu application = new Menu("Application");
        application.setStyle(IDLE_STYLE_APPLI);
        Menu niveaux = new Menu("Niveaux");
        niveaux.setStyle(IDLE_STYLE_NIVEAUX);
        Menu aide = new Menu("Aide");
        aide.setStyle(IDLE_STYLE_AIDE);
        
        MenuItem quitter = new MenuItem("Quitter");
        //quitter.setOnAction(new ChangeMenu(this.util,99));
        
        MenuItem about = new MenuItem("A propos");
        //about.setOnAction(new ChangeMenu(this.util,2));
        
        MenuItem facile = new MenuItem("Facile");
        facile.setStyle(IDLE_STYLE_FACILE);
        //accueil.setOnAction(new ChangeMenu(this.util,3));
        
        MenuItem moyen = new MenuItem("Moyen");
        moyen.setStyle(IDLE_STYLE_MOYEN);
        //cherV.setOnAction(new ChangeMenu(this.util,5));
        
        
        MenuItem difficile = new MenuItem("Difficile");
        difficile.setStyle(IDLE_STYLE_DIFFICILE);
        //proposeV.setOnAction(new ChangeMenu(this.util,6));
       
        niveaux.getItems().setAll(facile,moyen,difficile);
        application.getItems().setAll(quitter);
        aide.getItems().setAll(about);
        mainMenu.getMenus().addAll(niveaux,application, aide);
        mainMenu.setUseSystemMenuBar(true);
        this.root.setTop(mainMenu);  
    }
    
    public class ChangeMenu implements EventHandler<ActionEvent>{
        //public Utilisateur util;
        public int page;
        
        public ChangeMenu(int page){
            //this.util=u;
            this.page=page;
        }
        
        @Override
        public void handle(ActionEvent event) {
                stage.close();
            switch (this.page) {
                case 1:
                    PageAccueil pageAccueil = new PageAccueil();
                    break;
                case 2:
                    PageAide aide = new PageAide();
                    break;
                
                default:
                    break;
            }
        }  
    }
    
}
