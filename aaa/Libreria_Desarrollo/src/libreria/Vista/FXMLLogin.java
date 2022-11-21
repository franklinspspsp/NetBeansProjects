package libreria.Vista;

import DAO.AutorDAO;
import DAO.LibroDAO;
import DAO.UsuarioDAO;
import DAO.VentaDAO;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import libreria.Libreria_conexion;
import libreria.Modelo.exceptions.IllegalOrphanException;
import libreria.Modelo.exceptions.NonexistentEntityException;
import libreria.Persistence.Autor;
import libreria.Persistence.Libro;
import libreria.Persistence.Usuario;
import libreria.Persistence.Venta;



public class FXMLLogin implements Initializable {
    
    Connection conex = libreria.Libreria_conexion.conectar();
    PreparedStatement preparar;
    
    
    //Autor
    @FXML
    private TextField txtNombreA;
    @FXML
    private TextField txtApellidoA;
    @FXML
    private TextField txtPais;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtEstudio;
    @FXML
    private Button btnAgregarA;
    @FXML
    private Button btnEditarA;
    @FXML
    private Button btnEliminarA;
    @FXML
    private Button btnLimpiarA;
    @FXML
    private TableView<Autor> tvAutor;
    
    private final ObservableList<Autor>listaA=FXCollections.observableArrayList();
    private final AutorDAO aDao= new AutorDAO();
    
    @FXML
    private TableColumn clmIdAutorA;
    @FXML
    private TableColumn clmNombreA;
    @FXML
    private TableColumn clmApellidoA;
    @FXML
    private TableColumn clmPais;
    @FXML
    private TableColumn clmCiudad;
    @FXML
    private TableColumn clmEstudio;
    
    
    //Libro
    @FXML
    private TextField txtNombreL;
    @FXML
    private TextField txtIdAutor;
    @FXML
    private TextField txtImprenta;
    @FXML
    private TextField txtCapitulos;
    @FXML
    private TextField txtNroPaginas;
    @FXML
    private TextField txtGenero;
    @FXML
    private Button btnAgregarL;
    @FXML
    private Button btnEditarL;
    @FXML
    private Button btnEliminarL;
    @FXML
    private Button btnLimpiarL;
    @FXML
    private TableView<Libro> tvLibro;
    
    private final ObservableList<Libro>listaL=FXCollections.observableArrayList();
    private final LibroDAO lDao= new LibroDAO();
    
    @FXML
    private TableColumn clmIdLibroL;
    @FXML
    private TableColumn clmNombreL;
    @FXML
    private TableColumn clmIdAutorL;
    @FXML
    private TableColumn clmImprenta;
    @FXML
    private TableColumn clmCapitulos;
    @FXML
    private TableColumn clmPaginas;
    @FXML
    private TableColumn clmGenero;
    
    
    //Usuario
    @FXML
    private TextField txtNombreU;
    @FXML
    private TextField txtApellidoU;
    @FXML
    private TextField txtSexo;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnAgregarU;
    @FXML
    private Button btnEditarU;
    @FXML
    private Button btnEliminarU;
    @FXML
    private Button btnLimpiarU;
    @FXML
    private TableView<Usuario> tvUsuario;
    
    private final ObservableList<Usuario>listaU=FXCollections.observableArrayList();
    private final UsuarioDAO uDao= new UsuarioDAO();
    
    @FXML
    private TableColumn clmNombreU;
    @FXML
    private TableColumn clmApellidoU;
    @FXML
    private TableColumn clmSexo;
    @FXML
    private TableColumn clmDniU;
    @FXML
    private TableColumn clmTelefono;
    @FXML
    private TableColumn clmEmail;
    
    
    //Venta
    @FXML
    private TextField txtIdAutorV;
    @FXML
    private TextField txtDniV;
    @FXML
    private TextField txtIdLibroV;
    //este es dudoso, por que solo se auto incrementa, asi q no se si ponerlo o no
    @FXML
    private TextField txtIdVenta;
    
    //este es para probar
    @FXML
    private ComboBox cbIdVenta;
    @FXML
    private ComboBox cbDni;
    @FXML
    private ComboBox cbIdLibro;
    
    
    
    @FXML
    private Button btnAgregarV;
    @FXML
    private Button btnEditarV;
    @FXML
    private Button btnEliminarV;
    @FXML
    private Button btnLimpiarV;
    @FXML
    private TableView<Venta> tvVenta;
    
    private final ObservableList<Venta>listaV=FXCollections.observableArrayList();
    private final VentaDAO vDao= new VentaDAO();
    
