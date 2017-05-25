package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

public class ProducerThread extends Thread {

	Ringpuffer r;

	ProducerThread(Ringpuffer ringPuffer) {
		this.r = ringPuffer;
	}

	@Override
	public void run() {
		while (true) {
			Integer i = (Integer) (int) (Math.random() * 100) + 0;
			synchronized (this) {
				boolean put = this.r.put(i);
				System.out.print(getName() + ": " + i + ", ");
				if (put == false) {
					try {
						sleep(100);
						System.out.println();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
