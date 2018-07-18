package avinash.learn.executor.daemon;

import java.util.concurrent.ExecutorService;

import avinash.learn.executor.common.LoopTaskD;

public class DaemonThreadExecutor {

	public static void main(String[] args) {
		  String currentThreadName = Thread.currentThread().getName();
		    System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
			
		    System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}

}
