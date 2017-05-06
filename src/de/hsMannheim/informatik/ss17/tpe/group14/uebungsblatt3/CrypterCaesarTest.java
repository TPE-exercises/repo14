package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import static gdi.MakeItSimple.*;
import static org.junit.Assert.*;
import org.junit.*;

public class CrypterCaesarTest {

	@Test
	public final void encryptShift0() {
		
		CrypterCaesar caesar = new CrypterCaesar(0);
		
		assertEquals("Hello, world!", caesar.encrypt("Hello, world!"));
	}
	
	@Test
	public final void decryptShift0() {
		
		CrypterCaesar caesar = new CrypterCaesar(0);
		
		assertEquals("Hello, world!", caesar.decrypt("Hello, world!"));
	}
	
	@Test
	public final void shiftMinus13() {
		
		CrypterCaesar caesar = new CrypterCaesar(-13);
		
		assertEquals("CEBzEtüüÖxExE", caesar.encrypt("PROGRAMMIERER"));
		assertEquals("PROGRAMMIERER", caesar.decrypt("CEBzEtüüÖxExE"));
	}
	
	@Test
	public final void shiftPlus17() {
		
		CrypterCaesar caesar = new CrypterCaesar(17);
		
		assertEquals("kvDEGvCDFty", caesar.encrypt("Testversuch"));
		assertEquals("Testversuch", caesar.decrypt("kvDEGvCDFty"));
	}
}
