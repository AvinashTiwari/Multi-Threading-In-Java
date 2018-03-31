package Exchanger.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * Hello world!
 *
 */
class FirstThread implements Runnable{
	
	private int counter;
	private Exchanger<Integer> exchange;
	
	public FirstThread(Exchanger<Integer> exchange)
	{
		this.exchange =exchange;
	}

	public void run() {
        while(true)
        {
        	counter = counter +1;
        	System.out.println("First Thread increment the counter " + counter);
        	try {
				counter = exchange.exchange(counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
}


class SecondThread implements Runnable{
	
	private int counter;
	private Exchanger<Integer> exchange;
	
	public SecondThread(Exchanger<Integer> exchange)
	{
		this.exchange =exchange;
	}

	public void run() {
        while(true)
        {
        	counter = counter - 1;
        	System.out.println("Second Thread decrement the counter " + counter);
        	try {
				counter = exchange.exchange(counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	try {
				Thread.sleep(1000);
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
    	Exchanger<Integer> exchanger = new Exchanger<Integer>();
    	new Thread (new FirstThread(exchanger)).start();
    	new Thread (new SecondThread(exchanger)).start();

    }
}
