package com.tektree.simple.generators;

public class Fibonacci {

	public static void printSeries(Integer max) {
		Integer previous = 0;
		Integer current = 1;
		Integer result = current;
		System.out.println("Fibonacci series up to " + max);
		System.out.print(previous + "   ");
		System.out.print(current + "   ");
		do {
			previous = current;
			current = result;
			System.out.print(result + "   ");
			result = current + previous;
		} while (result <= max);
	}

	public static void printSeriesRecursively(Integer max) {
		System.out.println("Fibonacci series up to " + max);
		Integer index = 0;
		Integer fibonacci = 0;
		do {
			fibonacci = calculateFibonacci(index++);
			System.out.print(fibonacci + "   ");
		} while (fibonacci < max);
	}

	private static Integer calculateFibonacci(Integer index) {
		if(index < 0) {
			throw new RuntimeException("sjkdfgks");
		}
		if(index == 0 || index == 1){
			return index;
		}
		return calculateFibonacci(index - 1) + calculateFibonacci(index-2);
	}

}
