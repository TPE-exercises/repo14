package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {
	
	Stack stackA = new StackArray(3);
	Stack stackLL = new StackLinkedList(3);

	@Test
	public final void push() throws OverflowException{
		// Array Implementation
		try{
			assertEquals(true, stackA.push("Test"));
			assertEquals(true, stackA.push("Tes"));
			assertEquals(true, stackA.push("T"));
			assertEquals(true, stackA.push("e"));
			assertEquals(true, stackA.push("s"));
//			assertFalse(stackA.push(null));
		
		} catch (OverflowException oe){
			assertTrue(true);
		}
		stackA.empty();
		try{
			assertEquals(true, stackA.push(new Integer(4)));
			assertEquals(true, stackA.push(new Integer(4)));
			assertEquals(true, stackA.push(new Integer(3)));
			assertEquals(true, stackA.push(new Integer(2)));
			assertEquals(true, stackA.push(new Integer(2)));
		} catch (OverflowException oe){
			assertTrue(true);
		}
		
		// LinkedList Implementation
		try{
			assertEquals(true, stackLL.push("Test"));
			assertEquals(true, stackLL.push("Test"));
			assertEquals(true, stackLL.push("T"));
			assertEquals(true, stackLL.push("e"));
			assertEquals(true, stackLL.push("s"));
			
		} catch (OverflowException oe){
			assertTrue(true);
		}
		stackLL.empty();
		try{
			assertEquals(true, stackLL.push(new Integer(4)));
			assertEquals(true, stackLL.push(new Integer(4)));
			assertEquals(true, stackLL.push(new Integer(3)));
			assertEquals(true, stackLL.push(new Integer(2)));
			assertEquals(true, stackLL.push(new Integer(2)));
		} catch (OverflowException oe){
			assertTrue(true);
		}
	
	}
	
	@Test
	public final void pop() throws UnderflowException , OverflowException{
		// Array Implementation
		stackA = (Stack)stackA.empty();
		try{
			stackA.push("T");
			stackA.push("e");
			stackA.push("s");
		}catch(OverflowException oe){
			
		}
		
		try{
			assertEquals("s", stackA.pop());
			assertEquals("e", stackA.pop());
			assertEquals("T", stackA.pop());
//			stackA.pop();
		
		} catch(UnderflowException ue){
			assertTrue(true);
		}
		
		
		// Linked List Implementation
		stackLL.empty();
		stackLL.push("T");
		stackLL.push("e");
		stackLL.push("s");
		
		try{
			assertEquals("s", stackLL.pop());
			assertEquals("e", stackLL.pop());
			assertEquals("T", stackLL.pop());
			assertEquals("s", stackLL.pop());
		} catch(UnderflowException ue){
			assertTrue(true);
		}
		
	}
	
	@Test
	public final void top()throws UnderflowException, OverflowException{
		Stack stackA = new StackArray(3);
		Stack stackLL = new StackLinkedList(3);
		
		try{
			stackA.push(new Integer(3));
			assertEquals(3, stackA.top());
			stackA.push(new Integer(12));
			assertEquals(12, stackA.top());
			stackA.pop();
			assertEquals(3, stackA.top());
			stackA.pop();
			stackA.top();
		} catch(UnderflowException oe){
			assertTrue(true);
		}
		
		
	}
	
	@Test
	public final void isEmpty() throws OverflowException{
		
		// Array Implementation
		Stack stackAInteger = new StackArray();
		Stack stackAString = new StackArray();
		
		assertTrue(stackAInteger.isEmpty());
		assertTrue(stackAString.isEmpty());
		stackAInteger.push(new Integer (3));
		stackAString.push("Test");
		assertFalse(stackAInteger.isEmpty());
		assertFalse(stackAString.isEmpty());
		
		// Linked List Implementation
		Stack stackLLInteger = new StackLinkedList();
		Stack stackLLString = new StackLinkedList();
		
		
		assertTrue(stackLLInteger.isEmpty());
		assertTrue(stackLLString.isEmpty());
		stackLLInteger.push(new Integer(3));
		stackLLString.push("Test");
		assertFalse(stackLLInteger.isEmpty());
		assertFalse(stackLLString.isEmpty());

	}
	
	@Test
	public final void empty(){
		stackLL.empty();
		stackA.empty();
		assertTrue(stackLL.isEmpty());
		assertTrue(stackA.isEmpty());
	}
	
	@Test
	public final void size() throws UnderflowException, OverflowException{
		stackLL = (Stack) stackLL.empty();
		stackA = (Stack) stackA.empty();
		
		// Array Implementation
		stackA.push(new Integer (5));
		stackA.push(new Integer (3));
		stackA.push(new Integer (2));
		assertEquals(3, stackA.size());
		stackA.pop();
		assertEquals(2, stackA.size());
		
		stackA = (Stack)stackA.empty();
		assertTrue(stackA.isEmpty());
		stackA.push("Test");
		stackA.push("Affe");
		stackA.push("Vogel");
		assertEquals(3, stackA.size());
		stackA.pop();
		assertEquals(2, stackA.size());
		
		// Linked List Implementation
		stackLL.push(new Integer (5));
		stackLL.push(new Integer (3));
		stackLL.push(new Integer (2));
		assertEquals(3, stackLL.size());
		stackLL.pop();
		assertEquals(2, stackLL.size());
		
		stackLL = (Stack) stackLL.empty();
		stackLL.push("Test");
		stackLL.push("Affe");
		stackLL.push("Vogel");
		assertEquals(3, stackLL.size());
		stackLL.pop();
		assertEquals(2, stackLL.size());
		
	}

}
