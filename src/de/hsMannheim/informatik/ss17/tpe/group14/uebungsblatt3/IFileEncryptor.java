package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import java.io.*;

public interface IFileEncryptor {

	public File encrypt(File sourceDirectory) throws IOException;
	
	public File decrypt(File sourceDirectory) throws IOException;
}
