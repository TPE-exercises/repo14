package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import static gdi.MakeItSimple.*;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Queue.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Stack.*;

public class Menu {
	

	/**
	 * print the main menu on the console
	 */
	static void printMenu() {
		// print menu
		println("Main Menü");
		println("Q \t Queue");
		println("S \t Stack");

		String temp = readLine();
		// if the entry is right go to the next menu
		if (temp.equals("Q") || temp.equals("q")) {
			implementationMenu("Q");
		} else if (temp.equals("S") || temp.equals("s")) {
			implementationMenu("S");
		} else {
			// if the entry is wrong
			println("try again");
			printMenu();
		}
	}

	/**
	 * print the datatype for the implementation on the console
	 * @return the datatype as a string
	 */
	private static String dataType() {
		// print menu
		println("Implementation Menü");
		println("Which datatype will you insert?");
		println("I \t Integer");
		println("S \t String");

		char temp = readChar();
		switch (temp) {
		case 'I':
		case 'i':
			return "I";
		case 'S':
		case 's':
			return "S";
		default:
			dataType();
			return "2.try again!";
		}

	}

	private static void implementationMenu(String adt) {
		// print menu
		String dataType = dataType();
		readLine();
		println("A \t Array Implementation");
		println("L \t Linked List Implementation");
		char temp = readChar();

		// if the datatype is an queue
		if (adt.equals("Q")) {
			println("1 \t size of the Queue");
			println("2 \t continue with standard");
			int i = readInt();
			if (i == 1) {
				println("Please insert the size: ");
				i = readInt();
				switch (temp) {
				case 'A':
				case 'a':
					queueMenu(new QueueArray(i), dataType);
					break;
				case 'L':
				case 'l':
					queueMenu(new QueueLinkedList(i), dataType);
					break;
				default:
					implementationMenu(adt);
					break;
				}
			} else if ((i < 1 || i > 2 ) || (temp != 'A' && temp!='L' && temp!= 'a' && temp != 'l')) {
				println("Fail! Try again!");
				printMenu();
			} else {
				switch (temp) {
				case 'A':
				case 'a':
					queueMenu(new QueueArray(), dataType);
					break;
				case 'L':
				case 'l':
					queueMenu(new QueueLinkedList(), dataType);
					break;
				default:
					implementationMenu(adt);
					break;
				}
			}
			// if the datatype is a stack
		} else if (adt.equals("S")) {
			println("1 \t size of the Stack");
			println("2 \t continue with standard");
			int i = readInt();
			if (i == 1) {
				println("Please insert the size: ");
				i = readInt();
				switch (temp) {
				case 'A':
				case 'a':
					stackMenu(new StackArray(i), dataType);
					break;
				case 'L':
				case 'l':
					stackMenu(new StackLinkedList(i), dataType);
					break;
				default:
					implementationMenu(adt);
					break;
				}
			} else if ((i < 1 || i > 2 ) || (temp != 'A' && temp!='L' && temp!= 'a' && temp != 'l')) {
				println("Fail! Try again!");
				printMenu();
			} else {
				switch (temp) {
				case 'A':
				case 'a':
					stackMenu(new StackArray(), dataType);
					break;
				case 'L':
				case 'l':
					stackMenu(new StackLinkedList(), dataType);
					break;
				default:
					implementationMenu(adt);
					break;
				}
			}
		}
	}

	/**
	 * print stack menu
	 * @param stack
	 * @param dataType
	 */
	private static void stackMenu(Stack stack, String dataType) {
		println("Stack Menü");
		println("1 \t push(Object o)");
		println("2 \t pop()");
		println("3 \t top()");
		println("4 \t empty()");
		println("5 \t isEmpty()");
		println("6 \t size()");
		println("10 \t changeImplementaion()");
		println("20 \t changeADT()");

		int temp = 0;

		temp = readInt();
		switch (temp) {
		case 1:
			try {
				if (dataType.equals("S")) {
					println("value: ");
					String s = "";
					readLine();
					s = readLine();
					println(stack.push(s));
				} else if (dataType.equals("I")) {
					println("value: ");
					int i = readInt();
					println(stack.push((Integer) i));
				}
			} catch (OverflowException oe) {
				 println(oe);
				 oe.getStackTrace();
			}

			break;
		case 2:
			try {
				println(stack.pop().toString());
			} catch (UnderflowException ue) {
				println(ue);
				ue.getStackTrace();
			}

			break;
		case 3:
			try {
				println("top: " + stack.top().toString());
			} catch (UnderflowException ue) {
				println(ue);
				ue.getStackTrace();
			}
			break;
		case 4:
			stack = (Stack) stack.empty();
			println("new empty stack");
			break;
		case 5:
			println(stack.isEmpty());
			break;
		case 6:
			println("size: " + stack.size());
			break;
		case 10:
			readLine();
			implementationMenu("S");
			break;
		default:
			break;
		}

		// if the menu is not leaving print it new
		while (temp != 20) {
			stackMenu(stack, dataType);
		}
		printExitMenu();
	}

	/**
	 * print queue menu
	 * @param queue 
	 * @param dataType
	 */
	private static void queueMenu(Queue queue, String dataType) {
		println("Queue Menü");
		println("1 \t enter(Object o)");
		println("2 \t leave()");
		println("3 \t front()");
		println("4 \t empty()");
		println("5 \t isEmpty()");
		println("6 \t size()");
		println("10 \t changeImplementaion()");
		println("20 \t changeADT()");

		int temp = 0;

		temp = readInt();
		switch (temp) {
		case 1:
			try {
				if (dataType.equals("S")) {
					println("value: ");
					String s = "";
					readLine();
					s = readLine();
					println(queue.enter(s));
				} else if (dataType.equals("I")) {
					println("value: ");
					int i = readInt();
					println(queue.enter((Integer) i));
				}
			} catch (OverflowException oe) {
				println(oe);
				oe.getStackTrace();
			}

			break;
		case 2:
			try {
				println(queue.leave().toString());
			} catch (UnderflowException ue) {
				println(ue);
				ue.getStackTrace();
			}

			break;
		case 3:
			try {
				println("front: " + queue.front().toString());
			} catch (UnderflowException ue) {
				println(ue);
				ue.getStackTrace();
			}
			break;
		case 4:
			queue = (Queue) queue.empty();
			println("new empty stack");
			break;
		case 5:
			println(queue.isEmpty());
			break;
		case 6:
			println("size: " + queue.size());
			break;
		case 10:
			readLine();
			implementationMenu("S");
			break;
		default:
			break;
		}

		// if the menu is not leaving print it new
		while (temp != 20) {
			queueMenu(queue, dataType);
		}
		printExitMenu();
	}
	
	/**
	 * print exit menu
	 */
	static void printExitMenu(){
		println("Exit Menü");
		println("1 \t continue with Main Menu");
		println("2 \t exit");
		
		int temp = readInt();
		switch(temp){
		case 1: 
			readLine();
			printMenu();
			break;
		case 2:
			break;
		default:
			break;
		}
		
	}

	public static void main(String[] args) {

		printMenu();

	}

}
