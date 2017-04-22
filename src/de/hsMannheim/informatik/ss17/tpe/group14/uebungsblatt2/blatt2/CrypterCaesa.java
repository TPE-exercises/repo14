package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2;

import static gdi.MakeItSimple.*;

public class CrypterCaesa implements Crypter {

	private static final int ALPHABET_COUNT = 26;
	private final int shift;

	public CrypterCaesa(int shift) {

		if (shift < 0) {
			throw new GDIException("shift is negative");
		}

		if (shift > 26) {
			throw new GDIException("shift over 26 ar not allowed");
		}

		this.shift = shift;
	}

	@Override
	public String encrypt(String message) {

		if (!isLeagalString(message)) {
			throw new GDIException("Not supported characters in the given string");
		}

		String toEncrypt = toUpperCase(message);
		String encrypted = "";

		for (int i = 0; i < toEncrypt.length(); ++i) {
			// Shift the letter x to the left
			char letter = (char) (toEncrypt.charAt(i) + shift);

			if (letter > 'Z') {
				// Subtract the shift from the alphabet count if the character
				// is shifted out of the alphabet
				encrypted += (char) (toEncrypt.charAt(i) - (ALPHABET_COUNT - shift));
			} else {
				encrypted += letter;
			}
		}

		return encrypted;
	}

	@Override
	public String decrypt(String cypherText) {

		if (!isLeagalString(cypherText)) {
			throw new GDIException("The given string is not a caesa encryption");
		}

		String toDecript = toUpperCase(cypherText);
		String decripted = "";

		for (int i = 0; i < toDecript.length(); ++i) {
			// Shift the letter x to the right
			char letter = (char) (toDecript.charAt(i) - shift);

			if (letter < 'A') {
				// Subtract the shift from the alphabet count if the character
				// is shifted out of the alphabet
				decripted += (char) (toDecript.charAt(i) + (ALPHABET_COUNT - shift));
			} else {
				decripted += letter;
			}
		}

		return toLowerCase(decripted);
	}

	private String toUpperCase(String str) {

		String upperCase = "";

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				upperCase += (char) (str.charAt(i) - 32);
			} else {
				upperCase += str.charAt(i);
			}
		}

		return upperCase;
	}

	private String toLowerCase(String str) {

		String lowerCase = "";

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				lowerCase += (char) (str.charAt(i) + 32);
			} else {
				lowerCase += str.charAt(i);
			}
		}

		return lowerCase;
	}

	private boolean isLeagalString(String str) {

		for (int i = 0; i < str.length(); ++i) {
			if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'Z') && (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		CrypterCaesa caesaCrypt = new CrypterCaesa(10);

		println(caesaCrypt.encrypt("verschluesselung"));
	}
}
