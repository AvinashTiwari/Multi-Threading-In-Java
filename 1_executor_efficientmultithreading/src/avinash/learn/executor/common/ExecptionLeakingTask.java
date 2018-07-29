package avinash.learn.executor.common;

public class ExecptionLeakingTask implements Runnable {

	@Override
	public void run() {
		throw new RuntimeException();
		
	}

}
