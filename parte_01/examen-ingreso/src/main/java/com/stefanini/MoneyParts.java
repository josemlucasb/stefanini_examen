package com.stefanini;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class MoneyParts {

	public static final double[] DENOMINACIONES_MONEY = { 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100, 200 };

	public List<Double[]> build(String moneyString) throws Exception {

		if (StringUtils.isBlank(moneyString)) {
			throw new Exception("La moneda ingresada es nula.");
		}

		try {
			Double.parseDouble(moneyString);
		} catch (Exception e) {
			throw new Exception("El valor ingresado no corresponde a una Moneda");
		}

		Double money = Double.parseDouble(moneyString);

//		= (int) Math.pow(2, DENOMINACIONES_MONEY.length) - 1;
//		System.out.println("->" + x);
		
		
		
//		Double x = money % 0.05;
//		if (x == 0d) {
//			System.out.println("-->ok");
//		} else {
//			System.out.println("--error");
//		}
//		Math.fl
//		
//		System.out.println("-->" + x);
		
		
		
		
		return null;
	}
	
	public static void main(String[] args) {
		String moneyString = "0.3";
		
		try {
			MoneyParts moneyParts = new MoneyParts();
			List<Double[]> moneyOptions = moneyParts.build(moneyString);
			
			if (null != moneyOptions && !moneyOptions.isEmpty()) {
				moneyOptions.forEach(moneyOption -> {
					System.out.println("Combinacion Posible:");
					
					List<Double> moneys = Arrays.asList(moneyOption);
					moneys.forEach(money -> System.out.println(" -> " + money));
				});				
			}
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

}
