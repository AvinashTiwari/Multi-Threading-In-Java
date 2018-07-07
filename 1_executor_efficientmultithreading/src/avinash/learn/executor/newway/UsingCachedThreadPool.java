package avinash.learn.executor.newway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.LoopTaskA;

public class UsingCachedThreadPool {
	
	public static void main(String[] args) {
		ExecutorService es =Executors.newSingleThreadExecutor();
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.shutdown();

	}

}
