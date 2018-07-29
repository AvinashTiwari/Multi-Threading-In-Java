package avinash.learn.executor.handlingexecption;

import avinash.learn.executor.common.ExecptionLeakingTask;
import avinash.learn.executor.common.ThreadExceptionHandler;

public class HandlingUnCaughtExecptionForEveryThread {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default_handler"));
		try {
			new Thread(new ExecptionLeakingTask(), "My Thread 1 ").start();
			new Thread(new ExecptionLeakingTask(), "My Thread 2 ").start();
			new Thread(new ExecptionLeakingTask(), "My Thread 3 ").start();
		} catch (RuntimeException ex) {
			System.out.println("[ " + currentThreadName + " ] Catught Execption " + ex);

		}

		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
