package avinash.learn.executor.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CalculationTaskC implements Callable<Long> {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	private long sleeptime;
	private boolean isThreadInteruppted = false;

	@Override
	public Long call() throws Exception {
		boolean isRunningInDeamonThread = Thread.currentThread().isDaemon();
		String Threadtype = isRunningInDeamonThread ? "DEAMON" : "NoralThread";
		long totalTimeTakenInMills =0;
		
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName + ", " + Threadtype + " Id Is " + taskId
				+ " > Tick Tick  Start");

		for (int i = 0; i < 1000; i++) {
			System.out.println("< currentThreadName " + currentThreadName + " Id Is " + taskId + " > Tick " + i
					+ " Current running average " + (i==0 ? 0: totalTimeTakenInMills / (2 * i)));
			long timeTakenInMillis = DoSomeWork();
			totalTimeTakenInMills += timeTakenInMillis;
			if(Thread.interrupted()){
				System.out.println("[ " +currentThreadName + " ] < " + taskId + " > canceling ... ");
				break;
			}

		}
		System.out.println("< currentThreadName " + currentThreadName + " Id Is " + taskId + " >  Retrving 'Interuppted' " );

		// System.out.println("< currentThreadName " + currentThreadName + " Id
		// Is " + taskId +" > Tick Tick Done");
		
		return isThreadInteruppted  ? -1 : totalTimeTakenInMills;

	}


	private long DoSomeWork(){
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<2;i++){
			Collections.sort(generateDataSet());
		}
		
		return System.currentTimeMillis() - startTime;
	}

	private List<Integer> generateDataSet() {
		// TODO Auto-generated method stub
		List<Integer> inList = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 100000; i++){
			inList.add(random.nextInt(100000));
		}
		return inList;
	}


	public CalculationTaskC() {
		// this.sleeptime = sleeptime;
		this.InstanceNumber = count++;
		this.taskId = "Loop Task C" + InstanceNumber;
		// new Thread(this).start();
	}
}
