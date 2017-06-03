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

	public WordCounterWindow() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("WordCounter");

		frame.setLayout(new BorderLayout());

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "word", "count" });
		table = new JTable(model);

		frame.add(new JScrollPane(table), BorderLayout.CENTER);

		JButton selectFileButton = new JButton("Select File");
		selectFileButton.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent action) {
				clearWindow();
				
				File file = setFile();
				if (file == null) {
					JOptionPane.showMessageDialog(null, "No file selected", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						countWords(file);
					} catch (FileNotFoundException e) {
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

	private void countWords(File file) throws FileNotFoundException {
		long start = System.currentTimeMillis();

		Map<String, Integer> wordCounts = new WordCounter(file).getWords();
		List<WordCount> sortedWordCounts = new LinkedList<>();

		for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
			sortedWordCounts.add(new WordCount(entry.getKey(), entry.getValue()));
		}

		Collections.sort(sortedWordCounts);

		// List only 100 words
		if (sortedWordCounts.size() > 100) {
			sortedWordCounts = sortedWordCounts.subList(0, 99);
		}
		
		sortAlphabetical(sortedWordCounts);
		
		long elapsedTime = System.currentTimeMillis() - start;
		elapsedTimeLabel.setText("elapsedTime(ms): " + elapsedTime);
		
		updateTable(sortedWordCounts);
		
		frame.setTitle("WordCounter : " + file.getAbsolutePath());
	}

	private void sortAlphabetical(List<WordCount> wordCounts) {
		Collections.sort(wordCounts, new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				return o1.getWord().compareTo(o2.getWord());
			}

		});
	}
	
	private void updateTable(List<WordCount> wordCounts) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		for(WordCount wordCount : wordCounts) {
			Object[] row = new Object[2];
			row[0] = wordCount.getWord();
			row[1] = wordCount.getCount();
			model.addRow(row);
		}
	}

	private File setFile() {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("."));
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int returnVal = fc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile();
		}

		return null;
	}
	
	private void clearWindow() {
		frame.setTitle("WordCounter");
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		
		elapsedTimeLabel.setText("elapsedTime(ms): ");
	}

	public static void main(String[] args) {
		new WordCounterWindow();
	}
}
