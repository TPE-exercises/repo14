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
		
		super.write(String.valueOf((char) c), 0, 1);
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		
		super.write(new String(cbuf), off, len);
	}
	
	@Override
	public void write(String str, int off, int len) throws IOException {
		
		super.write(crypterCaesar.encrypt(str), off, len);
	}
}
