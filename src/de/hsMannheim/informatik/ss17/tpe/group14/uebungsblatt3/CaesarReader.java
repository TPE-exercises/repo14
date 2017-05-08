package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import java.io.*;

public class CaesarReader extends FilterReader {

	private final CrypterCaesar crypterCaeser;
	private String buffer = "";
	private int pos = 0;

	public CaesarReader(Reader in, int shift) {

		super(in);
		crypterCaeser = new CrypterCaesar(shift);
	}

	@Override
	public int read() throws IOException {

		int ret = super.read();
		
		if(ret == -1) {
			return ret;
		}
		
		String decrypted = crypterCaeser.decrypt(String.valueOf((char) ret));

		return decrypted.charAt(0);
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {

		if (pos == buffer.length()) {
			// No leftovers from a previous call available, need to actually read
			// more
			int result = in.read(cbuf, off, len);
			if (result <= 0) {
				return -1;
			}
			buffer = new String(cbuf, off, result);
			buffer = crypterCaeser.decrypt((buffer));
			pos = 0;
			
		}

		// Return as much as we have available, but not more than len
		int available = Math.min(buffer.length() - pos, len);
		buffer.getChars(pos, pos + available, cbuf, off);
		pos += available;

		return available;
	}
}
