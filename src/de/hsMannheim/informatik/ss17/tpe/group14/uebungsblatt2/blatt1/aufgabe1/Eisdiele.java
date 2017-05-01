package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe1;

import static gdi.MakeItSimple.*;

public class Eisdiele {
	
	private Eis [] eiskarte;
	
	/**
	 * Constructor for the Eisdiele
	 * @param anzahlEis on the card
	 */
	Eisdiele(int anzahlEis){
		eiskarte = new Eis[anzahlEis];
	}
	
	public void setEisAufEiskarte(Eis eis){
		for(int i = 0; i < eiskarte.length; i++){
			if(eiskarte[i] == null){
				eiskarte[i] = eis;
				return;
			}
		}
	}

	public void bestellen(String typ) {
		boolean eisVorhanden = false;
		for(int i = 0; i < eiskarte.length; i++){
			if(eiskarte[i] != null && typ.equals(eiskarte[i].getName())){
				eisVorhanden = true; 
				this.begruessen();
				eiskarte[i].vorbereiten();
				eiskarte[i].fuellen();
				eiskarte[i].dekorieren();
				this.kassieren(eiskarte[i]);
				this.verabschieden();	
			}
			if(i == eiskarte.length-1 && eisVorhanden == false){
				this.entschuldigen();
			}
		}
		
	}

	private void begruessen() {
		println("Guten Tag!");
	}

	private void kassieren(Eis eis) {

		println("Ihr " + eis.getName() + " kostet " + eis.getPreis() + ".");
	}

	private void verabschieden() {
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
		println();
	}

	private void entschuldigen() {
		println("Leider haben wir ihr Eis nicht im Angebot, bitte entschuldigen Sie das!");
		println();
	}

	
	public static void main(String[] args) {
		
		Eis spaghettieis = new Eis("Spaghettieis", 4.99, "Teller", "Spaghetti", new String[] {"Vanille"} , "Sahne", "Erdbeersoße" , "weiße Raspelschokolade");
		Eis bananensplitt = new Eis("Bananensplitt", 5.99, "Schale", "Kugeln", new String[] {"Vanielle" , "Zitone", "Banane"}, "Sahne", "Banane", "Schokosoße", "Amarenasoße", "frische Früchte");
		Eis schwarzwaldBecher = new Eis("Schwarzwald Becher", 5.99, "Schale", "Kugeln" , new String[] {"Milcheis"}, "Schattenmorellen", "Kirschwasser", "Sahne", "Schokosoße", "Schokoladenraspeln");

		Eisdiele eisdiele = new Eisdiele(3);
		eisdiele.setEisAufEiskarte(spaghettieis);
		eisdiele.setEisAufEiskarte(bananensplitt);
		
		eisdiele.bestellen("Spaghettieis");
		eisdiele.bestellen("Bananensplitt");
		eisdiele.bestellen("Schoko");
	}
}
