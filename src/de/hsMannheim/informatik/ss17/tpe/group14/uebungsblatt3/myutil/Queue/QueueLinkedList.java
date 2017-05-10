package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Queue;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.LinkedList.*;

public class QueueLinkedList implements Queue{
	
	protected LinkedList queue;
	protected int size;
	protected int num = 0;
	
	public QueueLinkedList(int size){
		this.size = size;
		queue = new LinkedList();
	}
	
	public QueueLinkedList(){
		new QueueLinkedList(10);
	}
	

	@Override
	public boolean enter(Object o) throws OverflowException{
		if(size() == size -1){
			throw new OverflowException(o);
		} else {
			queue.addLast(o);
			num++;
			return true;
		}
	}

	@Override
	public Object leave() throws UnderflowException{
		if(this.isEmpty()){
			throw new UnderflowException();
		} else {
			Object o = queue.getFirst();
			queue.removeFirst();
			num--;
			return o;
		}
	}

	@Override
	public Object front() throws UnderflowException{
		if(this.isEmpty()){
			throw new UnderflowException();
		} else {
			return queue.getFirst();
		}
	}

	@Override
	public Queue empty() {
		return new QueueLinkedList();
	}

	@Override
	public boolean isEmpty() {
		if(queue.getFirst() == null){
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
