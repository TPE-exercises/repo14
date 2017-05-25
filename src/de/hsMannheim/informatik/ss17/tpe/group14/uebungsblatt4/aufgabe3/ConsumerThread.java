package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

public class ConsumerThread extends Thread {

	Ringpuffer r;

	ConsumerThread(Ringpuffer ringPuffer) {
		this.r = ringPuffer;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				Object o = this.r.get();
				if (o == null) {
					try {
						sleep(10);
						System.out.println();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.print(getName() + ": " + o + ", ");
				}
			}
		}
	}
}
