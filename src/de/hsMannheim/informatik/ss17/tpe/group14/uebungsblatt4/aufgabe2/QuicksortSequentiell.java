package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe2;

public class QuicksortSequentiell implements SortAlgorithm {

	private Comparable [] array;
	private int size;

	public QuicksortSequentiell() {
		this.size = 0;
	}

	public void sort(Comparable[] array) {
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
				l++;
			}
			// find from the right side of the pivot an element that is smaller
			// than the pivot
			while (this.array[r].compareTo(pivot) > 0) {
				r--;
			}
			// if l bigger r the array is sorted
			if (l <= r) {
				change(l, r);
				// move index to next position on both sides
				l++;
				r--;
			}
		}
		// recursion
		if (lowerIndex < r)
			quickSort(lowerIndex, r);
		if (l < higherIndex)
			quickSort(l, higherIndex);
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
	}

	public static void main(String a[]) {

		QuicksortSequentiell sorter = new QuicksortSequentiell();
		Integer[] input = { 7, 1, 3, 0, 7, 34, 0, 10, 19, 1 };
		sorter.sort(input);
		for (int i : input) {
			System.out.print(i);
			System.out.print(", ");
		}
	}
}
