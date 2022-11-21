
package javafx_jpa;

import DAO.UsuarioDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

public class FXMLVistaUsuarioController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEliminar;
    @FXML
    private ListView<Usuarios> lstvUsuarios;
    
    private final ObservableList<Usuarios> listaUsuarios=FXCollections.observableArrayList();
    private final UsuarioDAO usuarioDao=new UsuarioDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstvUsuarios.setItems(listaUsuarios);
        listaUsuarios.addAll(usuarioDao.getAllUsuarios());
        
        lstvUsuarios.setCellFactory(new Callback<ListView<Usuarios>, ListCell<Usuarios>>() {
            @Override
            public ListCell<Usuarios> call(ListView<Usuarios> param) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                ListCell<Usuarios> listaCelda=new ListCell(){
                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                        if(item!=null){
                            Usuarios usuario = (Usuarios) item;
                            setText(usuario.getNombres());
                        }else{
                            setText("No se actualizo");
                        }
                    }
                    
                    };
                    return listaCelda;
                }
        });
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!txtUsuario.getText().trim().isEmpty()){
                    Usuarios nuevoUsuario = new Usuarios(getID());
                    nuevoUsuario.setNombres(txtUsuario.getText());
                    
                    try {
                        usuarioDao.AgregarUsuario(nuevoUsuario);
                    } catch (Exception ex) {
                        Logger.getLogger(FXMLVistaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    listaUsuarios.add(nuevoUsuario);
                }
            }
        });
        
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Usuarios itemSeleccionado = lstvUsuarios.getSelectionModel().getSelectedItem();
                if(itemSeleccionado!=null){
                    // COMPLETAR ****************
//                    try{
//                        usuarioDao.EliminarUsuario(7);
//                    }catch(Exception ex){
//                        Logger.getLogger(FXMLVistaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                }
                //listaUsuarios.setAll();
            }
        });
    }    
    private int getID(){
        List<Usuarios> allUsuarios = usuarioDao.getAllUsuarios();
        int maxID=0;
        
        if(!allUsuarios.isEmpty()){
            for(Usuarios usuario:allUsuarios){
                if(usuario.getIdUsuario()>maxID){
                    maxID=usuario.getIdUsuario();
                }
            }
        }
        return ++maxID;
    }
}