package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

import static org.junit.Assert.*;

import org.junit.Test;

public class RingpufferTest {

	Ringpuffer rp = new Ringpuffer();
	
	@Test
	public final void put(){
		
		assertTrue(rp.put(1));
		assertTrue(rp.put(3));
	}
	
	@Test
	public final void get(){
		rp.put(1);
		rp.put(3);
		assertEquals(1, rp.get());
		assertEquals(3, rp.get());
		
	}
	
	@Test
	public final void fullOrEmpty(){
		assertFalse(rp.isFull());
		assertTrue(rp.isEmpty());
		rp.put(4);
		assertFalse(rp.isEmpty());
		rp = new Ringpuffer(2);
		rp.put(6);
		rp.put(7);
		assertTrue(rp.isFull());
		assertFalse(rp.isEmpty());
		rp.get();
		rp.get();
		assertTrue(rp.isEmpty());
		rp.put(9);
		rp.put(0);
		assertEquals(9, rp.get());
		assertFalse(rp.isFull());
		rp.put(2);
		assertTrue(rp.isFull());
	}

}
