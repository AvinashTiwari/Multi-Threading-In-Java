package avinash.learn.executor.common;

public class ThreadfactoryWithExceptionHandler extends NamedThreadFactory{
	
	public Thread newThread(Runnable r){
		Thread t = super.newThread(r);
		t.setUncaughtExceptionHandler(new ThreadExceptionHandler());
		return t;
	}

}
