package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

public class Menu {
	
	static private Ringpuffer r = new Ringpuffer(20);
	static private ProducerThread pt1 = new ProducerThread(r);
	static private ProducerThread pt2 = new ProducerThread(r);
	static private ProducerThread pt3 = new ProducerThread(r);
	static private ConsumerThread ct1 = new ConsumerThread(r);
	static private ConsumerThread ct2 = new ConsumerThread(r);
	
	public static void runThreads(){
		pt1.setName("Producer1");
		pt2.setName("Producer2");
		pt3.setName("Producer3");
		ct1.setName("Consumer1");
		ct2.setName("Consumer2");
		ct1.start();
		ct2.start();
		pt1.start();
		pt2.start();
		pt3.start();
		
	}
	
	public static void main(String a[]) {
		runThreads();
	}

}
