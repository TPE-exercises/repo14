package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

public interface Crypter {
	/**
	 * Encrypt the given string and return the result
	 * 
	 * @param message
	 *            to encrypt
	 * @return the encrypted result
	 */
	public String encrypt(String message);

	/**
	 * Decrypt the given string and return the result
	 * 
	 * @param cypherText
	 *            to decrpt
	 * @return the decrypted result
	 */
	public String decrypt(String cypherText);
}
