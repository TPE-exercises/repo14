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

	/**
	 * order your icecream
	 * @param typ the name of the icecream
	 */
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

	/**
	 * welcome the guest
	 */
	private void begruessen() {
		println("Guten Tag!");
	}

	/**
	 * to cash up the guest
	 * @param eis
	 */
	private void kassieren(Eis eis) {

		println("Ihr " + eis.getName() + " kostet " + eis.getPreis() + ".");
	}

	/**
	 * say goodbye to the guest
	 */
	private void verabschieden() {
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
		println();
	}

	/**
	 * say sorry to the guest
	 */
	private void entschuldigen() {
		println("Leider haben wir ihr Eis nicht im Angebot, bitte entschuldigen Sie das!");
		println();
	}

	
	public static void main(String[] args) {
		
		Eis spaghettieis = new Eis("Spaghettieis", 4.99, "Teller", "Spaghetti", new String[] {"Vanille"} , "Sahne", "Erdbeersoße" , "weiße Raspelschokolade");
		Eis bananensplitt = new Eis("Bananensplitt", 5.99, "Schale", "Kugeln", new String[] {"Vanielle" , "Zitone", "Banane"}, "Sahne", "Banane", "Schokosoße", "Amarenasoße", "frische Früchte");
		Eis nussbecher = new Eis("Nussbecher", 5.99, "Glas", "Kugeln" , new String[] {"Milcheis"}, "verschiedene Nüsse", "Sahne", "Schokosoße", "Schokoladenraspeln");

		Eisdiele eisdiele = new Eisdiele(3);
		eisdiele.setEisAufEiskarte(spaghettieis);
		eisdiele.setEisAufEiskarte(bananensplitt);
		eisdiele.setEisAufEiskarte(nussbecher);
		
		eisdiele.bestellen("Spaghettieis");
		eisdiele.bestellen("Bananensplitt");
		eisdiele.bestellen("Schoko");
		eisdiele.bestellen("Nussbecher");
	}
}
