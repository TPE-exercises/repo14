package de.hsMannheim.informatik.ss17.tpe.group14.uebungsblatt4.aufgabe3;

public class TimerThread extends Thread{
	
	private Thread[] threads;
	private long time;
	
	/**
	 * constructor for timerThread to stop some threads after an specific time
	 * @param time in minutes
	 * @param threads all threads they have to stop
	 */
	TimerThread(long time, Thread ... threads){
		// from minutes in miliseconds
		this.time = time*60*1000;
		this.threads = threads;
	}
	
	@Override
	public void run(){
		try {
			// the time the threads can work
			sleep(time);
			// interrupt all threads
			for(int i = 0; i < threads.length; i++){
				this.threads[i].interrupt();
			}
			// exit all threads safely
			for(int i = 0; i < threads.length; i++){
				this.threads[i].join();
			}
			// say that the program has stopped
			System.out.println();
			System.out.println("Program is over");
		} catch (InterruptedException e) {
			// print an exception because the timerthread have not to be interrupted
			e.printStackTrace();
		}
		
		
	}

}
