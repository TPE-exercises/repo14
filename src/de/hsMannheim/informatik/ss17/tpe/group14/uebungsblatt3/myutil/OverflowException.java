package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil;

import static gdi.MakeItSimple.*;

public class OverflowException extends Throwable{
	
	protected String lastInsert;
	
	public OverflowException(Object o){
		println("Overflow: " + o);
	}
	
	public OverflowException(String s){
		println(s);
	}

}
