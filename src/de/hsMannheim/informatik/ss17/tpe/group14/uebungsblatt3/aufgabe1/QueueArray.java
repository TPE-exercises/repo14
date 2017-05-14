package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;

public class QueueArray implements Queue, ADT {

	protected Object[] queue;
	protected int num = 0; // number of elements in stack
	protected int flag = 1;

	public QueueArray(int size) {
		queue = new Object[size + 1];
	}

	public QueueArray() {
		// initialize with standard size
		queue = new Object[10 + 1];
	}

	@Override
	public boolean enter(Object o) throws OverflowException {
		// if the insertion object equals null it is not necessary to do anything
		if(o != null){
			try {
				if (size() >= queue.length - 1) {
					throw new OverflowException(o);
				} else {
					queue[num] = o;
					num++;
					return true;
				}
			} catch (OverflowException oe) {
				// the first time the queue will copied
				if (flag == 1) {
					// get the copy of the queue
					Object[] copiedQueue = new Object[((size()) * 2)+1];
					for (int i = 0; i < this.queue.length; i++) {
						copiedQueue[i] = queue[i];
					}
					// the new object have to insert on the next position after copying
					copiedQueue[num] = o;
					num++;
					this.setQueue(copiedQueue);
					flag++;
					return true;
				} else {
					throw oe;
				}
			}
		} else{
			return false;
		}
		
	}

	@Override
	public Object leave() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException();
		} else {
			// get the first element an delete it 
			Object o = this.front();
			for (int i = 0; i < size(); i++) {
				queue[i] = queue[i + 1];
			}
			num--;
			return o;
		}
	}

	@Override
	public Object front() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException();
		} else {
			// get the first element without deleting
			return this.queue[0];
		}
	}

	@Override
	public Queue empty() {
		// new empty queue with initialize size
		return new QueueArray();
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int size() {
		return this.num;
	}

	/**
	 * Get the queue array
	 * 
	 * @return queue array
	 */
	private Object[] getQueue() {
		return this.queue;
	}

	/**
	 * Set an new queue array
	 * 
	 * @param copiedQueue
	 *            the new queue array
	 */
	private void setQueue(Object[] copiedQueue) {
		this.queue = copiedQueue;
	}

}
