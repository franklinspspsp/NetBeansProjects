/*
Franklin Soto Pacco
Abraham Arteaga Lopez
 */
package practica3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Practica3 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        scene.getStylesheets().add(Practica3.class.getResource("Sheet1.css"+"").toExternalForm());
        stage.show();
        root.setId("Pane1");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
