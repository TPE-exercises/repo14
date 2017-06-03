package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe3;

public class WordCount implements Comparable<WordCount>{
	private final String word;
	private final int count;
	
	public WordCount(String word, int count) {
		this.word = word;
		this.count = count;
	}

	@Override
	public int compareTo(WordCount o) {
		return Integer.compare(count, o.getCount());
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}
}
