package avinash.learn.executor.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskA extends TimerTask {

	private long sleepTime;
	private int sum;

	private static int count = 0;
	private int instanceNumber;
	private String taskId;
    private SimpleDateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
	
	public ScheduleTaskA(long sleepTime) {
		this.sleepTime = sleepTime;
		this.instanceNumber = ++count;
		this.taskId = "ScheduleTaskA " + this.instanceNumber;
	}

	@Override
	public void run() {
		Date startTime = new Date();
		Date ScheduedForRunningTime = new Date(super.scheduledExecutionTime());

		String currentThreadName = Thread.currentThread().getName();
		System.out.println("###[ " + currentThreadName + " ]##  < " + taskId + " > Scheduled To  run at " + ScheduedForRunningTime + " "  + dateFormater.format(startTime));
 		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			System.out.println(currentThreadName + "  " + taskId);
			this.notify();
		}
	}

}
