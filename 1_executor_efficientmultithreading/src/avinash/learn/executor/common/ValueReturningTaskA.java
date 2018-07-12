package avinash.learn.executor.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable{

	private int a;
	private int b;
	private long sleepTime; 
	private int sum;
	
	private static int count =0;
	private int instanceNumber;
	private String taskId;
	
	public ValueReturningTaskA(int a , int  b, long sleepTime) {
		this.a =a;
		this.b =b;
		this.sleepTime = sleepTime;
		this.instanceNumber = ++count;
		this.taskId = "ValueReturnId " + this.instanceNumber;
	}
	
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("###[ " + currentThreadName + " ]##  < " + taskId + " > Starting");
		System.out.println(" [ " + currentThreadName + " ] sleeping for " +  sleepTime);
		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sum = a+b ;
		System.out.println("**** [ " + currentThreadName + " ] < " + taskId + ">");
	}
	
	public int getSum(){
		return sum;
	}

}
