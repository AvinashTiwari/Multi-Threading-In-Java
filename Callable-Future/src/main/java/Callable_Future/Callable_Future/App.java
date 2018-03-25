package Callable_Future.Callable_Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */

class processor implements Callable<String> {
	private int id;

	public processor(int id) {
		this.id = id;
	}

	public String call() throws Exception {
		Thread.sleep(1000);
		return "id: " + id;
	}
}

public class App {
	public static void main(String[] args) {
		 ExecutorService es = Executors.newFixedThreadPool(2);
		 List<Future<String>> list = new ArrayList<>();
		 
		 for(int i =0; i < 5 ; i++)
		 {
			 Future<String> future = es.submit(new processor(i + 1));
			 list.add(future);
			 
		 }
		 
		 for(Future<String> future : list)
		 {
			 try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
		 es.shutdown();
	}
}
