/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import static logiciel_edu.PageAccueil.HOVERED_HOME_STYLE;
import static logiciel_edu.PageAccueil.IDLE_HOME_STYLE;


public class PageBravo extends Fenetre {
    
    private final GridPane grid = new GridPane();
    private final Materials mat= new Materials();
    private final ImageView imageViewR =mat.createImage("route.jpg", 1200, 675, 0, 0, 0);
    
    public PageBravo(String niveau){
        grid.setVgap(20);
        grid.setHgap(20);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        Text text = new Text();
        text.setText("Bravo, tu as terminé le niveau "+niveau + "\nFélicitation !");
        //Setting font to the text 
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        //Setting the color 
        text.setFill(Color.GREEN);
        grid.add(text,15,10, 50,2);
        
        Button btnHome = new Button("Menu principal");
        btnHome.setPrefWidth(300);
        btnHome.setStyle(IDLE_HOME_STYLE);
        btnHome.setOnMouseEntered(e -> btnHome.setStyle(HOVERED_HOME_STYLE));
        btnHome.setOnMouseExited(e -> btnHome.setStyle(IDLE_HOME_STYLE));
        btnHome.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                close();
                PageAccueil pageAccueil = new PageAccueil();
            }
        });
        grid.add(btnHome, 17, 22,16,3);
        root.getChildren().setAll(imageViewR);
        root.getChildren().add(grid);
        this.setScene(scene);
    }
    
}
