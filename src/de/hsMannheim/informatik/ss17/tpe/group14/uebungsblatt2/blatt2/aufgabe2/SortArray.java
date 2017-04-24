package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe2;

import static gdi.MakeItSimple.*;

public class SortArray {

	private static InserationSort inserationSort = new InserationSort();
	private static Shellsort shellSort = new Shellsort();

	public static void main(String[] args) {

		println("1. values");
		println("2. strings");
		print("choice: ");
		int datatypeChoice = readInt();
		readLine();

		if (datatypeChoice == 1) {
			print("how many values: ");
			int length = readInt();
			readLine();
			int[] array = new int[length];

			for (int i = 0; i < array.length; ++i) {
				print("value: ");
				array[i] = readInt();
				readLine();
			}
		} else if (datatypeChoice == 2) {
			print("how many strings: ");
			int length = readInt();
			readLine();
			String[] array = new String[length];

			for (int i = 0; i < array.length; ++i) {
				print("string: ");
				array[i] = readLine();
			}
		} else {
			println("unknown input");
		}
	}

	/**
	 * Sort an array with the given sort algorithm, and print the array before
	 * and after the sort algorithm
	 * 
	 * @param sortAlgorithm
	 *            to use
	 * @param array
	 *            to sort
	 */
	private static void sortArray(Sort sortAlgorithm, Comparable[] array) {

		printArray(array);
		sortAlgorithm.sort(array);
		printArray(array);
	}

	/**
	 * Print an given array
	 * 
	 * @param array
	 *            to print
	 */
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

	/**
	 * Transform an int array to MyInt array
	 * 
	 * @param array
	 *            to transform
	 * @return transformed int array
	 */
	private static MyInt[] toMyIntArray(int[] array) {

		MyInt[] myInt = new MyInt[array.length];

		for (int i = 0; i < array.length; ++i) {
			myInt[i] = new MyInt(array[i]);
		}

		return myInt;
	}

	/**
	 * Transform string array to an MyString array
	 * 
	 * @param array
	 *            to transform
	 * @return transformed string array
	 */
	private static MyString[] toMyString(String[] array) {

		MyString[] myString = new MyString[array.length];

		for (int i = 0; i < array.length; ++i) {
			myString[i] = new MyString(array[i]);
		}

		return myString;
	}
}
