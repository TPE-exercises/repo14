package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil;

import static gdi.MakeItSimple.*;

public class UnderflowException extends Throwable{
	
	public UnderflowException() {
		println("Underflow");
//		this.getMessage();
//		this.printStackTrace();
	}
	
	public UnderflowException(String s){
		this.getMessage();
		this.printStackTrace();
	}

}
