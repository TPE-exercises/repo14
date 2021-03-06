package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt1;

import static gdi.MakeItSimple.*;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt1.list.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt1.queue.*;

public class MyBTree implements BTree {

	private final int degree;
	private BTreeNode root;

	/**
	 * Constructor of the BTree
	 * 
	 * @param degree
	 *            set the degree of the BTree
	 * 
	 * @throws GDIException
	 *             if the degree is not an natural number
	 */
	public MyBTree(int degree) {
		if (degree < 1) {
			throw new GDIException("degree is not an natural number");
		}

		this.degree = degree;
	}

	@Override
	public boolean insert(Integer object) {
		if (object == null) {
			throw new GDIException("The given object is null");
		}

		if (isEmpty()) {
			root = new BTreeNode(degree);
			root.setValue(0, object);
			return true;
		} else {
			return insertRecursive(object, root);
		}
	}

	private boolean insertRecursive(Integer object, BTreeNode node) {
		for (int i = 0; i < node.getValuesCount(); ++i) {
			if (node.getValue(i) == null || node.getValue(i).compareTo(object) > 0) {
				if (node.getChildren(i) == null) {
					// We can just add it to the node
					insertToNode(object, node, i);

					if (isNodeBursted(node)) {
						split(node);
					}

					return true;
				} else {
					// There is an deeper node
					return insertRecursive(object, node.getChildren(i));
				}
			} else if (node.getValue(i).equals(object)) {
				// The same object is already in the tree
				return false;
			}
		}

		throw new GDIException("The node is full, there is someting wrong on the logic");
	}

	private boolean isNodeBursted(BTreeNode node) {
		// If the node has an object on 2m+1 the node is bursted
		return node.getValue(node.getValuesCount() - 1) != null;
	}

	private void insertToNode(Integer object, BTreeNode node, int pos) {
		// Is an object already on this position?
		if (node.getValue(pos) == null) {
			// We can just add it to the given position
			node.setValue(pos, object);
		} else {
			// Jump to the second last position and move all values than bigger
			// as our object one to the right to make space for the new object
			for (int i = node.getValuesCount() - 2; i >= pos; --i) {
				node.setValue(i + 1, node.getValue(i));
				node.setChildren(i + 2, node.getChildren(i + 1));

				if (i == 0) {
					// The first children has to be moved also if the inserted
					// Value is the smallest in the node
					node.setChildren(1, node.getChildren(1));
				}
			}
			// Set the object to the right position
			node.setValue(pos, object);
		}
	}

	private void split(BTreeNode node) {
		BTreeNode leftNode = new BTreeNode(degree);
		BTreeNode rightNode = new BTreeNode(degree);

		if (node == root) {
			BTreeNode newRoot = new BTreeNode(degree);

			// Add the object in the middle to the new root
			newRoot.setValue(0, root.getValue(degree));

			newRoot.setChildren(0, leftNode);
			newRoot.setChildren(1, rightNode);

			// Split the root objects into two new nodes
			splitIntoNodes(node, leftNode, rightNode);

			root = newRoot;
		} else {
			BTreeNode motherNode = findMotherNode(root, node);

			if (motherNode == null) {
				throw new GDIException("no mother node found");
			}

			// Find the right position to insert the object in the middle
			for (int i = 0; i < motherNode.getValuesCount(); ++i) {
				if (motherNode.getChildren(i) == node) {
					insertToNode(node.getValue(degree), motherNode, i);
					motherNode.setChildren(i, leftNode);
					motherNode.setChildren(i + 1, rightNode);
				}
			}

			// Split the root objects into two new nodes
			splitIntoNodes(node, leftNode, rightNode);

			// We have to split again if the mother node is bursted to
			if (isNodeBursted(motherNode)) {
				split(motherNode);
			}
		}
	}

	private void splitIntoNodes(BTreeNode node, BTreeNode leftNode, BTreeNode rightNode) {
		// Split the objects from the root into two new nodes
		for (int i = 0; i < degree; ++i) {
			leftNode.setValue(i, node.getValue(i));
			leftNode.setChildren(i, node.getChildren(i));
			rightNode.setValue(i, node.getValue(degree + 1 + i));
			rightNode.setChildren(i + 1, node.getChildren(degree + 2 + i));
		}

		// The children m and m+1 are between the object for the new root
		leftNode.setChildren(degree, node.getChildren(degree));
		rightNode.setChildren(0, node.getChildren(degree + 1));
	}

