package avinash.learn.executor.common;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LoopTaskI implements Runnable {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	private long sleeptime;
	private CountDownLatch doneCountDown;
	@Override
	public void run() {
		boolean isRunningInDeamonThread = Thread.currentThread().isDaemon();
		String Threadtype = isRunningInDeamonThread ? "DEAMON" : "NoralThread";
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName + ", " + Threadtype + " Id Is " + taskId +" > Tick Tick  Start");

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

		if(this.doneCountDown != null){
			doneCountDown.countDown();
			System.out.println("< currentThreadName " + currentThreadName  
					+ " Id Is " + taskId +" > LatchDone = " + doneCountDown.getCount()
			);

		}
	}

	public LoopTaskI(  CountDownLatch doneCountDown) {
		this.InstanceNumber  = count++;
		this.taskId = "Loop TaskI "  + InstanceNumber;
		this.doneCountDown = doneCountDown;
//		new Thread(this).start();
	}
}
