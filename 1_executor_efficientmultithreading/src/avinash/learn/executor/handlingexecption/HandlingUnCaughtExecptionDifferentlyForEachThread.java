package avinash.learn.executor.handlingexecption;

import avinash.learn.executor.common.ExecptionLeakingTask;
import avinash.learn.executor.common.ThreadExceptionHandler;

public class HandlingUnCaughtExecptionDifferentlyForEachThread {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		//Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default_handler"));
		
		Thread t1 = new Thread(new ExecptionLeakingTask(), "MyThread1");
		t1.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		
		Thread t2 = new Thread(new ExecptionLeakingTask(), "MyThread2");
		t2.setUncaughtExceptionHandler(new ThreadExceptionHandler());

		Thread t3 = new Thread(new ExecptionLeakingTask(), "MyThread3");
		t3.setUncaughtExceptionHandler(new ThreadExceptionHandler());

		Thread t4 = new Thread(new ExecptionLeakingTask(), "MyThread4");
		t4.setUncaughtExceptionHandler(new ThreadExceptionHandler());

		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