    @FXML
    private TableColumn clmIdVentaV;
    @FXML
    private TableColumn clmDniV;
    @FXML
    private TableColumn clmIdLibroV;
    @FXML
    private TableColumn clmIdAutorV;
    
    Libreria_conexion conexion;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conexion= new Libreria_conexion();
        try {
            conexion.establecerConexion();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tvAutor.setItems(listaA);
        clmIdAutorA.setCellValueFactory(new PropertyValueFactory<Autor, Integer>("idAutor"));
        clmNombreA.setCellValueFactory(new PropertyValueFactory<Autor, String>("Nombre"));
        clmApellidoA.setCellValueFactory(new PropertyValueFactory<Autor, String>("Apellido"));
        clmPais.setCellValueFactory(new PropertyValueFactory<Autor, String>("Pais"));
        clmCiudad.setCellValueFactory(new PropertyValueFactory<Autor, String>("Ciudad"));
        clmEstudio.setCellValueFactory(new PropertyValueFactory<Autor, String>("Estudio"));
        listaA.addAll(aDao.getAllAutores());

        
        
        tvLibro.setItems(listaL);
        clmIdLibroL.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("idLibro"));
        clmNombreL.setCellValueFactory(new PropertyValueFactory<Libro, String>("Nombre"));
        clmIdAutorL.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("idAutor"));
        clmImprenta.setCellValueFactory(new PropertyValueFactory<Libro, String>("Imprenta"));
        clmCapitulos.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("Capitulos"));
        clmPaginas.setCellValueFactory(new PropertyValueFactory<Libro, Integer>("nroPäginas"));
        clmGenero.setCellValueFactory(new PropertyValueFactory<Libro, String>("Genero"));
        listaL.addAll(lDao.getAllLibros());
        
        
        
        tvUsuario.setItems(listaU);
        clmNombreU.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Nombre"));
        clmApellidoU.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Apellido"));;
        clmSexo.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Sexo"));;
        clmDniU.setCellValueFactory(new PropertyValueFactory<Usuario, String>("DNI"));;
        clmTelefono.setCellValueFactory(new PropertyValueFactory<Usuario, Integer>("Telefono"));;
        clmEmail.setCellValueFactory(new PropertyValueFactory<Usuario, String>("Email"));;
        listaU.addAll(uDao.getAllUsuarios());
        

        
        
        tvVenta.setItems(listaV);
        clmIdVentaV.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("idVenta"));
        clmDniV.setCellValueFactory(new PropertyValueFactory<Venta, String>("DNI"));;
        clmIdLibroV.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("idLibro"));;
        clmIdAutorV.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("idAutor"));;
        listaV.addAll(vDao.getAllVentas());
        
        conexion.cerrarConexion();
        
        
        //Autor
        btnAgregarA.setOnAction((event) -> { 
            Autor nAutor= new Autor(getIDA());
            nAutor.setNombre(txtNombreA.getText());
            nAutor.setApellido(txtApellidoA.getText());
            nAutor.setPais(txtPais.getText());
            nAutor.setCiudad(txtCiudad.getText());
            nAutor.setEstudio(txtEstudio.getText());

            try{
                aDao.AgregarAutor(nAutor);
            } catch (Exception ex) {
                Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaA.addAll(nAutor);
        });
        
        btnEditarA.setOnAction((event) -> { 
            
        });
        
        btnEliminarA.setOnAction((event) -> { 
            Autor itemSeleccionado=tvAutor.getSelectionModel().getSelectedItem();
            if(itemSeleccionado!=null){
                try{
                    aDao.EliminarAutor(itemSeleccionado.getIdAutor());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            listaA.setAll(aDao.getAllAutores());
        });
        
        btnLimpiarA.setOnAction((event) -> { 
            txtNombreA.setText("");
            txtApellidoA.setText("");
            txtPais.setText("");
            txtCiudad.setText("");
            txtEstudio.setText("");
        });
        

        //Libro
        btnAgregarL.setOnAction((event) -> { 
            Libro nLibro= new Libro(getIDL());
            nLibro.setNombre(txtNombreA.getText());
            //nLibro.setIdAutor(Integer.valueOf(txtIdAutor.getText()));
            nLibro.setImprenta(txtImprenta.getText());
            nLibro.setCapitulos(Integer.valueOf(txtCapitulos.getText()));
            nLibro.setNroPaginas(Integer.valueOf(txtNroPaginas.getText()));
            nLibro.setGenero(txtGenero.getText());
            try{
                lDao.AgregarLibro(nLibro);
            } catch (Exception ex) {
                Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaL.addAll(nLibro);
        });
        
        btnEditarL.setOnAction((event) -> { 
            
        });
        
        btnEliminarL.setOnAction((event) -> { 
            Libro itemSeleccionado=tvLibro.getSelectionModel().getSelectedItem();
            if(itemSeleccionado!=null){
                try{
                    lDao.EliminarLibro(itemSeleccionado.getIdLibro());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            listaL.setAll(lDao.getAllLibros());
        });
        
        btnLimpiarL.setOnAction((event) -> { 
            txtNombreL.setText("");
            txtIdAutor.setText("");
            txtImprenta.setText("");
            txtCapitulos.setText("");
            txtNroPaginas.setText("");
            txtGenero.setText("");
        });
        
        
        //Usuario
        btnAgregarU.setOnAction((event) -> { 
            Usuario nUsuario= new Usuario(getIDU());
            nUsuario.setNombre(txtNombreU.getText());
            nUsuario.setApellido(txtApellidoU.getText());
            nUsuario.setSexo(txtSexo.getText());
            nUsuario.setDni(txtDni.getText());
            nUsuario.setTelefono(Integer.valueOf(txtTelefono.getText()));
            nUsuario.setEmail(txtEmail.getText());

            try{
                uDao.AgregarUsuario(nUsuario);
            } catch (Exception ex) {
                Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaU.addAll(nUsuario);
        });
        
        btnEditarU.setOnAction((event) -> { 
            
        });
        
        btnEliminarU.setOnAction((event) -> { 
            Usuario itemSeleccionado=tvUsuario.getSelectionModel().getSelectedItem();
            if(itemSeleccionado!=null){
                try{
                    uDao.EliminarUsuario(itemSeleccionado.getDni());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            listaU.setAll(uDao.getAllUsuarios());
        });
        
        btnLimpiarU.setOnAction((event) -> { 
            txtNombreU.setText("");
            txtApellidoU.setText("");
            txtSexo.setText("");
            txtDni.setText("");
            txtTelefono.setText("");
            txtEmail.setText("");
        });
        
        
        //Venta
        btnAgregarV.setOnAction((event) -> { 
            Venta nVenta= new Venta(getIDV());
            //nVenta.setIdAutor(String.valueOf(txtIdAutorV.getText()));
            //nVenta.setDni(Integer.valueOf(txtDniV.getText()));
            //nVenta.setIdLibro(Integer.valueOf(txtIdLibroV.getText()));

            try{
                vDao.AgregarVenta(nVenta);
            } catch (Exception ex) {
                Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            listaV.addAll(nVenta);
        });
        
        btnEditarV.setOnAction((event) -> { 
            
        });
        
        btnEliminarV.setOnAction((event) -> { 
            Venta itemSeleccionado=tvVenta.getSelectionModel().getSelectedItem();
            if(itemSeleccionado!=null){
                try{
                    vDao.EliminarVenta(itemSeleccionado.getIdVenta());
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(FXMLLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            listaV.setAll(vDao.getAllVentas());
        });
        
        btnLimpiarV.setOnAction((event) -> { 
            
        });
        
    }
    
    private int getIDA(){
            List<Autor>allAutor=aDao.getAllAutores();
            int maxID=0;
            
            if(!allAutor.isEmpty()){
                for(Autor autor:allAutor){
                    maxID=autor.getIdAutor();
                }
            }
            return ++maxID;
        }
    
    private int getIDL(){
            List<Libro>allLibro=lDao.getAllLibros();
            int maxID=0;
            
            if(!allLibro.isEmpty()){
                for(Libro libro:allLibro){
                    maxID=libro.getIdLibro();
                }
            }
            return ++maxID;
        }
    
    private String getIDU(){
            List<Usuario>allUsuario=uDao.getAllUsuarios();
            String maxID;
            
            if(!allUsuario.isEmpty()){
                for(Usuario usuario:allUsuario){
                    maxID=usuario.getDni();
                }
            }
        return null;
        }
    
    private int getIDV(){
            List<Venta>allVenta=vDao.getAllVentas();
            int maxID=0;
            
            if(!allVenta.isEmpty()){
                for(Venta venta:allVenta){
                    maxID=venta.getIdVenta();
                }
            }
            return ++maxID;
        }
    
    public static void llenarcb(Libreria_conexion conex, ObservableList<Libro>lista){
            
    }
    
    private void ABD(ActionEvent event)throws Exception{
        String sql = " ";
        try{
            preparar =conex.prepareStatement(sql);
            preparar.executeUpdate();
            
            System.out.println(" ");
            preparar.close();
            conex.close();   
        }catch(SQLException sqlex){
            System.out.println(" ");
        }
    }
}