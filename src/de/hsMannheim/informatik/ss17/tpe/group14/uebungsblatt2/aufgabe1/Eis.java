package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.aufgabe1;

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
		this.setPreis(preis);
		this.setBehaeltnis(behaeltnis);
		this.art = art;
		this.setSorten(sorten);
		this.setExtras(extras);
	}

	public String getName() {
		return name;
	}

	public double getPreis() {
		return preis;
	}
	
	public void setPreis(double preis){
		this.preis = preis;
	}

	public String getBehaeltnis() {
		return behaeltnis;
	}
	
	public void setBehaeltnis(String behaeltnis){
		this.behaeltnis = behaeltnis;
	}

	public String getArt() {
		return art;
	}

	public String[] getSorten() {
		return sorten.clone();
	}
	
	public void setSorten (String[] sorten){
		this.sorten = sorten;
	}

	public String[] getExtras() {
		return extras.clone();
	}
	
	public void setExtras(String[] extras){
		this.extras = extras;
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
