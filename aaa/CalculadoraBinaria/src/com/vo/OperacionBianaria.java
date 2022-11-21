package com.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperacionBianaria {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
                    String res = OpBinaria.Multiplicacion("1011", "011"); 
                    System.out.println("basico:"+res);

			String resultado = dividirBinarios("1011", "011");
			resultado = resultado.trim().replace(".", ",");
			Double resultadoDouble;

			System.out.println(resultado);

			if (resultado.contains(",")) {

				String[] resultadoS = resultado.split(",");

				resultadoDouble = Double.valueOf(Integer.parseInt(
						resultadoS[0], 2));
				resultadoDouble += obtenerDecimales(resultadoS[1]);

			} else {
				resultadoDouble = Double.valueOf(Integer.parseInt(resultado, 2)
						+ "");
			}

			System.out.println(resultadoDouble);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String dividirBinarios(String divisorBin, String dividendoBin)
			throws Exception {

		validarBinario(divisorBin);
		validarBinario(dividendoBin);

		Double divisorDouble;
		Double dividendoDouble;

		divisorBin = divisorBin.trim().replace(".", ",");
		dividendoBin = dividendoBin.trim().replace(".", ",");

		if (divisorBin.contains(",")) {

			String[] divisorBinS = divisorBin.split(",");

			divisorDouble = Double.valueOf(Integer.parseInt(divisorBinS[0], 2));
			divisorDouble += obtenerDecimales(divisorBinS[1]);

		} else {
			divisorDouble = Double
					.valueOf(Integer.parseInt(divisorBin, 2) + "");
		}

		if (dividendoBin.contains(",")) {

			String[] dividendoBinS = dividendoBin.split(",");

			dividendoDouble = Double.valueOf(Integer.parseInt(dividendoBinS[0],
					2));
			dividendoDouble += obtenerDecimales(dividendoBinS[1]);

		} else {
			dividendoDouble = Double.valueOf(Integer.parseInt(dividendoBin, 2)
					+ "");
		}

		System.out.println("Dividiendo " + divisorDouble + " entre "
				+ dividendoDouble);
		if (dividendoDouble == 0) {
			throw new Exception(
					"El dividendo de la operacion no puede ser igual a cero.");
		}

		Double resultadoDouble = (double) (divisorDouble * dividendoDouble);

		System.out.println("Resultado: " + resultadoDouble);

		int resultadoInt = (int) resultadoDouble.longValue();

		String resultado = Integer.toBinaryString(resultadoInt);

		String decimalesBin = obtenerDecimales(resultadoDouble - resultadoInt);
		if (decimalesBin.contains("1")) {

			resultado += "." + decimalesBin;
		}

		return resultado;
	}

	public static Double obtenerDecimales(String decimalString) {

		Double resultado = new Double(0);
		char[] decimalChar = decimalString.toCharArray();

		for (int i = 0; i < decimalChar.length; i++) {

			int bitDecimal = Integer.parseInt(decimalChar[i] + "");
			resultado += bitDecimal
					* (1 / (Math.pow(2.0, Double.valueOf((i + 1) + ""))));
		}

		return resultado;
	}

	public static String obtenerDecimales(Double decimalDouble) {

		String resultado = "";

		Double valorTemp = decimalDouble;
		for (int i = 0; i < 1; i++) {
			valorTemp = valorTemp * 2;
			resultado += valorTemp.longValue();
			if (valorTemp > 1) {
				valorTemp -= 1;
			}
		}

		return resultado;
	}

	public static void validarBinario(String numeroBin) throws Exception {
		int contar = 0;
		int start = 0;
		while ((start = numeroBin.indexOf(".", start) + 1) > 0) {
			contar++;
		}

		if (contar > 1) {

			throw new Exception("Ha digitado un numero en formato no binario");
		}
		contar = 0;
		start = 0;
		while ((start = numeroBin.indexOf(",", start) + 1) > 0) {
			contar++;
		}

		if (contar > 1) {

			throw new Exception("Ha digitado un numero en formato no binario");
		}

		Pattern pat;
		pat = Pattern.compile("[^10,.]");

		final Matcher matcher = pat.matcher(numeroBin);
		if (matcher.find()) {
			throw new Exception("Ha digitado un numero en formato no binario");
		}
	}
}
