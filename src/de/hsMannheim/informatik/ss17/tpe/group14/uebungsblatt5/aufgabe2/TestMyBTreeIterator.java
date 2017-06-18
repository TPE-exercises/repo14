package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.aufgabe2;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree.*;

public class TestMyBTreeIterator {
	
	private MyBTree tree = new MyBTree(2);
	private Iterator<Comparable> it = tree.iterator();

	@Test
	public final void hasNext() {
		assertFalse(it.hasNext());
		tree.insert(new Integer (19));
		tree.insert(new Integer (1));
		tree.insert(new Integer (20));
		tree.insert(new Integer (13));
		it = tree.iterator();
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
		it = tree.iterator();
		assertEquals("19",it.next().toString());
		tree.insert(new Integer (1));
		it = tree.iterator();
		assertEquals("1", it.next().toString());
	}
	
	@Test
	public final void remove(){
		tree.insert(new Integer(19));
		tree.insert(new Integer (1));
		it = tree.iterator();
		it.remove();
		assertTrue("19".equals(it.next().toString()));
	}
	
	@Test 
	public final void foreachLoopWithElements(){
		tree.insert(new Integer(19));
		tree.insert(new Integer(1));
		tree.insert(new Integer(10));
		tree.insert(new Integer(12));
		int loopCounter = 0;
		
		for(Comparable i : tree){
			System.out.print(i + ", ");
			loopCounter++;
		}
		assertEquals(4,loopCounter);
		
	}
}
