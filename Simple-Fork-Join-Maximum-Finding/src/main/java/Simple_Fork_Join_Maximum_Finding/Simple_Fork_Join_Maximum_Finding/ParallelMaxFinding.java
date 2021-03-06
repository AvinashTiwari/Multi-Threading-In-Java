package Simple_Fork_Join_Maximum_Finding.Simple_Fork_Join_Maximum_Finding;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFinding extends RecursiveTask<Integer> {
	public int[] nums;
	private int lowIndex;
	private int highIndex;

	public ParallelMaxFinding(int[] nums, int lowIndex, int highIndex) {
		this.nums = nums;
		this.lowIndex = lowIndex;
		this.highIndex = highIndex;
	}

	@Override
	protected Integer compute() {
		 if(highIndex - lowIndex < App.THREASHOLD )
		 {
			 return sequentialMaxfinding();
		 }else
		 {
			 int middleIndex = (lowIndex + highIndex) / 2;
			 ParallelMaxFinding parallelMaxFinding1 =  new ParallelMaxFinding(nums,lowIndex, middleIndex);
			 ParallelMaxFinding parallelMaxFinding2 =  new ParallelMaxFinding(nums,middleIndex+1, highIndex);
			 invokeAll(parallelMaxFinding1, parallelMaxFinding2);
			 return Math.max(parallelMaxFinding1.join(), parallelMaxFinding2.join());

		 }
	}

	
	public int sequentialMaxfinding()
	{
		int max = nums[lowIndex];
		for(int i = lowIndex ; i < highIndex; i++)
		{
			if(nums[i] > max)
			{
				max = nums[i];
			}
		}
		
		return max;
	}

}
