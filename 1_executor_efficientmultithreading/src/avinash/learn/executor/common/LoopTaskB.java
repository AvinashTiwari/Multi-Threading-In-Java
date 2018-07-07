package avinash.learn.executor.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable {

	private static int count = 0;
	private int id;
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + id +" > Tick Tick  Start");

		for (int i = 10; i > 0; i--) {
			System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + id +" > Tick " + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + id +" > Tick Tick  Done");

	}

	public LoopTaskB() {
		this.id  = count++;
//		new Thread(this).start();
	}
}
