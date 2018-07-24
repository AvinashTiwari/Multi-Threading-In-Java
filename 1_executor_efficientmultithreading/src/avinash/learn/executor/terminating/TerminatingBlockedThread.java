package avinash.learn.executor.terminating;

import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.LoopTaskE;
import avinash.learn.executor.common.LoopTaskF;
import avinash.learn.executor.common.LoopTaskG;
import avinash.learn.executor.common.LoopTaskH;

public class TerminatingBlockedThread {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");

		LoopTaskG task1 = new LoopTaskG();
		LoopTaskG task2 = new LoopTaskG();
		LoopTaskG task3= new LoopTaskG();

		
		LoopTaskH task4 = new LoopTaskH();
		LoopTaskH task5 = new LoopTaskH();
		LoopTaskH task6= new LoopTaskH();

		
		
		Thread t1 = new Thread(task1, "MytHread 1");
		t1.start();
		Thread t2 = new Thread(task2, "MytHread 2");
		t2.start();

		Thread t3 = new Thread(task3, "MytHread 3");
		t3.start();
	
		Thread t4 = new Thread(task3, "MytHread 4");
		t4.start();
	
		Thread t5 = new Thread(task3, "MytHread 5");
		t5.start();
	
		Thread t6 = new Thread(task3, "MytHread 6");
		t6.start();
	
		
		TimeUnit.MILLISECONDS.sleep(5000);
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();

		t4.interrupt();
		t5.interrupt();
		t6.interrupt();

		
		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
