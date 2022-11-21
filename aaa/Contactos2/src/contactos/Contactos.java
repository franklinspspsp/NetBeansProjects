package contactos;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Contactos extends Application {
    private Stage stagePrincipal;
    @Override
    public void start(Stage stage) {
        
        try {
              Parent root = FXMLLoader.load(getClass().getResource("Vista/FXMLContactos.fxml"));
              Scene scene = new Scene(root);
              stage.setScene(scene);
              stage.show();
        } catch (IOException e) {
        }
    }
    public void ventanaEliminar(){
        try{    
            FXMLLoader loader = new FXMLLoader(Contactos.class.getResource("Vista/FXMLEliminar.fxml"));
            AnchorPane rootPane=(AnchorPane) loader.load();
            Stage ventanaEliminar = new Stage();
            ventanaEliminar.setTitle("Eliminación de Contactos");
            ventanaEliminar.initOwner(stagePrincipal);
            Scene scene = new Scene(rootPane);
            ventanaEliminar.setScene(scene);
            ventanaEliminar.show();
            } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}