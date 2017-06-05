package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounter {
	private final Map<String, Integer> words = new HashMap<>();

	/**
	 * Constructor to set the file
	 * 
	 * @param file
	 *            to work with
	 * @throws FileNotFoundException
	 *             if the file not exists
	 */
	public WordCounter(File file) throws FileNotFoundException {
		countWords(file);
	}

	/**
	 * Find every word in the given file and save the words width occur count to
	 * the map
	 * 
	 * @param file
	 *            to search the words
	 * @throws FileNotFoundException
	 *             if the file not exists
	 */
	private void countWords(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		try {
			input.useDelimiter(" +|(\r\n|\r|\n)"); // One or more spaces

			// Go through the complete filed
			while (input.hasNext()) {
				// We not distinguish between lower case and upper case
				String word = input.next().toLowerCase();
				removePunctuationMarks(word);

				if (isWord(word)) {
					if (words.containsKey(word)) {
						// Counts the occur of the word
						words.put(word, words.get(word) + 1);
					} else {
						words.put(word, 1); // First occur of the word
					}
				}
			}
		} finally {
			input.close();
		}
	}

	/**
	 * Remove all punctuation marks in the string
	 * 
	 * @param str
	 *            to remove the punctuation marks
	 */
	private void removePunctuationMarks(String str) {
		str.replaceAll("\\?|.|,|;|(|)|!|\"|„", "");
	}

	/**
	 * Return true if the given string is a word, else false
	 * 
	 * @param str
	 *            to check
	 * @return true if the given string is a word, else false
	 */
	private boolean isWord(String str) {
		// At least one letter
		if (str.length() == 0) {
			return false;
		}

		// A word only contains letters
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (!Character.isLetter(c)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Return the words as deep copy
	 * 
	 * @return the words
	 */
	public Map<String, Integer> getWords() {
		return new HashMap<>(words);
	}
}
