/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.pkg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author LENOVO
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnSumar; 
    @FXML
    private Button btnRestar; 
    @FXML
    private TextField txtnum1; 
    @FXML
    private TextField txtnum2; 
    @FXML
    private TextField txtResultado1; 
    @FXML
    private TextField txtResultado2; 
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void sumar (ActionEvent event){
        
        int num1 = Integer.parseInt(this.txtnum1.getText());
        int num2 = Integer.parseInt(this.txtnum2.getText());
        Suma s = new Suma (num1, num2);
        
        int resultado = s.suma();
        this.txtResultado1.setText(resultado + "");
    }
    
        @FXML
    private void resta (ActionEvent event){
        
        int num1 = Integer.parseInt(this.txtnum1.getText());
        int num2 = Integer.parseInt(this.txtnum2.getText());
        Resta r = new Resta (num1, num2);
        
        int resultado = r.resta();
        this.txtResultado2.setText(resultado + "");
    }
} 
