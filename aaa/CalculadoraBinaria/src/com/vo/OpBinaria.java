/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo;

/**
 *
 * @author LINUX
 */
public class OpBinaria {

    public static String Suma(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 + b1;
        String resultado = Integer.toString(c1, 2);
        return resultado;
    }
    
    public static String Resta(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 - b1; 
        String resultado = Integer.toString(c1, 2);
        return resultado;
    }
    
    public static String Divicion(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 / b1; 
        String resultado = Integer.toString(c1, 2);
        return resultado;
    }
    
    public static String Multiplicacion(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 * b1; 
        String resultado = Integer.toString(c1, 2);
        return resultado;
    }
}
