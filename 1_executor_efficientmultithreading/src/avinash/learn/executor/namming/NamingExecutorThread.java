package avinash.learn.executor.namming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.LoopTaskC;
import avinash.learn.executor.common.NamedThreadFactory;

public class NamingExecutorThread {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " Main thread Start");
		ExecutorService exeService = Executors.newCachedThreadPool(new NamedThreadFactory());
		exeService.execute(new LoopTaskC());
		exeService.execute(new LoopTaskC());
		exeService.execute(new LoopTaskC());

		System.out.println(currentThreadName + " End thread Start");

	}
}
