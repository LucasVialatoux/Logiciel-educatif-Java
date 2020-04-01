/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel_edu;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //PageAccueil pageAccueil = new PageAccueil();
        new JeuMoteur();
    }


    public static void main(String[] args) {
        launch(args);
    }
}