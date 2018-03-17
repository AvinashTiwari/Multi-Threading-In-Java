package Concurrency_Runner.Concurrency_Runner;


/**
 * Hello world!
 *
 */
class runner1 implements Runnable{

	public void run() {
		for(int i = 0; i <10; i++)
		{
			System.out.println("Runner 1 <>" + i);
		}		
	}
	
	
}

class runner2 implements Runnable{

	public void run() {
		for(int i = 0; i <10; i++)
		{
			System.out.println("Runner 2 <>" + i);
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

    }
}
