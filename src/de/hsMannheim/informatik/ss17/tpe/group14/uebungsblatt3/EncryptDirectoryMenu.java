package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import java.io.*;

public class EncryptDirectoryMenu {
	
	public static void main(String[] args) {
		CaesarFileEncryptor crypt = new CaesarFileEncryptor(10);
		try {
			crypt.encrypt(new File("C:\\Users\\Jans PC\\Documents\\Mathe"));
			crypt.decrypt(new File("C:\\Users\\Jans PC\\Documents\\Mathe_encrypted"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
