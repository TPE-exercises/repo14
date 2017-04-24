package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe2;

public class MyString implements Comparable {

	private String string;

	/**
	 * Constructor to set the string
	 * 
	 * @param string
	 */
	public MyString(String string) {
		this.string = string;
	}

	/**
	 * Set the given string
	 * 
	 * @param string
	 *            to set
	 */
	public void setString(String string) {
		this.string = string;
	}

	/**
	 * Return the current string
	 * 
	 * @return the current string
	 */
	public String getString() {
		return string;
	}

	@Override
	public int compareTo(Object o) {

		return string.compareTo((String) o);
	}

	@Override
	public String toString() {
		return string;
	}
}
