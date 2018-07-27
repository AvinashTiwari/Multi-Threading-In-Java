package avinash.learn.executor.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.FactorialTaskA;
import avinash.learn.executor.common.FactorialTaskB;
import avinash.learn.executor.common.LoopTaskA;
import avinash.learn.executor.common.LoopTaskE;
import avinash.learn.executor.common.LoopTaskG;
import avinash.learn.executor.common.NamedThreadFactory;

public class TerminatingBlockedExecutorTask {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		
		ExecutorService service = Executors.newCachedThreadPool(new NamedThreadFactory());
		LoopTaskA task1 = new LoopTaskA();
		LoopTaskG task2 = new LoopTaskG();
		FactorialTaskB task3 = new FactorialTaskB(30,500);

		Future<?> f1 = service.submit(task1);
		Future<?> f2 = service.submit(task2);
		Future<?> f3 = service.submit(task3);
		
		service.shutdown();
		
		TimeUnit.MILLISECONDS.sleep(2000);
		f1.cancel(true);
		f2.cancel(true);
		f3.cancel(true);

		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
