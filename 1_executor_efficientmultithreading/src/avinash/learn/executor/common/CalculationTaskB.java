package avinash.learn.executor.common;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskB implements Callable<TaskResult<String, Integer>> {

	private int a;
	private int b;
	private long sleepTime;

	private static int count = 0;
	private int instanceNumber;
	private String taskId;

	public CalculationTaskB(int a , int  b, long sleepTime) {
		this.a =a;
		this.b =b;
		this.sleepTime = sleepTime;
		this.instanceNumber = ++count;
		this.taskId = "CallTaskB " + this.instanceNumber;
 	}

	@Override
	public TaskResult<String, Integer> call() throws InterruptedException  {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("###[ " + currentThreadName + " ]##  < " + taskId + " > Starting");
		System.out.println(" [ " + currentThreadName + " ] sleeping for " +  sleepTime);
				TimeUnit.MILLISECONDS.sleep(sleepTime);
				System.out.println("**** [ " + currentThreadName + " ] < " + taskId + ">");
		return new TaskResult<String, Integer> (taskId, a + b);
	}
	
	
}
