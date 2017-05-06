package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

public class CrypterCaesar implements Crypter {

	private final int shift;
	private final static int INVALID_CHARACTER = -1;

	private static final char[] VALID_CHARACTERS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü',
			'ä', 'ö', 'ü' };

	/**
	 * Constructor to set the shift for the encryption
	 * 
	 * @param shift
	 *            value for the encryption
	 */
	public CrypterCaesar(int shift) {

		this.shift = shift;
	}

	@Override
	public String encrypt(String message) throws IllegalArgumentException {

		if (message == null) {
			throw new IllegalArgumentException("given string is null");
		}

		return caesarEncrypt(message);
	}

	@Override
	public String decrypt(String cypherText) {

		if (cypherText == null) {
			throw new IllegalArgumentException("given string is null");
		}

		return caesarDecrypt(cypherText);
	}

	/**
	 * Encrypt the given string with caesar cipher
	 * 
	 * @param message
	 *            to encrypt
	 * @return the encrypted string
	 */
	private String caesarEncrypt(String message) {

		String encryptedMessage = "";

		for (int i = 0; i < message.length(); ++i) {
			char c = message.charAt(i);
			int characterPosition = getCharacterPosition(c);

			// check if the character is encryptable
			if (characterPosition != INVALID_CHARACTER) {
				int newPosition = ((characterPosition + shift) % VALID_CHARACTERS.length);

				if (newPosition < 0) {
					// the shift is a negative number we have to add the
					// character count to the number to get the correct result
					newPosition += VALID_CHARACTERS.length;
				}

				encryptedMessage += VALID_CHARACTERS[newPosition];
			} else {
				// we ignore the character
				encryptedMessage += c;
			}
		}

		return encryptedMessage;
	}

	/**
	 * Decrypt the given string with caesar cipher
	 * 
	 * @param cypherText
	 *            to decrypt
	 * @return the decrypted string
	 */
	private String caesarDecrypt(String cypherText) {

		String decryptedMessage = "";

		for (int i = 0; i < cypherText.length(); ++i) {
			char c = cypherText.charAt(i);
			int characterPosition = getCharacterPosition(c);

			// check if the character is decryptable
			if (characterPosition != INVALID_CHARACTER) {
				int newPosition = ((characterPosition - shift) % VALID_CHARACTERS.length);

				if (newPosition < 0) {
					// the shift is a negative number we have to add the
					// character count to the number to get the correct result
					newPosition += VALID_CHARACTERS.length;
				}

				decryptedMessage += VALID_CHARACTERS[newPosition];
			} else {
				// we ignore the character
				decryptedMessage += c;
			}
		}

		return decryptedMessage;
	}

	/**
	 * Return the position of the given character in the valid characters array
	 * 
	 * @param c
	 *            the character to find the position
	 * @return the position, or (INVALID_CHARACTER = - 1) if the given character
	 *         is not in the array
	 */
	private int getCharacterPosition(char c) {

		for (int i = 0; i < VALID_CHARACTERS.length; ++i) {
			if (VALID_CHARACTERS[i] == c) {
				return i;
			}
		}

		return INVALID_CHARACTER;
	}
}
