package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe2;

public class InserationSort implements Sort {

	@Override
	public void sort(Comparable[] array) {
		
		for (int i = 1; i < array.length; ++i) {
			int j = i;
			Comparable currentObject = array[i];

			// Find for the current object the right place on the already sorted
			// row on the left
			while (j > 0 && array[j - 1].compareTo(currentObject) > 0) {
				// Move all bigger objects one to the right
				array[j] = array[j - 1];
				j--;
			}

			// Save the current object to the right position
			array[j] = currentObject;
		}
	}
}
