package avinash.learn.executor.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LoopTaskF implements Runnable {

	private static int count = 0;
	private int InstanceNumber;
	private String taskId;
	private long sleeptime;

	@Override
	public void run() {
		boolean isRunningInDeamonThread = Thread.currentThread().isDaemon();
		String Threadtype = isRunningInDeamonThread ? "DEAMON" : "NoralThread";
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("< currentThreadName " + currentThreadName + ", " + Threadtype + " Id Is " + taskId
				+ " > Tick Tick  Start");

		for (int i = 10;; i++) {
			System.out.println("< currentThreadName " + currentThreadName + " Id Is " + taskId + " > Tick " + i);
			DoSomeWork();
			
			if(Thread.interrupted()){
				System.out.println("[ " +currentThreadName + " ] < " + taskId + " > canceling ... ");
				break;
			}

		}
		System.out.println("< currentThreadName " + currentThreadName + " Id Is " + taskId + " >  Retrving 'Interuppted' " );

		// System.out.println("< currentThreadName " + currentThreadName + " Id
		// Is " + taskId +" > Tick Tick Done");

	}


	private void DoSomeWork(){
		for(int i=0; i<2;i++){
			Collections.sort(generateDataSet());
		}
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


	public LoopTaskF() {
		// this.sleeptime = sleeptime;
		this.InstanceNumber = count++;
		this.taskId = "Loop Task F" + InstanceNumber;
		// new Thread(this).start();
	}
}
