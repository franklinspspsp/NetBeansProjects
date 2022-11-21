/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unelefante;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class UnElefante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scan = new Scanner(System.in);
//        System.out.println("Escriba una letra: ");
//        String Letra = scan.nextLine();
//        System.out.println("Escriba un numero: ");
//        int numero = scan.nextInt();
//        
//        System.out.println("la letra es [" + Letra + "] y el numero es [" + numero + "]");
        String cadena="";
        char [] Arraycadena ;
        char caracter;
        int contador =0;
        System.out.println("Introduce una palabra");
        cadena=scan.nextLine();
        Arraycadena=cadena.toCharArray();
        for(int i =0;i<Arraycadena.length;i++){
            caracter = Arraycadena[i];
            for(int j=0;j<Arraycadena.length;j++){
                if(Arraycadena[j]==caracter){
                    contador++;
                }//Fin Si
            }//Fin Para
            System.out.println(Arraycadena[i]+" "+contador+" veces.");
            contador= 0;
        }//Fin Para
    }
    
}
