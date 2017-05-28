package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe1;

public class Starvation {

	private String s = "Hallo";

	private class Thread1 extends Thread {
		@Override
		public void run() {
			while (true) {
				synchronized (s) {
					// Blockiert s für eine lange Zeit.
					try {
						for (int i = 0; i < 10; ++i) {
							System.out.println(s + " : " + getName());
							sleep(100);
						}
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
						return;
					}
				}
				// Macht eine pause damit der andere Thread überhaupt die Chance
				// hat zu laufen.
				System.out.println(getName() + ": pause");
			}
		}
	}

	private class Thread2 extends Thread {
		@Override
		public void run() {
			while (true) {
				synchronized (s) {
					// Sollte jede 50 ms den Text ausgeben doch bekommt nicht
					// genug Laufzeit durch den anderen Thread
					System.out.println(s + " : " + getName());
				}
				try {
					sleep(50);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread1 t1 = new Starvation().new Thread1();
		Thread2 t2 = new Starvation().new Thread2();

		t1.start();
		t2.start();
	}
}
