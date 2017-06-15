package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe2;

import java.util.Iterator;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree.BTree;

public class MyBTreeIterator implements Iterator{
	

	private BTree tree;
	private Comparable value;
	
	public MyBTreeIterator(BTree tree){
		this.tree = tree;
		this.value = tree.getMin();
	}
	

	@Override
	public boolean hasNext() {
		if(!tree.isEmpty()){
			BTree temp = tree.clone();
			temp.remove(value);
			return temp.getMin()!= null;
		} else {
			return false;
		}
		
	}

	@Override
	public Object next() {
		if(tree.isEmpty()){
			System.out.println("The tree is already empty!");
		} else{
			tree.remove(value);
			this.value = tree.getMin();
			return value;
		}
	}
	
	@Override
	public void remove(){
		if(tree.isEmpty()){
			System.out.println("The tree is already empty!");
			return;
		}else{
			tree.remove(value);
		}
	}
	
	public void startIterator(BTree tree){
		MyBTreeIterator it = new MyBTreeIterator(tree);
		for(int i = 0; i < tree.size(); i++){
			System.out.println(it.getValue().toString() + ", ");
			if(it.hasNext()){
				it.next();
			} else{
				return;
			}
		}
	}
	
	public Comparable getValue(){
		return this.value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
