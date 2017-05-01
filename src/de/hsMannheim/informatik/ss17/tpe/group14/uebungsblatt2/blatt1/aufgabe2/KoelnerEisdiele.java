package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt1.aufgabe2;

import static gdi.MakeItSimple.*;

public class KoelnerEisdiele extends MyEisdiele{
	
	public KoelnerEisdiele(int anzahlEis) {
		super(anzahlEis);
	}

	@Override
	protected void begruessen() {
		println("Tach!");
		
	}

	@Override
	protected void kassieren(MyEis eis) {
		println("Det koß " + eis.getPreis() + "!");
		
	}

	@Override
	protected void verabschieden() {
		println("Machet jot!");
		
	}

	@Override
	protected void entschuldigen() {
		println("Exküs, det han mir nit do.");
		
	}

	@Override
	public MyEis erstellen(String typ) {
		MyEis eis = new KoelnerEis(typ);
		this.setEisAufEiskarte(eis);
		return eis;
	}

}
