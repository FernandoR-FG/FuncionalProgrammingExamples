package com.javacourse.funcionalprogramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

//Voy a crear una implementacion 
class EvenNumberPredicate implements Predicate<Integer>{

	@Override
	public boolean test(Integer number) {
		// TODO Auto-generated method stub
		return number%2==0;
	}
	
}

//Implemento Consumer para for each
class SystemOutConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer number) {
		// TODO Auto-generated method stub
		System.out.println(number);
	}
	
}

//Implemente la clase map y le de una implementaciopn a la Funcional Interface

class NumberSquareMapper implements Function<Integer, Integer>{

	@Override
	public Integer apply(Integer number) {
		// TODO Auto-generated method stub
		return number*number;
	}
	
}

public class LambdaExplicationRunner {

	
	
	public static void main(String[] args) {
		//Vamos a ver que pasa por detras de estas operaciones
		/* Filter
		 *  Stream<T> filter(Predicate<? super T> predicate);
		 *  boolean test(T t);
		 * */
		
		List.of(23,52,45,12).stream()
		.filter(n -> n%2==0)
		.forEach(e -> System.out.println(e));
		System.out.println("\n");
		//Probando el filtro enviando un objeto como filtro
		List.of(23,52,45,12,2,4,8).stream()
		.filter(new EvenNumberPredicate() )
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println("\n");
		/*
		 * Dentro del foreach
		 * .forEach(e -> System.out.print(e + " ")
		 * forEach(Consumer<? super T> action);
		 * Consumer<? super T>
		 *  void accept(T t);
		 * */
	
		List.of(230,520,450,120).stream()
		.filter(n -> n%2==0)
		.forEach(new SystemOutConsumer());
		System.out.println("\n");
		//Probando el filtro enviando un objeto como filtro
		List.of(23,52,45,12,2,4,8).stream()
		.filter(new EvenNumberPredicate() )
		.forEach(e -> System.out.print(e + " "));
		
		System.out.println("\n");

		/*
		 * Dentro del metodo Map
		 * acepta una funcion
		 * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
		 *  R apply(T t);
		 *  
		 * */
		
		List.of(230,520,450,120).stream()
		.filter(n -> n%2==0)
		.map(n->n*n)
		.forEach(new SystemOutConsumer());
		System.out.println("\n");
		
		

		List.of(230,520,450,120).stream()
		.filter(n -> n%2==0)
		.map(new NumberSquareMapper())
		.forEach(new SystemOutConsumer());
		System.out.println("\n");
	}

}
