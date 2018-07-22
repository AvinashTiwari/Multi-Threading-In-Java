package avinash.learn.executor.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskE implements Runnable {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	private long sleeptime;
	private volatile boolean shutdow =false;
	@Override
	public void run() {
		boolean isRunningInDeamonThread = Thread.currentThread().isDaemon();
		String Threadtype = isRunningInDeamonThread ? "DEAMON" : "NoralThread";
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName + ", " + Threadtype + " Id Is " + taskId +" > Tick Tick  Start");

		for (int i = 10;;i++) {
			System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick " + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized (this) {
				if(this.shutdow){
					break;
				}
			}
			
		}
		
		//System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick Tick  Done");

	}
	
	public void cancel(){
		synchronized (this) {
			this.shutdow = true;
		}
	}
	

	public LoopTaskE( ) {
		//this.sleeptime = sleeptime;
		this.InstanceNumber  = count++;
		this.taskId = "Loop TaskE"  + InstanceNumber;
//		new Thread(this).start();
	}
}
