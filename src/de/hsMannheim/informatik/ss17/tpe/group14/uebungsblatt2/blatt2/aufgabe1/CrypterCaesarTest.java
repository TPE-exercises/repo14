package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe1;

import static gdi.MakeItSimple.*;
import static org.junit.Assert.*;
import org.junit.*;

public class CrypterCaesarTest {

	@Test(expected = GDIException.class)
	public final void encryptAndDecrpytNegativeShift() {
		new CrypterCaesar(-1);
	}

	@Test
	public final void encryptAndDecrypt0Shift() {
		CrypterCaesar caesaCrypt = new CrypterCaesar(0);

		assertEquals("HOCHSCHULE", caesaCrypt.encrypt("hochschule"));
		assertEquals("hochschule", caesaCrypt.decrypt("HOCHSCHULE"));
	}

	@Test
	public final void encryptAndDecrypt3Shift() {
		CrypterCaesar caesaCrypt = new CrypterCaesar(3);

		assertEquals("FDHVDU", caesaCrypt.encrypt("caesar"));
		assertEquals("caesar", caesaCrypt.decrypt("FDHVDU"));
	}

	@Test
	public final void encryptAndDecrypt10Shift() {
		CrypterCaesar caesaCrypt = new CrypterCaesar(10);

		assertEquals("FOBCMRVEOCCOVEXQ", caesaCrypt.encrypt("verschluesselung"));
		assertEquals("verschluesselung", caesaCrypt.decrypt("FOBCMRVEOCCOVEXQ"));
	}

	@Test(expected = GDIException.class)
	public final void encryptIllegalCharacters() {
		CrypterCaesar caesaCrypt = new CrypterCaesar(5);
		caesaCrypt.decrypt("halloä");
	}
}
