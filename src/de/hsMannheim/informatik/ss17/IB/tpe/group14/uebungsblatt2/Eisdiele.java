package de.hsMannheim.informatik.ss17.IB.tpe.group14.uebungsblatt2;

import static gdi.MakeItSimple.*;

public class Eisdiele {
	
	public void bestellen(String typ){
		this.begruessen();
		this.kassieren();
		this.verabschieden();
		
		//if(!typ.equals(eissorten))
		//this.entschuldigen();
		
	}
	
	private void begruessen(){
		println("Guten Tag!");
	}
	
	private void kassieren(){
		
	}
	
	private void verabschieden(){
		println("Auf Wiedersehen! Und lassen Sie sich ihr Eis schmecken!");
	}
	
	private void entschuldigen(){
		println("Leider haben wir ihr Eis nicht im Angebot, bitte entschuldigen Sie das!");
	}
	
	
	public static void main(String[] args) {
		String [] spagettieisSorten = {"Vanille", "Schokolade"};
		String [] bananensplittSorten = {"Banane"};
		
		Eis[] eiskarte = new Eis[5];
		eiskarte[0] = new Eis("Spaghettieis", 4.56, "Schale", "Spaghetti", spagettieisSorten, "Schokosoße", "Sahne");
		eiskarte[1] = new Eis("Bananensplitt", 4.32, "Schale", "Kugeln" , bananensplittSorten, "Schokosoße", "Sahne");
		
		Eisdiele eisdiele = new Eisdiele();
		eisdiele.bestellen("Spaghettieis");
		eisdiele.bestellen("Bananensplitt");
	}
}
