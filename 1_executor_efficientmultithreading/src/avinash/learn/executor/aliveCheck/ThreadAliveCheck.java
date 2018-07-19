package avinash.learn.executor.aliveCheck;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import avinash.learn.executor.common.DaemonThreadFactory;
import avinash.learn.executor.common.LoopTaskC;
import avinash.learn.executor.common.LoopTaskD;

public class ThreadAliveCheck {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");

		Thread t = new Thread(new LoopTaskC(), "MyThread-1");
		Thread t1 = new Thread(new LoopTaskC(), "MyThread-2");
		boolean tIsAlie = t.isAlive();
		boolean t1IsAlie = t1.isAlive();
		
		System.out.println(tIsAlie + " " + " " + t1IsAlie);
		
		t.start();
		t1.start();
		
		while(true){
			TimeUnit.MILLISECONDS.sleep(600);
			tIsAlie = t.isAlive();
			t1IsAlie = t1.isAlive();
			System.out.println(" Thrad  " +  tIsAlie + " " + "  Thraed 1 " + t1IsAlie);
			
			if(!tIsAlie && !t1IsAlie){
				break;
			}

			
		}

		System.out.println("[ " + currentThreadName + " ] Main Thread ends Here");

	}
}