	private BTreeNode findMotherNode(BTreeNode node, BTreeNode children) {
		if (node == null) {
			return null;
		}

		// Search in all children of the node to identify the mother node
		for (int i = 0; i < node.getChildrenCount(); ++i) {
			// We have found the mother node
			if (node.getChildren(i) == children) {
				return node;
			} else {
				// We have to search also children of the children of the node
				BTreeNode motherNode = findMotherNode(node.getChildren(i), children);

				// We have found the mother node
				if (motherNode != null) {
					return motherNode;
				}
			}
		}

		// Mother node not found in this branch
		return null;
	}

	@Override
	public boolean insert(String filename) {
		// Check if the file exist if not there is nothing to insert
		if (!isFilePresent(filename)) {
			// File not exist
			return false;
		}

		Object file = openInputFile(filename);

		// Insert all values from the file in the current tree
		while (!isEndOfInputFile(file)) {
			int value = readInt(file);
			insert(value);
		}
		closeInputFile(file);

		return true;
	}

	@Override
	public boolean contains(Integer object) {
		return containsRecursive(object, root);
	}

	private boolean containsRecursive(Integer object, BTreeNode node) {
		// The object is not in the tree
		if (node == null) {
			return false;
		}

		// Check every value in the node until 2m - the last object in the node
		// is null
		for (int i = 0; i < node.getChildrenCount() - 1; ++i) {
			if (node.getValue(i) == null || node.getValue(i).compareTo(object) > 0) {
				// We have to go deeper in the tree
				return containsRecursive(object, node.getChildren(i));
			} else if (node.getValue(i).equals(object)) {
				// We found the object in the tree
				return true;
			}
		}

		// The last object is null so we have to search on link 2m
		return containsRecursive(object, node.getChildren(2 * degree));
	}

	@Override
	public int size() {
		BTreeNode node = root;
		int size = 0;
		// Tree is empty
		if (node == null) {
			return size;
		} else {
			// Save all nodes in a queue to count all nodesizes and the sum of
			// them are the treesize
			Queue queue = new Queue();
			queue.enter(node);
			while (!queue.isEmpty()) {
				node = queue.leave();
				size += countElementsInNode(node);
				for (int i = 0; i < node.getValuesCount(); i++) {
					if (node.getChildren(i) != null) {
						queue.enter(node.getChildren(i));
					} else {
						if (node.getChildren(i) != null)
							queue.enter(node.getChildren(++i));
					}
				}
			}
		}
		return size;
	}

