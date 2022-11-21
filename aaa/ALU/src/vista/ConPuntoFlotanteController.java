/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Acer
 */
public class ConPuntoFlotanteController implements Initializable {

    @FXML
    private TextField txtNro1;
    @FXML
    private TextField txtNro2;
    @FXML
    private TextField txtBin1;
    @FXML
    private TextField txtOct1;
    @FXML
    private TextField txtHex1;
    @FXML
    private TextField txtBin2;
    @FXML
    private TextField txtOct2;
    @FXML
    private TextField txtHex2;
    @FXML
    private TextField txtBinFin;
    @FXML
    private TextField txtOctFin;
    @FXML
    private TextField txtHexFin;
    @FXML
    private TextField txtDecFin;
    @FXML
    private Button btnConvertir;
    @FXML
    private Label lblaux;
    @FXML
    private Label lblaux2;
    @FXML
    private Button btnSuma;
    @FXML
    private Button btnResta;
    @FXML
    private Button btnMulti;
    @FXML
    private Button btnDivi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Se inicializan los componenetes para que no se puedan editar y tengan un alineado a la derecha
        txtBin1.setEditable(false);
        txtBin2.setEditable(false);
        txtHex1.setEditable(false);
        txtHex2.setEditable(false);
        txtOct1.setEditable(false);
        txtOct2.setEditable(false);
        txtBinFin.setEditable(false);
        txtDecFin.setEditable(false);
        txtOctFin.setEditable(false);
        
