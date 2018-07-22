package avinash.learn.executor.terminating;

import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.LoopTaskE;

public class TerminatingThreadFirstWay {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");

		  LoopTaskE task1 = new LoopTaskE();
		  LoopTaskE task2 = new LoopTaskE();
		  LoopTaskE task3= new LoopTaskE();

		new Thread(task1, "MytHread 1").start();
		new Thread(task2, "MytHread 2").start();
		new Thread(task3, "MytHread 3").start();
		
		TimeUnit.MILLISECONDS.sleep(5000);
		task1.cancel();
		task2.cancel();
		task3.cancel();

		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
