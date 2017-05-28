package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

import java.io.IOException;
import java.util.Scanner;


public class Menu {
	
	static private RingpufferThread r = new RingpufferThread(20);
	static private ProducerThread pt1 = new ProducerThread("Producer1", r, 1000);
	static private ProducerThread pt2 = new ProducerThread("Producer2", r, 750);
	static private ProducerThread pt3 = new ProducerThread("Producer3", r , 500);
	static private ConsumerThread ct1 = new ConsumerThread("Consumer1", r , 250);
	static private ConsumerThread ct2 = new ConsumerThread("Consumer2", r, 650);
	static private TimerThread t;
	
	public static void runThreads(){
			t.start();
			ct1.start();
			ct2.start();
			pt1.start();
			pt2.start();
			pt3.start();

	}
	
	public static void main(String a[]){
		System.out.println("How long does the threads works?");
		Scanner reader = new Scanner(System.in);
		int minutes = reader.nextInt();
		t= new TimerThread(minutes, pt1, pt2, pt3, ct1, ct2);
		t.start();
		ct1.start();
		ct2.start();
		pt1.start();
		pt2.start();
		pt3.start();
	}
}
