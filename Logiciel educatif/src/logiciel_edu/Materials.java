/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import java.io.File;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static logiciel_edu.Fenetre.page1Jeu;
import static logiciel_edu.Fenetre.pageFacile;
import static logiciel_edu.PageAccueil.HOVERED_BUTTON_STYLE;
import static logiciel_edu.PageAccueil.IDLE_BUTTON_STYLE;

/**
 *
 * @author lucas
 */
public class Materials{
    public Fenetre fenetre;
    private Text reponse;
    
    public Materials(){
        
    }
    
    public Button createNextBtn(String name, String image, String btnStyle, String btnHoverStyle, int pageToCall,Page1Jeu page){
        Button btn = new Button(name);
        Materials mat = new Materials();
        btn.setPrefWidth(300);
        btn.setStyle(btnStyle);
        btn.setOnMouseEntered(e -> btn.setStyle(btnHoverStyle));
        btn.setOnMouseExited(e -> btn.setStyle(btnStyle));
        btn.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                // do what you have to do
                page.changer(pageToCall);
            }
        });
        String imageURIRoue = new File(image).toURI().toString();
        ImageView imageView = new ImageView(imageURIRoue);
        imageView.setFitWidth(45); 
        imageView.setFitHeight(45);
        imageView.setLayoutX(685);
        imageView.setLayoutY(480);
        btn.setGraphic(imageView);
        
        return btn;
    }
    
    public Button createNextBtnFacile(String name, String image, String btnStyle, String btnHoverStyle, int pageToCall,PageFacile page){
        Button btn = new Button(name);
        Materials mat = new Materials();
        btn.setPrefWidth(300);
        btn.setStyle(btnStyle);
        btn.setOnMouseEntered(e -> btn.setStyle(btnHoverStyle));
        btn.setOnMouseExited(e -> btn.setStyle(btnStyle));
        btn.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                // do what you have to do
                page.changer(pageToCall);
            }
        });
        String imageURIRoue = new File(image).toURI().toString();
        ImageView imageView = new ImageView(imageURIRoue);
        imageView.setFitWidth(45); 
        imageView.setFitHeight(45);
        imageView.setLayoutX(685);
        imageView.setLayoutY(480);
        btn.setGraphic(imageView);
        
        return btn;
    }
    
    public Button createBtn(String name, String image, String btnStyle, String btnHoverStyle, int pageToCall,Page1Jeu page,GridPane grid){
        
        Button btn = new Button(name);
        final Button btnNext;
        Materials mat = new Materials();
        btn.setPrefWidth(300);
        btn.setStyle(btnStyle);
        btn.setOnMouseEntered(e -> btn.setStyle(btnHoverStyle));
        btn.setOnMouseExited(e -> btn.setStyle(btnStyle));
        btn.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                Stage stage = (Stage) btn.getScene().getWindow();
                Button btnNext;
                grid.getChildren().remove(reponse);
                for (Node node : grid.getChildren()) {
                    if (node instanceof Button
                     && grid.getColumnIndex(node) == 25
                     && grid.getRowIndex(node) == 100) {
                        Button btnDelete=(Button) node;
                        grid.getChildren().remove(btnDelete);
                        break;
                    }
                }
                // do what you have to do
                //stage.close();
                switch (pageToCall){
                    case 1:
                        page.changer(1);
                        break;
                    case 2:
                        reponse = mat.createText("C'est bien la fumée, bravo !\n"
                                + "Allez, passe vite à la question suivante !",Color.WHITESMOKE);
                        btnNext= createNextBtn("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,2,page1Jeu);
                        grid.add(btnNext, 25, 100);
                        break;
                    case 3:
                        reponse = mat.createText("La fumée est effectivement dangereuse pour nous !\n"
                                + "Allez, passe vite à la question suivante !",Color.WHITESMOKE);
                        btnNext = createNextBtn("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,3,page1Jeu);
                        grid.add(btnNext, 25, 100);
                        break;
                    case 4:
                        reponse = mat.createText("Le vélo est le plus écologique ! \nEffectivement il ne produit aucune fumée.\n"
                                + "Allez, passe vite à la question suivante !",Color.WHITESMOKE);
                        btnNext = createNextBtn("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,4,page1Jeu);
                        grid.add(btnNext, 25, 100);
                        break;
                    case 5:
                        reponse = mat.createText("Bien joué ! C'est bien ça le CO2 :-)\n"
                                + "Allez, passe vite à la question suivante !",Color.WHITESMOKE);
                        btnNext = createNextBtn("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,5,page1Jeu);
                        grid.add(btnNext, 25, 100);
                        break;
                    case 6:
                        reponse = mat.createText("Bien joué ! Le CO2 se compose bien d'oxygène et de carbone :-)\n"
                                + "Allez, passe vite à la question suivante !",Color.WHITESMOKE);
                        btnNext = createNextBtn("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,99,page1Jeu);
                        grid.add(btnNext, 25, 100);
                        break;
                    case 51:
                        reponse = mat.createText("Tu y es presque :-)\n"
                                + "La vitre est utile pour regarder dehors.\n"
                                + "Essaie encore ! Courage !",Color.WHITESMOKE);
                        break;
                    case 52:
                        reponse = mat.createText("Tu y es presque :-)\n"
                                + "La roue permet à la voiture de rouler.\n"
                                + "Essaie encore ! Courage !",Color.WHITESMOKE);
                        break;
                     case 53:
                         reponse = mat.createText("Tu y es presque :-)\n"
                                + "Attention, la fumée est bien dangereuse pour la santé !\n"
                                + "Essaie encore ! Courage !",Color.WHITESMOKE);
                        break;
                     case 54:
                         reponse = mat.createText("Tu y es presque :-)\n"
                                + "On a vu ensemble que la voiture pollue à cause de la fumée\n"
                                + "Essaie encore ! Courage !",Color.WHITESMOKE);
                        break;
                     case 55:
                        reponse = mat.createText("Tu y es presque :-)\n"
                                + "Attention, le scooter pollue aussi, il produit aussi de la fumée.\n"
                                + "Essaie encore ! Courage !",Color.WHITESMOKE);
                        break;
                     case 56:
                         reponse = mat.createText("Tu y es presque :-) Attention, c'est\n"
                                + "de la poussière. Essaie encore ! Courage !"
                                ,Color.WHITESMOKE);
                        break;
                     case 57:
                         reponse = mat.createText("Tu y es presque :-) Attention, c'est de l'oxygène.\n"
                                + "Le CO2 se compose de 2 choses. Essaie encore ! Courage !"
                                ,Color.WHITESMOKE);
                        break;
                     case 58:
                         reponse = mat.createText("Tu y es presque :-) Attention, c'est du carbone.\n"
                                + "Le CO2 se compose de 2 choses. Essaie encore ! Courage !"
                                ,Color.WHITESMOKE);
                        break;
                     case 99:
                         page1Jeu.close();
                         PageAccueil pageAccueil = new PageAccueil();
                        break;
                    default:
                        
                }
                grid.add(reponse,10,50,50,62);
            }
        });
        String imageURIRoue = new File(image).toURI().toString();
        ImageView imageView = new ImageView(imageURIRoue);
        imageView.setFitWidth(45); 
        imageView.setFitHeight(45);
        imageView.setLayoutX(685);
        imageView.setLayoutY(480);
        btn.setGraphic(imageView);
        
        return btn;
    }
    public Alert createAlert(String title, String headerText, String content, AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(content);
        return alert;
    }
    
    
    public Text createText(String myText,Color col){
        //Creating a Text object 
        Text text = new Text();
        text.setText(myText);
        //Setting font to the text 
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20)); 
        //Setting the color 
        text.setFill(col);
        return text;
    }
    
    public ImageView createImage(String myImage,int width, int height, double rotate,int layoutX, int layoutY){
        String imageURI = new File(myImage).toURI().toString(); 
        Image image = new Image(imageURI);
        ImageView imageView = new ImageView(image); 
        imageView.setFitWidth(width); 
        imageView.setFitHeight(height);
        if(rotate!=0){
            imageView.setRotate(rotate);
        }
        if(layoutX != 0){
            imageView.setLayoutX(layoutX);
        }
        if (layoutY !=0){
            imageView.setLayoutY(layoutY);
        }
        
        return imageView;
    }
    
    public ImageView createImageToClick(String myImage,int width, int height, double rotate,int layoutX, int layoutY,
            int pageToCall,PageFacile page,GridPane grid){
        Materials mat = new Materials();
        String imageURI = new File(myImage).toURI().toString(); 
        Image image = new Image(imageURI);
        ImageView imageView = new ImageView(image); 
        imageView.setFitWidth(width); 
        imageView.setFitHeight(height);
        if(rotate!=0){
            imageView.setRotate(rotate);
        }
        if(layoutX != 0){
            imageView.setLayoutX(layoutX);
        }
        if (layoutY !=0){
            imageView.setLayoutY(layoutY);
        }
        imageView.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                Button btnNext;
                grid.getChildren().remove(reponse);
                for (Node node : grid.getChildren()) {
                    if (node instanceof Button
                     && grid.getColumnIndex(node) == 75
                     && grid.getRowIndex(node) == 130) {
                        btnNext=(Button) node;
                        grid.getChildren().remove(btnNext);
                        break;
                    }
                }
                // do what you have to do
                switch (pageToCall){
                    case 1:
                        page.changer(1);
                        break;
                    case 2:
                        reponse = mat.createText("Bravo !\n",Color.WHITESMOKE);
                        btnNext= createNextBtnFacile("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,2,pageFacile);
                        grid.add(btnNext, 75, 130);
                        break;
                    case 3:
                        reponse = mat.createText("Bravo !\n",Color.WHITESMOKE);
                        btnNext = createNextBtnFacile("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,3,pageFacile);
                        grid.add(btnNext, 75, 130);
                        break;
                    case 4:
                        reponse = mat.createText("Bravo !\n",Color.WHITESMOKE);
                        btnNext = createNextBtnFacile("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,4,pageFacile);
                        grid.add(btnNext, 75, 130);
                        break;
                    case 5:
                        reponse = mat.createText("Bravo !\n",Color.WHITESMOKE);
                        btnNext = createNextBtnFacile("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,5,pageFacile);
                        grid.add(btnNext, 75, 130);
                        break;
                    case 6:
                        reponse = mat.createText("Bravo !\n",Color.WHITESMOKE);
                        btnNext = createNextBtnFacile("Prochaine question","next.png",IDLE_BUTTON_STYLE,HOVERED_BUTTON_STYLE,99,pageFacile);
                        grid.add(btnNext, 75, 130);
                        break;
                    case 51:
                         reponse = mat.createText("Non, ce n'est pas la voiture !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 52:
                         reponse = mat.createText("C'est une voiture, pas de la fumée !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 53:
                         reponse = mat.createText("Non ce n'est pas la fumée !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 54:
                         reponse = mat.createText("Non ce n'est pas la voiture !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 55:
                         reponse = mat.createText("Non ce n'est pas le scooter !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 56:
                         reponse = mat.createText("Non, ça c'est de la poussière !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 57:
                         reponse = mat.createText("Non, ça c'est une personne !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 58:
                         reponse = mat.createText("Non, ça c'est une voiture !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 59:
                         reponse = mat.createText("Non, ça c'est de la fumée !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 60:
                         reponse = mat.createText("Non, ça c'est des rochers !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 61:
                         reponse = mat.createText("Non, ça c'est du carbone !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 62:
                         reponse = mat.createText("Non, ça c'est un arbre !\nEssaie encore !"
                                ,Color.WHITESMOKE);
                        break;
                    case 99:
                         pageFacile.close();
                         PageAccueil pageAccueil = new PageAccueil();
                        break;
                    default:
                        reponse = mat.createText("Essaie encore !",Color.WHITESMOKE);
                        break;
                        
                }
                grid.add(reponse,40,50,50,70);
            }
        });
        
        return imageView;
    }
}
