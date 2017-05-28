package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe1;

import java.util.List;
import java.util.ArrayList;

public class PerformanceHazards {

	private final static int THREAD_COUNT = 4;
	private List<String> strings = new ArrayList<String>();

	public PerformanceHazards(List<String> strings) {

		this.strings = strings;
	}

	// Gibt solange Strings zurück bis die List leer ist.
	public String getNextString() throws Exception {

		synchronized (this) {

			if (strings.isEmpty()) {
				throw new Exception("no more Strings available");
			}

			String str = strings.get(strings.size() - 1);
			strings.remove(str);

			return str;
		}
	}

	public boolean isEmpty() {

		return strings.isEmpty();
	}

	public static void main(String[] args) {

		// Erstellt ein paar Strings die ausgegeben werden sollen.
		List<String> strings = new ArrayList<>();
		strings.add("hallo1");
		strings.add("hallo2");
		strings.add("hallo3");
		strings.add("hallo4");
		strings.add("hallo5");
		strings.add("hallo6");
		strings.add("hallo7");
		strings.add("hallo8");
		strings.add("hallo9");
		strings.add("hallo10");
		strings.add("hallo11");
		strings.add("hallo12");
		strings.add("hallo13");
		strings.add("hallo14");
		strings.add("hallo15");
		strings.add("hallo16");
		strings.add("hallo17");
		strings.add("hallo18");
		strings.add("hallo19");
		strings.add("hallo20");
		PerformanceHazards ph = new PerformanceHazards(strings);

		List<Thread> threads = new ArrayList<>();
		// Erstellt die Threads die die Strings ausgeben.
		for (int i = 0; i < THREAD_COUNT; ++i) {
			threads.add(new Thread() {
				@Override
				public void run() {
					while (!ph.isEmpty()) {
						try {
							String s = ph.getNextString();
							synchronized (System.out) {
								System.out.println(s);
							}
						} catch (Exception e) {
							System.out.println(e.getMessage());
							return;
						}
					}
				}
			});
		}

		// Die Zeit für das Ausführen des Programms messen.
		long start = System.currentTimeMillis();

		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				return;
			}
		}

		long end = System.currentTimeMillis();

		// Die Zeit für das Ausführen des Programms wird sich nicht verbessern
		// durch mehrere Threads, da nur jeweils ein Thread ein String lesen
		// kann, analog dazu die Ausgabe.
		System.out.println("time(ms): " + (end - start));
	}
}
