package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.LinkedList.*;

public class QueueLinkedList implements Queue, ADT {

	protected LinkedList queue;
	protected int size;
	protected int num = 0; // number of elements in stack
	protected int flag = 1;

	public QueueLinkedList(int size) {
		this.size = size;
		this.queue = new LinkedList();
	}

	
	public QueueLinkedList() {
		// standard initialize with 10
		this.size = 10;
		this.queue = new LinkedList();
	}

	@Override
	public boolean enter(Object o) throws OverflowException {
		// if the insertion object equals null it is not necessary to do anything
		if (o != null) {
			try {
				if (size() >= size) {
					throw new OverflowException(o);
				} else {
					this.queue.addLast(o);
					num++;
					return true;
				}
			} catch (OverflowException oe) {
				// the first time the queue will copied
				if (flag == 1) {
					// get the double size of the queue
					this.size = size * 2;
					queue.addLast(o);
					num++;
					flag++;
					return true;
				} else {
					throw oe;
				}
			}
		} else {
			return false;
		}

	}

	@Override
	public Object leave() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException();
		} else {
			// get the first element an delete it 
			Object o = queue.getFirst();
			queue.removeFirst();
			num--;
			return o;
		}
	}

	@Override
	public Object front() throws UnderflowException {
		if (!this.isEmpty()) {
			// get the first element without deleting
			return this.queue.getFirst();
		} else {
			throw new UnderflowException();
		}
	}

	@Override
	public Queue empty() {
		// new empty queue with initialize size
		return new QueueLinkedList();
	}

	@Override
	public boolean isEmpty() {
		return num == 0;
	}

	@Override
	public int size() {
		return this.num;
	}
	
}
