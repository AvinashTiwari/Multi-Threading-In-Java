package Concurrency_Volatile.Concurrency_Volatile;

/**
 * Hello world!
 *
 */
class Worker implements Runnable {
	private volatile boolean isTerminated = false;
	
	

	public boolean isTerminated() {
		return isTerminated;
	}



	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}



	public void run() {
		// TODO Auto-generated method stub
		while(!isTerminated)
		{
			System.out.println("Hello World from Worker class");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

public class App {
	public static void main(String[] args) {
		Worker worker = new Worker();
		Thread t1 = new Thread(worker);
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		worker.setTerminated(true);
		
		System.out.println("Finished ");
	}
}
