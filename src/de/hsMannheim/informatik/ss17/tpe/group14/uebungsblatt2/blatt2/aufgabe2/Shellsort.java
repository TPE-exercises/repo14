package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe2;

public class Shellsort implements Sort {
	private static final int[] H_VALUES = { 9, 7, 4, 1 };

	@Override
	public void sort(Comparable[] array) {

		for (int h : H_VALUES) {
			for (int i = h; i < array.length; ++i) {
				int j = i;
				Comparable currentObject = array[i];

				// find for the current object the right place on the already
				// sorted steps on the left
				while ((j - h) >= 0 && array[j - h].compareTo(currentObject) > 0) {
					// move all bigger objects one step to the right
					array[j] = array[j - h];
					j -= h;
				}
				// save the current value to the right position
				array[j] = currentObject;
			}
		}
	}
}
