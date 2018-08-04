package avinash.learn.executor.returnvalue;

import avinash.learn.executor.common.ValueReturningTaskC;

public class ReturningValueThridWay {

	public static void main(String[] args) throws InterruptedException {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		ValueReturningTaskC  task1 = new ValueReturningTaskC(2,3,2000);
		Thread t1 = new Thread(task1 , "Thread 1");
		
		ValueReturningTaskC  task2 = new ValueReturningTaskC(3,4,1000);
		Thread t2 = new Thread(task2 , "Thread 2");
		
		ValueReturningTaskC  task3 = new ValueReturningTaskC(4,5,500);
		Thread t3 = new Thread(task3 , "Thread 3");
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t2.join();

		System.out.println("T1 " + task1.getSum());
		System.out.println("T2 " + task2.getSum());
		System.out.println("T3 " + task3.getSum());

    System.out.println("[ " + currentThreadName + " ] Main Thread Ends Here");

	}

}
