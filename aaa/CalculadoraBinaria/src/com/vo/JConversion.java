/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vo;

/**
 *
 * @author LINUX
 */
public class JConversion {

    public static String BinarioADecimal(String a) {
        int a1 = Integer.parseInt(a, 2);
        String resultado = a1 + "";
        return resultado;
    }

    public static String OctalADecimal(String a) {
        int a1 = Integer.parseInt(a, 8);
        String resultado = a1 + "";
        return resultado;
    }

    public static String HexaADecimal(String a) {
        int a1 = Integer.parseInt(a, 16);
        String resultado = a1 + "";
        return resultado;
    }

    public static String DecimalABinario(String a) {
        int x = Integer.parseInt(a);
        String resultado = Integer.toString(x, 2);
        return resultado;
    }

    public static String DecimalAOctal(String a) {
        int x = Integer.parseInt(a);
        String resultado = Integer.toString(x, 8);
        return resultado;
    }

    public static String DecimalAHexa(String a) {
        int x = Integer.parseInt(a);
        String resultado = Integer.toString(x, 16);
        return resultado;
    }

    public static String BinarioAHexa(String binario) {
        Integer numero = Integer.valueOf(binario, 2);
        return Integer.toHexString(numero);
    }

    public static String HexaABinario(String hexa) {
        Integer numero = Integer.valueOf(hexa, 16);
        return Integer.toBinaryString(numero.intValue());
    }

    public static String BinariAOctal(String binario) {
        Integer numero = Integer.valueOf(binario, 2);
        return Integer.toOctalString(numero);
    }
    
    public static String OctalABinari(String octal) {
        Integer numero = Integer.parseInt(octal, 8);
        return Integer.toBinaryString(numero.intValue());
    }
}
