/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nate
 */
public class JavaFXApplication2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        /* Gets the UI design from FXMLDocument.fxml */
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        /* Creates a new instance of the Scene from root */
        Scene scene = new Scene(root);
        
        /* Sets the stage to the scene */
        stage.setScene(scene);
        
        /* Displays the stage to the user */
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
