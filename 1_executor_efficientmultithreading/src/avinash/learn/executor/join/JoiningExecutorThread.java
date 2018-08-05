package avinash.learn.executor.join;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import avinash.learn.executor.common.ExecptionLeakingTask;
import avinash.learn.executor.common.LoopTaskD;
import avinash.learn.executor.common.LoopTaskI;
import avinash.learn.executor.common.NamedThreadFactory;
import avinash.learn.executor.common.ThreadExceptionHandler;
import avinash.learn.executor.common.ThreadFactoryWithExceptionAlternator;
import avinash.learn.executor.common.ThreadfactoryWithExceptionHandler;

public class JoiningExecutorThread {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
		CountDownLatch doneSignal = new CountDownLatch(4);
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));
		execService.execute(new LoopTaskI(doneSignal));

		execService.shutdown();
		try{
			doneSignal.await();
			System.out.println("[ " + currentThreadName + " ] Got Signal to Continue ");

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
