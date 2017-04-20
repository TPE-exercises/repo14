package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.aufgabe1;

import static gdi.MakeItSimple.*;

public class Eisdiele {
	
	private Eis [] eiskarte;
	
	Eisdiele(int anzahlEis){
		eiskarte = new Eis[anzahlEis];
	}
	
	public void eisAufEiskarte(Eis eis){
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
			if(typ.equals(eiskarte[i].getName())){
				eisVorhanden = true; 
				this.begruessen();
				this.kassieren();
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

	private void kassieren() {

	}

	private void verabschieden() {
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}

	private void entschuldigen() {
		println("Leider haben wir ihr Eis nicht im Angebot, bitte entschuldigen Sie das!");
	}

	public static void main(String[] args) {
		String[] spagettieisSorten = { "Vanille", "Schokolade" };
		String[] bananensplittSorten = { "Banane" };

		
		Eis spaghettieis = new Eis("Spaghettieis", 4.56, "Schale", "Spaghetti", spagettieisSorten, "Schokosoße", "Sahne");
		Eis bananensplitt = new Eis("Bananensplitt", 4.32, "Schale", "Kugeln", bananensplittSorten, "Schokosoße", "Sahne");

		Eisdiele eisdiele = new Eisdiele(2);
		eisdiele.eisAufEiskarte(spaghettieis);
		eisdiele.eisAufEiskarte(bananensplitt);
		
		eisdiele.bestellen("Spaghettieis");
		eisdiele.bestellen("Bananensplitt");
		
		eisdiele.bestellen("Schoko");
	}
}
