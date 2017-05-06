package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import java.io.*;

public class CaesarWriter extends FilterWriter {

	private final CrypterCaesar crypterCaesar;

	public CaesarWriter(Writer out, int shift) {

		super(out);
		crypterCaesar = new CrypterCaesar(shift);
	}

	@Override
	public void write(int c) throws IOException {

		write(String.valueOf((char) c), 0, 1);
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {

		write(new String(cbuf), off, len);
	}

	@Override
	public void write(String str, int off, int len) throws IOException {

		super.write(crypterCaesar.encrypt(str.substring(off, len)), off, len);
	}
}
