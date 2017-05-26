package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe2;

public class QuicksortParallel extends Thread implements SortAlgorithm {

	final int MAX_THREADS = Runtime.getRuntime().availableProcessors();
	static int numThreads = 1;
	private Comparable[] array;
	private int start = 0;
	private int end = 0;
	static private int recursionsCounter = 0;
	static private int swapCounter = 0;
	static private int comparisonCounter = 0;
	private double startTime = 0;
	private double endTime = 0;
	static private int printCounter = 0;

	public QuicksortParallel() {
	}

	QuicksortParallel(int lowerIndex, int higherIndex, Comparable array[]) {
		this.start = lowerIndex;
		this.end = higherIndex;
		this.array = array;
	}

	@Override
	public void sort(Comparable[] array) {
		startTime = System.currentTimeMillis();
		// the array do not exist
		if (array == null || array.length == 0) {
			return;
		}
		// the field array initialize with the parameter array
		// start the quicksort with initialize low border and high border
		quickSort(0, array.length - 1, array);
	}

	@Override
	public void run() {
		quickSort(this.start, this.end, this.array);
	}

	private void quickSort(int lowerIndex, int higherIndex, Comparable[] array) {
		this.array = array;
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
		// if there are more Threads possible create new one
		if (numThreads < MAX_THREADS) {
			numThreads++;
			// split the quicksort in new threads, they are only work in their
			// part of the array
			if (lowerIndex < r) {
				recursionsCounter++;
				QuicksortParallel threadLeft = new QuicksortParallel(lowerIndex, r, this.array);
				threadLeft.start();
				try {
					threadLeft.join();				
				} catch (InterruptedException ex) {
					throw new IllegalStateException("Parallel quicksort threw an InterruptedException.");
				}
			}
			if (l < higherIndex) {
				recursionsCounter++;
				QuicksortParallel threadRight = new QuicksortParallel(l, higherIndex, this.array);
				threadRight.start();
				try {
					threadRight.join();
				} catch (InterruptedException ex) {
					throw new IllegalStateException("Parallel quicksort threw an InterruptedException.");
				}
			}

			// if no more threads are possible the current thread works further
			// it is not necessary to create an new one
		} else {
			// recursion
			if (lowerIndex < r) {
				recursionsCounter++;
				quickSort(lowerIndex, r, this.array);
			}
			if (l < higherIndex) {
				recursionsCounter++;
				quickSort(l, higherIndex, this.array);
			}
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
		Comparable temp = array[l];
		array[l] = array[r];
		array[r] = temp;
		printCounter++;
		System.out.print(printCounter + ": ");
		printArray(array);	
	}

	/**
	 * print an array
	 * 
	 * @param input
	 */
	private synchronized void printArray(Comparable[] input) {
		String s = toString();
		System.out.println(s);
	}

	/**
	 * print all stats of the Quicksort
	 */
	public void printStats() {
		endTime = System.currentTimeMillis();
		System.out.println("Recoursionsteps: " + recursionsCounter);
		System.out.println("Swaps: " + swapCounter);
		System.out.println("Comparison: " + comparisonCounter);
		System.out.println("Threads: " + numThreads);
		System.out.println("Time: " + (endTime - startTime) / 1000 + "s");
	}
	

	@Override
	public String toString(){
		String s = ""; 
		for (int i = 0; i < array.length; i++) {
			s += array[i].toString() + ", ";
		}
		return s;
	}
}
