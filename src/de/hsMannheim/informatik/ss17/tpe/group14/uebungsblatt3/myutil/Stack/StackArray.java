package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Stack;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.*;

public class StackArray implements Stack {
	
	protected Object[] stack;
	protected int num; // number of elements in stack
	protected int flag = 1;
	
	public StackArray(int size){
		stack = new Object [size];
	}
	
	public StackArray(){
		// initialize with standard size
		stack = new Object[10];
	}

	@Override
	public boolean push(Object o) throws OverflowException{
		if(num == stack.length-1 && flag == 2){
			throw new OverflowException(o);
		} else if(num == stack.length-1 && flag != 2){
			Object[] copiedStack = new Object[size()*2];
			for(int i = 0; i < this.getStack().length; i++){
				copiedStack[i] = stack[i];
			}
			this.setStack(copiedStack);
			flag++;
			throw new OverflowException(o);
		} else {
			stack[num++] = o;
			return true;
		}
		
	}

	@Override
	public Object pop() throws UnderflowException{
		if(this.isEmpty()){
			throw new UnderflowException();
		} else {
			return stack[--num];
		}
	}

	@Override
	public Object top() throws UnderflowException{
		if(this.isEmpty()){
			throw new UnderflowException();
		} else {
			return stack[num-1];
		}
	}

	@Override
	public Stack empty() {
		return new StackArray();
	}

	@Override
	public boolean isEmpty() {
		return num == 0;
	}

	@Override
	public int size() {
		return num;
	}
	
	protected Object[] getStack(){
		return this.stack;
	}

	protected void setStack(Object[] stack){
		this.stack = stack;
	}
}
