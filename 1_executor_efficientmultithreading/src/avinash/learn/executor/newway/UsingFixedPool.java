package avinash.learn.executor.newway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.LoopTaskA;

public class UsingFixedPool {
	
	public static void main(String[] args) {
		ExecutorService es =Executors.newFixedThreadPool(3);
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.shutdown();

	}

}
