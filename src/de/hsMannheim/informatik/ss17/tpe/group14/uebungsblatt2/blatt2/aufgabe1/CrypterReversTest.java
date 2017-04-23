package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe1;

import static gdi.MakeItSimple.*;
import static org.junit.Assert.*;
import org.junit.*;

public class CrypterReversTest {

	@Test
	public void test() {
		CrypterReverse revers = new CrypterReverse();
		
		assertEquals("ollah", revers.encrypt("hallo"));
		assertEquals("", revers.encrypt(""));
		assertEquals("naj", revers.encrypt("jan"));
		assertEquals("nereimmargorp", revers.encrypt("programmieren"));
		assertEquals("anna", revers.encrypt("anna"));
		assertEquals("wolfkrow", revers.decrypt("workflow"));
	}
}
