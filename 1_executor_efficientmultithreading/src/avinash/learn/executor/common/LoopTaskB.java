package avinash.learn.executor.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	@Override
	public void run() {
		Thread.currentThread().setName("Amazing name - " + InstanceNumber);
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick Tick  Start");

		for (int i = 10; i > 0; i--) {
			System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick " + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick Tick  Done");

	}

	public LoopTaskB() {
		this.InstanceNumber  = count++;
		this.taskId = "Loop TaskB"  + InstanceNumber;
//		new Thread(this).start();
	}
}
