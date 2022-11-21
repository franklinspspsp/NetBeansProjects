
package contactos.Vista;

import contactos.Conexion2;
import contactos.Modelo.Contacto;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class FXMLModificarController implements Initializable {

    Connection conex = Conexion2.conectar();
    PreparedStatement preparar;
    
    @FXML
    private Button btnModificarC;
    @FXML
    private Button btnSalir;
    @FXML
    private ComboBox<Contacto> cbxModificar;
    
    private ObservableList<Contacto> Contactos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Contactos = FXCollections.observableArrayList();
//        String sql = "Select IdContactos from contactos";
//        
//        
//        
//        cbxModificar.setItems(Contactos);
        
    }    

    @FXML
    private void actModificarC(ActionEvent event) {
        
    }

    @FXML
    private void actSalir(ActionEvent event) {
    }

    @FXML
    private void actComboBoxModificar(ActionEvent event) {
    }
    
}
