package Concurrency_Thread_Join.Concurrency_Thread_Join;

/**
 * Hello world!
 *
 */
class runner1 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i <10; i++)
		{
			System.out.println("Runner 1 <>" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	
}

class runner2 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i <10; i++)
		{
			System.out.println("Runner 2 <>" + i);
			try {
				Thread.sleep(100);
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
    	Thread t1 = new Thread(new runner1());
    	Thread t2 = new Thread(new runner2());

    	t1.start();
    	t2.start();
    	
    	try {
			t1.join();
	    	t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("Completed");
    	

    }
}
