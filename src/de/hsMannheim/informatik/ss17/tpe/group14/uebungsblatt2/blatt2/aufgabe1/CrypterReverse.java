package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2.aufgabe1;

public class CrypterReverse implements Crypter {

	@Override
	public String encrypt(String message) {

		String encrypted = "";
		// Add all letters of the given string reverse to the result
		for (int i = message.length() - 1; i >= 0; --i) {
			encrypted += message.charAt(i);
		}

		return encrypted;
	}

	@Override
	public String decrypt(String cypherText) {
		// The decryption is just once again the encryption
		return encrypt(cypherText);
	}

}
