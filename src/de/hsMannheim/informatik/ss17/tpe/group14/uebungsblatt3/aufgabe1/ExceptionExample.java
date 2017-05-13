package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import static gdi.MakeItSimple.*;

public class ExceptionExample {

	/**
	 * Eingabe eines ganzhligen Bruches
	 * 
	 * @return array mit Zähler und Nenner
	 */
	private static int[] nummernEingabe() {
		int[] zahlen = new int[2];
		println("Zähler: ");
		zahlen[0] = readInt();
		println("Nenner: ");
		zahlen[1] = readInt();
		return zahlen;
	}

	/**
	 * ganzzahlige Division zweier int Werte
	 * 
	 * @param zahlen
	 */
	private static void ganzzahligeDivison(int[] zahlen) {
		int erg = 0;
		try {
			erg = zahlen[0] / zahlen[1];
			println(erg);
		} catch (ArithmeticException aex) {
			println("Die Divison durch 0 ist nicht gestattet!");
		}

	}

	public static void main(String[] args) {
		
		while(true)
			ganzzahligeDivison(nummernEingabe());
		

	}
}
