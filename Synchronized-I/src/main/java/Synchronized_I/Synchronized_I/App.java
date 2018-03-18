package Synchronized_I.Synchronized_I;

/**
 * Hello world!
 *
 */
public class App 
{
	private static int counter = 0;
	public static synchronized void increment()
	{
		++counter;
	}
	
	public static void Process(){
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for(int i =0 ; i < 100; ++i)
				{
				 increment();	
				}
				
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				for(int i =0 ; i < 100; ++i)
				{
					increment();	
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
	
    public static void main( String[] args )
    {
    	Process();
    	System.out.println(counter);
    	
    }
}
