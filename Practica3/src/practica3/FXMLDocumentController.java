/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.naming.Binding;

/**
 *
 * @author USUARIO
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label lblRespuesta;
    @FXML
    private TextField txtValor1;
    @FXML
    private TextField txtValor2;
    @FXML
    private Button btnSuma;
    @FXML
    private Button btnResta;
    @FXML
    private Button btnMultiplicacion;
    @FXML
    private Button btnDivision;
    
    private IntegerProperty num1, num2, suma, resta, division, multiplicacion;
    
            
    @FXML
    private void Suma(ActionEvent event) {
        /*
        num1=new SimpleIntegerProperty(1);
        num2=new SimpleIntegerProperty(2);
        NumberBinding sum=num1.add(num2);
        lblRespuesta.setText(sum);
        */
//        num1=new SimpleIntegerProperty(1);
//        num2=new SimpleIntegerProperty(2);
//        
//        suma= new SimpleIntegerProperty();
//        resta= new SimpleIntegerProperty();
//        division=new SimpleIntegerProperty();
//        multiplicacion=new SimpleIntegerProperty();
//        NumberBinding resp=num1.add(num2);
//        lblRespuesta.setText(resp.toString());

        num1=new SimpleIntegerProperty(1);
        num2=new SimpleIntegerProperty(2);
        
//        suma = new SimpleIntegerProperty(num1+num2);
    }
    
    @FXML
    private void Resta(ActionEvent event) {
        /*
        num1=new SimpleIntegerProperty(1);
        num2=new SimpleIntegerProperty(2);
        
        NumberBinding res=num1.subtract(num2);
        lblRespuesta.setText(res);
        */
    }
    
    @FXML
    private void Division(ActionEvent event) {
        /*
        num1=new SimpleIntegerProperty(1);
        num2=new SimpleIntegerProperty(2);
        
        NumberBinding div=num1.divide(num2);
        lblRespuesta.setText(div);
        */
    }
    
    @FXML
    private void Multiplicacion(ActionEvent event) {
        /*
        num1=new SimpleIntegerProperty(1);
        num2=new SimpleIntegerProperty(2);
        
        NumberBinding div=num1.multiply(num2);
        lblRespuesta.setText(div);
        */
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
