package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe2;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Menu {
	
	static private QuicksortSequentiell qsS = new QuicksortSequentiell();
	static private QuicksortParallel qsP = new QuicksortParallel();
	
	/**
	 * initalize an array of Integer with random Integer 
	 * @param array to initalize
	 * @return
	 */
	static public Integer[] initializeArray(Integer[] array){
		if(array != null || array.length <= 0){
			for (int i = 0; i < array.length; i++){
				array[i] = (Integer)(int) (Math.random() * 100)+0;
			}
			return array;
		} else 
			return array;
		
	}
	
	/**
	 * print an array
	 * @param input
	 */
	static public void printArray(Comparable[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i].toString() + ", ");
		}
		System.out.println();
	}
	
	/**
	 * run both kind of quickssorts 
	 */
	static public void runQuicksorts(){
//		Integer[] arrayS = new Integer[50];
//		Integer[] arrayS ={};
		Integer[] arrayS = null;
		arrayS = initializeArray(arrayS);
		Integer[] arrayP = arrayS.clone();
		System.out.println("Quicksort Sequentiell");
		System.out.print("unsorted: ");
		printArray(arrayS);
		qsS.sort(arrayS);
		System.out.print("sorted: ");
		printArray(arrayS);
		qsS.printStats();
		System.out.println();
		System.out.println("Press Enter to continue");
		InputStreamReader reader = new InputStreamReader(System.in);
		try {
			reader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Quicksort Parallel");
		System.out.print("unsorted: ");
		printArray(arrayP);
		qsP.sort(arrayP);	
		System.out.print("sorted: ");
		printArray(arrayP);
		qsP.printStats();
	}
	
	public static void main(String a[]) {
		runQuicksorts();
	}

}
