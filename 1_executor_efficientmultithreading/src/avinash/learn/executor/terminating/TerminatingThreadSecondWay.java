package avinash.learn.executor.terminating;

import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.LoopTaskE;
import avinash.learn.executor.common.LoopTaskF;

public class TerminatingThreadSecondWay {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");

		  LoopTaskF task1 = new LoopTaskF();
		  LoopTaskF task2 = new LoopTaskF();
		  LoopTaskF task3= new LoopTaskF();

		Thread t1 = new Thread(task1, "MytHread 1");
		t1.start();
		Thread t2 = new Thread(task2, "MytHread 2");
		t2.start();

		Thread t3 = new Thread(task3, "MytHread 3");
		t3.start();
		
		TimeUnit.MILLISECONDS.sleep(5000);
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();

		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
