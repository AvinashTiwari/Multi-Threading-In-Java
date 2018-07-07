package avinash.learn.executor.namming;

import avinash.learn.executor.common.LoopTaskB;

public class NammingThreadFirstWay {
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
      System.out.println(currentThreadName + " Main thread Start");
      new Thread(new LoopTaskB()).start();
      Thread t2 =       new Thread(new LoopTaskB());
      t2.start();
      System.out.println(currentThreadName + " End thread Start");

	}
}
