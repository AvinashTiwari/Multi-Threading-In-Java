package avinash.learn.executor.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable{

	private int a;
	private int b;
	private long sleepTime; 
	private int sum;
	
	private static int count =0;
	private int instanceNumber;
	private String taskId;
	private ResultListner<Integer> result;
	
	
	public ValueReturningTaskB(int a , int  b, long sleepTime, ResultListner<Integer> result) {
		this.a =a;
		this.b =b;
		this.sleepTime = sleepTime;
		this.instanceNumber = ++count;
		this.taskId = "ValueReturnIdB " + this.instanceNumber;
		this.result = result;
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
		
		result.notifyResult(sum);
		
	}
	
	
}
