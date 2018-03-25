package Cyclic_Barrier.Cyclic_Barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */

class Worker implements Runnable {
	private int id;
	private Random random;
	private CyclicBarrier cyclicBarrier;

	public Worker(CyclicBarrier cyclicBarrier, int id) {
		this.cyclicBarrier = cyclicBarrier;
		this.id = id;
		this.random = new Random();
	}

	public void run() {
		doWork();
	}

	private void doWork() {
		System.out.println("Thread with id  : " + this.id + " Starte the Tsak");
		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Thread with Id has finised " + this.id);
		try {
			cyclicBarrier.await();
			System.out.println("After Await");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + this.id;
	}

}

public class App {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {

			public void run() {
				System.out.println("All task are Finished");
			}
		});

		for (int i = 0; i < 5; i++) {
			executorService.execute(new Worker(barrier, i));
		}
		
		executorService.shutdown();
	}
}
