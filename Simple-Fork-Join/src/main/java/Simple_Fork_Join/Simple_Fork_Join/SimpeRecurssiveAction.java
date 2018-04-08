package Simple_Fork_Join.Simple_Fork_Join;

import java.util.concurrent.RecursiveAction;

public class SimpeRecurssiveAction extends RecursiveAction {
	
	private int simulatedWork;
	
	public SimpeRecurssiveAction(int simulatedWork)
	{
		this.simulatedWork = simulatedWork;
	}

	@Override
	protected void compute() {
		if(simulatedWork > 100)
		{
			System.out.println("Parralel execution split task" );
			SimpeRecurssiveAction SimpeRecurssiveAction1 = new SimpeRecurssiveAction(simulatedWork/2);
			SimpeRecurssiveAction SimpeRecurssiveAction2 = new SimpeRecurssiveAction(simulatedWork);
			SimpeRecurssiveAction1.fork();
			SimpeRecurssiveAction2.fork();

		}else
		{
			System.out.println("No Need Parallele execution");
		}
			
		
	}

}
