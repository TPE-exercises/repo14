package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil;

public interface Stack extends ADT{
	
	/**
	 * Insert an element in the stack
	 * @param o the object for insertion
	 * @return if the insertion was possible or not
	 * @throws OverflowException 
	 */
	public boolean push(Object o) throws OverflowException;
	
	/**
	 * Get the first element of the stack with deleting
	 * @return the first element
	 * @throws UnderflowException 
	 */
	public Object pop() throws UnderflowException;
	
	/**
	 * Get the first element of the stack without deleting
	 * @return the first element
	 * @throws UnderflowException 
	 */
	public Object top() throws UnderflowException;
	

}
