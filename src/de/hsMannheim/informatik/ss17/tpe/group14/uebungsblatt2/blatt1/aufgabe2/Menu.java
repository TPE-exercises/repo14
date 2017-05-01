package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public class Menu {
	
	static public void printMenu(){
		println("Wo befinden Sie sich?");
		println("Mannheim \t-> MA");
		println("Köln \t \t-> KO");
		println("Hamburg \t-> HH");	
		String standort = readLine();
		switch(standort){
		case "MA": 
			MyEisdiele ma = new MannheimerEisdiele(3);
			ma.erstellen("Bananensplitt");
			ma.erstellen("Spaghettieis");
			ma.erstellen("Nussbecher");
			bestellung(ma);
			break;
		case "KO": 
			MyEisdiele ko = new KoelnerEisdiele(3);
			ko.erstellen("Bananensplitt");
			ko.erstellen("Spaghettieis");
			ko.erstellen("Nussbecher");
			bestellung(ko);
			break;
		case "HH":
			MyEisdiele hh = new HamburgerEisdiele(3);
			hh.erstellen("Bananensplitt");
			hh.erstellen("Spaghettieis");
			hh.erstellen("Nussbecher");
			bestellung(hh);
			break;
		default:
			println("Geben Sie einen gültigen Standort ein!");
			break;
		}
	}
	
	static private void bestellung(MyEisdiele ed){
		println("Was wollen Sie bestellen?");
		String bestellung = readLine();
		ed.bestellen(bestellung);
	}

	public static void main(String[] args) {
	
		while(true)
		printMenu();

	}

}
