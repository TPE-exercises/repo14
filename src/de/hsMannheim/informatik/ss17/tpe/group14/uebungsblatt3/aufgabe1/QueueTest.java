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
			assertTrue(queueLL.enter(new Integer(1)));
			assertTrue(queueLL.enter(new Integer(2)));
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

}
