/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class FXMLPaisesController implements Initializable {

    
    @FXML
    public TextField txtPais;
    
    Connection conex = Conexion2.conectar();
    PreparedStatement preparar;
    
    String nombre;
    @FXML
    private Button btnAgregarPais;
    @FXML
    private Button btnEliminarPais;
    @FXML
    private Button btnSalirPais;
    
    @FXML
    private void actAgregarPais(ActionEvent event)throws Exception{

        
        nombre = txtPais.getText();
                
        String sql = "INSERT INTO paises(NombrePais) VALUES (?)";
        try{
            preparar =conex.prepareStatement(sql);
            
            preparar.setString(1,nombre);
            preparar.executeUpdate();
            
            System.out.println("El pais se ha REGISTRADO");
            preparar.close();
            conex.close();   
        }catch(SQLException sqlex){
           // Logger.getLogger(FXMLDocumentController.class.getName());
            System.out.println("El pais NO ha sido registrado");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actEliminarPais(ActionEvent event) {
    }

    @FXML
    private void actSalirPais(ActionEvent event) {
        System.exit(0);
    }
    
}
