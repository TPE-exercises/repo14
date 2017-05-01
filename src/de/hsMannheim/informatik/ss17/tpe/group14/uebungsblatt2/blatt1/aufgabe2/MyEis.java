package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public abstract class MyEis {
	
	/**
	 * Constructor for an ice with the name
	 * @param typ is the name of the icecream
	 */
	MyEis(String typ){
		switch(typ){
		case "Spaghettieis": 
			this.setName("Spaghettieis");
			this.setPreis(4.99);
			break;
		case "spaghettieis":
			this.setName("Spaghettieis");
			this.setPreis(4.99);
			break;
		case "Bananensplitt":
			this.setName("Bananensplitt");
			this.setPreis(5.99);
			break;
		case "bananensplitt":
			this.setName("Bananensplitt");
			this.setPreis(5.99);
			break;
		case "Nussbecher":
			this.setName("Nussbecher");
			this.setPreis(5.99);
			break;
		case "nussbecher":
			this.setName("Nussbecher");
			this.setPreis(5.99);
			break;
		default:
			break;
		}
	}

	private String name;
	private double preis;
	private String behaeltnis;
	private String art;
	private String[] sorten;
	private String[] extras;
	
	
	/**
	 * get name of the icecream
	 * @return name 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set a new name for an existed icecream
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * get how much the icecream cost
	 * @return preis
	 */
	public double getPreis() {
		return preis;
	}
	
	/**
	 * set an new price for an existed icecream
	 * @param preis
	 */
	public void setPreis(double preis){
		this.preis = preis;
	}

	/**
	 * get the container for the ice
	 * @return behaeltnis
	 */
	public String getBehaeltnis() {
		return behaeltnis;
	}
	
	/**
	 * set the container for the ice
	 * @param behaeltnis
	 */
	public void setBehaeltnis(String behaeltnis){
		this.behaeltnis = behaeltnis;
	}

	/**
	 * get the kind how the ice look like
	 * @return art
	 */
	public String getArt() {
		return art;
	}
	
	/**
	 * set the kind how the ice look like
	 * @param art
	 */
	public void setArt(String art){
		this.art = art;
	}

	/**
	 * get all kinds of the icecreams in a string array
	 * @return
	 */
	public String[] getSorten() {
		return sorten;
	}
	
	/**
	 * set all kinds of the icecreams 
	 * @param sorten
	 */
	public void setSorten (String[] sorten){
		this.sorten = sorten;
	}

	/**
	 * get all toppings from the ice
	 * @return
	 */
	public String[] getExtras() {
		return extras;
	}
	
	/**
	 * set all toppings from the ice
	 * @param extras
	 */
	public void setExtras(String[] extras){
		this.extras = extras;
	}

	/**
	 * the first step by the ice production
	 */
	public void vorbereiten() {
		println(this.getBehaeltnis() + " nehmen.");
	}

	/**
	 * fill the ice into the container
	 */
	public void fuellen() {
		if (sorten.length != 0) {
			print(this.getBehaeltnis() + " füllen mit " + this.getArt() + " aus ");
			printArray(this.getSorten());
		}
	}

	/**
	 * all things that decorate the ice
	 */
	public void dekorieren() {
		if (extras.length != 0) {
			print("Eis dekorieren mit ");
			printArray(this.getExtras());
		}
	}
	/**
	 * print an array and seperate all parts wit  "," and at the end a "."
	 * @param array
	 */
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
