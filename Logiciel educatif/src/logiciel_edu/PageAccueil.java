package logiciel_edu;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Insets;
import java.io.File;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import static logiciel_edu.Fenetre.pageCours;
/**
 *
 * 
 */
public class PageAccueil extends Fenetre{
    public TextField user;
    public PasswordField mdp;
    public Platform platform;
    public boolean userEmpty, mdpEmpty;
    public Button btnConnexion;
    public Button bfacile;
    public Button bmoyen;
    public Button bcours;
    
    public static final String HOVERED_HOME_STYLE = "-fx-background-color: #0579ff;-fx-font-size: 2em;-fx-text-fill: white;";
    public static final String IDLE_HOME_STYLE = "-fx-background-color: #0771eb;-fx-font-size: 2em;-fx-text-fill: white;";
    
    public static final String IDLE_BUTTON_STYLE = "-fx-background-color: #2EAB4A;-fx-font-size: 2em;-fx-text-fill: white;";
    public static final String NORM_BUTTON_STYLE = "-fx-background-color: #FF7900;-fx-font-size: 2em;-fx-text-fill: white;";
    public static final String HOVERED_NORM_BUTTON_STYLE = "-fx-background-color: #ffad66;-fx-font-size: 2em;-fx-text-fill: white;";
    public static final String HARD_BUTTON_STYLE = "-fx-background-color: #36a3d1;-fx-font-size: 2em;-fx-text-fill: white;";
    public static final String HOVERED_HARD_BUTTON_STYLE = "-fx-background-color: #45bbed;-fx-font-size: 2em;-fx-text-fill: white;";
    public static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #49d168;-fx-font-size: 2em;-fx-text-fill: white;";
    public static final String IDLE_BUTTON_STYLE_AIDE = "-fx-background-color:#f58d42;-fx-font-size: 2em;-fx-text-fill: white;";
    public static final String HOVERED_BUTTON_STYLE_AIDE = "-fx-background-color:#faa05f;-fx-font-size: 2em;-fx-text-fill: white;";
    
    public PageAccueil(){
        initialisation();
        String imageURI2 = new File("fond.png").toURI().toString(); 
        Image image2 = new Image(imageURI2);
        ImageView imageView = new ImageView(image2); 
        imageView.setFitWidth(1200); 
        imageView.setFitHeight(675); 
        root.getChildren().setAll(imageView);
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(btnConnexion, 46, 35);
        grid.add(bfacile, 46, 35);
        grid.add(bmoyen, 46, 45);
        grid.add(bcours, 46, 55);
        btnConnexion.setOnAction(new Menue(this));
        root.getChildren().add(grid);
        scene.addEventFilter(KeyEvent.KEY_PRESSED,new ActionEntree(this));
        this.setScene(scene);
    }
    
    public void initialisation(){
        btnConnexion = new Button("Jouer");
        btnConnexion.setPrefWidth(300);
        btnConnexion.setStyle(IDLE_BUTTON_STYLE);
        btnConnexion.setOnMouseEntered(e -> btnConnexion.setStyle(HOVERED_BUTTON_STYLE));
        btnConnexion.setOnMouseExited(e -> btnConnexion.setStyle(IDLE_BUTTON_STYLE));
        
        bfacile = new Button("Facile");
        bfacile.setPrefWidth(300);
        bfacile.setStyle(IDLE_BUTTON_STYLE);
        bfacile.setOnMouseEntered(e -> bfacile.setStyle(HOVERED_BUTTON_STYLE));
        bfacile.setOnMouseExited(e -> bfacile.setStyle(IDLE_BUTTON_STYLE));
        bfacile.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                close();
                pageFacile = new PageFacile();
                pageFacile.changer(1);
            }
        });
        bfacile.setVisible(false);
        
        bmoyen = new Button("Moyen");
        bmoyen.setPrefWidth(300);
        bmoyen.setStyle(NORM_BUTTON_STYLE);
        bmoyen.setOnMouseEntered(e -> bmoyen.setStyle(HOVERED_NORM_BUTTON_STYLE));
        bmoyen.setOnMouseExited(e -> bmoyen.setStyle(NORM_BUTTON_STYLE));
        bmoyen.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                close();
                page1Jeu = new Page1Jeu();
                page1Jeu.changer(1);
            }
        });
        bmoyen.setVisible(false);
        
        bcours = new Button("Cours");
        bcours.setPrefWidth(300);
        bcours.setStyle(HARD_BUTTON_STYLE);
        bcours.setOnMouseEntered(e -> bcours.setStyle(HOVERED_HARD_BUTTON_STYLE));
        bcours.setOnMouseExited(e -> bcours.setStyle(HARD_BUTTON_STYLE));
        bcours.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                close();
                pageCours = new PageCours();
                pageCours.changer(1);
            }
        });
        bcours.setVisible(false);
    }
    
     public class Menue implements EventHandler<ActionEvent>{
        public PageAccueil p;
        public Menue(PageAccueil p){
            this.p=p;
        }
        @Override
          public void handle(ActionEvent e) {
            this.p.btnConnexion.setVisible(false);
            this.p.bfacile.setVisible(true);
            this.p.bmoyen.setVisible(true);
            this.p.bcours.setVisible(true);
        }
    }
   
    public class ActionEntree implements EventHandler<KeyEvent>{
        public PageAccueil p;
        public boolean b;
        public ActionEntree(PageAccueil p){
            this.p=p;
            this.b=false;
        }
        @Override
          public void handle(KeyEvent e) {
              if(e.getCode() == KeyCode.ENTER && !this.p.btnConnexion.isVisible()){
                this.p.btnConnexion.setVisible(false);
                this.p.bfacile.setVisible(true);
                this.p.bmoyen.setVisible(true);
                this.p.bcours.setVisible(true);
              }
              else if(e.getCode() == KeyCode.ESCAPE && !this.p.btnConnexion.isVisible()){
                this.p.btnConnexion.setVisible(true);
                this.p.bfacile.setVisible(false);
                this.p.bmoyen.setVisible(false);
                this.p.bcours.setVisible(false);
              }
        }
    }
}
