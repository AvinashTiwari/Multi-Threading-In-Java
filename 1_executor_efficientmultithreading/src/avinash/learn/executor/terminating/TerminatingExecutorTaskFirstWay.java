package avinash.learn.executor.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.FactorialTaskA;
import avinash.learn.executor.common.LoopTaskE;
import avinash.learn.executor.common.NamedThreadFactory;

public class TerminatingExecutorTaskFirstWay {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		
		ExecutorService service = Executors.newCachedThreadPool(new NamedThreadFactory());
		LoopTaskE t1 = new LoopTaskE();
		FactorialTaskA t2 = new FactorialTaskA(30, 1000);
		service.execute(t1);
		service.submit(t2);
		
		service.shutdown();
		t1.cancel();
		t2.cancel();
		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
