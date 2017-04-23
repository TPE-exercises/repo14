package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe2;

public class MyInt implements Comparable {

	private int value;

	public MyInt(int value) {

		this.value = value;
	}

	public void setValue(int value) {

		this.value = value;
	}

	public int getValue() {

		return value;
	}

	@Override
	public int compareTo(Object o) {

		int otherValue = ((MyInt) o).getValue();

		if (value > otherValue) {
			return 1;
		} else if (value < otherValue) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {

		return "" + value;
	}
}
