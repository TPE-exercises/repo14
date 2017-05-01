package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

public class KoelnerEis extends MyEis{
	
	/**
	 * Constructor for a Kölner icecream
	 * @param typ is the name of the icecream
	 */
	KoelnerEis(String typ){
		super(typ);
		switch(typ){
		case "Spaghettieis": 
			this.setBehaeltnis("Teller");
			this.setArt("Spaghettis");
			this.setSorten(new String[]{"Vanille"});
			this.setExtras(new String[]{"Ädbevvesoße"});
			break;
		case "Bananensplitt":
			this.setBehaeltnis("Kump"); // Schüssel
			this.setArt("Kugeln");
			this.setSorten(new String[]{"Banane"});
			this.setExtras(new String[]{"Schokoladen-Kokos-Soße", "fresche Frooch", "Bierteigwaffeln"});
			break;
		case "Nussbecher":
			this.setBehaeltnis("Glas");
			this.setArt("Kugeln");
			this.setSorten(new String[]{"Vanille"});
			this.setExtras(new String[]{"Walnüsse", "Haselnüsse", "Sahne", "Likör"});
			break;
		default:
			break;
		}
		
	}

}
