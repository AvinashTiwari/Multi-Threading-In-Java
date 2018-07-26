package avinash.learn.executor.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.CalculationTaskC;
import avinash.learn.executor.common.FactorialTaskA;
import avinash.learn.executor.common.LoopTaskE;
import avinash.learn.executor.common.LoopTaskF;
import avinash.learn.executor.common.NamedThreadFactory;

public class TerminatingExecutorTaskSecondWay {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		
		ExecutorService service = Executors.newCachedThreadPool(new NamedThreadFactory());
		CalculationTaskC task1 = new CalculationTaskC(); 
		LoopTaskF task2 = new LoopTaskF();
		
		Future<Long> f1 = service.submit(task1);
		Future<?> f2 = service.submit(task2);
		
		service.shutdown();
		
		TimeUnit.MILLISECONDS.sleep(2000);
		
		System.out.println(f1.cancel(true));
		System.out.println(f2.cancel(true));


		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
