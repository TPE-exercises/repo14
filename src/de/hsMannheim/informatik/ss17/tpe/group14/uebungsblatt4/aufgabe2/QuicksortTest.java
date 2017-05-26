package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe2;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuicksortTest {

	@Test
	public final void quicksortSequentiell() {
		Integer[] array = {44, 6, 55, 30, 94, 18};
		QuicksortSequentiell qsS = new QuicksortSequentiell();
		qsS.sort(array);
		String s = "6, 18, 30, 44, 55, 94, ";
		assertEquals(s, qsS.toString());
	}
	
	@Test
	public final void quicksortParallel(){
		Integer[] array = {44, 6, 55, 30, 94, 18};
		QuicksortParallel qsP = new QuicksortParallel();
		qsP.sort(array);
		String s = "6, 18, 30, 44, 55, 94, ";
		assertEquals(s, qsP.toString(array));
	}
	
		

}
