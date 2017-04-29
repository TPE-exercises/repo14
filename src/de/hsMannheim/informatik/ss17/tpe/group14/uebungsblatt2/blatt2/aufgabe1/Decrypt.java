package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe1;

import static gdi.MakeItSimple.*;

public class Decrypt {
	public static void main(String[] args) {
		try {
			CrypterReverse revers = new CrypterReverse();
			CrypterCaesar caesar = new CrypterCaesar(5);
			String decripted = caesar.decrypt(revers.decrypt("XHMSNYYXYJQQJS"));

			println(revers.decrypt(decripted));
		} catch (Exception ex) {
			println(ex.getMessage());
		}
	}
}
