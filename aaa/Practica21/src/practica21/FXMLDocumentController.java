/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica21;

import Clientes.Conexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USUARIO
 */
public class FXMLDocumentController implements Initializable {
    
    Connection conex = Conexion.conectar();
    PreparedStatement preparar;
    String nombre, apellido,sexo,tipodoc,direccion,email, fechanac;
    int codigo, edad, numerodoc,telefono;
    
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtSexo;
    @FXML
    private DatePicker FechaNac;
    @FXML
    private TextField txtTipoDoc;
    @FXML
    private TextField txtNumDoc;
    @FXML
    private TextArea txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnGuardar.setOnAction((event) -> {
            codigo = Integer.parseInt(txtCodigo.getText());
            nombre = txtNombres.getText();
            apellido = txtApellidos.getText();
            sexo=txtSexo.getText();
            fechanac=FechaNac.getPromptText();
            tipodoc=txtTipoDoc.getText();
            numerodoc=Integer.parseInt(txtNumDoc.getText());
            direccion=txtDireccion.getText();
            telefono=Integer.parseInt(txtTelefono.getText());
            email=txtEmail.getText();
                
            String sql = "INSERT INTO clientes(Codigo,Nombre,Apellidos,Sexo,FechaNacimiento,TipoDocu,NumeroDoc,Direccion,Telefono,Email) VALUES (?,?,?,?,?,?,?,?,?,?)";
            try{
                preparar =conex.prepareStatement(sql);
            
                preparar.setString(1, String.valueOf(codigo));
                preparar.setString(2,nombre);
                preparar.setString(3,apellido);
                preparar.setString(4,sexo);
                preparar.setString(5,fechanac);
                preparar.setString(6,tipodoc);
                preparar.setString(7,String.valueOf(numerodoc));
                preparar.setString(8,direccion);
                preparar.setString(9,String.valueOf(telefono));
                preparar.setString(10,email);
                       
                preparar.executeUpdate();
            
                System.out.println("El contacto se ha REGISTRADO");
                preparar.close();
                conex.close();   
            }catch(SQLException sqlex){
                Logger.getLogger(FXMLDocumentController.class.getName());
                System.out.println("El contacto NO ha sido registrado" + sqlex);
            }
        });
        
        btnNuevo.setOnAction((event) -> {
            txtCodigo.setText("");
            txtNombres.setText("");
            txtSexo.setText("");
            txtApellidos.setText("");
            txtSexo.setText("");
            txtTipoDoc.setText("");
            txtNumDoc.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtEmail.setText("");
        });
        
        btnEditar.setOnAction((event) -> {
            codigo = Integer.parseInt(txtCodigo.getText());
            nombre = txtNombres.getText();
            apellido = txtApellidos.getText();
            sexo=txtSexo.getText();
            fechanac=FechaNac.getPromptText();
            tipodoc=txtTipoDoc.getText();
            numerodoc=Integer.parseInt(txtNumDoc.getText());
            direccion=txtDireccion.getText();
            telefono=Integer.parseInt(txtTelefono.getText());
            email=txtEmail.getText();
                
            String sql = ("UPDATE clientes \n" +
                "SET Nombre=?, \n" +
                "Apellidos=?  \n" +
                "Sexo=?  \n" +
                "FechaNacimiento=?  \n" +
                "TipoDocu=?  \n" +
                "NumeroDoc=?  \n" +
                "Direccion=?  \n" +
                "Telefono=?  \n" +
                "Email=?  \n" +
                "WHERE Codigo=?;");
            try{
                preparar =conex.prepareStatement(sql);
            
                preparar.setString(1, String.valueOf(codigo));
                preparar.setString(2,nombre);
                preparar.setString(3,apellido);
                preparar.setString(4,sexo);
                preparar.setString(5,fechanac);
                preparar.setString(6,tipodoc);
                preparar.setString(7,String.valueOf(numerodoc));
                preparar.setString(8,direccion);
                preparar.setString(9,String.valueOf(telefono));
                preparar.setString(10,email);
                       
                preparar.executeUpdate();
            
                System.out.println("El contacto se ha REGISTRADO");
                preparar.close();
                conex.close();   
            }catch(SQLException sqlex){
                Logger.getLogger(FXMLDocumentController.class.getName());
                System.out.println("El contacto NO ha sido registrado" + sqlex);
            }
        });
        
        btnCancelar.setOnAction((event) -> {
            Stage stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close();
        });
    }    
    
}