        txtNro1.alignmentProperty().set(Pos.CENTER_RIGHT);
        txtNro2.alignmentProperty().set(Pos.CENTER_RIGHT);
        
        
    }    

    @FXML
    private void Convertir(ActionEvent event) {
        
       
        Double Nro1=Double.parseDouble(txtNro1.getText());
        Double Nro2=Double.parseDouble(txtNro2.getText());
        //Convertimos ambos numeros mediante sus metodos correspondientes
        Conversion(Nro1);
        Conversion2(Nro2);
        
        
         
         //Mostramos el valor de la conversion sin el primer caractes puesto que segun
         //el formato IEEE  754 este se elimina
         txtBin1.setText(txtBin1.getText().substring(1));
         txtBin2.setText(txtBin2.getText().substring(1));
         
         
         char[] arrayChar1 = txtBin1.getText().toCharArray();
         char[] arrayChar2 = txtBin2.getText().toCharArray();
         int conteo1=0;
         int conteo2=0;
         //tomaremos el valor hasta antes de la coma decimal en ambos casos
        outerlup:
        for(int i=0; i<arrayChar1.length; i++)
        {
             conteo1=conteo1+1;
        if( arrayChar1[i] == '.')

              break outerlup;

        }
        
        
        outerlup2:
        for(int j=0; j<arrayChar2.length; j++)
        {
              conteo2=conteo2+1;
        if( arrayChar2[j] == '.')

                break outerlup2;

        }
        
        System.out.println("Desplazamientos "+conteo1);
        System.out.println("Desplazamientos "+conteo2);
        //Asiganaremos el numero obtenido a los desplazamientos
        int n =8;
        int desp1 = conteo1;
        int desp2 = conteo2;
        //Recreamos la formula para el exponente en ambos casos
        double exp2 = desp2+(Math.pow(2, n-1)-1);
        int exp2int = (int)exp2;
        System.out.println("Valor a convertir del exponente "+exp2int);
        
        double exp1 = desp1+(Math.pow(2, n-1)-1);
        int exp1int = (int)exp1;
        System.out.println("Valor a convertir del exponente "+exp1int);
        //Convertimos el valor del exponente a binario en ambos casos
       Conversionaux1(exp1);
       Conversionaux2(exp2);
       
       //Hacemos el llenado de 0's para la mantisa
       if(txtBin1.getLength()<=24 )
       {
         int longxtxtbin1=txtBin1.getLength();
         int ceros1 = (24-longxtxtbin1);
         String unir1 =String.join("", Collections.nCopies(ceros1, "0"));
         txtBin1.setText((txtBin1.getText()).concat(unir1));  
       }
       if(txtBin2.getLength()<=24 )
       {
         
          int longxtxtbin2=txtBin2.getLength();
          int ceros2 = (24-longxtxtbin2);
          String unir2 =String.join("", Collections.nCopies(ceros2, "0"));
          txtBin2.setText((txtBin2.getText()).concat(unir2));
       }
       
      //Comprobamos los valores de la mantisa
      System.out.println("Longitud de la mantisa"+txtBin1.getLength());
      System.out.println("Longitud de la mantisa"+txtBin2.getLength());
        
      String parteexp1 = lblaux.getText();
      String parteexp2 = lblaux2.getText();
      //ingresaremos el bit de signo 0 o 1 dependiendo de este 
      double signo1 = Double.parseDouble(txtNro1.getText());
      double signo2 = Double.parseDouble(txtNro2.getText());
      String signo11;
      String signo22;
      if(signo1>0)
      {
          signo11="0";
      }
      else
          
      {
          signo11="1";
      }
      
      
      if(signo2>0)
      {
          signo22="0";
      }
      else
          
      {
          signo22="1";
      }
          
         
      //Haremos concatenacion de el signo, el exponente y la mantisa en ambos casos
      txtBin1.setText(signo11+parteexp1.concat(txtBin1.getText()));
      txtBin2.setText(signo22+parteexp2.concat(txtBin2.getText()));
      //Ocultaremos nuestras variables auxiliares
      //lblaux.setText("");
      //lblaux2.setText("");
     
      //Prueba sin punto
      
      String txttt = txtBin1.getText();
      String txttt2 = txtBin2.getText();
      
      String txtttsinpunto = txttt.replace(".", "");
      String txttt2sinpunto = txttt2.replace(".", "");
      
      
      txtBin1.setText(txtttsinpunto);
      txtBin2.setText(txttt2sinpunto);
      
      
      //Comprobaremos la longitud de nuestro
      System.out.println("Longitud de la conversion final"+txtBin1.getLength());
      System.out.println("Longitud de la conversion final"+txtBin2.getLength());
    
        
        
        
        
      //OPERACION 
        ConvertirOctal1(event);
        ConvertirOctal2(event);
        ConvertirHexadecimal1(event);
        ConvertirHexadecimal2(event);
//        hexa1(Nro1);
   //     hexa2(Nro2);
      
      
        
    }
    
    
    private void Conversion(Double Nro)
    {
        
        
        //Todo el numero 
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(Nro));
        //Parte Entera
        int ValorInt = bigDecimal.intValue();
        //Parte decimal
        BigDecimal Valorbig = bigDecimal.subtract(
        new BigDecimal(ValorInt));
        
        
        //Comprobamos los valores del numero, su parte entera y su parte decimal
        System.out.println("Double Number: " + bigDecimal.toPlainString());
        System.out.println("Integer Part: " + ValorInt);
        System.out.println("Decimal Part: " + Valorbig.toPlainString());
        
        
        //Operaciones
        //Operando parte entera
        
       //Crearemos variables que nos permitiran controlar  el cociente, 
       //residuo y los contadores para terminar los bucles de las divisiones sucesivas
        int Coci = ValorInt;
        int Res = Coci %2;
        int contador=1;
        int ContExterno=0;
        String palabrainvertida="";
        String pt1Final="";
        
        
        
        //Inicializamos el campo txtBin1 con el primer valor del residuo
        txtBin1.setText(Integer.toString(Res));
        
        do {
            //Iremos pasando los valores del cociente y el residuo mientras 
            //que el cociente sea mayor a 1 (el ultimo valor de nuestra division)
            ContExterno=ContExterno+1;
            Coci= Coci / 2;
            int Convpt1 = Coci%2;
            
            do {
            //Inicializamos un par de cadenas de texto auxiliares para ir construyendo
            //nuestro numero binario de la parte entera mientras que los contadores sean iguales
            //lo cual significa que se tienen los valores de las divisiones y del residuo 
            contador=contador+1;
            String cadena= Integer.toString(Convpt1);
            String textofin=txtBin1.getText()+cadena;
            
            //Acomplamos los valores al campo de texto por cada pasada
            txtBin1.setText(textofin);
                
            
            } while (contador==ContExterno);
            
        } while (Coci>1);
        
        //Una vez el cociente llega a 1, voltearemos el resultado para poder visualizar el numero en cuestion
        if(Coci==1)
        {
            String palabra = txtBin1.getText();
             //"1011 -> 1101"
            for (int i = palabra.length()-1; i>=0; i--)
            {

            palabrainvertida += palabra.charAt(i);

            }
            pt1Final = palabrainvertida;
            txtBin1.setText(pt1Final+".");
        }
       
        
        //Operando parte decimal
        
        
        
        //Trabajaremos las multiplicaciones sucesivas con la parte flotante del numero
        //Usaremos variables auxiliares para poder operar 
        BigDecimal Primerdeci = Valorbig;
        double dPrimerdeci = Primerdeci.doubleValue();
        
        BigDecimal Deci = Primerdeci.multiply(new BigDecimal(2));
        double dDeci = Deci.doubleValue();
        int  deciEntero = Deci.intValue();
        BigDecimal decideci=Deci.subtract(new BigDecimal(deciEntero));
        
        
        double ddecideci = decideci.doubleValue();
        
        System.out.println(Deci);
        System.out.println(deciEntero);
        System.out.println(ddecideci);

        int x=0;
        //tamaño lista = 0
        //Crearemos una lista donde se iran almacenando los valores de cada decimal 
        //(de estos se extraera la conversion a binario) para saber hasta que punto
        //se deben realizar las iteraciones
        List<Double> list = new ArrayList<>();
        
        
        int contador2=0;
        int contadorext2=0;
       
        //concatenamos el primer valor multiplicado con el resultado obtenido en las divisiones sucesivas
        txtBin1.setText(txtBin1.getText().concat(Integer.toString(deciEntero)));
        
        
        if( x >= list.size())
        {
            //tamaño lista = 1
              list.add(dPrimerdeci);
        }
    
        //Recorremos la lista
        for (int j=0;j<list.size();j++)
          
           {
            System.out.println("INICIO j:"+j);
            //evaluamos si el valor de j corresponde al tamaño de la lista
            if(j<=list.size() )
            {
                outerloop:
                //Asignaremos los valore a la parte decimal, entera y la iremos pasando en cada iteracion
                //mientras el nuevo valor a multiplicar no este en la lista(no sea repetido)
                do 
                {

                    contador2=contador2+1;
                    System.out.println("Cont2 "+contador2);
                    Primerdeci = decideci;
                    dPrimerdeci = ddecideci;

                    Deci = Primerdeci.multiply(new BigDecimal(2));

                    deciEntero = Deci.intValue();
                    //usaremos variables auxiliares para ir construyendo nuestra conversion 
                    String cadena2= Integer.toString(deciEntero);
                    String textofin=txtBin1.getText()+cadena2;
                    txtBin1.setText(textofin);
                    
                    
                    
                    decideci=Deci.subtract(new BigDecimal(deciEntero));
                    ddecideci=decideci.doubleValue();

                    
                    do
                    {

                        //Evualaremos si los contadores  son diferentes
                        
                      
                        
                        for (int i=0; i<list.size();i++)
                            {
                                
                             //Compararemos cada valor en la lista con el ultimo valor a multiplicar   
                                System.out.println("Comparando "+dPrimerdeci +" con el valor en la pos:"+i);
                                System.out.println(list);
                                //Si el valor se repite o la longitud supera los 23 bits, se termina el ciclo.
                                if(dPrimerdeci==list.get(i) || (txtBin1.getLength() >=24))
                                {
                                    break outerloop;
                                }
                                
                               
                                
                            }
                       
                            contadorext2=contadorext2+1;
                            System.out.println("ContExt "+contadorext2);
                        
                        
                            //avanzamos a traves de la lista y añadimos el elemento a multiplicar tras su evaluacion
                            j=j+1;
                            System.out.println("Nuevo valor j:"+j);
                              System.out.println("Insertando "+dPrimerdeci);
                              list.add(j, dPrimerdeci);
                              System.out.println(list);
                          
                        
                        
                      }
                     while(contador2!=contadorext2 );



                } while (ddecideci != list.get(j)) ;
            
            }
            
               //Mostramos el valor obtenido tras las iteraciones
            
               System.out.println(txtBin1.getText());
        
                   
                   
           }
        
        
        
    }
           
    
    private void Conversion2(Double Nro)
    {
        
        
        //Todo el numero 
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(Nro));
        //Parte Entera
        int ValorInt = bigDecimal.intValue();
        //Parte decimal
        BigDecimal Valorbig = bigDecimal.subtract(
        new BigDecimal(ValorInt));
        
        
        
        System.out.println("Double Number: " + bigDecimal.toPlainString());
        System.out.println("Integer Part: " + ValorInt);
        System.out.println("Decimal Part: " + Valorbig.toPlainString());
        
        
        //Operaciones
        //Operando parte entera
        
       
        int Coci = ValorInt;
        int Res = Coci %2;
        int contador=1;
        int ContExterno=0;
        String palabrainvertida="";
        String pt1Final="";
        
        
        
        txtBin2.setText(Integer.toString(Res));
        
        do {
            ContExterno=ContExterno+1;
            Coci= Coci / 2;
            int Convpt1 = Coci%2;
            
            do {
            contador=contador+1;
            String cadena= Integer.toString(Convpt1);
            String textofin=txtBin2.getText()+cadena;
            
            
            txtBin2.setText(textofin);
                
            
            } while (contador==ContExterno);
            
        } while (Coci>1);
        
        if(Coci==1)
        {
            String palabra = txtBin2.getText();
             //"1011 -> 1101"
            for (int i = palabra.length()-1; i>=0; i--)
            {

            palabrainvertida += palabra.charAt(i);

            }
            pt1Final = palabrainvertida;
            txtBin2.setText(pt1Final+".");
        }
       
        
        //Operando parte decimal
        
        
        
        
        BigDecimal Primerdeci = Valorbig;
        double dPrimerdeci = Primerdeci.doubleValue();
        
        BigDecimal Deci = Primerdeci.multiply(new BigDecimal(2));
        double dDeci = Deci.doubleValue();
        int  deciEntero = Deci.intValue();
        BigDecimal decideci=Deci.subtract(new BigDecimal(deciEntero));
        
        
        double ddecideci = decideci.doubleValue();
        
        System.out.println(Deci);
        System.out.println(deciEntero);
        System.out.println(ddecideci);

        int x=0;
        //tamaño lista = 0
        List<Double> list = new ArrayList<>();
        
        
        int contador2=0;
        int contadorext2=0;
       
        
        txtBin2.setText(txtBin2.getText().concat(Integer.toString(deciEntero)));
        
        
        if( x >= list.size())
        {
            //tamaño lista = 1
              list.add(dPrimerdeci);
        }
    
        
        for (int j=0;j<list.size();j++)
          
           {
            System.out.println("INICIO j:"+j);
            if(j<=list.size())
            {
                outerloop:
                do 
                {

                    contador2=contador2+1;
                    System.out.println("Cont2 "+contador2);
                    Primerdeci = decideci;
                    dPrimerdeci = ddecideci;

                    Deci = Primerdeci.multiply(new BigDecimal(2));

                    deciEntero = Deci.intValue();
                    String cadena2= Integer.toString(deciEntero);
                    String textofin=txtBin2.getText()+cadena2;
                    txtBin2.setText(textofin);
                    
                    
                    
                    decideci=Deci.subtract(new BigDecimal(deciEntero));
                    ddecideci=decideci.doubleValue();

                    
                    do
                    {

                        //Evaluamos si el numero a ingresar no se encuentra ya en la lista
                        
                      
                        
                        for (int i=0; i<list.size();i++)
                            {
                                
                                
                                System.out.println("Comparando "+dPrimerdeci +" con el valor en la pos:"+i);
                                System.out.println(list);
                                
                                if(dPrimerdeci==list.get(i) || (txtBin2.getLength() >=24))
                                {
                                    break outerloop;
                                }
                                
                               
                                
                            }
                       
                            contadorext2=contadorext2+1;
                            System.out.println("ContExt "+contadorext2);
                        
                        
                            j=j+1;
                            System.out.println("Nuevo valor j:"+j);
                              System.out.println("Insertando "+dPrimerdeci);
                              list.add(j, dPrimerdeci);
                              System.out.println(list);
                          
                        
                        
                      }
                     while(contador2!=contadorext2 );



                } while (ddecideci != list.get(j)) ;
            
            }
            
               
            /*
               System.out.println(txtBin2.getText());
               if(txtBin2.getText().endsWith("1"))
               {
                   txtBin2.setText(txtBin2.getText().substring(0, txtBin2.getLength()).concat("0"));
               }
               else
               {
                   txtBin2.setText(txtBin2.getText().substring(0, txtBin2.getLength()).concat("1"));
               }
                 */   
               
               
           /*
             String cadena2= (list.toString()+","+dPrimerdeci);
             System.out.println(dPrimerdeci);
            
             System.out.print("ARRAY"+cadena2);   
             
       
             System.out.println("\nFINAL j:"+j);
             
             
             String textofin2=txtBin1.getText()+","+cadena2;
        
            txtBin1.setText(textofin2);
            */
           
           
           
           
                   
                   
                   
           }
        
        
        
        //NRO2
        
        
        
        
        
        
        
       
           
         
        
       
        
    }
    
    
    
    public void Conversionaux1(double Nro)
    {
        //Todo el numero 
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(Nro));
        //Parte Entera
        int ValorInt = bigDecimal.intValue();
        //Parte decimal
        BigDecimal Valorbig = bigDecimal.subtract(
        new BigDecimal(ValorInt));
        
        
        
        System.out.println("Double Number: " + bigDecimal.toPlainString());
        System.out.println("Integer Part: " + ValorInt);
        System.out.println("Decimal Part: " + Valorbig.toPlainString());
        
        
        //Operaciones
        //Operando parte entera
        
       
        int Coci = ValorInt;
        int Res = Coci %2;
        int contador=1;
        int ContExterno=0;
        String palabrainvertida="";
        String pt1Final="";
        
        
        
        lblaux.setText(Integer.toString(Res));
        
        do {
            
            ContExterno=ContExterno+1;
            Coci= Coci / 2;
            int Convpt1 = Coci%2;
            
            do {
            contador=contador+1;
            String cadena= Integer.toString(Convpt1);
            String textofin=lblaux.getText()+cadena;
            
            
            lblaux.setText(textofin);
                
            
            } while (contador==ContExterno);
            
        } while (Coci>1);
        
        if(Coci==1)
        {
            String palabra = lblaux.getText();
             //"1011 -> 1101"
            for (int i = palabra.length()-1; i>=0; i--)
            {

            palabrainvertida += palabra.charAt(i);

            }
            pt1Final = palabrainvertida;
            lblaux.setText(pt1Final);
        }
        System.out.println(lblaux.getText());
        
    }
    
    public void Conversionaux2(double Nro)
    {
        //Todo el numero 
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(Nro));
        //Parte Entera
        int ValorInt = bigDecimal.intValue();
        //Parte decimal
        BigDecimal Valorbig = bigDecimal.subtract(
        new BigDecimal(ValorInt));
        
        
        
        System.out.println("Double Number: " + bigDecimal.toPlainString());
        System.out.println("Integer Part: " + ValorInt);
        System.out.println("Decimal Part: " + Valorbig.toPlainString());
        
        
        //Operaciones
        //Operando parte entera
        
       
        int Coci = ValorInt;
        int Res = Coci %2;
        int contador=1;
        int ContExterno=0;
        String palabrainvertida="";
        String pt1Final="";
        
        
        
        lblaux2.setText(Integer.toString(Res));
        
        do {
            
            ContExterno=ContExterno+1;
            Coci= Coci / 2;
            int Convpt1 = Coci%2;
            
            do {
            contador=contador+1;
            String cadena= Integer.toString(Convpt1);
            String textofin=lblaux2.getText()+cadena;
            
            
            lblaux2.setText(textofin);
                
            
            } while (contador==ContExterno);
            
        } while (Coci>1);
        
        if(Coci==1)
        {
            String palabra = lblaux2.getText();
             //"1011 -> 1101"
            for (int i = palabra.length()-1; i>=0; i--)
            {

            palabrainvertida += palabra.charAt(i);

            }
            pt1Final = palabrainvertida;
            lblaux2.setText(pt1Final);
        }
        
        System.out.println(lblaux2.getText());
        
    }

    @FXML
    private void Suma(ActionEvent event) {
        
        SumaBinaria(txtBin1.getText(), txtBin2.getText());
        octal_sum(15, 33);
        
    }

    @FXML
    private void Resta(ActionEvent event) {
    }

    @FXML
    private void Multiplicacion(ActionEvent event) {
        String resultadobi = multiplicarBinarios(txtBin1.getText(), txtBin2.getText());
        txtBinFin.setText(resultadobi);
        String resultadodeci =  multiplicarDecimales(txtNro1.getText(),txtNro2.getText());
        txtDecFin.setText(resultadodeci);
        String resultadohexa = multiplicacionHexadecimales(txtHex1.getText(),txtHex2.getText());
        txtHexFin.setText(resultadohexa);
        String resultadooctal =String.valueOf(multiplicacionOctales(txtOct1.getText(),txtOct2.getText()));
        txtOctFin.setText(resultadooctal);
        
    }

    @FXML
    private void Division(ActionEvent event) {
    }
    

    public static String multiplicarBinarios(String binary1, String binary2) {
        try {
            binary1 = binary1.substring(binary1.indexOf('1'));
            binary2 = binary2.substring(binary2.indexOf('1'));
        } catch (StringIndexOutOfBoundsException e) {// some number is 0
            return "0";
        }

        // 1st step: multiply each bit of binary2 by binary1
        String zero = IntStream.range(0, binary1.length()).mapToObj(v -> "0").collect(Collectors.joining());
        StringBuilder lpad = new StringBuilder(IntStream.range(0, binary2.length() - 1).mapToObj(v -> "0").collect(Collectors.joining()));
        StringBuilder rpad = new StringBuilder();
        String[] prod = new String[binary2.length()];

        for (int i = binary2.length() - 1, j = 0; i >= 0; i--, j++) {
            prod[j] = lpad.toString()
                    .concat(binary2.charAt(i) == '1' ? binary1 : zero)
                    .concat(rpad.toString());
            if (lpad.length() > 0) {
                lpad.deleteCharAt(0);
                rpad.append('0');
            }
        }

        // 2nd step: sum the products
        String result = prod[0];

        for (int i = 1; i < prod.length; i++) {
            StringBuilder sum = new StringBuilder();
            int[] carry = new int[binary1.length() + binary2.length()];

            for (int j = binary2.length() + binary1.length() - 2; j >= 0; j--) {
                int r = result.charAt(j) - '0' + prod[i].charAt(j) - '0';

                if (r > 1) {
                    sum.append(carry[j + 1]);
                    carry[j] = 1;
                } else if ((r += carry[j + 1]) > 1) {
                    sum.append('0');
                    carry[j] = 1;
                } else {
                    sum.append(r);
                }
            }

            if (carry[0] == 1) {
                sum.append('1');
            }

            result = sum.reverse().toString();
        }

        return result;
    }
     public static double multiplicacionOctales(String num1,String num2){
        double resultadooctal = Double.parseDouble(num1) * Double.parseDouble(num2);
        return resultadooctal;
    }
     public static String multiplicacionHexadecimales(String str1, String str2)  {
        if(str1 == null || str2 == null)
            return "Valores vacios no son aceptados";

        char[] hex1 = str1.toCharArray();
        char[] hex2 = str2.toCharArray();

        int[][] ArrHexMatrix;
        int arrLength = hex1.length + hex2.length;
        int arrIndexLength = hex1.length + hex2.length - 1;
        int lines = hex2.length;
        ArrHexMatrix = new int[hex2.length][arrLength];

        int mod = 0;
        int carry = 0;
        int count = 0;
        int index = 0;

        for (int i = lines - 1; i >= 0; i--) {

            carry = 0;
            count = 0;
            for (int j = hex1.length - 1; j >= 0; j--) {
                try {
                    if(getInt(hex2[i])==-1 || getInt(hex1[j])==-1)
                        return "Escriba en mayuscula";

                    mod = (getInt(hex2[i]) * getInt(hex1[j]) + carry) % 16;
                    carry = ((getInt(hex2[i]) * getInt(hex1[j])) + carry) / 16;

                    if (j == 0) {
                        ArrHexMatrix[index][arrIndexLength - count - index] = mod;
                        ArrHexMatrix[index][arrIndexLength - count - 1 - index] = carry;
                    } else {
                        ArrHexMatrix[index][arrIndexLength - count - index] = mod;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
            }
            index++;
        }

        int sum = 0;
        mod = 0;
        carry = 0;
        count = 0;

        char[] total = new char[arrLength];
        for (int i = arrLength - 1; i >= 0; i--) {
            sum = 0;
            for (int j = 0; j < lines; j++) {
                sum += ArrHexMatrix[j][i];
            }
            mod = (sum + carry) % 16;
            carry = (sum + carry) / 16;

            try {
                total[i] = getChar(mod);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return String.valueOf(total);
    }

    private static int getInt(char chr) {
        switch (chr) {
        case '0':
            return 0;
        case '1':
            return 1;
        case '2':
            return 2;
        case '3':
            return 3;
        case '4':
            return 4;
        case '5':
            return 5;
        case '6':
            return 6;
        case '7':
            return 7;
        case '8':
            return 8;
        case '9':
            return 9;
        case 'A':
            return 10;
        case 'B':
            return 11;
        case 'C':
            return 12;
        case 'D':
            return 13;
        case 'E':
            return 14;
        case 'F':
            return 15;
        default:
            return -1;
        }

    }

    private static char getChar(int val) throws Exception {
        switch (val) {
        case 0:
            return '0';
        case 1:
            return '1';
        case 2:
            return '2';
        case 3:
            return '3';
        case 4:
            return '4';
        case 5:
            return '5';
        case 6:
            return '6';
        case 7:
            return '7';
        case 8:
            return '8';
        case 9:
            return '9';
        case 10:
            return 'A';
        case 11:
            return 'B';
        case 12:
            return 'C';
        case 13:
            return 'D';
        case 14:
            return 'E';
        case 15:
            return 'F';
        default:
            throw new Exception();
        }
    }
      public static String multiplicarDecimales(String a, String b){
       double resultadoA = Double.valueOf(a);
       double resultadoB = Double.valueOf(b);
       BigDecimal resultadofa = BigDecimal.valueOf(resultadoA);
       BigDecimal resultadofb = BigDecimal.valueOf(resultadoB);
       BigDecimal resultadon = resultadofa.multiply(resultadofb);
       String resultadof = String.valueOf(resultadon);
       return resultadof;  
    }
    //AQUI TERMINA MULTIPLICACION
     //------------------------------------------------------------------------------------------
     //-------------------------------------------------------------------------------------------
     //--------------------------------------------------------------------------------------------
      private void ConvertirOctal1(ActionEvent event){
        
        double nu1 = Double.parseDouble(txtNro1.getText());
        double conversion = 0;
         //Todo el numero 
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(nu1));
        //Parte Entera
        int ValorInt = bigDecimal.intValue();
        //Parte decimal
        BigDecimal Valorbig = bigDecimal.subtract(
        new BigDecimal(ValorInt));
        
        if (nu1 >= 0) {
            //separar la parte entera con decimal
//            System.out.println("El número originalmente es:" + decimal);
            double parteDecimal = (nu1 % 1);
            int parteEntera = (int) (nu1- parteDecimal);
//            System.out.println("Parte entera:"+ parteEntera +" Parte decimal:" + parteDecimal);
            //conversion de parte entera   
            String octal = Integer.toOctalString(parteEntera);
            double octal1 = Double.valueOf(octal);
            double octald = parteDecimal * 8 ;
            //si es bluce infinito o no
            if (octal1 % 1 == 0) {
                
                String x = Integer.toString((int) octald);
                double dnum = Double.valueOf(x.length());
                double y = octald / Math.pow(10, dnum);
                //conversion 
                conversion = octal1 + y;
                
                this.txtOct1.setText(Double.toString(conversion));
                
            }else{
                this.txtOct2.setText(Double.toString(conversion)+" decimal infinito");
            }
                        
        }
        
    }
    
    
      private void ConvertirOctal2(ActionEvent event){
        
        double nu2 = Double.parseDouble(txtNro2.getText());
        double conversion = 0;
         //Todo el numero 
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(nu2));
        //Parte Entera
        int ValorInt = bigDecimal.intValue();
        //Parte decimal
        BigDecimal Valorbig = bigDecimal.subtract(
        new BigDecimal(ValorInt));
        
        if (nu2 >= 0) {
            //separar la parte entera con decimal
//            System.out.println("El número originalmente es:" + decimal);
            double parteDecimal = (nu2 % 1);
            int parteEntera = (int) (nu2 - parteDecimal);
//            System.out.println("Parte entera:"+ parteEntera +" Parte decimal:" + parteDecimal);
            //conversion de parte entera   
            String octal = Integer.toOctalString(parteEntera);
            double octal1 = Double.valueOf(octal);
            double octald = parteDecimal * 8 ;
            //si es bluce infinito o no
            if (octal1 % 1 == 0) {
                
                String x = Integer.toString((int) octald);
                double dnum = Double.valueOf(x.length());
                double y = octald / Math.pow(10, dnum);
                //conversion 
                conversion = octal1 + y;
                
                this.txtOct2.setText(Double.toString(conversion));
                
            }else{
                this.txtOct2.setText(Double.toString(conversion)+" decimal infinito");
            }
                        
        }
    }
      
      
    public  String SumaBinaria(String s1, String s2)
    {
       
    if (s1 == null || s2 == null) return "";
    int primero = s1.length() - 1;
    int segundo = s2.length() - 1;
    StringBuilder sb = new StringBuilder();
    int acarreo = 0;
    while (primero >= 0 || segundo >= 0) {
        int sum = acarreo;
        if (primero >= 0) {
            sum += s1.charAt(primero) - '0';
            primero--;
        }
        if (segundo >= 0) {
            sum += s2.charAt(segundo) - '0';
            segundo--;
        }
        acarreo = sum >> 1;
        sum = sum & 1;
        sb.append(sum == 0 ? '0' : '1');
    }
    if (acarreo > 0)
        sb.append('1');

    sb.reverse();
    txtBinFin.setText(String.valueOf(sb));
    return String.valueOf(sb);
         
    }
    
    
    public int octal_sum(double a, double b)
            
    {   
        
        double nu2 = a;
        //Todo el numero 
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(nu2));
        //Parte Entera
        int ValorInt = bigDecimal.intValue();
        //Parte decimal
        BigDecimal Valorbig = bigDecimal.subtract(
        new BigDecimal(ValorInt));    
        
        
        double nu22 = a;
        //Todo el numero 
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(nu22));
        //Parte Entera
        int ValorInt2 = bigDecimal2.intValue();
        //Parte decimal
        BigDecimal Valorbig2 = bigDecimal2.subtract(
        new BigDecimal(ValorInt2));   
        
        
    int sum = 0, digit = 0, carry = 0, digit_rank = 1;

    // Calculate the sum
    while (ValorInt > 0 || ValorInt2 > 0 || carry>0)
    {
        // Calculate the digit
        digit = (int) (ValorInt % 10 + ValorInt2 % 10 + carry);

        // Determine if you should carry or not
        if (digit > 7)
        {
            carry = 1;
            digit %= 8;
        }
        else
            carry = 0;

        // Add the digit at the beggining of the sum
        sum += digit * digit_rank;
        digit_rank *= 10;

        // Get rid of the digits of a and b we used
        ValorInt /= 10;
        ValorInt2 /= 10;
    }
    txtOctFin.setText(Integer.toString(sum));
    
    return sum;
}
            
    private void ConvertirHexadecimal1(ActionEvent event){
        double resul = 0;
        String cadenaResul = "";
        //String mutable[];
        double number =  Double.parseDouble(txtNro1.getText());
        String str;
        double numEntero;
        double decNumbert;
        str = String.valueOf(number);
        numEntero = Integer.parseInt(str.substring(0, str.indexOf('.')));

        while (numEntero > 16) {

            resul = numEntero / 16;
            str = String.valueOf(resul);
            numEntero = Integer.parseInt(str.substring(0, str.indexOf('.')));
            decNumbert = Float.parseFloat(str.substring(str.indexOf('.')));
            resul = decNumbert * 16;
            switch ((int) resul) {
                case 10:
                    cadenaResul = "A" + cadenaResul;
                    break;
                case 11:
                    cadenaResul = "B" + cadenaResul;
                    break;
                case 12:
                    cadenaResul = "C" + cadenaResul;
                    break;
                case 13:
                    cadenaResul = "D" + cadenaResul;
                    break;
                case 14:
                    cadenaResul = "E" + cadenaResul;
                    break;
                case 15:
                    cadenaResul = "F" + cadenaResul;
                    break;
                default:
                    cadenaResul = (int) resul + cadenaResul + "";
                    break;
            }
            if (numEntero < 16) {
                resul = numEntero;
                cadenaResul = (int) resul + cadenaResul + "";
            }

        }
        cadenaResul = cadenaResul + ".";

        str = String.valueOf(number);
        decNumbert = Double.parseDouble(str.substring(str.indexOf('.')));

        for (int i = 0; i < 5; i++) {
            resul = decNumbert * 16;
            switch ((int) resul) {
                case 10:
                    cadenaResul = cadenaResul + "A" + "";
                    break;
                case 11:
                    cadenaResul = cadenaResul + "B" + "";
                    break;
                case 12:
                    cadenaResul = cadenaResul + "C" + "";
                    break;
                case 13:
                    cadenaResul = cadenaResul + "D" + "";
                    break;
                case 14:
                    cadenaResul = cadenaResul + "E" + "";
                    break;
                case 15:
                    cadenaResul = cadenaResul + "F" + "";
                    break;
                default:
                    cadenaResul = cadenaResul + (int) resul + "";
                    break;
            }

            str = String.valueOf(resul);
            decNumbert = Double.parseDouble(str.substring(str.indexOf('.')));

        }
            txtHex1.setText(cadenaResul);

            
   }   
            private void ConvertirHexadecimal2(ActionEvent event){
        double resul = 0;
        String cadenaResul = "";
        //String mutable[];
        double number =  Double.parseDouble(txtNro2.getText());
        String str;
        double numEntero;
        double decNumbert;
        str = String.valueOf(number);
        numEntero = Integer.parseInt(str.substring(0, str.indexOf('.')));

        while (numEntero > 16) {

            resul = numEntero / 16;
            str = String.valueOf(resul);
            numEntero = Integer.parseInt(str.substring(0, str.indexOf('.')));
            decNumbert = Float.parseFloat(str.substring(str.indexOf('.')));
            resul = decNumbert * 16;
            switch ((int) resul) {
                case 10:
                    cadenaResul = "A" + cadenaResul;
                    break;
                case 11:
                    cadenaResul = "B" + cadenaResul;
                    break;
                case 12:
                    cadenaResul = "C" + cadenaResul;
                    break;
                case 13:
                    cadenaResul = "D" + cadenaResul;
                    break;
                case 14:
                    cadenaResul = "E" + cadenaResul;
                    break;
                case 15:
                    cadenaResul = "F" + cadenaResul;
                    break;
                default:
                    cadenaResul = (int) resul + cadenaResul + "";
                    break;
            }
            if (numEntero < 16) {
                resul = numEntero;
                cadenaResul = (int) resul + cadenaResul + "";
            }

        }
        cadenaResul = cadenaResul + ".";

        str = String.valueOf(number);
        decNumbert = Double.parseDouble(str.substring(str.indexOf('.')));

        for (int i = 0; i < 5; i++) {
            resul = decNumbert * 16;
            switch ((int) resul) {
                case 10:
                    cadenaResul = cadenaResul + "A" + "";
                    break;
                case 11:
                    cadenaResul = cadenaResul + "B" + "";
                    break;
                case 12:
                    cadenaResul = cadenaResul + "C" + "";
                    break;
                case 13:
                    cadenaResul = cadenaResul + "D" + "";
                    break;
                case 14:
                    cadenaResul = cadenaResul + "E" + "";
                    break;
                case 15:
                    cadenaResul = cadenaResul + "F" + "";
                    break;
                default:
                    cadenaResul = cadenaResul + (int) resul + "";
                    break;
            }

            str = String.valueOf(resul);
            decNumbert = Double.parseDouble(str.substring(str.indexOf('.')));

        }
            txtHex2.setText(cadenaResul);

            
   } 
      
}
    
    
    
    
    
    
    
    
    

