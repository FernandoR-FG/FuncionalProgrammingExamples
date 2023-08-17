package com.javacourse.funcionalprogramming;

import java.util.List;
import java.util.function.Predicate;

public class MethodReferencesRunner {
	
	//Guardar funciones en variables 
	//Como vemos aqui se hizp una variable donde almacena una funcion
	/*Predicate<? super Integer> evenPredicate = createEvenPredicate();
	private Predicate<? super Integer> createEvenPredicate() {
		return n -> n%2==0;
	}*/
	
			//Predicate<? super Integer> evenPredicate = n -> n%2==1;
	
	//Se puede pasar por referencia intancias y metodos staticos
	public static void print(Integer number) {
		System.out.print(number + " ");
	}

	public static void main(String[] args) {

		
		List.of("ANT","Fish","Dog").stream()
			.map(s->s.length())
			.forEach(s->System.out.println(s));
		
		//La impresion
		List.of("ANT","Fish","Dog").stream()
		.map(s->s.length())
		.forEach(MethodReferencesRunner::print); //Shortcut del anterior
		
		
		//Metodos por referencia 
		
		Integer max = List.of(23, 45, 67,34).stream()
				//.filter(evenPredicate)
			.filter(MethodReferencesRunner::isEven)
			.max(Integer::compare)//(n1, n2) -> Integer.compare(n1,n2))
			.orElse(0);
		System.out.println("\nMax: "+max);
				
	}
	public static boolean isEven(Integer number) {
		return number%2==0;
	}

}
