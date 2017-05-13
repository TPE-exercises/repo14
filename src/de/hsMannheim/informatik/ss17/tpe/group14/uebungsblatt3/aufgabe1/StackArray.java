package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;
import static gdi.MakeItSimple.*;

public class StackArray implements Stack, ADT {

	protected Object[] stack;
	protected int num = 0; // number of elements in stack
	protected int flag = 1;

	public StackArray(int size) {
		this.stack = new Object[size];
	}

	public StackArray() {
		// initialize with standard size
		this.stack = new Object[10];
	}

	@Override
	public boolean push(Object o) throws OverflowException {
		if(o != null){
			try {
				if (size() >= stack.length ) {
					throw new OverflowException(o) ;
				} else {
					stack[num] = o;
					num++;
					return true;
				}
			} catch (OverflowException oe) {
				if (flag == 1) {
					Object[] copiedStack = new Object[size() * 2];
					for (int i = 0; i < this.stack.length; i++) {
							copiedStack[i] = stack[i];
					}
					
					copiedStack[num] = o;
					num++;
					this.setStack(copiedStack);
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
	public Object pop() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException();
		} else {
			num--;
			return stack[num];
		}
	}

	@Override
	public Object top() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException();
		} else {
			return stack[num - 1];
		}
	}

	@Override
	public ADT empty() {
		return new StackArray();
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
	 * Get the stack array
	 * 
	 * @return stack array
	 */
	protected Object[] getStack() {
		return this.stack;
	}

	/**
	 * Set an new stack array
	 * 
	 * @param copiedStack
	 *            the new queue array
	 */
	protected void setStack(Object[] stack) {
		this.stack = stack;
	}
	
}
