package Student_Libary.Student_Libary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	private int id;
	private Lock lock;

	public Book(int id) {
		this.id = id;

		lock = new ReentrantLock();
	}

	public void read(Student student) throws InterruptedException {
		lock.tryLock(1, TimeUnit.MILLISECONDS);
		System.out.println(student + " Start Readin " + this);
		Thread.sleep(2000);
		lock.unlock();
		System.out.println(student + " Finished reading " + this);

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book #" + id;
	}

}
