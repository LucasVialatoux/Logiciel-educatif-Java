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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public abstract class Fenetre  {
    
    public Stage stage;
    public BorderPane root;
    static final String IDLE_STYLE_APPLI = "-fx-background-color: #a6afb3;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    static final String IDLE_STYLE_NIVEAUX = "-fx-selection-bar: #d7d9db ;-fx-background-color: #16a7e0;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    static final String IDLE_STYLE_AIDE = "-fx-background-color: #f58d42;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    private static final String IDLE_STYLE_FACILE = "-fx-background-color: #2EAB4A;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    private static final String IDLE_STYLE_MOYEN = "-fx-background-color: #e6b420;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    private static final String IDLE_STYLE_DIFFICILE = "-fx-background-color: #e03b16;-fx-font-size: 2em;-fx-text-fill: white;-fx-padding: 5 30 5 5;";
    
    
    public Fenetre(String bgd) {
        this.stage=new Stage();
        this.root = new BorderPane(); 
        Scene scene = new Scene(this.root, 1200, 675);
        this.stage.setTitle("Voiture");
        String imageURI = new File("Logo.png").toURI().toString(); 
        Image image = new Image(imageURI);
        this.stage.getIcons().add(image);
        this.stage.setScene(scene);
        
        menu();
        background(bgd);
        this.stage.show(); 
        
    }
    
    public final void background(String name){
        if(!name.isEmpty()){
            String imageURI2 = new File(name).toURI().toString(); 
            Image image2 = new Image(imageURI2);
            ImageView imageView = new ImageView(image2); 
            imageView.setFitWidth(1200); 
            imageView.setFitHeight(675);
            this.root.getChildren().setAll(imageView);
        }
        
    }
    
    public void menu(){
        MenuBar mainMenu = new MenuBar();  
        
        Menu application = new Menu("Application");
        application.setStyle(IDLE_STYLE_APPLI);
        Menu niveaux = new Menu("Niveaux");
        niveaux.setStyle(IDLE_STYLE_NIVEAUX);
        Menu aide = new Menu("Aide");
        aide.setStyle(IDLE_STYLE_AIDE);
        
        MenuItem accueil = new MenuItem("Accueil");
        accueil.setOnAction(new ChangeMenu(1));
        
        MenuItem quitter = new MenuItem("Quitter");
        quitter.setOnAction(new ChangeMenu(99));
        
        MenuItem about = new MenuItem("A propos");
        about.setOnAction(new ChangeMenu(2));
        
        MenuItem facile = new MenuItem("Facile");
        facile.setStyle(IDLE_STYLE_FACILE);
        facile.setOnAction(new ChangeMenu(3));
        
        MenuItem moyen = new MenuItem("Moyen");
        moyen.setStyle(IDLE_STYLE_MOYEN);
        moyen.setOnAction(new ChangeMenu(4));
        
        
        MenuItem difficile = new MenuItem("Difficile");
        difficile.setStyle(IDLE_STYLE_DIFFICILE);
        difficile.setOnAction(new ChangeMenu(5));
       
        niveaux.getItems().setAll(facile,moyen,difficile);
        application.getItems().setAll(accueil,quitter);
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
                    PageAide aide = new PageAide("fond.png");
                    break;
                case 3:
                    PageFacile pageFacile = new PageFacile("fondFacile.png");
                    break;
                case 4:
                    PageMoyen pageMoyen = new PageMoyen("fondMoyen.png");
                    break;
                case 5:
                    PageDifficile pageDifficile = new PageDifficile("fondDifficile.png");
                    break;
                
                default:
                    break;
            }
        }  
    }
    
}
