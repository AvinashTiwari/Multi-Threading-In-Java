package Concurrency_1.Concurrency_1;

/**
 * Hello world!
 *
 */

class runner1{
	public void startRunning(){
		for(int i = 0; i <10; i++)
		{
			System.out.println("Runner 1" + i);
		}
	}
}

class runner2{
	public void startRunning(){
		for(int i = 0; i <10; i++)
		{
			System.out.println("Runner 2" + i);
		}
	}
}


public class App 
{
    public static void main( String[] args )
    {
    	runner1 r1 = new runner1();
    	runner1 r2 = new runner1();
    	
    	r1.startRunning();
    	r2.startRunning();

    }
}
