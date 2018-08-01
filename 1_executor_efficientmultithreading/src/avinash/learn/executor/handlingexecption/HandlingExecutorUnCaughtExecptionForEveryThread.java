package avinash.learn.executor.handlingexecption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.ExecptionLeakingTask;
import avinash.learn.executor.common.ThreadExceptionHandler;

public class HandlingExecutorUnCaughtExecptionForEveryThread {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("Default_handler"));
		
		ExecutorService exServcie1 = Executors.newCachedThreadPool();
		exServcie1.execute(new ExecptionLeakingTask());
		exServcie1.execute(new ExecptionLeakingTask());
		exServcie1.execute(new ExecptionLeakingTask());
		
		ExecutorService exServcie2 = Executors.newCachedThreadPool();
		exServcie2.execute(new ExecptionLeakingTask());
		exServcie2.execute(new ExecptionLeakingTask());
		exServcie2.execute(new ExecptionLeakingTask());

		exServcie2.shutdown();
		exServcie1.shutdown();

		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
