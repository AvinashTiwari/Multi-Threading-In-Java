package avinash.learn.executor.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskA implements Callable<Long> {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	private long sleeptime;
	private volatile boolean shutdow =false;
	
	private long a;
	private long sleepTime;
	private long factorial;
	@Override
	public Long  call() throws InterruptedException {
		boolean isRunningInDeamonThread = Thread.currentThread().isDaemon();
		String Threadtype = isRunningInDeamonThread ? "DEAMON" : "NoralThread";
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName + ", " + Threadtype + " Id Is " + taskId +" > Tick Tick  Start");
		factorial = 1L;
		for (long i = 1; i <=a ;i++) {
			factorial *=a;
			System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick " + i + " result " + factorial );
				TimeUnit.MILLISECONDS.sleep(sleepTime);
			
			synchronized (this) {
				if(this.shutdow){
					factorial = -1L;
					break;
				}
			}
			
		}
		
		System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick Tick  Done");

		return factorial;
	}
	
	public void cancel(){
		synchronized (this) {
			this.shutdow = true;
		}
	}
	

	public FactorialTaskA(long a , long sleeptime ) {
		//this.sleeptime = sleeptime;
		this.a =a;
		this.sleepTime = sleeptime;
		
		this.InstanceNumber  = count++;
		this.taskId = "Loop factorialA"  + InstanceNumber;
//		new Thread(this).start();
	}
}
