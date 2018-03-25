package Executor_Services.Executor_Services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=0; i <5; i++)
        {
        	es.submit(new Worker());
        }
    }
}
class Worker implements Runnable {

	public void run() {
		for(int i=0; i < 10 ; i++)
		{
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
