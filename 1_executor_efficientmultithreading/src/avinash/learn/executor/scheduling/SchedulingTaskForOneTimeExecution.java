package avinash.learn.executor.scheduling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.ExecptionLeakingTask;
import avinash.learn.executor.common.LoopTaskD;
import avinash.learn.executor.common.ThreadExceptionHandler;
import avinash.learn.executor.common.ThreadFactoryWithExceptionAlternator;
import avinash.learn.executor.common.ThreadfactoryWithExceptionHandler;

public class SchedulingTaskForOneTimeExecution {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		
		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
