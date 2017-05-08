package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3;

import java.io.*;

public class CaesarFileEncryptor implements IFileEncryptor {

	private final int shift;

	private enum Manipulation {
		ENCRYPT, DECRYPT
	};

	public CaesarFileEncryptor(int shift) {

		this.shift = shift;
	}

	@Override
	public File encrypt(File sourceDirectory) throws IOException {

		if (!sourceDirectory.isDirectory()) {
			throw new IllegalArgumentException("Given file is not a directory");
		}

		File encryptedDirectory = createDirectory(sourceDirectory.getAbsolutePath() + "_encrypted");

		if (encryptedDirectory == null) {
			throw new IOException("Can not create a encrypted directory");
		}

		copyDirectory(sourceDirectory, encryptedDirectory, Manipulation.ENCRYPT);

		return encryptedDirectory;
	}

	@Override
	public File decrypt(File sourceDirectory) throws IOException {

		if (!sourceDirectory.isDirectory()) {
			throw new IllegalArgumentException("Given file is not a directory");
		}

		String dir = sourceDirectory.getAbsolutePath() + "_decrypted";

		File decryptedDirecory = createDirectory(dir);
		
		copyDirectory(sourceDirectory, decryptedDirecory, Manipulation.DECRYPT);

		return decryptedDirecory;
	}

	private void copyDirectory(File directory, File encryptedDirectory, Manipulation manipulation) {

		// encrypt all files of the directory
		for (File file : directory.listFiles()) {

			// we encrypt only text files
			if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {

				// create the same file in the encrypted directory
				File encryptedFile = new File(encryptedDirectory.getAbsolutePath() + "\\" + file.getName());
				try {
					copyFile(file, encryptedFile, manipulation);
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}

		// go through every directory and encrypt the text files to
		for (File dir : directory.listFiles()) {

			if (dir.isDirectory()) {
				// create the same file ion the encrypted directory
				String directoryFullPath = encryptedDirectory.getPath() + "\\" + dir.getName();
				File newDirectory = new File(directoryFullPath);

				if (!newDirectory.mkdir()) {
					System.out.println("cannot create " + directoryFullPath);
				} else {
					copyDirectory(dir, newDirectory, manipulation);
				}
			}
		}
	}

	private void copyFile(File input, File output, Manipulation manipulation) throws IOException {

		BufferedReader reader;
		PrintWriter writer;

		if (manipulation == Manipulation.ENCRYPT) {
			reader = new BufferedReader(new FileReader(input));
			writer = new PrintWriter(new CaesarWriter(new FileWriter(output), shift));
		} else {
			reader = new BufferedReader(new CaesarReader(new FileReader(input), shift));
			writer = new PrintWriter(new FileWriter(output));
		}

		for (String buffer; (buffer = reader.readLine()) != null;) {
			writer.println(buffer);
		}

		reader.close();
		writer.close();
	}

	private File createDirectory(String fullPath) throws IOException {

		File directory = new File(fullPath);
		
		if (!directory.exists() && directory.mkdir()) {
			return directory;
		}
		

		for (int i = 1; i < Integer.MAX_VALUE; ++i) {
			directory = new File(fullPath + "(" + i + ")");

			if (!directory.exists() && directory.mkdir()) {
				return directory;
			}
		}

		return null;
	}
}
