package Wait_Notify.Wait_Notify;

/**
 * Hello world!
 *
 */
class Processor {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("This is produce");
			wait();
			System.out.println("Again Produce");

		}

	}

	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized (this) {
			System.out.println("This is Consumer");
			notify();
			System.out.println("Again Consumer");
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
