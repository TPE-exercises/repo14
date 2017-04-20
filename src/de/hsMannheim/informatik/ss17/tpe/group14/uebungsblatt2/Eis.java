package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2;

import static gdi.MakeItSimple.*;

public class Eis {

	private String name;
	private double preis;
	private String behaeltnis;
	private String art;
	private String[] sorten;
	private String[] extras;

	/**
	 * Constuctor
	 * 
	 * @param name
	 * @param preis
	 * @param behaeltnis
	 * @param art
	 * @param sorten
	 * @param extras
	 */
	Eis(String name, double preis, String behaeltnis, String art, String[] sorten, String... extras) {
		this.name = name;
		this.preis = preis;
		this.behaeltnis = behaeltnis;
		this.art = art;
		this.sorten = sorten;
		this.extras = extras;
	}

	public String name() {
		return name;
	}

	public double preis() {
		return preis;
	}

	public String behaeltnis() {
		return behaeltnis;
	}

	public String art() {
		return art;
	}

	public String[] sorten() {
		return sorten.clone();
	}

	public String[] extras() {
		return extras.clone();
	}

	public void vorbereiten() {
		println("Nimm die: " + this.behaeltnis + ".");
	}

	public void fuellen() {
		if (sorten.length != 0) {
			print("Fuelle die " + this.behaeltnis + " mit: ");
			printArray(sorten);
		}
	}

	public void dekorieren() {
		if (extras.length != 0) {
			print("Dekoriert wird das Eis mit: ");
			printArray(extras);
		}
	}

	private void printArray(String[] array) {
		for (int i = 0; i < array.length; ++i) {
			if (i + 1 == array.length) {
				print(array[i] + ".");
			} else {
				print(array[i] + ", ");
			}
		}
		println();
	}
}
