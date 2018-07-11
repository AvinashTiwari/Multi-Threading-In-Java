package avinash.learn.executor.common;

public class ValueReturningTaskA implements Runnable{

	private int a;
	private int b;
	private long sleep; 
	private int sum;
	
	private static int count =0;
	private int instanceNumber;
	private String taskId;
	
	public ValueReturningTaskA(int a , int  b, long sleep) {
		this.a =a;
		this.b =b;
		this.sleep = sleep;
		this.instanceNumber = ++count;
		this.taskId = "ValueReturnId " + this.instanceNumber;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
