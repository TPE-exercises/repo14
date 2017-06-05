package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe3;

public class WordCount implements Comparable<WordCount> {
	private final String word;
	private final int count;

	/**
	 * Constructor to set the word and count
	 * 
	 * @param word
	 *            to set
	 * @param count
	 *            occur of the word
	 */
	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public int compareTo(WordCount o) {
		return Integer.compare(count, o.getCount());
	}

	/**
	 * Return the word
	 * 
	 * @return the word
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Return the count of the word
	 * 
	 * @return the count of the word
	 */
	public int getCount() {
		return count;
	}
}
