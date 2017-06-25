package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WordCounterWindow {
	private final JFrame frame = new JFrame();
	private final JTable table;
	private JLabel elapsedTimeLabel = new JLabel("elapsedTime(ms): ");

	/**
	 * Constructor set the window up
	 */
	public WordCounterWindow() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("WordCounter");

		frame.setLayout(new BorderLayout());

		// Set the table model
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "word", "count" });
		table = new JTable(model);

		frame.add(new JScrollPane(table), BorderLayout.CENTER);

		JButton selectFileButton = new JButton("Select File");
		selectFileButton.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 3136482600733766398L;

			// If the button is clicked open the file chooser dialog
			@Override
			public void actionPerformed(ActionEvent action) {
				clearWindow();

				File file = setFile();
				if (file == null) { // No file selected
					JOptionPane.showMessageDialog(null, "No file selected", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						countWords(file);
					} catch (FileNotFoundException e) { // The given File don't
														// exists
						JOptionPane.showMessageDialog(null, "No file selected", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		JPanel panel = new JPanel();
		panel.add(selectFileButton);
		panel.add(elapsedTimeLabel);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Update the Table with the 100 most occurs words in the file
	 * 
	 * @param file
	 *            with the words
	 * @throws FileNotFoundException
	 *             if the file not exists
	 */
	private void countWords(File file) throws FileNotFoundException {
		long start = System.currentTimeMillis();

		Map<String, Integer> wordCounts = new WordCounter(file).getWords();
		List<WordCount> sortedWordCounts = new LinkedList<>();

		for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
			sortedWordCounts.add(new WordCount(entry.getKey(), entry.getValue()));
		}

		// Sort by occur of the words
		Collections.sort(sortedWordCounts, Collections.reverseOrder());

		// List only 100 words
		if (sortedWordCounts.size() > 100) {
			sortedWordCounts = sortedWordCounts.subList(0, 100);
		}

		sortAlphabetical(sortedWordCounts);

		long elapsedTime = System.currentTimeMillis() - start;
		elapsedTimeLabel.setText("elapsedTime(ms): " + elapsedTime);

		updateTable(sortedWordCounts);

		frame.setTitle("WordCounter : " + file.getAbsolutePath());
	}

	/**
	 * Sort the words alphabetical
	 * 
	 * @param wordCounts
	 *            to sort
	 */
	private void sortAlphabetical(List<WordCount> wordCounts) {
		Collections.sort(wordCounts, new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				int val = o1.compareTo(o2);
				
				if(val == -1) {
					val = 1;
				} else if(val == 1) {
					val = -1;
				}
				
				if(val == 0) {
					return o1.getWord().compareTo(o2.getWord());
				}
				
				return val;
			}

		});
	}

	/**
	 * Update the table with the new words
	 * 
	 * @param wordCounts
	 *            the new words
	 */
	private void updateTable(List<WordCount> wordCounts) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (WordCount wordCount : wordCounts) {
			Object[] row = new Object[2];
			row[0] = wordCount.getWord();
			row[1] = wordCount.getCount();
			model.addRow(row);
		}
	}

	/**
	 * Open a file chooser and ask the user to set a file
	 * 
	 * @return the choosen file
	 */
	private File setFile() {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("."));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fc.showSaveDialog(null);
		// File selected?
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}

		return null;
	}

	/**
	 * Reset the window with title, table, and elapsed time label
	 */
	private void clearWindow() {
		frame.setTitle("WordCounter");

		// Remove every row of the table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}

		elapsedTimeLabel.setText("elapsedTime(ms): ");
	}

	public static void main(String[] args) {
		new WordCounterWindow();
	}
}
