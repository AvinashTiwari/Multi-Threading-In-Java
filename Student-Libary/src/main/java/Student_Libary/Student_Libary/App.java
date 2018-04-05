package Student_Libary.Student_Libary;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Student[] students = null;
		Book[] books = null;
		ExecutorService xecutorService = Executors.newFixedThreadPool(Constant.NUMBER_OF_STUDENT);

		try{
		books = new Book[Constant.NUMBER_OF_BOOKS];
		students = new Student[Constant.NUMBER_OF_STUDENT];
		
		for(int i=0; i < Constant.NUMBER_OF_BOOKS; i++)
			books[i] = new Book(i);
		
		for(int i=0 ; i < Constant.NUMBER_OF_STUDENT;i++)
		{
			students[i] = new Student(i, books);
			xecutorService.execute(students[i]);
		
		}
		}catch(Exception ex)
		{
			
		}finally
		{
			xecutorService.shutdown();
		}
		
		
	}
}
