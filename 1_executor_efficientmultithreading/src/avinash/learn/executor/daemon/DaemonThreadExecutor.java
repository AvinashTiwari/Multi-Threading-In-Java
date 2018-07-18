package avinash.learn.executor.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.DaemonThreadFactory;
import avinash.learn.executor.common.LoopTaskD;

public class DaemonThreadExecutor {

	public static void main(String[] args) {
		  String currentThreadName = Thread.currentThread().getName();
		    System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		    
		    ExecutorService  exeService = Executors.newCachedThreadPool(new DaemonThreadFactory());
		    exeService.equals(new  LoopTaskD(100));
		    exeService.equals(new  LoopTaskD(200));
		    exeService.equals(new  LoopTaskD(100));
		    exeService.equals(new  LoopTaskD(200));
		    
		    exeService.shutdown();

		    System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}

}
