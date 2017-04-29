package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe1;

import static gdi.MakeItSimple.*;

public class CrypterCaesar implements Crypter {

	private static final int ALPHABET_COUNT = 26;
	private final int shift;

	/**
	 * Constructor to set the shift for the encryption
	 * 
	 * @param shift
	 *            value for the encryption
	 * 
	 * @throws GDIException
	 *             if the shift is negative or bigger than the alphabet count
	 */
	public CrypterCaesar(int shift) throws GDIException {

		if (shift < 0) {
			throw new GDIException("shift is negative");
		}

		if (shift > ALPHABET_COUNT) {
			throw new GDIException("shift over 26 are not allowed");
		}

		this.shift = shift;
	}

	@Override
	public String encrypt(String message) throws GDIException {

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
	public String decrypt(String cypherText) throws GDIException {

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

	/**
	 * Transform the given string to upper case and return the result
	 * 
	 * @param str
	 *            to transform
	 * @return the given string as upper case
	 */
	private String toUpperCase(String str) {

		String upperCase = "";

		// Change all letters in the alphabet to upper case
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				// Change the letter to upper case
				upperCase += (char) (str.charAt(i) - 32);
			} else {
				upperCase += str.charAt(i);
			}
		}

		return upperCase;
	}

	/**
	 * Transform the given string to lower case and return the result
	 * 
	 * @param str
	 *            to transform
	 * @return the given string as lower case
	 */
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

	/**
	 * Check if all letters in the given string are in the alphabet
	 * 
	 * @param str
	 *            to check
	 * @return true if all letters in the alphabet, else false
	 */
	private boolean isLeagalString(String str) {

		for (int i = 0; i < str.length(); ++i) {
			// Check if the latter is not in the alphabet
			if (!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') && !(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
				return false;
			}
		}

		return true;
	}
}
