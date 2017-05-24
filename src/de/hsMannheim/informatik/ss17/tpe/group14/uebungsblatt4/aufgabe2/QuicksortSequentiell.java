package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe2;

public class QuicksortSequentiell implements SortAlgorithm {

	private Comparable [] array;
	private int size;
	private int recursionsCounter = 0;
	private int swapCounter = 0;
	private int comparisonCounter = 0;
	private double startTime = 0;
	private double endTime = 0;

	public QuicksortSequentiell() {
		super();
	}

	public void sort(Comparable[] array) {
		startTime = System.currentTimeMillis();
		// the array do not exist
		if (array == null || array.length == 0) {
			return;
		}
		// the field array initialize with the parameter array
		this.array = array;
		this.size = array.length;
		// start the quicksort with initialize low border and high border
		quickSort(0, size - 1);
	}

	/**
	 * Implements the quicksort
	 * 
	 * @param lowerIndex
	 *            left startindex
	 * @param higherIndex
	 *            right endindex
	 */
	private void quickSort(int lowerIndex, int higherIndex) {
		// pointer from left and pointer from right
		int l = lowerIndex;
		int r = higherIndex;
		// calculate pivot number
		Comparable pivot = this.array[(higherIndex + lowerIndex) / 2];
		// Divide into two arrays
		while (l <= r) {
			// find from left side of the pivot an element that is bigger than
			// the pivot
			while (this.array[l].compareTo(pivot) < 0) {
				comparisonCounter++;
				l++;
			}
			// find from the right side of the pivot an element that is smaller
			// than the pivot
			while (this.array[r].compareTo(pivot) > 0) {
				comparisonCounter++;
				r--;
			}
			// if l bigger r the array is sorted
			if (l <= r) {
				change(l, r);
				swapCounter++;
				// move index to next position on both sides
				l++;
				r--;
			}
		}
		// recursion
		if (lowerIndex < r){
			recursionsCounter++;
			quickSort(lowerIndex, r);
		}
		if (l < higherIndex){
			recursionsCounter++;
			quickSort(l, higherIndex);
		}
			
		
	}

	/**
	 * Change the elements in an array on two indexes
	 * 
	 * @param l
	 *            first index to change
	 * @param r
	 *            second index to change
	 */
	private void change(int l, int r) {
		Comparable temp = this.array[l];
		this.array[l] = this.array[r];
		this.array[r] = temp;
		printArray(array);
	}
	
	/**
	 * print an Array
	 * @param input
	 */
	private void printArray(Comparable[] input){
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i].toString() + ", ");
		}
		System.out.println();
	}
	
	/**
	 * print all stats of the Quicksort
	 */
	public void printStats(){
		endTime = System.currentTimeMillis();
		System.out.println("Recoursionsteps: " + recursionsCounter);
		System.out.println("Swaps: " + swapCounter);
		System.out.println("Comparison: " + comparisonCounter);
		System.out.println("Time: " + (endTime - startTime)/1000 + "s");
	}

	public static void main(String a[]) {

		QuicksortSequentiell sorter = new QuicksortSequentiell();
		Integer[] input = new Integer [50];
		for (int i = 0; i < input.length; i++){
			input[i] = (Integer)(int) (Math.random() * 100)+1;
		}
		sorter.sort(input);
		sorter.printStats();
	}
}
