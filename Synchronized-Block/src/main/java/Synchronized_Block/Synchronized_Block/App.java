package Synchronized_Block.Synchronized_Block;

/**
 * Hello world!
 *
 */
public class App {
	private static int counter1 = 0;
	private static int counter2 = 0;

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	private static void add() {
		synchronized (lock1) {
			counter1++;
		}
	}

	private synchronized static void addAgain() {
		synchronized (lock1) {
			counter2++;
		}
	}

	public static void Compute() {
		for (int i = 0; i < 100; i++) {
			add();
			addAgain();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				Compute();
			}
		});
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				Compute();

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("counter1 .._" + counter1);
		System.out.println("counter2 .._" + counter2);

	}
}
