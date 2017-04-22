package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt2.blatt2;

public class CrypterRevers implements Crypter {

	@Override
	public String encrypt(String message) {

		String encrypted = "";
		for (int i = message.length() - 1; i >= 0; --i) {
			encrypted += message.charAt(i);
		}

		return encrypted;
	}

	@Override
	public String decrypt(String cypherText) {

		return encrypt(cypherText);
	}

}
