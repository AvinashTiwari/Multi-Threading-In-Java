package Student_Libary.Student_Libary;

import java.util.Random;

public class Student implements Runnable{
	private int id;
	
	private Book[] book;
	
	public Student(int id, Book[] book)
	{
		this.id = id;
		this.book = book;
	}

	public void run() {
		Random random = new Random();
		while(true)
		{
			int bookId = random.nextInt(Constant.NUMBER_OF_BOOKS);
			try {
				book[bookId].read(this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student # " +id;
	}
	
	
}
