package de.hsMannheim.informatik.ss17.IB.tpe.group14.uebungsblatt2;

import static gdi.MakeItSimple.*;

public class Eis {

	// Bezeichnung des Eises z.B. Spaghettieis/Bananasplit/etc
	private String name;
	private double preis;
	// Waffel/Becher/Teller/Schüssel/Glas/etc.
	private String behaeltnis;
	// Bällchen/Bälle/Spaghettis/Klekse/etc.
	private String art;
	// Vanille/Schokolade/Straciatella/Zitrone/etc
	private String[] sorten;
	// Sahne, Schokosträusel/Keks/Soße/etc
	private String[] extras;

	/*
	 * 1. Wie soll die Sorte des Eis bestellt werden
	 * 2. sollen vorbereiten/ fuellen/ dekorieren immer ausgeführt werden
	 * 3. Für die Methoden in der Eisdiele ist keien Logik notwendig? Reine Ausgabe auf Konsole? 
	 */
	
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
		this.vorbereiten();
		this.fuellen();
		this.dekorieren();
	}

	public void vorbereiten() {
		println("Nimm die: " + this.behaeltnis + ".");
	}

	public void fuellen() {
		print("Fülle die " + this.behaeltnis + " mit: ");
		for (int i = 0; i < this.sorten.length; i++) {
			if (i == 0) {
				print("ein " + this.art + " " + this.sorten[i]);
			} else {
				print(", ein " + this.art + " " + this.sorten[i]);
				if (i == this.sorten.length - 1)
					print(".");
			}
		}
		println();
	}

	public void dekorieren() {
		print("Dekoriert wird das Eis mit: ");
		for (int i = 0; i < this.extras.length; i++) {
			if(i == 0){
				print(this.extras[i]);
			} else {
				print(", " + this.extras[i]);
				if (i == this.extras.length - 1)
					print( ".");
			}
		}
		println();
	}
}
