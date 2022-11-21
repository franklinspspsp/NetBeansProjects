package contactos.Vista;

import contactos.Conexion2;
import contactos.Contactos;
import contactos.Vista.FXMLEliminarController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLContactosController implements Initializable {

    Connection conex = Conexion2.conectar();
    PreparedStatement preparar;
    String nombre, apellido;
    int codigo, edad;
    
    public Contactos VEliminar;
    
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private Button btnNuevoContacto;
    @FXML
    private Button btnGuardarContacto;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actNuevoContacto(ActionEvent event) {
    }

    @FXML
    private void actGuardarContacto(ActionEvent event)throws Exception{
        codigo = Integer.parseInt(txtCodigo.getText());
        nombre = txtNombres.getText();
        apellido = txtApellidos.getText();
        edad=Integer.parseInt(txtEdad.getText());
                
        String sql = "INSERT INTO contacto(IdContactos,Nombres,Apellidos,Edad) VALUES (?,?,?,?)";
        try{
            preparar =conex.prepareStatement(sql);
            
            preparar.setString(1, String.valueOf(codigo));
            preparar.setString(2,nombre);
            preparar.setString(3,apellido);
            preparar.setString(4,String.valueOf(edad));
            //preparar.setString(4, pais);
            
            preparar.executeUpdate();
            
            System.out.println("El contacto se ha REGISTRADO");
            preparar.close();
            conex.close();   
        }catch(SQLException sqlex){
           // Logger.getLogger(FXMLDocumentController.class.getName());
            System.out.println("El contacto NO ha sido registrado" + sqlex);
        }
    }

    @FXML
    private void actSalirContacto(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void actModificarContacto(ActionEvent event) {
        
    }

    @FXML
    private void actEliminarContacto(ActionEvent event) throws IOException{
        VEliminar.ventanaEliminar();
    }

    public void setVEliminar(Contactos VEliminar) {
        this.VEliminar = VEliminar;
    }
    
}
