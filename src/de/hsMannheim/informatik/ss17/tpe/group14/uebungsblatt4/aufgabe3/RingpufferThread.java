package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

public class RingpufferThread {

	private Object[] ringpuffer;
	private int pointerFirst = 0;
	private int pointerLast = 0;
	private int num = 0;

	/**
	 * initial constructor
	 */
	public RingpufferThread() {
		this.ringpuffer = new Object[10]; // standard initialize size
	}

	/**
	 * constructor with specific size
	 */
	public RingpufferThread(int size) {
		this.ringpuffer = new Object[size];
	}

	/**
	 * Put an element in the rigpuffer
	 * @param o element to put in
	 * @return if it works, return true, else return false
	 * @throws InterruptedException
	 */
	public synchronized boolean put(Object o) throws InterruptedException {
		// if the ringpuffer is full of elements the working thread have to wait until there is new space
		while (this.isFull()) {
			wait();
		}
		if(!this.isFull()&& o != null){
			// delete all waiting threads of the waitingqueue and they can coninue working 
			notifyAll();
			// last position in the ringpuffer
			if (this.pointerLast == this.ringpuffer.length) {
				this.pointerLast = 0;
				this.ringpuffer[pointerLast] = o;
				this.pointerLast++;
				this.num++;
				return true;
			} else {
				// any position in the ringpuffer
				this.ringpuffer[pointerLast] = o;
				this.pointerLast++;
				this.num++;
				return true;
			}
		}
		return false;
	}

	/**
	 * get the first object in the ringpuffer
	 * @return the object or wait if the ringpuffer is empty
	 * @throws InterruptedException
	 */
	public synchronized Object get() throws InterruptedException {
		// if the ringpuffer is empty of elements the working thread have to wait until there new elements inside
		while (this.isEmpty()) {
			wait();
		}
		// delete all waiting threads of the waitingqueue and they can coninue working 
		notifyAll();
		// last position in the ringpuffer
		if (this.pointerFirst == this.ringpuffer.length - 1) {
			Object o = this.ringpuffer[pointerFirst];
			this.pointerFirst = 0;
			this.num--;
			return o;
		} else {
			// any other position in the ringpuffer
			Object o = this.ringpuffer[pointerFirst];
			this.pointerFirst++;
			this.num--;
			return o;
		}
	}

	/**
	 * Return if the Ringpuffer is empty or not
	 * @return true if empty, else false
	 */
	public synchronized boolean isEmpty() {
		return num == 0;
	}

	/**
	 * Return if the Ringpuffer is full or not
	 * @return true if full, else false
	 */
	public synchronized boolean isFull() {
		return num == this.ringpuffer.length;
	}
}
