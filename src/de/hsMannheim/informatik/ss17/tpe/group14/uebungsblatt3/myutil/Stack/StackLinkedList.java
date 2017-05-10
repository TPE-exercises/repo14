package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Stack;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.LinkedList.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.*;

public class StackLinkedList implements Stack {
	
	LinkedList stack;
	protected int size;
	protected int num = 0;

	public StackLinkedList(int size){
		this.size = size;
		stack = new LinkedList();
	}
	
	public StackLinkedList() {
		new StackLinkedList(10);
	}
	
	@Override
	public boolean push(Object o) throws OverflowException{
		if(size() == size -1 ){
			throw new OverflowException(o);
		} else {
			stack.addFirst(o);
			num++;
			return true;
		}
	}

	@Override
	public Object pop() throws UnderflowException{
		if(this.isEmpty()){
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
		if(this.isEmpty()){
			throw new UnderflowException();
		} else {
			return stack.getFirst();
		}
	}

	@Override
	public Stack empty() {
		return new StackLinkedList();
	}

	@Override
	public boolean isEmpty() {
		if(stack.getFirst() == null){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return num;
	}

}
