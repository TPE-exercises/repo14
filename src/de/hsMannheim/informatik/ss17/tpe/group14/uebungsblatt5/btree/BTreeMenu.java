package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt5.btree;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BTreeMenu {

	private static MyBTree[] trees = new MyBTree[3];
	private static MyBTree workingTree;
	private static final String FILE_PATH = "src/de/hsMannheim/informatik/ss17/tpe/group14/values.txt";
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Initalize BTree array
		trees[0] = new MyBTree(1);
		trees[1] = new MyBTree(2);
		trees[2] = new MyBTree(3);
		workingTree = trees[0];
		
		int input = -1;
		while (input != 30) {
			printMenu();
			try {
				input = scanner.nextInt();
				executeCommand(input);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				scanner.nextLine();
				input = -1;
			}
		}
		
		scanner.close();
	}

	private static void printMenu() {
		System.out.println("1\t-> insert(Comparable o)");
		System.out.println("2\t-> insertInts(String filename)");
		System.out.println("3\t-> contains(Comparable o)");
		System.out.println("4\t-> remove(Comparable o");
		System.out.println("5\t-> size()");
		System.out.println("6\t-> height()");
		System.out.println("7\t-> getMax()");
		System.out.println("8\t-> getMin()");
		System.out.println("9\t-> isEmpty()");
		System.out.println("10\t-> addAll(BTree otherTree)");
		System.out.println("11\t-> printInorder()");
		System.out.println("12\t-> printPostorder()");
		System.out.println("13\t-> printPreorder()");
		System.out.println("14\t-> printLevelorder()");
		System.out.println("15\t-> clone()");
		System.out.println("16\t-> change tree");
		System.out.println("30\t-> exit");
	}

	private static void executeCommand(int cmd) {
		switch (cmd) {
		case 1:
			System.out.print("value: ");
			System.out.print(workingTree.insert(scanner.nextInt()));
			break;
		case 2:
			try {
				System.out.print(workingTree.insertInts(FILE_PATH));
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.print("value to search: ");
			System.out.print(workingTree.contains(scanner.nextInt()));
			break;
		case 4:
			System.out.print("value: ");
			System.out.print(workingTree.delete(new Integer(scanner.nextInt())));
			break;
		case 5:
			System.out.print(workingTree.size());
			break;
		case 6:
			System.out.print(workingTree.height());
			break;
		case 7:
			System.out.print(workingTree.getMax());
			break;
		case 8:
			System.out.print(workingTree.getMin());
			break;
		case 9:
			System.out.print(workingTree.isEmpty());
			break;
		case 10:
			System.out.println("Index of the tree to add: ");
			System.out.print(workingTree.addAll(trees[scanner.nextInt()]));
			break;
		case 11:
			workingTree.printInorder();
			break;
		case 12:
			workingTree.printPostorder();
			break;
		case 13:
			workingTree.printPreorder();
			break;
		case 14:
			workingTree.printLevelorder();
			break;
		case 15:
			System.out.print("index to clone: ");
			int index = scanner.nextInt();
			if(index > 0 && index < 3)
				trees[index] = workingTree.clone();
			else
				System.out.print("other index");
			break;
		case 16:
			System.out.print("index: ");
			workingTree = trees[scanner.nextInt()];
			break;
		case 30: // exit the program
			break;
		default:
			System.out.println("unknown command");
		}
		scanner.nextLine();
		scanner.nextLine();
	}
}
