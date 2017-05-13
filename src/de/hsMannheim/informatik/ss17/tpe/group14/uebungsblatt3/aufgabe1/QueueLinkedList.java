package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.LinkedList.*;

public class QueueLinkedList implements Queue, ADT {

	protected LinkedList queue;
	protected int size;
	protected int num = 0;
	protected int flag = 1;

	public QueueLinkedList(int size) {
		this.size = size;
		this.queue = new LinkedList();
	}

	// standard initialize with 10
	public QueueLinkedList() {
		this.size = 10;
		this.queue = new LinkedList();
	}

	@Override
	public boolean enter(Object o) throws OverflowException {
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
				if (flag == 1) {
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
			Object o = queue.getFirst();
			queue.removeFirst();
			num--;
			return o;
		}
	}

	@Override
	public Object front() throws UnderflowException {
		if (!this.isEmpty()) {
			return this.queue.getFirst();
		} else {
			throw new UnderflowException();
		}
	}

	@Override
	public Queue empty() {
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
