package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import static org.junit.Assert.*;
import org.junit.Test;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;

public class QueueTest {

	Queue queueA = new QueueArray(3);
	Queue queueLL = new QueueLinkedList(3);

	@Test
	public final void enter() {
		// Array Implementation
		try {
			assertTrue(queueA.enter("A"));
			assertTrue(queueA.enter("B"));
			assertFalse(queueA.enter(null));
			assertTrue(queueA.enter("C"));
			assertTrue(queueA.enter("D"));
			assertTrue(queueA.enter("E"));
			assertTrue(queueA.enter("F"));
			assertTrue(queueA.enter("G"));

		} catch (OverflowException oe) {
			assertTrue(true);
		}

		// Linked List Implementation
		try {
			assertTrue(queueLL.enter("A"));
			assertTrue(queueLL.enter("B"));
			assertFalse(queueA.enter(null));
			assertTrue(queueLL.enter("C"));
			assertTrue(queueLL.enter("D"));
			assertTrue(queueLL.enter("E"));
			assertTrue(queueLL.enter("F"));
			assertTrue(queueLL.enter("G"));

		} catch (OverflowException oe) {
			assertTrue(true);
		}
		
		try{
			assertTrue(queueLL.enter(new Integer(2)));
		} catch (OverflowException oe){
			assertTrue(true);
		}

	}
	
	@Test
	public final void leave() {
		queueA = (Queue) queueA.empty();
		queueLL = (Queue) queueLL.empty();

		// Array Implementation
		try {
			assertTrue(queueA.enter(new Integer(1)));
			assertTrue(queueA.enter(new Integer(2)));
			assertEquals(1, queueA.leave());
			assertTrue(queueA.enter(new Integer(3)));
			assertTrue(queueA.enter(new Integer(4)));
			assertEquals(2, queueA.leave());

		} catch (OverflowException oe) {
			assertTrue(true);
		} catch (UnderflowException ue) {
			assertTrue(true);
		}

		// Linked List Implementation
		try {
			assertTrue(queueLL.enter(new Integer(1)));
			assertTrue(queueLL.enter(new Integer(2)));
			assertEquals(1, queueLL.leave());
			assertTrue(queueLL.enter(new Integer(3)));
			assertTrue(queueLL.enter(new Integer(4)));
			assertEquals(2, queueLL.leave());

		} catch (OverflowException oe) {
			assertTrue(true);
		} catch (UnderflowException ue) {
			assertTrue(true);
		}
	}
	
	@Test
	public final void front(){
		queueA = (Queue) queueA.empty();
		queueLL = (Queue) queueLL.empty();
		
		// Array Implementation
		try {
			assertTrue(queueA.enter(new Integer(1)));
			assertTrue(queueA.enter(new Integer(2)));
			assertEquals(1, queueA.front());
			assertTrue(queueA.enter(new Integer(3)));
			assertTrue(queueA.enter(new Integer(4)));
			assertEquals(1, queueA.front());

		} catch (OverflowException oe) {
			assertTrue(true);
		} catch (UnderflowException ue) {
			assertTrue(true);
		}

		// Linked List Implementation
		try {
			queueLL.enter(null);
			queueLL.enter(new Integer(1));
			queueLL.enter(new Integer(7));
			assertEquals(1, queueLL.front());
			assertTrue(queueLL.enter(new Integer(3)));
			assertTrue(queueLL.enter(new Integer(4)));
			assertEquals(1, queueLL.front());

		} catch (OverflowException oe) {
			assertTrue(true);
		} catch (UnderflowException ue) {
			assertTrue(true);
		}
	}
	
	@Test
	public final void isEmpty(){
		queueA = (Queue) queueA.empty();
		queueLL = (Queue) queueLL.empty();
		
		assertTrue(queueA.isEmpty());
		assertTrue(queueLL.isEmpty());
		try {
			queueA.enter(null);
			queueLL.enter(null);
		} catch (OverflowException oe){
			assertTrue(true);
		}
		
		assertTrue(queueA.isEmpty());
		assertTrue(queueLL.isEmpty());
		
		try {
			queueA.enter(new Integer(5));
			queueLL.enter(new Integer(12));
		} catch (OverflowException oe){
			assertTrue(true);
		}
		assertFalse(queueA.isEmpty());
		assertFalse(queueLL.isEmpty());
	}
	
	@Test
	public final void empty(){
		queueA = (Queue) queueA.empty();
		queueLL = (Queue) queueLL.empty();
		
		assertTrue(queueA.isEmpty());
		assertTrue(queueLL.isEmpty());
	}

	@Test
	public final void size(){
		assertEquals(0, queueA.size());
		assertEquals(0, queueLL.size());
		
		try {
			queueA.enter(new Integer(5));
			queueLL.enter(new Integer(12));
			assertEquals(1, queueA.size());
			assertEquals(1, queueLL.size());
			queueA.enter(null);
			queueLL.enter(null);
			assertEquals(1, queueA.size());
			assertEquals(1, queueLL.size());
			queueA.enter(new Integer(8));
			queueA.enter(new Integer(5));
			queueA.enter(new Integer(7));
			queueLL.enter(new Integer(8));
			assertEquals(4, queueA.size());
			assertEquals(2, queueLL.size());
			queueLL.enter(new Integer(6));
			queueLL.enter(new Integer(9));
			queueLL.enter(new Integer(0));
			assertEquals(4, queueA.size());
			assertEquals(5, queueLL.size());
			queueA.leave();
			queueLL.leave();
			assertEquals(3, queueA.size());
			assertEquals(4, queueLL.size());
		} catch (OverflowException oe){
			assertTrue(true);
		} catch (UnderflowException ue){
			assertTrue(true);
		}
			
	}
}
