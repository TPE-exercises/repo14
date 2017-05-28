package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe1;

public class Starvation extends Thread {

	private String s = "Hallo";

	@Override
	public void run() {

		synchronized (s) {
			for (int i = 0; i < 10; ++i) {
				System.out.println(s + " : " + getName());
				
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.getMessage();
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Starvation s1 = new Starvation();
		Starvation s2 = new Starvation();
		Starvation s3 = new Starvation();
		Starvation s4 = new Starvation();
		
		s1.start();
		s2.start();
		s3.start();
		s4.start();
	}
}
