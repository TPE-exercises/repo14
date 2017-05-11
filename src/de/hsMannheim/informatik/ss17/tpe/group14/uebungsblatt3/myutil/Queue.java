package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil;

public interface Queue extends ADT{

	/**
	 * Insert an new element in the queue
	 * 
	 * @param o
	 *            the object o
	 * @return if the insertion was possible or not
	 * @throws OverflowException
	 */
	public boolean enter(Object o) throws OverflowException;

	/**
	 * Leave the first element of the queue with deleting it
	 * 
	 * @return the leaved element
	 * @throws UnderflowException
	 */
	public Object leave() throws UnderflowException;

	/**
	 * Get the first element of the queue without deleting it
	 * 
	 * @return the first element
	 * @throws UnderflowException
	 */
	public Object front() throws UnderflowException;

}
