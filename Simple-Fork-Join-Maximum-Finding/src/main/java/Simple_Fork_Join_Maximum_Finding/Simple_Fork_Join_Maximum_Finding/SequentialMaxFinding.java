package Simple_Fork_Join_Maximum_Finding.Simple_Fork_Join_Maximum_Finding;

public class SequentialMaxFinding {
	
	public int sequentialMaxfinding(int[] nums , int highIndex)
	{
		int max = nums[0];
		for(int i = 1 ; i < highIndex; i++)
		{
			if(nums[i] > max)
			{
				max = nums[i];
			}
		}
		
		return max;
	}

}
