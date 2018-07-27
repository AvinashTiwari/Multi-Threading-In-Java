package avinash.learn.executor.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialTaskB implements Callable<Long> {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	private long sleeptime;
	
	private long a;
	private long sleepTime;
	private long factorial;
	@Override
	public Long  call()  {
		boolean isRunningInDeamonThread = Thread.currentThread().isDaemon();
		String Threadtype = isRunningInDeamonThread ? "DEAMON" : "NoralThread";
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName + ", " + Threadtype + " Id Is " + taskId +" > Tick Tick  Start");
		factorial = 1L;
		for (long i = 1; i <=a ;i++) {
			factorial *=a;
			System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick " + i + " result " + factorial );
				try {
					TimeUnit.MILLISECONDS.sleep(sleepTime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Thread Sleep Interuppted ");
					factorial = -1L;
				}
			
			
		}
		
		System.out.println("< currentThreadName " + currentThreadName  + " Id Is " + taskId +" > Tick Tick  Done");

		return factorial;
	}
	
	

	public FactorialTaskB(long a , long sleeptime ) {
		//this.sleeptime = sleeptime;
		this.a =a;
		this.sleepTime = sleeptime;
		
		this.InstanceNumber  = count++;
		this.taskId = "Loop factorial B"  + InstanceNumber;
//		new Thread(this).start();
	}
}
