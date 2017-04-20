package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.aufgabe2;

public abstract class Eis {
	
	private String name;
	private double preis;
	private String behaeltnis;
	private String art;
	private String[] sorten;
	private String[] extras;
	
	public abstract String getName();
	public abstract double getPreis();
	public abstract void setPreis();
	public abstract String getBehaeltnis();
	public abstract void setBehaeltnis(String behaeltnis);
	public abstract String getArt();
	public abstract String [] getSorten();
	public abstract void setSorten(String [] sorten);
	public abstract String [] getExtras();
	public abstract String [] setExtras(String [] extras);
	

}
