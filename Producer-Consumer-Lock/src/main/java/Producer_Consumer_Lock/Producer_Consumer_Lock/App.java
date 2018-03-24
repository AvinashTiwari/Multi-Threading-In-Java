package Producer_Consumer_Lock.Producer_Consumer_Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */

class worker {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void producer() throws InterruptedException {
		lock.lock();
		System.out.println("producr method...");
		condition.await();
		System.out.println("producr again...");
		lock.unlock();

	}

	public void consumer() throws InterruptedException {
		lock.lock();
		Thread.sleep(2000);
		System.out.println("consumer method...");
		condition.signal();
		lock.unlock();

	}
}

public class App {
	public static void main(String[] args) {
		final worker wordker = new worker();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					wordker.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					wordker.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
