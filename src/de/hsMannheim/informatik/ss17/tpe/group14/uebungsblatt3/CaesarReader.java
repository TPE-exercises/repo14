package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import java.io.*;

public class CaesarReader extends FilterReader {

	private final CrypterCaesar crypterCaeser;

	public CaesarReader(Reader in, int shift) {

		super(in);
		crypterCaeser = new CrypterCaesar(shift);
	}

	@Override
	public int read() throws IOException {

		String decrypted = crypterCaeser.decrypt(String.valueOf((char) super.read()));

		return decrypted.charAt(0);
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {

		int ret = super.read(cbuf, off, len);

		// Decrypt the character between offset and end of buffer
		String buffer = crypterCaeser.decrypt(new String(cbuf, off, len));

		// Change the character between offset and end of buffer with the
		// decrypted characters
		int i = off;
		for (char c : buffer.toCharArray()) {
			cbuf[i++] = c;
		}

		return ret;
	}
}
