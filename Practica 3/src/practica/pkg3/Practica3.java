/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class Practica3 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        scene.getStylesheets().add
        (Practica3.class.getResource("Practica.css").toExternalForm());
        stage.setTitle("Usando SceneBuilder");  
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
