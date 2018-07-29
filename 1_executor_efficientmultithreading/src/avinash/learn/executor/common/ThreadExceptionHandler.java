package avinash.learn.executor.common;

import java.lang.Thread.UncaughtExceptionHandler;

public class ThreadExceptionHandler implements UncaughtExceptionHandler {
	private String handlerId;

	public ThreadExceptionHandler(String handlerId) {
		this.handlerId = handlerId;
	}

	public ThreadExceptionHandler() {
	}

	@Override
	public void uncaughtException(Thread arg0, Throwable arg1) { 
		System.out.println(this + " Caught exception Thread " + arg0.getName() + " " + arg0);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " @ "+ this.hashCode() + (handlerId == null || "".equals(handlerId)) != null ? "": handlerId;
		
	}

	
}
