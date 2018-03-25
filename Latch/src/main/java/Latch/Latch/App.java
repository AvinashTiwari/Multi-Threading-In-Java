package Latch.Latch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ExecutorService exeServcie = Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(5);
		for (int i = 0; i < 5; i++)
			exeServcie.execute(new Worker(i+1, latch));
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All Prequeiste done");
		exeServcie.shutdown();

	}

}

class Worker implements Runnable {
	private int id;
	private CountDownLatch countDownLatchdata;
	private Random random;

	public Worker(int id, CountDownLatch countDownLatch) {
		this.id = id;
		this.countDownLatchdata = countDownLatch;
	}

	public void run() {
		doWork();
		countDownLatchdata.countDown();
	}

	private void doWork() {
		System.out.println("Thread with Id : " + this.id + " Start working..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
