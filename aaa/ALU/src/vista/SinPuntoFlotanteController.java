/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class SinPuntoFlotanteController implements Initializable {
    
    @FXML
    private TextField txtNumero1;
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
    private Button btnConvertir;
    @FXML
    private TextField txtRes1;
    @FXML
    private TextField txtRes2;
    @FXML
    private TextField txtRes3;
    @FXML
    private TextField txtRes4;
    @FXML
    private Button btnSuma;
    @FXML
    private Button btnResta;
    @FXML
    private Button btnMulti;
    @FXML
    private Button btnDivi;
    @FXML
    private TextField txtNumero2;
    
    @FXML
    public void Convertir(ActionEvent event) {
        String decimal = txtNumero1.getText();
        int decimal1 = Integer.parseInt(decimal);
        
        String decimal3 = txtNumero2.getText();
        int decimal4 = Integer.parseInt(decimal3);
        
        int decimal5=1;
        //Binario
        
        int [] arregloaB = ConvertirBinario(decimal1);
        int [] arreglobB = ConvertirBinario(decimal4);
        
        String cadenaB;
        String cadena1B;

        if(decimal1 >= 0){
            cadenaB = "0";}
        else {
            cadenaB = "1";
        }
        
        for ( int binario1 : arregloaB) {
            cadenaB += binario1;
        }

        txtBin1.setText(cadenaB);
        
        if(decimal4 >= 0){
            cadena1B = "0";}
        else{
            cadena1B = "1";
        }
        
        for ( int binario2 : arreglobB) {
            cadena1B += binario2;
        }

        txtBin2.setText(cadena1B);
        
        //decimal
        //int arr1 = Integer.valueOf(cadenaB);
        
        int arr = ConvertirDecimal(arregloaB,arregloaB.length - 1);
        String arr2 = String.valueOf(arr);
        txtRes1.setText(arr2);
        
        
        
        //Octal
        
        int [] arregloaO = ConvertirOctal(decimal1);
        int [] arreglobO = ConvertirOctal(decimal4);
        int [] arreglocO = ConvertirOctal(decimal5);
        
        String cadenaO;
        if(decimal1 >= 0){
            cadenaO = "0";}
        else {
            arregloaO= sumaOctal(arregloaO, arreglocO);
            arregloaO[0]=1;
            cadenaO = "1";
        }
        
        for ( int binario1 : arregloaO) {
            cadenaO += binario1;
        }

        txtOct1.setText(cadenaO);
        
        String cadena1O = "0";
        
        if(decimal1 >= 0){
            cadena1O = "0";}
        else {
            arregloaO= sumaOctal(arregloaO, arreglocO);
            arregloaO[0]=1;
            cadena1O = "1";
        }
        
        for ( int binario2 : arreglobO) {
            cadena1O += binario2;
        }

        txtOct2.setText(cadena1O);
        
        //Convertir a hexadecimal
        String arregloaH = ConvertirHexadecimal(decimal1);
        String arreglobH = ConvertirHexadecimal(decimal4);
        
        String cadenaH = "0";
        
        
        /*for ( int binario1 : arregloaH) {
            cadenaH += binario1;
        }*/

        txtHex1.setText(arregloaH);
        
        String cadena1H = "0";
        
        /*for ( int binario2 : arreglobH) {
            cadena1H += binario2;
        }
*/
        txtHex2.setText(arreglobH);
     
    }
    
    public void Suma(ActionEvent event){
        String decimal = txtNumero1.getText();
        int decimal1 = Integer.parseInt(decimal);
        
        String decimal3 = txtNumero2.getText();
        int decimal4 = Integer.parseInt(decimal3);
        
        //Suma binarios
        int [] arregloaB = ConvertirBinario(decimal1);
        int [] arreglobB = ConvertirBinario(decimal4);
        int [] resultadoB = sumaBinaria(arregloaB, arreglobB);
        
        
        String cadena2B = "";
        
        
        for ( int binario3 : resultadoB) {
            cadena2B += binario3;
        }

        txtRes2.setText(cadena2B);
        
        //Suma Octal
        int [] arregloaO = ConvertirOctal(decimal1);
        int [] arreglobO = ConvertirOctal(decimal4);
        int [] resultadoO = sumaOctal(arregloaO, arreglobO);
        
        
        String cadena2O = "";
        
        for ( int binario3 : resultadoO) {
            cadena2O += binario3;
        }

        txtRes3.setText(cadena2O);
    }
    
    public void Resta(ActionEvent event){
        String decimal = txtNumero1.getText();
        int decimal1 = Integer.parseInt(decimal);
        
        String decimal3 = txtNumero2.getText();
        int decimal4 = Integer.parseInt(decimal3);
        
        int [] arregloa = ConvertirBinario(decimal1);
        int [] arreglob = ConvertirBinario(decimal4);
        int [] resultado = restaBinaria(arregloa, arreglob);
        
        
        String cadena2 = "0";
        
        if(decimal1 >= 0){
            cadena2 = "0";}
        else {
            cadena2 = "1";
        }
        
        for ( int binario3 : resultado) {
            cadena2 += binario3;
        }

        txtRes2.setText(cadena2);
        
        //Resta Octal
        int [] arregloaO = ConvertirOctal(decimal1);
        int [] arreglobO = ConvertirOctal(decimal4);
        int [] resultadoO = restaOctal(arregloaO, arreglobO);
        
        
        String cadena2O = "";
       
        
        for ( int binario3 : resultadoO) {
            cadena2O += binario3;
        }

        txtRes3.setText(cadena2O);
    }
    
    public void Multiplicacion(ActionEvent event){
        String decimal = txtNumero1.getText();
        int decimal1 = Integer.parseInt(decimal);
        
        String decimal3 = txtNumero2.getText();
        int decimal4 = Integer.parseInt(decimal3);
        
        //Suma binarios
        int [] arregloaB = ConvertirBinario(decimal1);
        int [] arreglobB = ConvertirBinario(decimal4);
        int [] resultadoB = MultiplicacionBinaria(arregloaB, decimal4);
        
        
        String cadena2B = "";
        
        
        for ( int binario3 : resultadoB) {
            cadena2B += binario3;
        }

        txtRes2.setText(cadena2B);
        
        //Suma Octal
        int [] arregloaO = ConvertirOctal(decimal1);
        int [] arreglobO = ConvertirOctal(decimal4);
        int [] resultadoO = MultiplicacionOctal(arregloaO, decimal4);
        
        
        String cadena2O = "";
        
        for ( int binario3 : resultadoO) {
            cadena2O += binario3;
        }

        txtRes3.setText(cadena2O);}
    
    public void Division(ActionEvent event){
        String decimal = txtNumero1.getText();
        int decimal1 = Integer.parseInt(decimal);
        
        String decimal3 = txtNumero2.getText();
        int decimal4 = Integer.parseInt(decimal3);
        
        //Suma binarios
        int [] arregloaB = ConvertirBinario(decimal1);
        int [] arreglobB = ConvertirBinario(decimal4);
        int [] resultadoB = DivisionBinaria(arregloaB, arreglobB, decimal4);
        
        
        String cadena2B = "";
        
        
        for ( int binario3 : resultadoB) {
            cadena2B += binario3;
        }

        txtRes2.setText(cadena2B);
        
      
    }
    
    public static int ConvertirDecimal(int []numero, int index){
        int decimal = 0;
  //comprueba que el indice no sea menor que 0
  if(index >= 0) {
    //comprueba que el valor del binario sea 1 en la posicion del indice
    if(numero[index] == 1) {
      // suma el valor del binario correspondiente al indice y lo guarda en decimalValue
      // ten en cuenta que el valor de un digito binario depende de la posicion en la que este en el arreglo
      // 
      // Ejemplo
      // 
      // indice del arreglo        0           2          3           4           5           6            7
      // valor del binario        2^6         2^5        2^4         2^3         2^2         2^1          2^0
      // 
      // Nota que se le resta 1 al numero de elementos del arreglo ya que un array comienza desde la posicion 0
      //
      decimal = (int) (decimal + (Math.pow(2, ( (numero.length-1) - index ))));
      //Recursividad restandole 1 al indice para trabajar con el indice anterior
      ConvertirDecimal(numero, index-1);
    }
    //en caso de que el valor del binario sea 0 en la posicion del indice no hace falta hacer ninguna operacion
    else{
    //Recursividad restandole 1 al indice para trabajar con el indice anterior
      ConvertirDecimal(numero, index-1);
    }
  
  //devuelve el valor del binario en Decimal
  
  }
   return decimal;
    }
    
    @FXML
    public static int[] Complemento2(int[]a){
        int arreglo [] = new int[31];
        int arreglo1 [] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        
        for(int i = arreglo.length -1 , j=0, k=0; i > -1; i--, j++){
            if(a[i]==0){
                arreglo[j]=1;
            }else if(arreglo[j]==1){
                arreglo[j]=0;
            }
        }
        arreglo = sumaBinaria(arreglo, arreglo1);
        System.out.println("arre:"+arreglo);
        return arreglo;
    }
    
    @FXML
    public static int [] ConvertirBinario(int decimal) {
        
        //Convierte decimal a binario
       
        //variables
         String res="";
         int residuo;
         int x = 0;
         int arreglo [] = new int[31];
         int arreglo1 [] = new int[31];
         
         if(decimal >= 0){   
            while (decimal > 0) {

                residuo = decimal % 2;//obtener el residuo
                decimal = decimal / 2;//realizar la siguiente division
                //En el orden natural de la operacion los valores estan invertidos
                //por eso aqui los volvemos a invertir :)
                res = residuo + res;
                x++;

            }
            for(int i = arreglo.length -1, j=0, k=0; i > -1; i--, j++){

               if(i >= res.length()){ 
                   arreglo[j] = 0;//llenamos los lugares vacios con ceros
               }
               else{
                   arreglo[j] = Integer.parseInt(res.charAt(k)+ "");//cuando llegemos al primer uno guradamos la conversion a binarios
                   k++;
               }
            }
         }
         else if(decimal < 0){
            
             int val=decimal+(-(decimal*2));
             
             while (val > 0) {

                residuo = val % 2;//obtener el residuo
                val = val / 2;//realizar la siguiente division
                //En el orden natural de la operacion los valores estan invertidos
                //por eso aqui los volvemos a invertir :)
                res = residuo + res;
                x++;
                
              }
            
            for(int i = arreglo.length -1 , j=0, k=0; i > -1; i--, j++){

               if(i >= res.length()){ 
                   arreglo[j] = 0;//llenamos los lugares vacios con ceros
               }
               else{
                   arreglo[j] = Integer.parseInt(res.charAt(k)+ "");//cuando llegemos al primer uno guradamos la conversion a binarios
                   k++;
               }

               arreglo = Complemento2(arreglo);

            }
            
         }
        return arreglo;
    }
    
    @FXML
    public static int [] ConvertirOctal(int decimal) {
        
        //Convierte decimal a binario
       
        //variables
         String res="";
         int residuo;
         int x = 0;
         int arreglo [] = new int[31];
         
        if(decimal >= 0){
         while (decimal > 0) {
             
             residuo = decimal % 8;//obtener el residuo
             decimal = decimal / 8;//realizar la siguiente division
             //En el orden natural de la operacion los valores estan invertidos
             //por eso aqui los volvemos a invertir :)
             res = residuo + res;
             x++;

         }
         
         for(int i = arreglo.length -1, j=0, k=0; i > -1; i--, j++){
             
            if(i >= res.length()){ 
                arreglo[j] = 0;//llenamos los lugares vacios con ceros
            }
            else{
                arreglo[j] = Integer.parseInt(res.charAt(k)+ "");//cuando llegemos al primer uno guradamos la conversion a binarios
                k++;
            }
         }
        }
        else if(decimal < 0){
            
             int val=decimal+(-(decimal*2));
                          
             while (val > 0) {

                residuo = val % 8;//obtener el residuo
                val = val / 8;//realizar la siguiente division
                //En el orden natural de la operacion los valores estan invertidos
                //por eso aqui los volvemos a invertir :)
                res = residuo + res;
                x++;
                
              }
            
            for(int i = arreglo.length - 1, j=0, k=0; i > -1; i--, j++){

               if(i >= res.length()){ 
                   arreglo[j] = 7;//llenamos los lugares vacios con ceros
               }
               else{
                   arreglo[j] = Integer.parseInt(res.charAt(k)+ "");//cuando llegemos al primer uno guradamos la conversion a binarios
                   k++;
               }

                 switch (arreglo[j]) {
                     case 0:
                         arreglo[j]=7;
                         break;
                 
                     case 1:
                         arreglo[j]=6;
                         break;
                     case 2:
                         arreglo[j]=5;
                         break;
                     case 3:
                         arreglo[j]=4;
                         break;
                     case 4:
                         arreglo[j]=3;
                         break;
                     case 5:
                         arreglo[j]=2;
                         break;
                     case 6:
                         arreglo[j]=1;
                         break;
                     case 7:
                         arreglo[j]=0;
                         break;
                     default:
                         break;
                 }
                //arreglo= sumaBinaria(arreglo, arreglo1);
                //arreglo[j]=arreglo[j]+1;
            }
            
         }
         return arreglo;// se regresa el arreglo

    }
    
    @FXML
    public static String ConvertirHexadecimal(int decimal) {
       
        //variables
         String res=""; String a ="";
         int residuo = 0;
         int x = 0;
         char arreglo [] = new char[31];
         //char hex [] = new char[31];
         char hex [] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};   
         while (decimal > 0) {
             
                residuo = decimal % 16;//obtener el residuo

                res = hex[residuo] + res;
                
                decimal = decimal / 16;//realizar la siguiente division
                x++;

         }
         for(int i = arreglo.length -1, j=0, k=0; i > -1; i--, j++){
             
            if(i >= res.length()){ 
                arreglo[j] = 0;//llenamos los lugares vacios con ceros
            }
            
         }
         return res;// se regresa el arreglo
    }

     public static int[] sumaBinaria(int a[], int b[]) {
        int acarreo = 0;//variable de control.
        int[] c = new int[31];//Arreglo a retornar.        
        //Se recorre el arreglo a de manera inversa.
        for (int i = c.length -1 ; i > 0; i--) {   
            if(a[i]== 0 && b[i]== 0){
                if(acarreo == 0){
                    c[i]=0;
                }else if (acarreo == 1){
                    c[i]=1;
                }
            }else if(a[i]== 1 && b[i]== 1){
                if(acarreo == 0){
                    c[i]=0;
                    acarreo=1;
                }else if (acarreo == 1){
                    c[i]=1;
                    acarreo=1;
                }
            }else if(a[i]== 0 && b[i]== 1){
                if(acarreo == 0){
                    c[i]=1;
                }else if (acarreo == 1){
                    c[i]=0;
                    acarreo=1;
                }
            }else if(a[i]== 1 && b[i]== 0){
                if(acarreo == 0){
                    c[i]=1;
                }else if (acarreo == 1){
                    c[i]=0;
                    acarreo=1;
                }
            }
            
        }
        return c;//Se regresa el arreglo.
    }
    
    /*public static int[] restaBinaria(int a[], int b[]) {
        int acarreo = 0;//variable de control.
        int[] c = new int[31];//Arreglo a retornar.        
        //Se recorre el arreglo a de manera inversa.
        for (int i = c.length -1 ; i > 0; i--) {            
            int resta = a[i] - b[i]; //Se realiza  la resta una vez por ciclo
            if(resta == -1) {//Si la resta da -1 los elementos en el arreglo son 0 y 1.
               c[i] = 1;//Por lo tanto debe ir como resultado un 1
               acarreo = 1;//Y se lleva un acarreo
           }
            //Si por el contrario la resta es 0 quiere decir que los elementos
            //eran 1 y 1 || 0 y 0.
            else if(resta == 0) {
               c[i] = 0;//Entonces debe ir 0 como resultado
           }
            //Si por el contrario la suma es 1, entonces los elementos 
            //eran 1 y 0.
            else if(resta == 1) {
               c[i] = 1;//Y debe ir como resultado un 1.
           }
            
           if(acarreo == 1) {
               if(a[i-1] - 1 >= 0) {
                   a[i-1]=a[i-1]-1;
                   acarreo = 0;
               }
               else{
                   b[i-1] = b[i-1]+1;
               }
               
           } 
        }
        return c;//Se regresa el arreglo.
    }*/
     
     public static int[] restaBinaria(int a[], int b[]) {
        int acarreo = 0;//variable de control.
        int[] c = new int[31];//Arreglo a retornar.        
        //Se recorre el arreglo a de manera inversa.
        for (int i = c.length -1 ; i > 0; i--) {
            
            if(a[i]== 0 && b[i]== 0){
                if(acarreo == 0){
                    c[i]=0;
                }else if (acarreo == 1){
                    c[i]=0;
                }
            }else if(a[i]== 1 && b[i]== 1){
                if(acarreo == 0){
                    c[i]=0;
                    //acarreo=1;
                }else if (acarreo == 1){
                    c[i]=0;
                    //acarreo=1;
                }
            }else if(a[i]== 0 && b[i]== 1){
                if(acarreo == 0){
                    c[i]=1;
                }else if (acarreo == 1){
                    c[i]=0;
                    acarreo=1;
                }
            }else if(a[i]== 1 && b[i]== 0){
                if(acarreo == 0){
                    c[i]=1;
                }else if (acarreo == 1){
                    c[i]=0;
                    acarreo=1;
                }
            }
              
        }
        return c;//Se regresa el arreglo.
    }
    
    public static int[] MultiplicacionBinaria(int a[], int b){
         int [] mul = new int[31];
         String res="";
         int residuo;
         int x = 0;
         int arreglo [] = new int[31];
          
     
         for(int i=0; i<b; i++){
            mul = sumaBinaria(mul,a);
            x++;
         }
         
        return mul;//Se regresa el arreglo.

    }
    private static int[] clonarBinario(int a[]){
        int[] clon = new int[31];
        System.arraycopy(a, 0, clon, 0, 31);
        return clon;
    }
    
    
    
    public static int[] DivisionBinaria(int a[], int b[], int c){
         int [] res = new int[31];
         int [] aAux = new int[31];
         //String res="";
         int resDecimal = 0;
         int x = 0;
         int arreglo [] = new int[31];
         int m = 0;
         
         res = clonarBinario(a);
         resDecimal = ConvertirDecimal(res,res.length-1);
         //for(m=c; m<=0;m--){
                while(res[30] == 0){
                    System.out.println("jk:"+resDecimal);
                    res = restaBinaria(res,b);
                    imprimirBinario(res);
                    resDecimal = ConvertirDecimal(res,res.length-1);
                    
                    x++;
                    //System.out.println("x:"+x);
                    
         }
        /* for(int i = arreglo.length -1, j=0, k=0; i > -1; i--, j++){

               if(i >= res.length()){ 
                   arreglo[j] = 0;//llenamos los lugares vacios con ceros
               }
               else{
                   arreglo[j] = Integer.parseInt(res.charAt(k)+ "");//cuando llegemos al primer uno guradamos la conversion a binarios
                   k++;
               }
            }*/
         arreglo = ConvertirBinario(m);
         System.out.println("res: "+m);
        
        return res;//Se regresa el arreglo.
    }
    
    public static void imprimirBinario(int bin[]){
        for (int i = 0; i < bin.length; i++) {
            System.out.print(bin[i]+',');
        }
        System.out.print(" Longitud: " + bin.length+"\n");
    }
    
    public static int[] sumaOctal(int a[], int b[]) {
        int acarreo = 0;//variable de control.
        int[] c = new int[31];//Arreglo a retornar.        
        //Se recorre el arreglo a de manera inversa.
        for (int i = c.length -1 ; i > 0; i--) {            
            int suma = a[i] + b[i]; //Se realiza  la suma una vez por ciclo
            if(suma > 7) {//Si la suma da 7 los elementos en el arreglo son suma-8 y 1.
               c[i] = suma - 8 ;//Por lo tanto debe ir como resultado un 0
               acarreo = 1;//Y se lleva un acarreo
           }
            //Si por el contrario la suma es 0 quiere decir que los elementos
            //eran 0 y 0.
            else if(suma == 0) {
               c[i] = 0;//Entonces debe ir 0 como resultado
           }
            //Si por el contrario la suma es 7, entonces los elementos eran 0 y 1 o viceversa.
            else if(suma == 7) {
               c[i] = 7;//Y debe ir como resultado un 7.
           }else
                c[i] = a[i]+b[i];  
            
            int res = 0;
            if(acarreo == 1) {//Si existe un acarreo en este ciclo
               //Se comprueba si la suma del elemento siguiente del arreglo "a" mas el acarreo es igual a 7.
               
               if(a[i-1] + 1 > 7) {
                   a[i-1] = 0;//Si lo es, se asigna un 0 a "a".
                   acarreo = 1;//Y se sigue llevando un acarreo.
               } else {//Si la suma no da 2, solo puede dar 1.
                   a[i-1] = a[i-1]+1;//Y entonces se asigna 1 a "a".
                  acarreo = 0;//Y el acarreo desaparece.
               }
           } 
        }
        return c;//Se regresa el arreglo.
    }
    
    public static int[] restaOctal(int a[], int b[]) {
        int acarreo = 0;//variable de control.
        int[] c = new int[31];
        for (int i = c.length -1 ; i > 0; i--) {            
            int resta = a[i] - b[i]; 
            
            if(resta < 0) {
               c[i] = 8+resta;
               acarreo = 1;
           } 
            else if(resta > 0) {
               c[i] = resta;
               
           }
            else if(resta==0){
                c[i]=0;
            }
            
           if(acarreo == 1) {
               if(a[i-1] - 1 >= 0) {
                   a[i-1]=a[i-1]-1;
                   acarreo = 0;
               }
               else{
                   b[i-1] = b[i-1]+1;
               }
               
           } 
        }
        return c;
    }
    
        public static int[] MultiplicacionOctal(int a[], int b){
         int [] mul = new int[31];
         int x = 0;
        
         for(int i=0; i<b; i++){
            mul = sumaOctal(mul,a);
            x++;
         }
         
        return mul;//Se regresa el arreglo.

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
