package avinash.learn.executor.common;

public class ThreadFactoryWithExceptionAlternator  extends NamedThreadFactory{
	private int count =0;
	
	public Thread newThread(Runnable r){
		Thread t = super.newThread(r);
		int sequenceNumber = ++count;
		
		if(sequenceNumber %2 ==0 ){
			t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		}
		
		return t;
	}

}
