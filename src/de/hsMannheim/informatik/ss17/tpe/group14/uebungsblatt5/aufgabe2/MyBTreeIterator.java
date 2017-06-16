package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree.BTree;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree.MyBTree;

public class MyBTreeIterator implements Iterator {

	private BTree tree;
	private List<Comparable> listOfTree;
	private int pointer;
	private int end;

	public MyBTreeIterator(BTree tree) {
		this.tree = tree;
		this.listOfTree = tree.getAllElements();
		this.pointer = 0;
		this.end = listOfTree.size();
	}

	@Override
	public boolean hasNext() {
		try {
			return (!listOfTree.get(pointer + 1).equals(null));
		} catch (IndexOutOfBoundsException ex) {
			return false;
		}

	}

	@Override
	public Object next() {
		try{
			Comparable value = listOfTree.get(pointer);
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
			tree.delete(listOfTree.get(pointer));
			end--;
			this.listOfTree = this.tree.getAllElements();
		}
	}

	
	public void startIterator() {
		for(int i = 0; i < this.end; i++){
			System.out.print(listOfTree.get(i)+ ", ");
		}	
		System.out.println();
	}

	public static void main(String[] args) {
		
		BTree tree = new MyBTree(2);
		tree.insert(new Integer (11));
		tree.insert(new Integer (19));
		tree.insert(new Integer (12));
		tree.insert(new Integer (1));
		tree.insert(new Integer (0));
		tree.insert(new Integer (67));
		
		MyBTreeIterator it = new MyBTreeIterator(tree);
		it.startIterator();
		
		BTree treeS = new MyBTree(2);
		treeS.insert("Vorlesung");
		treeS.insert("TPE");
		treeS.insert("Freitag");
		treeS.insert("kein Bock");
		treeS.insert("HS");
		treeS.insert("Mannheim");
		
		MyBTreeIterator itS = new MyBTreeIterator(treeS);
		itS.startIterator();
	}

}
