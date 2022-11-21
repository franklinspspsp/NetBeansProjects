/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactos.Vista;

import contactos.Conexion2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Delam
 */
public class FXMLContactosController implements Initializable {

    Connection conex = Conexion2.conectar();
    PreparedStatement preparar;
    String nombre, apellido;
    int edad;
    
   
    
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtApellidos;
    @FXML
    private Button btnNuevoContacto;
    @FXML
    private Button btnGuardarContacto;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnSalir;
    
    
    @FXML
    private void actGuardarContacto(ActionEvent event)throws Exception{
        nombre = txtNombres.getText();
        apellido = txtApellidos.getText();
        edad = Integer.parseInt(txtEdad.getText());
        
        String sql = "INSERT INTO contactos(Nombres,Apellidos,Edad) VALUES(?,?,?)";
        try{
            preparar =conex.prepareStatement(sql);
            
            preparar.setString(1,nombre);
            preparar.setString(2, apellido);
            preparar.setString(3,String.valueOf(edad));
            
           
            preparar.executeUpdate();
            System.out.println("El contacto se ha REGISTRADO");
            preparar.close();
            conex.close();
            
        }catch(SQLException sqlex){
            System.out.println("El contacto NO ha sido registrado"+ sqlex);  
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actNuevoContacto(ActionEvent event) {
    }

    @FXML
    private void actModificarContacto(ActionEvent event) {
    }

    @FXML
    private void actEliminarContacto(ActionEvent event) {
    }

    @FXML
    private void actSalir(ActionEvent event) {
    }
    
}
