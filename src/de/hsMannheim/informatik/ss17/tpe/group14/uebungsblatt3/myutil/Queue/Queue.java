package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Queue;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.*;

public interface Queue {
	
	/**
	 * Insert an new element in the queue
	 * @param o the object o
	 * @return if the insertion was possible or not
	 * @throws OverflowException 
	 */
	public boolean enter(Object o) throws OverflowException;
	
	/**
	 * Leave the first element of the queue with deleting it
	 * @return the leaved element 
	 * @throws UnderflowException 
	 */
	public Object leave() throws UnderflowException;
	
	/**
	 * Get the first element of the queue without deleting it
	 * @return the first element
	 * @throws UnderflowException 
	 */
	public Object front() throws UnderflowException;
	
	/**
	 * Get an new empty queue
	 * @return new empty queue
	 */
	public Queue empty();
	
	/**
	 * Get if the queue is empty or not
	 * @return if the queue is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * Get the number of elements in the Queue
	 * @return number of elements
	 */
	public int size();

}
