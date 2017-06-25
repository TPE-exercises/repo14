package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt6;

import java.util.ArrayList;
import java.util.List;

public class Box<E extends Comparable<? super E>> implements Comparable<E>{
	private E element;
	
	public Box(E element) {
		this.setElement(element);
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public int compareTo(E o) {
		return element.compareTo(o);
	}
	
	public static void main(String[] args) {
		List<Box<Integer>> boxs = new ArrayList<>();
		
		boxs.add(new Box<Integer>(12));
		boxs.add(new Box<Integer>(11));
		boxs.add(new Box<Integer>(10));
		boxs.add(new Box<Integer>(15));
		boxs.add(new Box<Integer>(14));
		boxs.add(new Box<Integer>(33));
		boxs.add(new Box<Integer>(1));
		
		for(Box<Integer> box : boxs) {
			System.out.println(box.getElement());
		}
	}
}
