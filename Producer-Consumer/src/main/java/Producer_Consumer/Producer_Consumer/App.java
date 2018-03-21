package Producer_Consumer.Producer_Consumer;

import java.util.*;
import java.util.List;

/**
 * Hello world!
 *
 */
class Processor {

	private List<Integer> list = new ArrayList<Integer>();
	private final int LIMIT = 5;
	private final int BOTTOM = 0;
	private final Object lock = new Object();
	private int value = 0;

	public void produce() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (list.size() == LIMIT) {
					System.out.println("Waiting for removal items from the list");
					lock.wait();
				} else {
					System.out.println("Add " + value);
					list.add(value);
					value++;
					lock.notify();

				}
				Thread.sleep(500);
			}

		}
	}

	public void consume() throws InterruptedException {
		synchronized (lock) {
			while (true) {
				if (list.size() == BOTTOM) {
					System.out.println("Waiting for adding item for list");
					lock.wait();

				} else {
					System.out.println("Remove " + list.remove(--value));
					lock.notify();

				}

				Thread.sleep(500);
			}
		}
	}
}

public class App {

	public static void main(String[] args) {

		final Processor p = new Processor();

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					p.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		Thread t2 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					p.consume();
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
