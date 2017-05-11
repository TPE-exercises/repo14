package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.LinkedList.*;

public class StackLinkedList implements Stack, ADT {

	protected LinkedList stack;
	protected int size;
	protected int num = 0;
	protected int flag = 1;

	public StackLinkedList(int size) {
		this.size = size;
		this.stack = new LinkedList();
	}

	public StackLinkedList() {
		this.size = 10;
		this.stack = new LinkedList();
	}

	@Override
	public boolean push(Object o) throws OverflowException {
		if(o != null){
			try {
				if (size() >= size - 1) {
					throw new OverflowException(o.toString());
				} else {
					stack.addFirst(o);
					num++;
					return true;
				}
			} catch (OverflowException oe) {
				if (flag == 1) {
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
			return stack.getFirst();
		}
	}

	@Override
	public ADT empty() {
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
