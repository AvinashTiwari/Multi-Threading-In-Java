package avinash.learn.executor.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskH implements Runnable {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	private long sleeptime;
	private boolean seetingflage =false;

	@Override
	public void run() {
		boolean isRunningInDeamonThread = Thread.currentThread().isDaemon();
		String Threadtype = isRunningInDeamonThread ? "DEAMON" : "NoralThread";
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName + ", " + Threadtype + " Id Is " + taskId
				+ " > Tick Tick  Start");

		for (int i = 10;; i++) {
			System.out.println("< currentThreadName " + currentThreadName + " Id Is " + taskId + " > Tick " + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long) (Math.random() * 3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(
						"< currentThreadName " + currentThreadName + " Id Is " + taskId + " > Sleep Interuted" + 
				 "Setting flag");
				seetingflage  = true;
			}
			
			doSomeWork();
			
			if(seetingflage || Thread.interrupted()){
				System.out.println("interrupted");
				break;
			}

		}

		// System.out.println("< currentThreadName " + currentThreadName + " Id
		// Is " + taskId +" > Tick Tick Done");

	}

	private void doSomeWork() {
		System.out.println("< currentThreadName "  );		
	}

	public LoopTaskH() {
		// this.sleeptime = sleeptime;
		this.InstanceNumber = count++;
		this.taskId = "Loop TaskGH" + InstanceNumber;
		// new Thread(this).start();
	}
}
