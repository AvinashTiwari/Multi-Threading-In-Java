package avinash.learn.executor.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {

	private static int count = 0;
	private int id;
	@Override
	public void run() {
		System.out.println("< " + id +"> Tick Tick  Start");
		for (int i = 10; i > 0; i--) {
			System.out.println("< " + id +" > Tick " + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("< " + id +"> Tick Tick Done ");

	}

	public LoopTaskA() {
		this.id  = count++;
//		new Thread(this).start();
	}
}
