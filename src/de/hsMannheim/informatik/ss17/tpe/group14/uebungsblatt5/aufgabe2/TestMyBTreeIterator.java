package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe2;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree.*;

public class TestMyBTreeIterator {
	
	private BTree tree = new MyBTree(2);
	private MyBTreeIterator it = new MyBTreeIterator(tree);

	@Test
	public final void hasNext() {
		assertFalse(it.hasNext());
		tree.insert(new Integer (19));
		tree.insert(new Integer (1));
		tree.insert(new Integer (20));
		tree.insert(new Integer (13));
		it = new MyBTreeIterator(tree);
		assertTrue(it.hasNext());
		it.remove();
		it.remove();
		it.remove();
		it.remove();
		assertFalse(it.hasNext());
	}
	
	@Test
	public final void next(){
		tree.insert(new Integer(19));
		it = new MyBTreeIterator(tree);
		assertEquals("19",it.next().toString());
		tree.insert(new Integer (1));
		it = new MyBTreeIterator(tree);
		assertEquals("1", it.next().toString());
	}
	
	@Test
	public final void remove(){
		tree.insert(new Integer(19));
		tree.insert(new Integer (1));
		it = new MyBTreeIterator(tree);
		it.remove();
		assertTrue("19".equals(it.next().toString()));
		
	}

}