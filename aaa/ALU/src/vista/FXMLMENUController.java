/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class FXMLMENUController implements Initializable {

    @FXML
    private Button btnSin;
    @FXML
    private Button btnCon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SinPuntoFlotante(ActionEvent event) {
     try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/SinPuntoFlotante.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));                
                stage.setTitle("Conversor");
            //    stage.setMaximized(true);
                stage.show();
            } catch (Exception e) {
                System.out.println("No se pudo cargar /vista/SinPuntoFlotante.fxml");
            }
    }

    @FXML
    private void ConPuntoFlotante(ActionEvent event) {
        
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/ConPuntoFlotante.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));                
                stage.setTitle("Conversor");
            //    stage.setMaximized(true);
                stage.show();
            } catch (Exception e) {
                System.out.println("No se pudo cargar /vista/go.fxml");
            }
        
    }
    
}
