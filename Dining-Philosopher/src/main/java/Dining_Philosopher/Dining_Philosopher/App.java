package Dining_Philosopher.Dining_Philosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exeutorService = null;
		Philosopher[] philosopher =  null;
		
		try {
			philosopher = new Philosopher[Constants.NUMBER_OF_PHILOSOPHER];
			ChopSticks[] chopSticks = new ChopSticks[Constants.NUMBER_OF_CHOP_STICK];
			
			for(int i=0; i < Constants.NUMBER_OF_CHOP_STICK; i++)
			{
				chopSticks[i] = new ChopSticks(i);
			}
			
			exeutorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHER);
			for(int i = 0; i < Constants.NUMBER_OF_PHILOSOPHER ; i++)
			{
				philosopher[i] = new Philosopher(i, chopSticks[i],chopSticks[(i + 1) % Constants.NUMBER_OF_CHOP_STICK]);
				exeutorService.execute(philosopher[i]);
			}
			
			Thread.sleep(Constants.SIMULATION_RUNNING_TIME);
			
			for(Philosopher p: philosopher)
			{
				p.setFull(true);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			
			exeutorService.shutdown();
			while(!exeutorService.isTerminated())
			Thread.sleep(1000);
			
			for(Philosopher p: philosopher)
			{
				System.out.println(p + " eats " + p.getcounter() );
			}
		}
	}
}
