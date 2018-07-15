package avinash.learn.executor.returnvalue;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import avinash.learn.executor.common.CalculationTaskA;
import avinash.learn.executor.common.CalculationTaskB;
import avinash.learn.executor.common.LoopTaskA;
import avinash.learn.executor.common.NamedThreadFactory;
import avinash.learn.executor.common.TaskResult;
import avinash.learn.executor.common.ValueReturningTaskA;
import avinash.learn.executor.common.ValueReturningTaskB;

public class ReturningValueExeutorValueSecondWay {

	public static void main(String[] args) {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
	ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadFactory());
	
	CompletionService<TaskResult<String, Integer>> tasks = new  ExecutorCompletionService<TaskResult<String, Integer>>(execService);
	
	tasks.submit(new CalculationTaskB(2,3, 2000));
	tasks.submit(new CalculationTaskB(2,4, 1000));
	tasks.submit(new CalculationTaskB(2,5, 500));

	
	//Future<?> result4 =	execService.submit(new LoopTaskA());
	tasks.submit(new LoopTaskA(), new TaskResult<String, Integer>("LoopTask Q",99));
	
	execService.shutdown();
	
	for(int i=0; i < 4; i++){
		try {
			System.out.println("Result  = " + tasks.take().get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    System.out.println("[ " + currentThreadName + " ] Main Thread Ends Here");

	}

}
