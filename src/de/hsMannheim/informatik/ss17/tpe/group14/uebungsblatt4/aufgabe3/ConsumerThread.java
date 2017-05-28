package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

public class ConsumerThread extends Thread {

	private RingpufferThread r;
	private long sleepTime;

	/**
	 * constructor of an Consumer Thread
	 * @param name of the thread
	 * @param ringPuffer the workspace of the thread
	 * @param sleepTime in milliseconds
	 */
	ConsumerThread(String name, RingpufferThread ringPuffer, long sleepTime) {
		this.setName(name);
		this.sleepTime = sleepTime;
		this.r = ringPuffer;
	}

	@Override
	public void run() {
		// if the thread is not interrupted get elements form the workarea
		while (!isInterrupted()) {
			try {
				// print the element of the ringpuffer
				System.out.print(getName() + ": " + this.r.get().toString() + ", ");
				sleep(sleepTime);
			} catch (InterruptedException e) {
				// if it is interrupted the thread has done the work to do
				interrupt();
			}
		}
	}

}
