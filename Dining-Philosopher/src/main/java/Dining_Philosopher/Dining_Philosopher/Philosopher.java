package Dining_Philosopher.Dining_Philosopher;

import java.util.Random;

public class Philosopher implements Runnable {
	private int id;
	private ChopSticks leftChopstik;
	private ChopSticks rightChopstik;
	private Random random;
	private int eatingCounter;
	private volatile boolean isFull = false;

	public Philosopher(int id, ChopSticks leftChopstik, ChopSticks rightChopstik) {
		this.id = id;
		this.leftChopstik = leftChopstik;
		this.rightChopstik = rightChopstik;
		this.random = new Random();

	}

	public void run() {

		try {

			while (!isFull) {
				think();
				if(leftChopstik.pickUp(this, State.LEFT))
				{
					if(rightChopstik.pickUp(this, State.RIGHT))
					{
						eat();
						rightChopstik.putDown(this, State.RIGHT);
					}
					
					leftChopstik.putDown(this, State.RIGHT);
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}
	
	public int getcounter()
	{
		return this.eatingCounter;
	}

	private void think() throws InterruptedException {
		System.out.println(this + " is thinking.. ");
		Thread.sleep(random.nextInt(1000));
	}

	private void eat() throws InterruptedException {
		System.out.println(this + " is eating.. ");
		this.eatingCounter++;
		Thread.sleep(random.nextInt(1000));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Philoapher " + id;
	}

}
