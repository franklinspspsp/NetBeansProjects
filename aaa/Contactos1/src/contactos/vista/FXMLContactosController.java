
package contactos.vista;

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


public class FXMLContactosController implements Initializable {
    
    Connection conex = Conexion2.conectar();
    PreparedStatement preparar;
    String nombre, apellidos;
    int Edad;

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
    }    

    @FXML
    private void actNuevoContacto(ActionEvent event) {
    }

    @FXML
    private void actGuardarContacto(ActionEvent event) {
        nombre = txtNombres.getText();
        apellidos = txtApellidos.getText();
        Edad = Integer.parseInt(txtEdad.getText());
        
        String sql = "INSERT INTO contactos(Nombres, Apellidos, Edad) VALUES (?,?,?)";
        try{
            preparar = conex.prepareStatement(sql);
            
            preparar.setString(1, nombre);
            preparar.setString(2,apellidos);
            preparar.setString(3,String.valueOf(Edad));
            
            preparar.executeUpdate();
            
            System.out.println("El contacto se ha registrado correctamente");
            preparar.close();
            conex.close();
        }catch(SQLException sqlex){
            System.out.println("El contacto no pudo ser registrado1" + sqlex);
                    
                    
            
        }
        
    }

    @FXML
    private void actSalir(ActionEvent event) {
    }

    @FXML
    private void actModificar(ActionEvent event) {
    }

    @FXML
    private void actEliminar(ActionEvent event) {
    }
    
}
