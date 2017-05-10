package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.LinkedList;

public class LinkedList {
	Node head;

	// >>>>>>>>>> constructors <<<<<<<<<<<<<<<

	public LinkedList() {
		head = null;
	}

	// --------------- public methods
	// --------------------------------------------

	public void addLast(Object val) {

		// inserts val at a new element at tail of the list

		if (head == null)
			head = new Node(val, null);
		else {
			Node l = head;
			while (l.getNext() != null)
				l = l.getNext();

			Node n = new Node(val, null); // create a new element
			l.setNext(n); // link the new element
		}
	}

	public void addFirst(Object val) {

		// inserts val at a new element at head of the list

		if (head == null)
			head = new Node(val, null);
		else {
			head = new Node(val, head);
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Object removeFirst() {

		// removes first element of the list

		Node p = head;

		if (!isEmpty()) {
			head = head.next;
			return p.val;
		} else
			return null;
	}

	public Object getFirst() {

		// gets first element of the list

		if (!isEmpty())
			return head.val;
		else
			return null;
	}

	public int printList() { // returns no. of printed elements

		Node p = head;
		int cnt = 0;
		int noe = this.size();

		if (noe == 0)
			return 0; // nothing to print

		while (cnt < noe - 1) { // print all elements but last
			System.out.print(p + ", ");
			p = p.getNext();
			cnt++;
		}

		System.out.println(p); // print last element

		return noe;

	}

	public int size() {

		Node p = head;
		int cnt = 0;

		while (p != null) {
			cnt++;
			p = p.getNext();
		}

		return cnt;

	}
}
