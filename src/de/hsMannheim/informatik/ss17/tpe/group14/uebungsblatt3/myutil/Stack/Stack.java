package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Stack;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.OverflowException;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.UnderflowException;

public interface Stack {
	
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
	
	/**
	 * Get an new empty stack
	 * @return new empty stack
	 */
	public Stack empty();
	
	/**
	 * Get if the stack is empty or not
	 * @return if the stack is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * Get the number of elements in the Queue
	 * @return number of elements
	 */
	public int size();

}
