/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workhex;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Proyecto 
{
	/**
	 * Metodo inicial.
	 */
	public static void main(String[] args)           
	{
		try 
		{	
			int operacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion \n" 
																	+ "1-Conversion \n"
																	+ "2-Suma \n" 
																	+ "3-Resta \n" 
																	+ "4-Multiplicacion"));
			iniciarMenu(operacion);
		} 
		catch (Exception err) 
	
		{
		JOptionPane.showMessageDialog(null, "Error","Informacion Invalida!",JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Aplicacion para Conversion,sumar,resta o multiplicar Sistemas numericos
	 * 
	 * @param operacion
	 * Codigo es de la opreacion 
	 * @Autor: Diego Fernando Echverry
	 * @Autor: Pedro Holguin
	 */
	
	
	/**
	 * Menu para seleccionar base en la operación de conversión.
	 * 
	 * @param seleccionado
	 *            Numero seleccionado anteriormente, si se le pasa un -1 se
	 *            mostre todas las opciones.
	 * 
	 * @return La base seleccionada por el usuario.
	 */
	public static int menuBase(int seleccionado) 
	{

		int baseSeleccionada = -1;
		if (seleccionado == -1) 
		{
			// 1 binario, 2 octal, 3 decimal, 4 hexadecimal.

			baseSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una Base \n" 
																			+ "1 - Binario \n"
																			+ "2 - Octal \n" + "3 - Decimal \n"
																			+ "4 - Hexadecimal"));
		} else 
		{
			String opcionBinario = " Binario \n";
			String opcionOctal =   " Octal \n";
			String opcionDecimal = " Decimal \n";
			String opcionHexadecimal = " Hexadecimal";
			String opcionesSeleccionables = "";
			int contador =2;
			if (seleccionado != 1)
				opcionesSeleccionables +=contador++ +opcionBinario;
			if (seleccionado != 2)
				opcionesSeleccionables +=contador++ + opcionOctal;
			if (seleccionado != 3)
				opcionesSeleccionables +=contador++ + opcionDecimal;
			if (seleccionado != 4)
				opcionesSeleccionables +=contador++ + opcionHexadecimal;
			baseSeleccionada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una Base \n"
																			+ opcionesSeleccionables));
		}

		if (baseSeleccionada <= 0 || baseSeleccionada > 4) 
			{
				JOptionPane.showMessageDialog(null, "Rango Invalido", "Error!",
				JOptionPane.ERROR_MESSAGE);
			}

		return baseSeleccionada;
	}

	public static String ingresarNumero() 
	{
		return JOptionPane.showInputDialog("Ingrese el numero en la base origen");
	}


	public static void iniciarMenu(int operacion) 
	{

		if (operacion >= 1 && operacion <= 4) 
		{
			
				switch (operacion) 
				{
				// Conversion
				case 1:
					int baseOrigen = menuBase(-1);
					   String numeroIngresado = ingresarNumero();
						int baseDestino = menuBase(baseOrigen);
						if (numeroIngresado.length()>10) {
							JOptionPane.showMessageDialog(null,  "No se permiten numeros de mas de 10 digitos!","Error",JOptionPane.ERROR_MESSAGE);
						}else 
						{
							if (numeroIngresado.charAt(0) == '-') {
								JOptionPane.showMessageDialog(null, "Error","No se permiten numeros negativos!",JOptionPane.ERROR_MESSAGE);
							}else 
							{
								
									JOptionPane.showMessageDialog(null,convertirNumeroBase(baseOrigen,
											baseDestino, numeroIngresado));	
							}
						}
						
						
					break;

				// Suma
				case 2:
					int baseOperacion = menuBase(-1);
					String[] datosOperacion = ingresarDatosOperacion();
					
						if (datosOperacion[0].length()>10 ||datosOperacion[1].length()>10) 
						{
							JOptionPane.showMessageDialog(null, "No se permiten numeros de mas de 10 digitos!","Error",JOptionPane.ERROR_MESSAGE);
						}else 
						{
							if (datosOperacion[0].charAt(0)=='-' || datosOperacion[1].charAt(0)=='-') 
							{
								JOptionPane.showMessageDialog(null, "No se permiten numeros negativos!","Error",JOptionPane.ERROR_MESSAGE);
							}else 
							{
									JOptionPane.showMessageDialog(null,sumar(
											datosOperacion[0],
											datosOperacion[1], 
											baseOperacion));
							}
						
					}
					break;
				// Resta
				case 3:
					int baseOperacionResta = menuBase(-1);
					
						String[] datosOperacionResta = ingresarDatosOperacion();
						if (datosOperacionResta[0].charAt(0)=='-' || datosOperacionResta[1].charAt(0)=='-') {
							JOptionPane.showMessageDialog(null, "No se permiten numeros negativos!","Error",JOptionPane.ERROR_MESSAGE);
						}else 
							{if (datosOperacionResta[0].length()>10 || datosOperacionResta[0].length()>10) {
								JOptionPane.showMessageDialog(null,  "No se permiten numeros de mas de 10 digitos!","Error",JOptionPane.ERROR_MESSAGE);
								}else 
								{
									JOptionPane.showMessageDialog(null,restar(
									datosOperacionResta[0],
									datosOperacionResta[1], 
									baseOperacionResta));	
							}
						}
					break;

				// Multiplicacion
				case 4:
					int baseOperacionMultiplicacion = menuBase(-1);
					String[] datosOperacionMultiplicacion = ingresarDatosOperacion();
					if (datosOperacionMultiplicacion[0].charAt(0)=='-' || datosOperacionMultiplicacion[1].charAt(0)=='-') {
						JOptionPane.showMessageDialog(null, "No se permiten numeros negativos!","Error",JOptionPane.ERROR_MESSAGE);
					}else 
					{
						JOptionPane.showMessageDialog(null,multiplicar(
								datosOperacionMultiplicacion[0],
								datosOperacionMultiplicacion[1],
								baseOperacionMultiplicacion));	
					}
					if (datosOperacionMultiplicacion[0].length()>10 || datosOperacionMultiplicacion[0].length()>10) {
						JOptionPane.showMessageDialog(null,  "No se permiten numeros de mas de 10 digitos!","Error",JOptionPane.ERROR_MESSAGE);
					}
					break;
				}

			
		} else 
		{
			JOptionPane.showMessageDialog(null, "No esta entre las opciones del Menu", "Error!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @param baseOperacion
	 * @return resultado de las sumas
	 */
	private static String sumar(String primerOperando, String segundoOperando,int baseOperacion) 
	{

		String retorno = "Resultado Suma: ";
		try {
			switch (baseOperacion) 
			{
			// Binario
			case 1:
				retorno += sumarBinarios(primerOperando, segundoOperando);
				break;
			// Octal
			case 2:
				retorno += sumarOctal(primerOperando, segundoOperando);
				break;

			// Decimal
			case 3:
				retorno += sumarDecimal(primerOperando, segundoOperando);
				break;

			// Hexadecimal
			case 4:
				retorno += sumarHexadecimal(primerOperando, segundoOperando);
				break;
			}
		} catch (Exception err) 
		{
			JOptionPane.showMessageDialog(null, "Error",
					"Has introducido carcateres invalidos!",
					JOptionPane.ERROR_MESSAGE);
		}
		if (retorno.equals("Resultado Suma: ")) {
			return null;
		}else {
			return retorno;
		}
		
	}

	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return suma de binarios
	 */
	private static String sumarBinarios(String primerOperando,String segundoOperando) 
	{
		int[] arreglo1 = convertirCadenaArreglo(primerOperando);
		int[] arreglo2 = convertirCadenaArreglo(segundoOperando);
		int mayor = arreglo1.length > arreglo2.length ? arreglo1.length: arreglo2.length;
		int[] resultado = new int[mayor + 1];
		boolean iguales = arreglo1.length == arreglo2.length;
		int loQuellevo = 0;
		String resultadofinal = "";
		for (int i = 0; i < mayor; i++) 
		{
			// Cuando los arreglos tiene el mismo tamaño.
			if (iguales) 
			{
				int suma = arreglo1[i] + arreglo2[i] + loQuellevo;
				if (suma == 2) 
				{
					loQuellevo = 1;
					resultado[i] = 0;
				} else if (suma == 3) 
				{
					loQuellevo = 1;
					resultado[i] = 1;
				} else {
					loQuellevo = 0;
					resultado[i] = suma;
				}
				if (i == mayor - 1) 
				{
					resultado[i + 1] = loQuellevo;
				}
			}
			// Cuando los arreglos NO tienen el mismo tamaño.
			else {
				int[] pequeno = arreglo1.length < arreglo2.length ? arreglo1
						: arreglo2;
				int[] grande = arreglo1.length > arreglo2.length ? arreglo1
						: arreglo2;
				int operandoPequeno = 0;
				// Cuando se puede acceder al indice del arreglo pequeño
				if (i < pequeno.length) {
					operandoPequeno = pequeno[i];
				}
				// Cuando NO se puede acceder al indice del arreglo pequeño
				else 
				{
					operandoPequeno = 0;
				}
				int suma = operandoPequeno + grande[i] + loQuellevo;
				if (suma == 2) 
				{
					loQuellevo = 1;
					resultado[i] = 0;
				} else if (suma == 3) 
				{
					loQuellevo = 1;
					resultado[i] = 1;
				} else {
					loQuellevo = 0;
					resultado[i] = suma;
				}
				if (i == mayor - 1) 
				{
					resultado[i + 1] = loQuellevo;
				}
			}
		}
		int[] reversado = new int[resultado.length];
		for (int i = 0; i < resultado.length; i++) {
			reversado[i] = resultado[resultado.length - 1 - i];
			resultadofinal += reversado[i];
		}
		return resultadofinal;
	}
	//invierte las los binarios para procesarlos*******************************************************=> 
		public static int[] convertirCadenaArreglo(String operando) {
			int[] arrreglo = new int[operando.length()];
			for (int i = 0; i < arrreglo.length; i++) {
				arrreglo[i] = Integer.parseInt(""+ operando.charAt(arrreglo.length - 1 - i));
			}
			return arrreglo;
		}

	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return suma de Octal
	 */
	private static String sumarOctal(String primerOperando,
			String segundoOperando) 
	{
		String primero =convertirOctalADecimal(primerOperando);
		String segundo= convertirOctalADecimal(primerOperando);
		String sumaDecimal = sumarDecimal(primero,segundo);
		String resultado = convertirDecimalAoctal(sumaDecimal);
		return resultado;
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return suma de Decimal
	 */
	private static String sumarDecimal(String primerOperando,String segundoOperando) {
		String resultadoCad = "";
		String sumaFinal = "";
		int[] arreglo1 = convertirCadena2Arreglo(primerOperando);
		int[] arreglo2 = convertirCadena2Arreglo(segundoOperando);
		int loQuellevo = 0;
		int[] resultado = new int[arreglo1.length];
		for (int i = 0; i < arreglo1.length; i++) {
			int suma =  arreglo1[i] + arreglo2[i]+loQuellevo;
			if (suma < 10) {
				loQuellevo = 0;
				resultado[i] = suma;
			}
			if (suma >= 10) {
				loQuellevo = 1;
				resultado[i] = suma - 10;
			}
                        else {
				loQuellevo = 0;
				resultado[i] = suma;
			}

		}
		
		for (int j = resultado.length-1; j >=0 ; j--) {
			resultadoCad += resultado[j];
		}
		int resultadoFinal = Integer.parseInt(resultadoCad);
		sumaFinal += resultadoFinal;
		return sumaFinal;
		
	}
	

	/**
	 * 
	 * @param operando
	 *  invierte y da una misma longitud a los 2 arreglos
	 * @return
	 */
	public static int[] convertirCadena2Arreglo(String operando) {
		int[] arrreglo = new int[10];
		for (int i = 0; i < arrreglo.length; i++) {
			arrreglo[i] = 0;
		}
		for (int i = operando.length() - 1; i >= 0; i--) {
			arrreglo[i] += Integer.parseInt(""
					+ operando.charAt(operando.length() - 1 - i));
		}
		return arrreglo;
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return suma de hexadecimal
	 */
	private static String sumarHexadecimal(String primerOperando,
			String segundoOperando) 
	{
		String primerOctal = convertirHexadecimalADecimal(primerOperando);
		String segundoOctal = convertirHexadecimalADecimal(segundoOperando);
		int primero = Integer.parseInt(primerOctal);
		int segundo = Integer.parseInt(segundoOctal);
		int operacion = primero + segundo;
		String resultado = "" + operacion;
		return convertirDecimalAhexadecimal(resultado);
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @param baseOperacion
	 * @return Resultado de las restas
	 */
	private static String restar(String primerOperando, String segundoOperando,
			int baseOperacion) 
	{

		String retorno = "Resultado Resta: ";

		switch (baseOperacion) 
		{
		// Binario
		case 1:
			retorno += restarBinarios(primerOperando, segundoOperando);
			break;
		// Octal
		case 2:
			retorno += restarOctal(primerOperando, segundoOperando);
			break;

		// Decimal
		case 3:
			retorno += restarDecimal(primerOperando, segundoOperando);
			break;

		// Hexadecimal
		case 4:
			retorno += restarHexadecimal(primerOperando, segundoOperando);
			break;
		}

		return retorno;
	}

	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return Resta de Binarios
	 */
	private static String restarBinarios(String primerOperando,
		String segundoOperando) {
		String primerBinario = convertirBinarioADecimal(primerOperando);
		String segundoBinario = convertirBinarioADecimal(segundoOperando);
		int primero = Integer.parseInt(primerBinario);
		int segundo = Integer.parseInt(segundoBinario);
		int operacion = primero - segundo;
		String resultado = "" + operacion;
		return convertirDecimalABinario(resultado);
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return Resta de Octal
	 */
	private static String restarOctal(String primerOperando,
			String segundoOperando) {
		String primerOctal = convertirOctalADecimal(primerOperando);
		String segundoOctal = convertirOctalADecimal(segundoOperando);
		int primero = Integer.parseInt(primerOctal);
		int segundo = Integer.parseInt(segundoOctal);
		int operacion = primero - segundo;
		String resultado = "" + operacion;
		return convertirDecimalAoctal(resultado);
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return Resta de Decimal
	 */
	private static String restarDecimal(String primerOperando,
			String segundoOperando) {
		int primero = Integer.parseInt(primerOperando);
		int segundo = Integer.parseInt(segundoOperando);
		int operacion = primero - segundo;
		String resultado = "" + operacion;
		return resultado;
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return Resta de hexadecimal
	 */
	private static String restarHexadecimal(String primerOperando,
			String segundoOperando) {
		String primerOctal = convertirHexadecimalADecimal(primerOperando);
		String segundoOctal = convertirHexadecimalADecimal(segundoOperando);
		int primero = Integer.parseInt(primerOctal);
		int segundo = Integer.parseInt(segundoOctal);
		int operacion = primero - segundo;
		String resultado = "" + operacion;
		return convertirDecimalAhexadecimal(resultado);
	}

	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @param baseOperacion
	 * @return Resultado de la Multiplicacion
	 */
	private static String multiplicar(String primerOperando,
			String segundoOperando, int baseOperacion) 
	{

		String retorno = "Resultado Multiplicacion: ";

		switch (baseOperacion) 
		{
		// Binario
		case 1:
			retorno += multiplicarBinarios(primerOperando, segundoOperando);
			break;
		// Octal
		case 2:
			retorno += multiplicarOctal(primerOperando, segundoOperando);
			break;

		// Decimal
		case 3:
			retorno += multiplicarDecimal(primerOperando, segundoOperando);
			break;

		// Hexadecimal
		case 4:
			retorno += multiplicarHexadecimal(primerOperando, segundoOperando);
			break;
		}

		return retorno;
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return Multiplicacion de Binarios
	 */
	private static String multiplicarBinarios(String primerOperando,
			String segundoOperando) 
	{
		String primerBinario = convertirBinarioADecimal(primerOperando);
		String segundoBinario = convertirBinarioADecimal(segundoOperando);
		int primero = Integer.parseInt(primerBinario);
		int segundo = Integer.parseInt(segundoBinario);
		int operacion = primero * segundo;
		String resultado = "" + operacion;
		return convertirDecimalABinario(resultado);
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return Multiplicacion de Octal
	 */
	private static String multiplicarOctal(String primerOperando,
			String segundoOperando) 
	{
		String primerOctal = convertirOctalADecimal(primerOperando);
		String segundoOctal = convertirOctalADecimal(segundoOperando);
		int primero = Integer.parseInt(primerOctal);
		int segundo = Integer.parseInt(segundoOctal);
		int operacion = primero * segundo;
		String resultado = "" + operacion;
		return convertirDecimalAoctal(resultado);
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return Multiplicacion de Decimal
	 */
	private static String multiplicarDecimal(String primerOperando,
			String segundoOperando) 
	{
		int primero = Integer.parseInt(primerOperando);
		int segundo = Integer.parseInt(segundoOperando);
		int operacion = primero * segundo;
		String resultado = "" + operacion;
		return resultado;
	}
	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @return Multiplicacion de hexadecimal
	 */
	private static String multiplicarHexadecimal(String primerOperando,
			String segundoOperando) 
	{
		String primerOctal = convertirHexadecimalADecimal(primerOperando);
		String segundoOctal = convertirHexadecimalADecimal(segundoOperando);
		int primero = Integer.parseInt(primerOctal);
		int segundo = Integer.parseInt(segundoOctal);
		int operacion = primero * segundo;
		String resultado = "" + operacion;
		return convertirDecimalAhexadecimal(resultado);
	}
	/**
	 * Toma los datos Suma Resta Multiplicacion a operar
	 * @return Primer y Segundo Dato
	 */
	public static String[] ingresarDatosOperacion() 
	{
		String primerDato = JOptionPane.showInputDialog("Primera Base:");
		String segundoDato = JOptionPane.showInputDialog("Segunda Base:");
		return new String[] { primerDato, segundoDato };
	}

	/**
	 * 
	 * @param primerOperando
	 * @param segundoOperando
	 * @param baseOperacion
	 * @return
	 */
	public static String convertirNumeroBase(int baseOrigen, int baseDestino,
			String numeroIngresado) 
	{

		String retorno = "Resultado: ";

		switch (baseOrigen) 
		{
		// Binario
		case 1:

			switch (baseDestino) 
			{
			// Octal
			case 2:
					retorno += convertirBinarioAOctal(numeroIngresado);
				break;

			// Decimal
			case 3:
				retorno += convertirBinarioADecimal(numeroIngresado);
				break;

			// Hexadecimal
			case 4:
				retorno += convertirBinarioAHexadecimal(numeroIngresado);
				break;
			}

			break;

		//BASE Octal
		case 2:
			switch (baseDestino) 
			{
			// Binario
			case 2:
				retorno += convertirOctalABinario(numeroIngresado);
				break;

			// Decimal
			case 3:
				retorno += convertirOctalADecimal(numeroIngresado);
				break;

			// Hexadecimal
			case 4:
				retorno += convertirOctalAhexdecimal(numeroIngresado);
				break;
			}
			break;

		//BASE Decimal
		case 3:
			switch (baseDestino) 
			{
			// Binario
			case 2:
				retorno += convertirDecimalABinario(numeroIngresado);
				break;
			// octal
			case 3:
				retorno += convertirDecimalAoctal(numeroIngresado);
				break;

			// hexadecimal
			case 4:
				retorno += convertirDecimalAhexadecimal(numeroIngresado);
				break;
			}
			break;

		//BASE Hexadecimal
		case 4:
			switch (baseDestino) 
			{
			// Binario
			case 2:
				retorno += convertirHexadecimalABinario(numeroIngresado);
				break;
			// octal
			case 3:
				retorno += convertirHexadecimalAOctal(numeroIngresado);
				break;

			// decimal
			case 4:
				retorno += convertirHexadecimalADecimal(numeroIngresado);
				break;
			}
			break;
		}

		System.out.println("baseOrigen " + baseOrigen 
						+ " baseDestino "+ baseDestino 
						+ " numeroIngresado " + numeroIngresado);
		return retorno;
	}
	/**
	 * Pasa un numero de Binario A Octal.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirBinarioAOctal(String base) 
	{
		String a = convertirBinarioADecimal(base);
		String octal = convertirDecimalAoctal(a);
		return octal;

	}
	/**
	 * Pasa un numero de Binario A Decimal.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirBinarioADecimal(String base) 

	{

		String cadenaInver = "";
		int b = 0;
		int c = 0;
		String resulString = "";
		for (int i = base.length() - 1; i >= 0; i--) 
		{
			cadenaInver += "" + base.charAt(i);
		}
		double[] arreglo;
		for (int i = 0; i <= cadenaInver.length(); i++) 
		{
			arreglo = new double[99];
			arreglo[i] = (Math.pow(2, i));

			for (int m = 0; m < cadenaInver.length(); m++) 
			{
				String convertir = "" + cadenaInver.charAt(m);
				b = Integer.parseInt(convertir);
				c += b * arreglo[m];
			}
		}
		resulString += c;
		return resulString;
	}
	/**
	 * Pasa un numero de Binario A hexadecimal.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirBinarioAHexadecimal(String base) 
	{
		String a = convertirBinarioADecimal(base);
		String hexadecimal = convertirDecimalAhexadecimal(a);
		return hexadecimal;

	}
	
	/**
	 * Pasa un numero de Octal A Binario.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirOctalABinario(String base) 
	{
		String a = convertirOctalADecimal(base);
		String bianrio = convertirDecimalABinario(a);
		return bianrio;
	}
	/**
	 * Pasa un numero de Octal A Decimal.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirOctalADecimal(String base) 
	{
		String cadenaInver = "";
		int b = 0;
		int c = 0;
		String decimal="";
		for (int i = base.length()-1; i >= 0; i--) {
			cadenaInver += ""+base.charAt(i);
		}

		for (int i = 0; i < cadenaInver.length(); i++) {
				String convertir = "" + cadenaInver.charAt(i);
				b = Integer.parseInt(convertir);
				c += (b * Math.pow(8, i));
		}
		decimal +=c;
		return decimal;
	}
	/**
	 * Pasa un numero de Octal A hexadecimal.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirOctalAhexdecimal(String base) 
	{
		String a = convertirOctalADecimal(base);
		String hexadecimal = convertirDecimalAhexadecimal(a);
		return hexadecimal;

	}
	/**
	 * 
	 * Pasa un numero de decimal a Binario.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirDecimalABinario(String base) 
	{
		int decimal = Integer.parseInt(base);
		String binario = "";
		while (decimal > 0) 
		{
			binario = decimal % 2 + binario;
			decimal /= 2;
		}
		return binario;
	}
	/**
	 * 
	 * Pasa un numero de decimal a Octal.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirDecimalAoctal(String base) 
	{
		int inicio = Integer.parseInt(base);
		String acumulador = "";
		if (inicio <= 8) 
		{
			acumulador += inicio;
		} else {
			int div1 = inicio / 8;
			int div2 = div1 / 8;
			int div3 = div2 / 8;
			int div4 = div3 / 8;
			int div5 = div4 / 8;
			int div6 = div5 / 8;
			int div7 = div6 / 8;
			int div8 = div7 / 8;
			int div9 = div8 / 8;
			int[] arreglo = new int[10];
			arreglo[0] = inicio % 8;
			arreglo[1] = div1 % 8;
			arreglo[2] = div2 % 8;
			arreglo[3] = div3 % 8;
			arreglo[4] = div4 % 8;
			arreglo[5] = div5 % 8;
			arreglo[6] = div6 % 8;
			arreglo[7] = div7 % 8;
			arreglo[8] = div8 % 8;
			arreglo[9] = div9 % 8;
			for (int i = arreglo.length - 1; i >= 0; i--) 
			{
				if (arreglo[i] != 0) 
				{
					acumulador += arreglo[i];
				}
			}

		}
		return acumulador;
	}
	/**
	 * Pasa un numero de decimal a hexadecimal.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 * 
	 */
	public static String convertirDecimalAhexadecimal(String bas) 
	{
		int decimal = Integer.parseInt(bas);
		String digits = "0123456789ABCDEF";
		if (decimal == 0)
			return "0";
		String hexde = "";
		while (decimal > 0) {
			int mod = decimal % 16; // Dígito de la derecha
			hexde = digits.charAt(mod) + hexde; // Concatenación de cadenas
			decimal = decimal / 16;
		}
		return hexde;
	}
	/**
	 * Pasa un numero de Hexadecimal A Binario
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirHexadecimalABinario(String base) 
	{
		String a = convertirHexadecimalADecimal(base);
		String binario = convertirDecimalABinario(a);
		return binario;

	}
	/**
	 * Pasa un numero de Hexadecimal A Octal
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirHexadecimalAOctal(String base) 
	{
		String a = convertirHexadecimalADecimal(base);
		String octal = convertirDecimalAoctal(a);
		return octal;

	}
	/**
	 * 
	 * Pasa un numero de hexadecimal A Decimal.
	 * 
	 * @param numeroIngresado
	 *            Numero a convertir
	 */
	public static String convertirHexadecimalADecimal(String base) 
	{
		String digitos = "0123456789ABCDEF";
		String decimal = "";
		base = base.toUpperCase();
		int decimalInt = 0;
		for (int i = 0; i < base.length(); i++) 
		{
			char c = base.charAt(i);
			int d = digitos.indexOf(c);
			decimalInt = 16 * decimalInt + d;
		}
		decimal += decimalInt;
		return decimal;
	}

	
}