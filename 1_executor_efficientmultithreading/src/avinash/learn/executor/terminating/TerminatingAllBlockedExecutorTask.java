package avinash.learn.executor.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.CalculationTaskB;
import avinash.learn.executor.common.CalculationTaskC;
import avinash.learn.executor.common.FactorialTaskA;
import avinash.learn.executor.common.FactorialTaskB;
import avinash.learn.executor.common.LoopTaskA;
import avinash.learn.executor.common.LoopTaskE;
import avinash.learn.executor.common.LoopTaskF;
import avinash.learn.executor.common.LoopTaskG;
import avinash.learn.executor.common.NamedThreadFactory;

public class TerminatingAllBlockedExecutorTask {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		
		ExecutorService service = Executors.newCachedThreadPool(new NamedThreadFactory());
		
		LoopTaskA task1 = new LoopTaskA();
		LoopTaskF task2 = new LoopTaskF();
        FactorialTaskB task3 = new FactorialTaskB(30,500);
        CalculationTaskC task4 = new CalculationTaskC();
        CalculationTaskB task5 = new CalculationTaskB(2,3,900);
        
        service.execute(task1);
        service.execute(task2);
        service.submit(task3);
        service.submit(task4);
        service.submit(task5);
        
        TimeUnit.MILLISECONDS.sleep(1000);
        
        service.shutdown();
		System.out.println("[ " + currentThreadName + " ] All Thread Terminate " + 
				service.awaitTermination(500, TimeUnit.MILLISECONDS));

	
		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
