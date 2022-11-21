/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hex;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Trabajo
{
    public static long Hexadecimal (String numero)
    {
        long Suma = 0;
        StringBuilder num = new StringBuilder (numero).reverse();
        for(int i = 0; i < num.length(); i++)
        {
            if (num.charAt(i) == 'A')
            {
                Suma += 10*(Math.pow(16, i));
            }
            else 
            {
                if(num.charAt(i) == 'B')
                {
                    Suma += 11*(Math.pow(16, i));
                }
                else
                {
                    if(num.charAt(i) == 'C')
                    {
                        Suma += 12*(Math.pow(16, i));
                    }
                    else
                    {
                        if(num.charAt(i) == 'D')
                        {
                            Suma += 13*(Math.pow(16, i));
                        }
                        else
                        {
                            if(num.charAt(i) == 'E')
                            {
                                Suma += 14*(Math.pow(16, i));
                            }
                            else 
                            {
                                if(num.charAt(i) == 'F')
                                {
                                    Suma += 15*(Math.pow(16, i));
                                }
                                else
                                {
                                    Suma = Suma + Integer.parseInt(""+num.charAt(i))*(long)Math.pow(16, i);
                                }
                            }
                        }
                    }
                }
            }
        }
    return Suma;
    }
    
    public static void main(String[]util)
    {
        long numero1, numero2;
        int Resultado = 0, Operaciones;
        Scanner Hex = new Scanner(System.in);
        System.out.println("Ingrese el primer número hexadecimal: ");
        String num1 = Hex.nextLine().toUpperCase();
        System.out.println("Ingrese el segundo número hexadecimal: ");
        String num2 = Hex.nextLine().toUpperCase();
        numero1 = Hexadecimal(num1);
        numero2 = Hexadecimal(num2);
        System.out.println("Operaciones 1.Suma  2.Resta  3.Multiplicación  4.División  5.Salir");
        
        Operaciones  = Hex.nextInt();
        while (Operaciones!=5)
        {
            switch(Operaciones)
            {
                case 1:
                    Resultado = (int) (numero1+numero2);
                    break;
                    case 2:
                            Resultado = (int) (numero1-numero2);
                    break;
                            case 3:
                            Resultado = (int) (numero1*numero2);
                    break;
                            case 4:
                                if(numero2 == 0)
                                {
                                    Resultado = 99999;
                                }
                                else
                                {
                                    Resultado = (int) (numero1/numero2);
                                }
                                break;
            }
            if(Resultado < 0)
            {
                System.out.println("No existen los numeros hexadecimales negativos");
            }
            else
            {
                if (Resultado == 99999)
                {
                    System.out.println("La división para cero no existe");
                }
                else
                {
                    String str = Integer.toHexString(Resultado);
                    System.out.println("El resultado de la operación " +Operaciones+ "\t es: \n" +str);
                }
            }
        System.out.println("Operaciones .Suma  2.Resta  3.Multiplicación  4.División  5.Salir");
        Operaciones = Hex.nextInt();
        }
    }
}