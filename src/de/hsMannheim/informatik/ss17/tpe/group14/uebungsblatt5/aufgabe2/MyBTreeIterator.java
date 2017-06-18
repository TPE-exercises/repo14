package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree.BTree;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree.MyBTree;

public class MyBTreeIterator implements Iterator<Comparable>{

	private BTree tree; // only for remove()
	private List<Comparable> listOfTree;
	private int pointer;

	/**
	 * Constructor for an iterator, but it is better to use the MyBTree method iterator()
	 * @param tree
	 */
	public MyBTreeIterator(BTree tree) {
		// only if someone want to remove an element at the tree
		this.tree = tree;
		this.listOfTree = tree.getAllElements();
		this.pointer = 0;
	}

	@Override
	public boolean hasNext() {
		try {
			// if the element is not null is in any case an element there
			return (!listOfTree.get(pointer + 1).equals(null));
		} catch (IndexOutOfBoundsException ex) {
			// if on the next position is not an element any more it is necessary to check if the pointer is 
			// already at the last position of the list or not
			if(pointer < listOfTree.size())
				return true;
			else
			return false;
		}
	}

	@Override
	public Comparable next() {
		try{
			// get the value on the position on the pointer
			Comparable value = listOfTree.get(pointer);
			// after getting the current value the pointer go one step further
			// this implementation is necessary because the first element in the list is also needed
			this.pointer++;
			return value;
		} catch(IndexOutOfBoundsException ex){
			throw new NoSuchElementException();
		}			
	}

	@Override
	public void remove() {
		if (tree.isEmpty()) {
			System.out.println("The tree is already empty!");
			return;
		} else {
			// delete the last element
			tree.delete(listOfTree.get(pointer));
			// get an new list to continue working
			this.listOfTree = this.tree.getAllElements();
		}
	}

	/**
	 * start the iteration of the current tree
	 */
	public void startIterator() {
		// print the current tree
		for(int i = 0; i < this.listOfTree.size(); i++){
			System.out.print(listOfTree.get(i)+ ", ");
		}	
		System.out.println();
	}

	public static void main(String[] args) {
		
		MyBTree tree = new MyBTree(2);
		tree.insert(new Integer (11));
		tree.insert(new Integer (19));
		tree.insert(new Integer (12));
		tree.insert(new Integer (1));
		tree.insert(new Integer (0));
		tree.insert(new Integer (67));

		for(Comparable i : tree){
			System.out.print(i + ", ");
		}
	}
}
