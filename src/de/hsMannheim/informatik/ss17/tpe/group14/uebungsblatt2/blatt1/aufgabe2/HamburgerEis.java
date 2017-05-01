package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

public class HamburgerEis extends MyEis {

	/**
	 * Constructor for a Hamburger icecream
	 * 
	 * @param typ
	 *            is the name of the icecream
	 */
	HamburgerEis(String typ) {
		super(typ);
		switch (typ) {
		case "Spaghettieis":
			this.setBehaeltnis("Teller");
			this.setArt("Spaghettis");
			this.setSorten(new String[] { "Vanille" });
			this.setExtras(new String[] { "Erdbeersoße" });
			break;
		case "Bananensplitt":
			this.setBehaeltnis("Schüssel");
			this.setArt("Bolle");
			this.setSorten(new String[] { "Banane", "Vanille" });
			this.setExtras(new String[] { "Waffeln", "Bananen", "Sahne" });
			break;
		case "Nussbecher":
			this.setBehaeltnis("Glas");
			this.setArt("Bolle");
			this.setSorten(new String[] { "Nusseisvariation" });
			this.setExtras(new String[] { "Walnüsse", "Haselnüsse", "Sahne", "Likör" });
			break;
		default:
			break;
		}

	}
}
