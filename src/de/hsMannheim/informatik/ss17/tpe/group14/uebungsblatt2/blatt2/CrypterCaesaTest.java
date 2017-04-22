package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2;

import static gdi.MakeItSimple.*;
import static org.junit.Assert.*;
import org.junit.*;

public class CrypterCaesaTest {

	@Test(expected = GDIException.class)
	public final void encryptAndDecrpytNegativeShift() {
		new CrypterCaesa(-1);
	}

	@Test
	public final void encryptAndDecrypt0Shift() {
		CrypterCaesa caesaCrypt = new CrypterCaesa(0);

		assertEquals("HOCHSCHULE", caesaCrypt.encrypt("hochschule"));
		assertEquals("hochschule", caesaCrypt.decrypt("HOCHSCHULE"));
	}

	@Test
	public final void encryptAndDecrypt3Shift() {
		CrypterCaesa caesaCrypt = new CrypterCaesa(3);

		assertEquals("FDHVDU", caesaCrypt.encrypt("caesar"));
		assertEquals("caesar", caesaCrypt.decrypt("FDHVDU"));
	}

	@Test
	public final void encryptAndDecrypt10Shift() {
		CrypterCaesa caesaCrypt = new CrypterCaesa(10);

		assertEquals("FOBCMRVEOCCOVEXQ", caesaCrypt.encrypt("verschluesselung"));
		assertEquals("verschluesselung", caesaCrypt.decrypt("FOBCMRVEOCCOVEXQ"));
	}
}
