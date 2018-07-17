package avinash.learn.executor.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskD implements Runnable {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	private long sleeptime;
	@Override
	public void run() {
		boolean isRunningInDeamonThread = Thread.currentThread().isDaemon();
		String Threadtype = isRunningInDeamonThread ? "DEAMON" : "NoralThread";
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName + ", " + Threadtype + " Id Is " + taskId +" > Tick Tick  Start");

		for (int i = 10; i > 0; i--) {
			System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(sleeptime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick Tick  Done");

	}

	public LoopTaskD( long sleeptime) {
		this.sleeptime = sleeptime;
		this.InstanceNumber  = count++;
		this.taskId = "Loop TaskD"  + InstanceNumber;
//		new Thread(this).start();
	}
}
