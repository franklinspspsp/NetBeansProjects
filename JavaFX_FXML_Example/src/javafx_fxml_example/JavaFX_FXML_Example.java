package javafx_fxml_example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFX_FXML_Example extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root,300,250);
        
        stage.setScene(scene);
        scene.getStylesheets().add(JavaFX_FXML_Example.class.getResource("CSS.css").toExternalForm());
        stage.setTitle("Usando SceneBuilder");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
