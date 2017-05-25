package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe2;

public class Menu {
	
	static private QuicksortSequentiell qsS = new QuicksortSequentiell();
	static private QuicksortParallel qsP = new QuicksortParallel();
	
	static public Integer[] initializeArray(Integer[] array){
		for (int i = 0; i < array.length; i++){
			array[i] = (Integer)(int) (Math.random() * 100)+0;
		}
		return array;
	}
	
	static public void runQuicksorts(){
		Integer[] arrayS = new Integer[101];
		arrayS = initializeArray(arrayS);
		Integer[] arrayP = arrayS.clone();
		qsS.sort(arrayS);
		System.out.println("Quicksort Sequentiell");
		qsS.printStats();
		System.out.println();
		qsP.sort(arrayP);
		System.out.println("Quicksort Parallel");
		qsP.printStats();
	}
	
	public static void main(String a[]) {
		runQuicksorts();
	}

}
