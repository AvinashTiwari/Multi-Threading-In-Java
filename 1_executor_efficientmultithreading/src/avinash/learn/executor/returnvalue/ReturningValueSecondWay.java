package avinash.learn.executor.returnvalue;

import avinash.learn.executor.common.ValueReturningTaskA;
import avinash.learn.executor.common.ValueReturningTaskB;

public class ReturningValueSecondWay {

	public static void main(String[] args) {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		ValueReturningTaskB  task1 = new ValueReturningTaskB(2,3,2000,new  SumObserver("task 1"));
		Thread t1 = new Thread(task1 , "Thread 1");
		
		ValueReturningTaskB  task2 = new ValueReturningTaskB(3,4,1000,new  SumObserver("task 2"));
		Thread t2 = new Thread(task2 , "Thread 2");
		
		ValueReturningTaskB  task3 = new ValueReturningTaskB(4,5,500, new  SumObserver("task 3"));
		Thread t3 = new Thread(task3 , "Thread 3");
		t1.start();
		t2.start();
		t3.start();
		
		

    System.out.println("[ " + currentThreadName + " ] Main Thread Ends Here");

	}

}
