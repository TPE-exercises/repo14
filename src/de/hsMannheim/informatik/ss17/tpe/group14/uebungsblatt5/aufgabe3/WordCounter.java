package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.JFileChooser;

public class WordCounter {
	private final Map<String, Integer> words = new HashMap<>();

	public WordCounter(File file) throws FileNotFoundException {
		countWords(file);
	}

	private void countWords(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		input.useDelimiter(" +|(\r\n|\r|\n)"); // One or more spaces

		while (input.hasNext()) {
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
	}

	private void removePunctuationMarks(String str) {
		str.replaceAll("\\?|.|,|;|(|)|!|\"|„", "");
	}

	private boolean isWord(String str) {
		if(str.length() == 0) {
			return false;
		}
		
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if ((c < 'a' || c > 'z') && (c != 'ä' && c != 'ö' && c != 'ü')) {
				return false;
			}
		}

		return true;
	}

	public Map<String, Integer> getWords() {
		return new HashMap<>(words);
	}
}
