package Simple_Fork_Join_Recursive_Task.Simple_Fork_Join_Recursive_Task;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer>{
	
	private int simulatedTask;
	public SimpleRecursiveTask(int simulatedTask)
	{
		this.simulatedTask = simulatedTask;
	}

	@Override
	protected Integer compute() {
		if(simulatedTask > 100)
		{
			System.out.println("Parallel execution neede becuase of huse task "  + simulatedTask);
			SimpleRecursiveTask task1 = new  SimpleRecursiveTask(simulatedTask/2);
			SimpleRecursiveTask task2 = new  SimpleRecursiveTask(simulatedTask/2);
			task1.fork();
			task2.fork();
			
			int solution  = 0;
			solution += task1.join();
			solution += task2.join();
			
			return solution;

			
		}else
		{
			System.out.println("No need for parallel execution. " + simulatedTask);
			return 2 * simulatedTask;
		}
	}

}
