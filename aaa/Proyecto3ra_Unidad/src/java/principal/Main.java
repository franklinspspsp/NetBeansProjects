
package principal;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
   
       FXMLLoader carga = new FXMLLoader(this.getClass().getResource("Main.fxml"));
       Parent padre=carga.load();
       Scene scene = new Scene(padre);
       scene.getStylesheets().add(Main.class.getResource("SheetT.css"+"").toExternalForm());
       primaryStage.setScene(scene);
       primaryStage.show();
        }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
