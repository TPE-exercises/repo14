package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt1.queue;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt1.BTreeNode;

public class QueueNode {
	
	private BTreeNode element;
	private QueueNode next;

	/**
	 * @return the value of the current node
	 */
	public BTreeNode getElement() {
		return element;
	}

	/**
	 * @param value the new value of the current node
	 */
	public void setValue(BTreeNode node) {
		this.element = node;
	}

	/**
	 * @return the next element
	 */
	public QueueNode getNext() {
		return next;
	}

	/**
	 * @param next the new next element
	 */
	public void setNext(QueueNode next) {
		this.next = next;
	}

}

