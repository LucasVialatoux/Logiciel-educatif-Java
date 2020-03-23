package logiciel_edu;
import javafx.scene.input.KeyEvent;
import javafx.geometry.Insets;
import java.io.File;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 *
 * @author p1606751
 */
public class PageAccueil{
    
    public TextField user;
    public PasswordField mdp;
    public Stage stage;
    public Pane root;
    public Platform platform;
    public boolean userEmpty, mdpEmpty;
    public Button btnConnexion;
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #2EAB4A;-fx-font-size: 2em;-fx-text-fill: white;";
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #49d168;-fx-font-size: 2em;-fx-text-fill: white;";
    private static final String IDLE_BUTTON_STYLE_AIDE = "-fx-background-color:#f58d42;-fx-font-size: 2em;-fx-text-fill: white;";
    private static final String HOVERED_BUTTON_STYLE_AIDE = "-fx-background-color:#faa05f;-fx-font-size: 2em;-fx-text-fill: white;";
    
    public PageAccueil(){
        this.stage=new Stage();
        this.root = new Pane();
        String imageURI = new File("Logo.png").toURI().toString(); 
        Image image = new Image(imageURI);
        this.stage.getIcons().add(image);
        
        btnConnexion = new Button("Jouer");
        btnConnexion.setPrefWidth(300);
        btnConnexion.setStyle(IDLE_BUTTON_STYLE);
        btnConnexion.setOnMouseEntered(e -> btnConnexion.setStyle(HOVERED_BUTTON_STYLE));
        btnConnexion.setOnMouseExited(e -> btnConnexion.setStyle(IDLE_BUTTON_STYLE));
        
        Button btnAide = new Button("Aide");
        btnAide.setPrefWidth(300);
        btnAide.setStyle(IDLE_BUTTON_STYLE_AIDE);
        btnAide.setOnMouseEntered(e -> btnAide.setStyle(HOVERED_BUTTON_STYLE_AIDE));
        btnAide.setOnMouseExited(e -> btnAide.setStyle(IDLE_BUTTON_STYLE_AIDE));
        
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
        btnConnexion.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent t) {
                                    stage.close();
                                    new PageFacile("fondFacile.png");
                                }
                            });
        grid.add(btnAide, 46, 45);
        btnAide.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent t) {
                                    stage.close();
                                    new PageAide("");
                                }
                            });
        root.getChildren().add(grid);
        Scene scene = new Scene(root, 1200, 675);
        scene.addEventFilter(KeyEvent.KEY_PRESSED,new ActionEntree(this));
        stage.setTitle("Voiture"); 
        stage.setScene(scene);
        stage.show();
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
              if(e.getCode() == KeyCode.ENTER && !this.p.btnConnexion.isDisable()&&b==true){
                  b=false;
                  //Connexion c=new Connexion(this.p);
                  ActionEvent event = null;
                  //c.handle(event);
              }else{
                  b=true;
              }
        }
    }
}
