package Delayed_Queue.Delayed_Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		BlockingQueue<DelayedWorker> queue = new DelayQueue<>();
		
		try{
			queue.put(new DelayedWorker(1000, "Thi First Messsage"));
			queue.put(new DelayedWorker(10000, "Thi Second Messsage"));
			queue.put(new DelayedWorker(4000, "Thi Third  Messsage"));

		}catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		
		while(!queue.isEmpty())
		{
			try{
				System.out.println(queue.take());
			}catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
}

class DelayedWorker implements Delayed {

	private long duration;
	private String message;

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DelayedWorker(long duration, String message) {
		this.duration = duration + System.currentTimeMillis();
		this.message = message;
	}

	public int compareTo(Delayed otherDelayed) {
		if (this.duration < ((DelayedWorker) otherDelayed).getDuration()) {
			return -1;
		}

		if (this.duration > ((DelayedWorker) otherDelayed).getDuration()) {
			return 1;
		}

		return 0;
	}

	public long getDelay(TimeUnit unit) {
		// TODO Auto-generated method stub
		return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.message;
	}
	
	
	
	

}
