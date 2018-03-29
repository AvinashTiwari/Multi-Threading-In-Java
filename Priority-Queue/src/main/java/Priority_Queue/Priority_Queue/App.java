package Priority_Queue.Priority_Queue;

import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Hello world!
 *
 */

class FirstWorker implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public FirstWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		try {
			blockingQueue.put("B");
			blockingQueue.put("H");
			blockingQueue.put("A");
			Thread.sleep(1000);
			blockingQueue.put("F");
			Thread.sleep(1000);

			blockingQueue.put("E");

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}

class SecondWorker implements Runnable {

	private BlockingQueue<String> blockingQueue;

	public SecondWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			Thread.sleep(1000);
			System.out.println(blockingQueue.take());
			System.out.println(blockingQueue.take());

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}

public class App {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new PriorityBlockingQueue<>();
		
		new Thread(new FirstWorker(queue)).start();
		new Thread(new SecondWorker(queue)).start();
	}
}
