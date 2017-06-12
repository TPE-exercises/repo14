package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree;

import static gdi.MakeItSimple.*;

public class BTreeNode {

	private Comparable[] objects;

	private BTreeNode[] children;

	/**
	 * Constructor to create a new node with given degree
	 * 
	 * @param degree
	 *            is the degree of the node
	 */
	public BTreeNode(int degree) {
		// 2m+1 object in an node
		objects = new Comparable[degree * 2 + 1];
		// 2m+2 children on an node
		children = new BTreeNode[degree * 2 + 2];
	}

	/**
	 * Return the object on the given position
	 * 
	 * @param pos
	 *            the given position
	 * @return the object on the given position
	 * 
	 * @throws GDIException
	 *             if the position is out of range
	 */
	public Comparable getObject(int pos) {
		if (pos < 0 || pos > objects.length - 1) {
			throw new GDIException("pos out of range");
		}

		return objects[pos];
	}

	/**
	 * Return the children node on the given position
	 * 
	 * @param pos
	 *            the given position
	 * @return the children of the node on the given position
	 * 
	 * @throws GDIException
	 *             if the position is out of range
	 */
	public BTreeNode getChildren(int pos) {
		if (pos < 0 || pos > children.length - 1) {
			throw new GDIException("pos out of range");
		}

		return children[pos];
	}

	/**
	 * Set the object on the given position
	 * 
	 * @param pos
	 *            the given position
	 * @param value
	 *            object to set
	 * @throws GDIException
	 *             if the position is out of range
	 */
	public void setObject(int pos, Comparable value) {
		if (pos < 0 || pos > objects.length - 1) {
			throw new GDIException("pos out of range");
		}

		objects[pos] = value;
	}

	/**
	 * Set the children node on the given position
	 * 
	 * @param pos
	 *            the given position
	 * @param node
	 *            the node to set as children
	 * 
	 * @throws GDIException
	 *             if the position is out of range
	 */
	public void setChildren(int pos, BTreeNode node) {
		if (pos < 0 || pos > children.length - 1) {
			throw new GDIException("pos out of range");
		}

		children[pos] = node;
	}

	/**
	 * Return the maximal object count on the node
	 * 
	 * @return maximal node count
	 */
	public int getObjectCount() {
		return objects.length;
	}

	/**
	 * Return the maximal children count on the node
	 * 
	 * @return maximal children count
	 */
	public int getChildrenCount() {
		return children.length;
	}
}
