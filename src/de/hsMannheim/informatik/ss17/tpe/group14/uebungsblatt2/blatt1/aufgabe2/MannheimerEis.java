package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

public class MannheimerEis extends MyEis{

	/**
	 * Constructor for a Mannheimer icecream
	 * @param typ is the name of the icecream
	 */
	MannheimerEis(String typ){
		super(typ);
		switch(typ){
		case "Spaghettieis": 
			this.setBehaeltnis("Teller");
			this.setArt("Spaghettis");
			this.setSorten(new String[]{"Vanille"});
			this.setExtras(new String[]{"Monnemer Dreck"});
			break;
		case "Bananensplitt":
			this.setBehaeltnis("Schale");
			this.setArt("Kugeln");
			this.setSorten(new String[]{"Vanille" , "Banane" , "Stracciatella"});
			this.setExtras(new String[]{"Sahne", "Banane", "Schokosoße", "Amarenasoße", "frische Früchte"});
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
