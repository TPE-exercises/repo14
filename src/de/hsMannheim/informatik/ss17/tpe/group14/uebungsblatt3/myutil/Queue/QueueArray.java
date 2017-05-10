package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Queue;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.*;

public class QueueArray implements Queue{
	
	protected Object [] queue;
	protected int num = 0;
	protected int flag = 1;
	
	
	public QueueArray(int size) {
		queue = new Object[size+1];
	}
	
	public QueueArray(){
		// initialize with standard size
		queue = new Object[10+1];
	}
	

	@Override
	public boolean enter(Object o) throws OverflowException {
		if(size() == queue.length -2 && flag == 2){
			throw new OverflowException(o);
		} else if (size() == queue.length -2 && flag != 2){
			Object[] copiedQueue = new Object[size()*2];
			for(int i = 0; i < this.getQueue().length; i++){
				copiedQueue[i] = queue[i];
			}
			this.setQueue(copiedQueue);
			flag++;
		} else {
			queue[num++] = o;
			return true;
		}
		return false;
	}

	@Override
	public Object leave() throws UnderflowException {
		if(this.isEmpty()){
			throw new UnderflowException();
		} else {
			Object o = this.front();
			for(int i = 0; i < size(); i++){
				queue[i] = queue[i+1];
			}
			num--;
			return o;
		}
	}

	@Override
	public Object front() throws UnderflowException {
		if(this.isEmpty()){
			throw new UnderflowException();
		} else {
			return queue[0];
		}
	}

	@Override
	public Queue empty() {
		return new QueueArray();
	}

	@Override
	public boolean isEmpty() {
		return queue[0] == null;
	}

	@Override
	public int size() {
		return num;
	}
	
	/**
	 * Get the queue array
	 * @return queue array
	 */
	private Object[] getQueue() {
		return this.queue;
	}

	/**
	 * Set an new queue array
	 * @param copiedQueue the new queue array
	 */
	private void setQueue(Object[] copiedQueue) {
		this.queue = copiedQueue;
	}

}
