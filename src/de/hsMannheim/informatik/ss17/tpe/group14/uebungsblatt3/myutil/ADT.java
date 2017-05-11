package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil;

public interface ADT {
	
	/**
	 * Get an new empty ADT
	 * 
	 * @return new empty ADT
	 */
	public ADT empty();

	/**
	 * Get if the ADT is empty or not
	 * 
	 * @return if the ADT is empty or not
	 */
	public boolean isEmpty();
	
	/**
	 * Get the number of elements in the ADT
	 * 
	 * @return number of elements
	 */
	public int size();

}
