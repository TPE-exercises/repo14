package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.aufgabe1;

import static gdi.MakeItSimple.*;

import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Queue.*;
import de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt3.myutil.Stack.*;

public class Menu {

	static void printMenu() {
		println("Main Menü");
		println("Q \t Queue");
		println("S \t Stack");

		String temp = readLine();
		if (temp.equals("Q") || temp.equals("q")) {
			implementationMenu("Q");
		} else if (temp.equals("S") || temp.equals("s")) {
			implementationMenu("S");
		} else {
			println("try again");
			printMenu();
		}
	}

	private static String dataType(){
		println("Implementation Menü");
		println("Which datatype will you insert?");
		println("I \t Integer");
		println("S \t String");
		
		String temp = readLine();
		switch (temp) {
		case "I":
		case "i":
			return "I";
		case "S":
		case "s":
			return "S";
		default:
			return "try again!";
		}
		
	}
	
	private static void implementationMenu(String adt) {
		String dataType = dataType();
		
		println("Implementation Menü");
		println("A \t Array Implementation");
		println("L \t Linked List Implementation");
		String temp = readLine();

		if (adt.equals("Q")) {
			println("1 \t size of the Queue");
			println("2 \t continue with standard");
			int i = readInt();
			if (i == 1) {
				println("Please insert the size: ");
				i = readInt();
				switch (temp) {
				case "A":
				case "a":
					queueMenu(new QueueArray(i), dataType);
					break;
				case "L":
				case "l":
					queueMenu(new QueueLinkedList(i), dataType);
					break;
				default:
					break;
				}
			} else if (i != 1 && i != 2) {
				println("Fail! Try again!");
				printMenu();
			} else {
				switch (temp) {
				case "A":
				case "a":
					queueMenu(new QueueArray(), dataType);
					break;
				case "L":
				case "l":
					queueMenu(new QueueLinkedList(), dataType);
					break;
				default:
					break;
				}
			}
		} else if (adt.equals("S")) {
			println("1 \t size of the Stack");
			println("2 \t continue with standard");
			int i = readInt();
			if (i == 1) {
				println("Please insert the size: ");
				i = readInt();
				switch (temp) {
				case "A":
				case "a":
					stackMenu(new StackArray(i), dataType);
					break;
				case "L":
				case "l":
					stackMenu(new StackLinkedList(i), dataType);
					break;
				default:
					break;
				}
			} else if (i != 1 && i != 2) {
				println("Fail! Try again!");
				printMenu();
			} else {
				switch (temp) {
				case "A":
				case "a":
					stackMenu(new StackArray(), dataType);
					break;
				case "L":
				case "l":
					stackMenu(new StackLinkedList(), dataType);
					break;
				default:
					break;
				}
			}
		}
	}

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
		
		while (temp != 20){
			temp = readInt();
			switch(temp){
			case 1: 
				try{
					if(dataType.equals("S")){
						String s = readLine();
						println(stack.push(s));
					} else if(dataType.equals("I")){
						int i = readInt();
						println(stack.push((Integer) i));
					}
				}catch(OverflowException oe){
					println(oe);
				}
			
				break;
			case 2:
				try{
					println(stack.pop().toString());
				} catch(UnderflowException ue){
					println(ue);
				}
				
				break;
			case 3:
				try{
					println(stack.top().toString());
				} catch (UnderflowException ue){
					println(ue);
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
				println(stack.size());
				break;
			case 10:
				implementationMenu("S");
				break;
			default:
				break;
			}
		}
		printMenu();

	}

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
		switch(temp){
		case 1: 
			try{
				if(dataType.equals("S")){
					String s = readLine();
					println(queue.enter(s));
				} else if(dataType.equals("I")){
					int i = readInt();
					println(queue.enter((Integer) i));
				}
			} catch (OverflowException oe){
				println(oe);
			}
			
			break;
		case 2:
			try{
				println(queue.leave().toString());
			} catch(UnderflowException ue){
				println(ue);
			}
			
			break;
		case 3:
			try{
				println(queue.front().toString());
			} catch(UnderflowException ue){
				println(ue);
			}
			
			break;
		case 4:
			queue = (Queue) queue.empty();
			println("new empty queue");
			break;
		case 5:
			println(queue.isEmpty());
			break;
		case 6:
			println(queue.size());
			break;
		case 10:
			implementationMenu("Q");
			break;
		default:
			break;
		}
	
		
		while (temp != 20){
			queueMenu(queue, dataType);
		}
		printMenu();
	}

	public static void main(String[] args) {

		printMenu();

	}

}
