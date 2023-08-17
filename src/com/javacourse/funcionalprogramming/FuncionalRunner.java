package com.javacourse.funcionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FuncionalRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = List.of("Apple", "Banana", "Cat");
		
		printBasicFilteringFP(list);
		
		
		
		// void forEach(Consumer<? super T> action);
		//Consumer<? super T> action
		//void accept(T t);
		/*
		 * forEach( //despues se aplica el forEach
						element -> System.out.println(element)
						);
		 * 
		 * */
		

		//  Filtrado de números pares usando una expresión lambda
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> pares = numeros.stream()
		                             .filter(num -> num % 2 == 0)
		                             .collect(Collectors.toList()); // pares contendrá [2, 4, 6]

		// Aplicar una operación a todos los elementos de una lista usando map
		List<Integer> numeros1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> cuadrados = numeros1.stream()
		                                 .map(num -> num * num)
		                                 .collect(Collectors.toList()); // cuadrados contendrá [1, 4, 9, 16, 25]

		// Filtrar elementos de una lista usando filter
		List<Integer> numeros11 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> pares = numeros11.stream()
		                             .filter(num -> num % 2 == 0)
		                             .collect(Collectors.toList()); // pares contendrá [2, 4, 6]

		// Reducción de una lista a un único valor usando reduce
		List<Integer> numeros111 = Arrays.asList(1, 2, 3, 4, 5);
		int suma = numeros111.stream()
		                 .reduce(0, (acc, num) -> acc + num); // suma será 15

		
		
		
	}

	//Metodo normal
	private static void printBasic(List<String> list) {
		for(String string:list) {
			System.out.println(string);
		}
	}
	private static void printBasicFiltering(List<String> list) {
		for(String string:list) {
			if(string.endsWith("at")) {
				System.out.println(string);
			}
		}
	}
	
	//Lamda expresion ->
	//Esto es funcional programming
	private static void printBasicFP(List<String> list) {
		list.stream().forEach(element -> System.out.println(element));
	}
	private static void printBasicFilteringFP(List<String> list) {
		list.stream().filter( //Primero se crea el filtro
				element -> element.endsWith("at") //element -> logic
				).forEach( //despues se aplica el forEach
						element -> System.out.println(element)
						);
	}
	
	List<Integer> numeros = List.of(6,5,8,7,4,1,5);
	
	
	//Esto es programacion funcional:
	//Funcional busca no mutar el valor de la variable dice que y no colo lo hace
				//utilizo stream - reduce hasta 0, (cada par de numeros) -> expresionacumplir
	int sum = sumFP();
	
	private Integer sumFP() {
		return numeros.stream().reduce(0, (number1, number2)->number1+number2);
	}
	//Con filtro
	int sumF = extracted();

	private Integer extracted() {
		return numeros.stream().filter(number -> number%2==1).reduce(0, (number1, number2)->number1+number2);
	}
	
	//Una lambda expresion es una forma recortada de hacer un metodo
	/*
	 * (number1, number2)-> {  se puede poner o no las llaves 
	 * 	return	number1+number2);	se debe porner obligad el return si tiene llaves
	 * }
	 * 
	 * */

	
	//Hay otros metodos para manejar la programaion funcional
	/* .sorted
	 * .distinct
	 * .map(e -> e*e) Mapeo cada elemento con su cuadrado
	 * */
	
	//Algunos ejercicios
	//IntStream.,11).map(e -> e*e).forEach(p -> System.out.println(p));
	// Ejemplo 1: Suma de dos números usando una expresión lambda
	
	
}
