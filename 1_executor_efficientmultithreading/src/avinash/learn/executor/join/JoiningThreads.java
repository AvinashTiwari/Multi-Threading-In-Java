package avinash.learn.executor.join;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.ExecptionLeakingTask;
import avinash.learn.executor.common.LoopTaskD;
import avinash.learn.executor.common.ThreadExceptionHandler;
import avinash.learn.executor.common.ThreadFactoryWithExceptionAlternator;
import avinash.learn.executor.common.ThreadfactoryWithExceptionHandler;

public class JoiningThreads {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		Thread t1 = new Thread(new LoopTaskD(100), "MyThread-1");
		Thread t2 = new Thread(new LoopTaskD(200), "MyThread-2");
		Thread t3 = new Thread(new LoopTaskD(300), "MyThread-3");
		Thread t4 = new Thread(new LoopTaskD(400), "MyThread-4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		System.out.println("[ " + currentThreadName + " ] Joined " + t1.getName());

		t2.join();
		System.out.println("[ " + currentThreadName + " ] Joined " + t2.getName());

		t3.join();
		System.out.println("[ " + currentThreadName + " ] Joined " + t3.getName());
		
		t4.join();
		System.out.println("[ " + currentThreadName + " ] Joined " + t4.getName());

		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
