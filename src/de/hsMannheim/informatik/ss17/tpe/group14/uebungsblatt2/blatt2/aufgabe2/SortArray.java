package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe2;

import static gdi.MakeItSimple.*;

public class SortArray {

	public static void main(String[] args) {
		try {
			Sort algorithm = selectSortAlgorithm();

			if (algorithm != null) {

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

					sortArray(algorithm, toMyIntArray(array));

				} else if (datatypeChoice == 2) {
					print("how many strings: ");
					int length = readInt();
					readLine();
					String[] array = new String[length];

					for (int i = 0; i < array.length; ++i) {
						print("string: ");
						array[i] = readLine();
					}

					sortArray(algorithm, toMyString(array));

				} else {
					println("unknown input");
				}
			} else {
				println("unknown sort algorithm");
			}
		} catch (Exception ex) {
			println(ex.getMessage());
			println("program exit");
		}
	}

	/**
	 * Ask the user for a Sort implementation and return it, or null if the user
	 * input is not valid.
	 * 
	 * @return a Sort implementation or null
	 */
	private static Sort selectSortAlgorithm() {

		println("1.) inserationSort");
		println("2.) shellsort");

		int sortAlgorithmChoice = readInt();
		readLine();

		if (sortAlgorithmChoice == 1) {
			return new InserationSort();
		} else if (sortAlgorithmChoice == 2) {
			return new Shellsort();
		} else {
			return null;
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
