package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Ringpuffer {

	private Object[] ringpuffer;
	private int pointerFirst = 0;
	private int pointerLast = 0;
	private int num = 0;

	public Ringpuffer() {
		this.ringpuffer = new Object[10]; // standard initialize size
	}

	public Ringpuffer(int size) {
		this.ringpuffer = new Object[size];
	}

	public boolean put(Object o) {
		if (o != null) {
			if (this.isFull()) {
				return false;
			} else {
				if (this.pointerLast == this.ringpuffer.length) {
					this.pointerLast = 0;
					this.ringpuffer[pointerLast] = o;
					this.pointerLast++;
					this.num++;
				} else {
					this.ringpuffer[pointerLast] = o;
					this.pointerLast++;
					this.num++;
				}
				return true;
			}
		} else {
			return false;
		}

	}

	public Object get() {
		if (this.isEmpty()) {
			return null;
		} else if (this.pointerFirst == this.ringpuffer.length-1) {
			Object o = this.ringpuffer[pointerFirst];
			this.pointerFirst = 0;
			this.num--;
			return o;
		}else {
			Object o = this.ringpuffer[pointerFirst];
			this.pointerFirst++;
			this.num--;
			return o;
		}

	}

	public boolean isEmpty() {
		return num == 0;
	}

	public boolean isFull() {
		return num == this.ringpuffer.length;
	}

	public static void main(String[] args) {
		Ringpuffer rp = new Ringpuffer();
		assertFalse(rp.isFull());
		assertTrue(rp.isEmpty());
		rp.put(4);
		assertFalse(rp.isEmpty());
		rp = new Ringpuffer(2);
		rp.put(6);
		rp.put(7);
		assertTrue(rp.isFull());
		assertFalse(rp.isEmpty());
		rp.get();
		rp.get();
		assertTrue(rp.isEmpty());
		rp.put(9);
		rp.put(0);
		rp.get();
		assertFalse(rp.isFull());
		rp.put(2);
		assertTrue(rp.isFull());

	}
}
