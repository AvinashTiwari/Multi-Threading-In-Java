package Blocking_Queue.Blocking_Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Hello world!
 *
 */

class FirstWorker implements Runnable{
	private BlockingQueue<Integer> blockinhQueue;
	
	public FirstWorker(BlockingQueue<Integer> blockinhQueue)
	{
		this.blockinhQueue = blockinhQueue;
	}

	public void run() {
		int counter = 0;
       while(true)
       {
    	   try {
			blockinhQueue.put(counter);
	    	   counter++;
	    	   System.out.println("Putting Item " + counter);
	    	   Thread.sleep(1000);
    	   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
       }
	}
	
}

class SecondWorker implements Runnable{
	private BlockingQueue<Integer> blockinhQueue;
	
	public SecondWorker(BlockingQueue<Integer> blockinhQueue)
	{
		this.blockinhQueue = blockinhQueue;
	}

	public void run() {
		int counter = 0;
       while(true)
       {
    	   try {
			int nu = blockinhQueue.take();
			System.out.println(" Taking Item from Queue " + nu);
  	    	   Thread.sleep(300);
    	   } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
       }
	}
	
}



public class App 
{
    public static void main( String[] args )
    {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        FirstWorker firstWorker =  new FirstWorker(blockingQueue);
        SecondWorker secondWorker = new SecondWorker(blockingQueue);
        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
}
}
