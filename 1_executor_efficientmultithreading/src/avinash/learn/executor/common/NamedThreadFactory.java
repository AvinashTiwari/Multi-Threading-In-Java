package avinash.learn.executor.common;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory  implements ThreadFactory {
   private static  int count =0;
   private static String Name = "MyThread -";
   
	@Override
	public Thread newThread(Runnable r) {
	 Thread t = new Thread(r, Name+ ++count);
	 return t;
	}

}
