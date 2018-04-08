package Simple_Fork_Join.Simple_Fork_Join;

import java.util.concurrent.ForkJoinPool;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpeRecurssiveAction simpeRecurssiveAction = new SimpeRecurssiveAction(120);
		pool.invoke(simpeRecurssiveAction);
		
	}
}