	private int countElementsInNode(BTreeNode node) {
		int elementsInNode = 0;
		// Count all elements in the node
		for (int i = 0; i < node.getValuesCount(); i++) {
			if (node.getValue(i) != null) {
				elementsInNode++;
			}
		}
		return elementsInNode;
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(BTreeNode node) {
		if (node == null)
			return 0;
		else {
			return 1 + height(node.getChildren(0));
		}
	}

	@Override
	public Integer getMax() {
		BTreeNode node = root;
		// Tree is empty
		if (node == null) {
			throw new GDIException("the tree is empty");
		} else {
			Integer value = 0;
			// Check if we are on a leaf of the tree
			boolean onLeaf = false;
			// Search in every node for the biggest element an the children of
			// it
			for (int i = 0; i < node.getValuesCount() && onLeaf == false; i++) {
				if (node.getValue(i) == null || i == node.getValuesCount() - 1) {
					// Node is full of element, the max is in the right node of
					// it
					if (node.getChildren(i) != null) {
						node = node.getChildren(i);
						i = 0;
						// The node is not full of elements, we step back to get
						// The right child
					} else if (node.getChildren(i - 1) != null) {
						node = node.getChildren(i - 1);
						i = 0;
						// On the right leaf and get the maximal element
					} else {
						value = node.getValue(i - 1);
						onLeaf = true;

					}
				}
			}
			return value;
		}
	}

	@Override
	public Integer getMin() {
		BTreeNode node = root;
		// Empty tree
		if (node == null) {
			throw new GDIException("the tree is empty");
		}
		// Search for the value at the smallest value on the left side in the
		// tree
		while (node.getChildren(0) != null) {
			node = node.getChildren(0);
		}
		return node.getValue(0);
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void addAll(BTree otherTree) {
		MyLinkedList objects = otherTree.getAllElements();

		for (int i = 0; i < objects.size(); ++i) {
			insert(objects.get(i));
		}
	}

	@Override
	public void printInorder() {
		printInorder(root);

	}

	// Recursive method for inorder
	private void printInorder(BTreeNode node) {
		if (node == null) {
			return;
		} else {
			for (int i = 0; i < node.getValuesCount(); i++) {
				// Get the children of one element
				if (node.getChildren(i) != null)
					printInorder(node.getChildren(i));
				// Get the element
				if (node.getValue(i) != null) {
					print(node.getValue(i) + ", ");
				}

			}
		}
	}

	@Override
	public void printPostorder() {
		printPostorder(root);
	}

	// Recursive method for postorder
	private void printPostorder(BTreeNode node) {
		if (node == null) {
			return;
		} else {
			for (int i = 0; i < node.getValuesCount(); i++) {
				// Get the children
				if (node.getChildren(i) != null)
					printPostorder(node.getChildren(i));
			}
			// Get the full node
			printNode(node);
		}
	}

	@Override
	public void printPreorder() {
		printPreorder(root);
	}

	// Recursive method for preorder
	private void printPreorder(BTreeNode node) {
		if (node == null) {
			return;
		} else {
			for (int i = 0; i < node.getValuesCount(); i++) {
				// Get the element between two children
				if (node.getValue(i) != null)
					print(node.getValue(i) + ", ");
				// Get the cildren of an element
				if (node.getChildren(i) != null)
					printPreorder(node.getChildren(i));
			}
		}
	}

	@Override
	public void printLevelorder() {
		printLevelorder(root);

	}

	// Recursive method for levelorder
	private void printLevelorder(BTreeNode node) {

		if (node == null) {
			return;
		} else {
			BTreeNode temp = node;
			Queue queue = new Queue();
			queue.enter(node);
			// The tree is not empty while the queue is not empty
			while (!queue.isEmpty()) {
				temp = queue.leave();
				// Print the current node
				printNode(temp);
				for (int i = 0; i < temp.getValuesCount(); i++) {
					// Get the children
					if (temp.getChildren(i) != null) {
						queue.enter(temp.getChildren(i));
					} else {
						if (temp.getChildren(i) != null)
							// Enter the right child of the node
							queue.enter(temp.getChildren(++i));
					}
				}
			}
		}

	}

	// Print the full Node
	private void printNode(BTreeNode node) {
		for (int i = 0; i < node.getValuesCount(); i++) {
			// Mark the beginning of an node
			if (i == 0)
				print("(");
			if (node.getValue(i) != null) {
				Integer value = node.getValue(i);
				print(value);
				if (node.getValue(i + 1) != null)
					print(" ,");
			}
			// Mark the end of an node
			if (i == node.getValuesCount() - 1)
				print(")");
		}
	}

	@Override
	public MyLinkedList getAllElements() {
		MyLinkedList list = new MyLinkedList();

		// Insert all objects to the list
		getAllElementsRecursive(list, root);

		return list;
	}

	private void getAllElementsRecursive(MyLinkedList list, BTreeNode node) {
		if (node == null) {
			return;
		}

		// Add all objects to the list
		for (int i = 0; i < node.getValuesCount(); ++i) {
			if (node.getValue(i) != null) {
				list.addLast(node.getValue(i));
			}
		}

		// Go one level deeper in the tree
		for (int i = 0; i < node.getChildrenCount(); ++i) {
			getAllElementsRecursive(list, node.getChildren(i));
		}

	}

	/**
	 * Return a deep copy of the tree
	 * 
	 * @return MyBTree a copy of the tree
	 */
	@Override
	public MyBTree clone() {
		MyLinkedList objects = getAllElements();

		MyBTree tree = new MyBTree(degree);

		for (int i = 0; i < objects.size(); ++i) {
			// Insert all objects as an deep copy
			tree.insert(new Integer(objects.get(i).intValue()));
		}

		return tree;
	}
}