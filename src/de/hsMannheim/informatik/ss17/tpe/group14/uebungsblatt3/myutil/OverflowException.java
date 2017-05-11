package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil;

import static gdi.MakeItSimple.*;

public class OverflowException extends Throwable{
	
	protected String lastInsert;
	
	public OverflowException(String s){
//		lastInsert = s;
		println("Overflow: " + s);
//		this.getMessage();
//		this.printStackTrace();
	}
	
	public OverflowException(){
		this.getMessage();
		this.printStackTrace();
	}

}
