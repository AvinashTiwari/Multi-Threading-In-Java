package avinash.learn.executor.newway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.LoopTaskA;
import avinash.learn.executor.common.NamedThreadFactory;

public class UsingCachedThreadPool2 {
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es =Executors.newSingleThreadExecutor(new NamedThreadFactory());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		
		TimeUnit.SECONDS.sleep(15);
		
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.execute(new LoopTaskA());
		es.shutdown();

	}

}
