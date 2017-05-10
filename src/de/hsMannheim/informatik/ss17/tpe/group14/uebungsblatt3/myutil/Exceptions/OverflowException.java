package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions;

public class OverflowException extends Throwable{
	
	protected String lastInsert;
	
	public OverflowException(Object o){
		lastInsert = o.toString();
		getMessage();
		printStackTrace();
	}

}
