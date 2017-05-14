package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.LinkedList.*;

public class StackLinkedList implements Stack, ADT {

	protected LinkedList stack;
	protected int size;
	protected int num = 0; // number of elements in stack
	protected int flag = 1;

	public StackLinkedList(int size) {
		this.size = size;
		this.stack = new LinkedList();
	}

	
	public StackLinkedList() {
		// standard initialize with 10
		this.size = 10;
		this.stack = new LinkedList();
	}

	@Override
	public boolean push(Object o) throws OverflowException {
		// if the insertion object equals null it is not necessary to do anything
		if(o != null){
			try {
				if (size() >= size) {
					throw new OverflowException(o);
				} else {
					stack.addFirst(o);
					num++;
					return true;
				}
			} catch (OverflowException oe) {
				// the first time the stack will copied
				if (flag == 1) {
					// double the size of the stack
					this.size = size * 2;
					stack.addFirst(o);
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
	public Object pop() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException();
		} else {
			// get the first element an delete it 
			Object o = stack.getFirst();
			stack.removeFirst();
			num--;
			return o;
		}
	}

	@Override
	public Object top() throws UnderflowException {
		if (this.isEmpty()) {
			throw new UnderflowException();
		} else {
			// get the first element without deleting
			return this.stack.getFirst();
		}
	}

	@Override
	public Stack empty() {
		// new empty stack with initialize size
		return new StackLinkedList();
	}

	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	@Override
	public int size() {
		return this.num;
	}

}
