package avinash.learn.executor.newway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.LoopTaskA;

public class UsingSingleThreaExecutor {
	
	public static void main(String[] args) {
		ExecutorService es =Executors.newCachedThreadPool();
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.shutdown();

	}

}
