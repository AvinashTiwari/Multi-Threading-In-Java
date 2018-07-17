package avinash.learn.executor.daemon;

import java.util.concurrent.ExecutorService;

import avinash.learn.executor.common.LoopTaskD;

public class DaemonThread {

	public static void main(String[] args) {
		  String currentThreadName = Thread.currentThread().getName();
		    System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
			Thread t1 = new Thread(new LoopTaskD(500), "Thread 1");
			Thread t2 = new Thread(new LoopTaskD(1000), "Thread 2");
			t2.setDaemon(true);
			t1.start();
			t2.start();
		    System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}

}
