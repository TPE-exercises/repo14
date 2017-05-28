package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe1;

public class RaceConditions extends Thread {

	private static int value = 0;

	@Override
	public void run() {

		for(int i = 0; i < 1000; ++i) {
			// Mehrere Threads k�nnen gleichzeitig die Variable erh�hen 
			value += 1;
			
			try {
				// Schl�ft f�r 1 ms
				sleep(1);
			} catch (InterruptedException e) {
				System.out.println(this.getName() + " interrupted");
				return;
			}
		}
		
		System.out.println("value: " + value);
	}

	public static void main(String[] args) {
		
		RaceConditions rc1 = new RaceConditions();
		rc1.setName("rc1");
		RaceConditions rc2 = new RaceConditions();
		rc2.setName("rc2");
		
		// Startet 2 Threads und die Ausgabe m�sste 2000 sein
		rc1.start();
		rc2.start();
	}
}
