package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

public class ProducerThread extends Thread {

	private RingpufferThread r;
	private long sleepTime;

	/**
	 * constructor of an Producer Thread that is only produce random Integer
	 * @param name name of the thread
	 * @param ringPuffer the workspace
	 * @param sleepTime the time to sleep after one insert in milliseconds
	 */
	ProducerThread(String name, RingpufferThread ringPuffer, long sleepTime) {
		this.setName(name);
		this.r = ringPuffer;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {
		// if the thread is not interrupted it create new Integer
		while (!isInterrupted()) {
			Integer i = (Integer) (int) (Math.random() * 100) + 0;
			try {
				// put it into the work area
				this.r.put(i);
//				System.out.print(getName() + ": " + i + ", ");
				sleep(this.sleepTime);
			} catch (InterruptedException e) {
				// if it is interrupted the thread has done the work to do
				interrupt();
			}
		}
	}
}
