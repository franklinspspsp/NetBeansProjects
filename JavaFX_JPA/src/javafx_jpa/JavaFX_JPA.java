
package javafx_jpa;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class JavaFX_JPA extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader carga= new FXMLLoader(this.getClass().getResource("FXMLVistaUsuario.fxml"));
        Parent padre=carga.load();
                
        Scene scene = new Scene(padre);
   
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
