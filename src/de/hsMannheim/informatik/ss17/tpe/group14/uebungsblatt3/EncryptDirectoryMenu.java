package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import static gdi.MakeItSimple.*;
import java.io.*;

import javax.swing.JFileChooser;

public class EncryptDirectoryMenu {

	public static void main(String[] args) {

		File directory = setDirectory();

		if (directory == null) {
			System.out.println("no directory selected");
		} else {
			System.out.print("shift: ");
			int shift = readInt();
			readLine();
			System.out.println();

			CaesarFileEncryptor crypt = new CaesarFileEncryptor(shift);

			System.out.println("1.) encrypt");
			System.out.println("2.) decrypt");

			int i = readInt();
			readLine();

			if (i == 1) {
				try {
					crypt.encrypt(directory);
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			} else if (i == 2) {
				try {
					crypt.decrypt(directory);
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			} else {
				System.out.println("unknown input");
			}
		}
	}

	private static File setDirectory() {

		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("."));
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}

		return null;
	}
}
