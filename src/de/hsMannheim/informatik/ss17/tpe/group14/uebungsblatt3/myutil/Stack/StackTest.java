package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Stack;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.OverflowException;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Exceptions.UnderflowException;

public class StackTest {
	
	Stack stackA = new StackArray(3);
	Stack stackLL = new StackLinkedList(3);

	@Test
	public final void push() throws OverflowException{
		// Array Implementation
		try{
			assertEquals(true, stackA.push("Test"));
//			assertEquals(false, stackA.push("Test"));
			assertEquals(true, stackA.push("T"));
			assertEquals(true, stackA.push("e"));
			assertEquals(true, stackA.push("s"));
			
		} catch (OverflowException oe){
			assertTrue(true);
		}
		stackA.empty();
		try{
			assertEquals(true, stackA.push(new Integer(4)));
//			assertEquals(false, stackA.push(new Integer(4)));
			assertEquals(true, stackA.push(new Integer(3)));
			assertEquals(true, stackA.push(new Integer(2)));
			assertEquals(true, stackA.push(new Integer(2)));
		} catch (OverflowException oe){
			assertTrue(true);
		}
		
		// LinkedList Implementation
		try{
			assertEquals(true, stackLL.push("Test"));
//			assertEquals(false, stackLL.push("Test"));
			assertEquals(true, stackLL.push("T"));
			assertEquals(true, stackLL.push("e"));
			assertEquals(true, stackLL.push("s"));
			
		} catch (OverflowException oe){
			assertTrue(true);
		}
		stackLL.empty();
		try{
			assertEquals(true, stackLL.push(new Integer(4)));
//			assertEquals(false, stackLL.push(new Integer(4)));
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
		stackA.empty();
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
			assertEquals("s", stackA.pop());
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

}
