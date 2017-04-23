package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe2;

import static gdi.MakeItSimple.*;

public class SortArray {

	private static InserationSort inserationSort = new InserationSort();
	private static Shellsort shellSort = new Shellsort();

	public static void main(String[] args) {
	}

	private static void sortArray(Sort sortAlgorithm, Comparable[] array) {

		printArray(array);
		sortAlgorithm.sort(array);
		printArray(array);
	}

	private static void printArray(Comparable[] array) {

		for (int i = 0; i < array.length; ++i) {
			if (i + 1 == array.length) {
				print(array[i] + ".");
			} else {
				print(array[i] + ", ");
			}
		}
		println();
	}

	private static MyInt[] toMyIntArray(int[] array) {

		MyInt[] myInt = new MyInt[array.length];

		for (int i = 0; i < array.length; ++i) {
			myInt[i] = new MyInt(array[i]);
		}

		return myInt;
	}

	private static MyString[] toMyString(String[] array) {

		MyString[] myString = new MyString[array.length];

		for (int i = 0; i < array.length; ++i) {
			myString[i] = new MyString(array[i]);
		}

		return myString;
	}
}
