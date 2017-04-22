package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2;

import static gdi.MakeItSimple.*;

public class Decrypt {
	public static void main(String[] args) {
		CrypterRevers revers = new CrypterRevers();
		CrypterCaesar caesar = new CrypterCaesar(5);
		String decripted = caesar.decrypt(revers.decrypt("XHMSNYYXYJQQJS"));

		println(revers.decrypt(decripted));
	}
}
