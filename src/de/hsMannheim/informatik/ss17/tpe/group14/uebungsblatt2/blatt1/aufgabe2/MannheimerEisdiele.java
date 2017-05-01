package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public class MannheimerEisdiele extends MyEisdiele {
	
	public MannheimerEisdiele(int anzahlEis) {
		super(anzahlEis);
	}

	@Override
	protected void begruessen() {
		println("Servus!");
		
	}

	@Override
	protected void kassieren(MyEis eis) {
		println("Des macht " + eis.getPreis() + "!");
	}

	@Override
	protected void verabschieden() {
		println("Allah ciao!");
		
	}

	@Override
	protected void entschuldigen() {
		println("Sorry, des Eis habe mir net da!");
		
	}

	@Override
	public MyEis erstellen(String typ) {	
		MyEis eis = new MannheimerEis(typ);
		this.setEisAufEiskarte(eis);
		return eis;
	}

	
}
