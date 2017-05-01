package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public class HamburgerEisdiele extends MyEisdiele{
	
	public HamburgerEisdiele(int anzahlEis) {
		super(anzahlEis);
	}

	@Override
	protected void begruessen() {
		println("Moin Moin Meister!");
		
	}

	@Override
	protected void kassieren(MyEis eis) {
		println("Det macht jetzt " + eis.getPreis() + ", ne!");	
	}

	@Override
	protected void verabschieden() {
		println("Machs jut Meister!");
	}

	@Override
	protected void entschuldigen() {
		println("Det habe wir nicht da, ne.");	
	}

	@Override
	public MyEis erstellen(String typ) {
		MyEis eis = new HamburgerEis(typ);
		this.setEisAufEiskarte(eis);
		return eis;
	}

}
