package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.aufgabe2;

public abstract class Eisdiele {
	
	private String [] eiskarte;
	
	public abstract Eis erstellen(String typ);
	public abstract void bestellen(String typ);
	public abstract void begruessen();
	public abstract void kassieren();
	public abstract void verabschieden();
	public abstract void entschuldigen();

}
