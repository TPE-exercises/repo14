package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import java.io.*;

public interface IFileEncryptor {

	/**
	 * Encrypt the given directory recursively and return the new directory that
	 * is in the same directory like the given one
	 * 
	 * @param sourceDirectory
	 *            to encrypt
	 * @return the encrypted directory
	 * @throws IOException
	 *             if not able to create the encrypted directory
	 */
	public File encrypt(File sourceDirectory) throws IOException;

	/**
	 * Decrypt the given directory recursively and return the new directory that
	 * is in the same directory like the given one
	 * 
	 * @param sourceDirectory
	 *            to decrypt
	 * @return the decrypted directory
	 * @throws IOException
	 *             if not able to create the encrypted directory
	 */
	public File decrypt(File sourceDirectory) throws IOException;
}
