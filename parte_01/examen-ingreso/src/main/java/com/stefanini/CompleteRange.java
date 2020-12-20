package com.stefanini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompleteRange {

	public Collection<Integer> build(Collection<Integer> numberParameters) throws Exception {

		if (null == numberParameters) {
			throw new Exception("La coleccion ingresada es nula");
		}

		Optional<Integer> existNegativeOp = numberParameters.stream().filter(x -> x <= 0).findAny();
		if (existNegativeOp.isPresent()) {
			throw new Exception("La coleccion contiene algun numero negativo");
		}

		// Obteniendo el MAX valor
		int maxNumber = numberParameters.stream().mapToInt(Integer::new).max().getAsInt();
		System.out.println("Max. numero: " + maxNumber);

		// Generando numeros a comparar hasta el MAX valor
		List<Integer> listAComparar = generarNumerosHastaRango(maxNumber);

		List<Integer> numberParameterFaltantes = listAComparar.stream()
				.filter(x -> numberParameters.stream().allMatch(y -> !y.equals(x))).collect(Collectors.toList());

		System.out.println("\nNumeros faltantes:");
		numberParameterFaltantes.forEach(x -> System.out.println(" -> " + x));

		// Agregando numeros faltantes
		List<Integer> completeList = new ArrayList<Integer>();
		completeList.addAll(numberParameters);
		completeList.addAll(numberParameterFaltantes);

		return completeList.stream().sorted().collect(Collectors.toList());
	}

	private List<Integer> generarNumerosHastaRango(int maxNumber) {
		List<Integer> listCompare = new ArrayList<>();

		for (int i = 1; i <= maxNumber; i++) {
			listCompare.add(i);
		}

		return listCompare;
	}

	public static void main(String... args) {
		// Input
		Collection<Integer> numberParameters = Arrays.asList(5, 3, 2, 6);

		try {
			CompleteRange completeRange = new CompleteRange();
			Collection<Integer> outNumberParameters = completeRange.build(numberParameters);

			System.out.println("\nParametros completos:");
			outNumberParameters.forEach(x -> System.out.println(" -> " + x));
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

}
