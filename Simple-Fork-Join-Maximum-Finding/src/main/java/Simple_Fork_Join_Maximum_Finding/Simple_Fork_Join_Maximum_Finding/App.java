package Simple_Fork_Join_Maximum_Finding.Simple_Fork_Join_Maximum_Finding;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Hello world!
 *
 */
public class App 
{
	public static int THREASHOLD =0;
    public static void main( String[] args )
    {
    	int[] nums = initNums();
    	THREASHOLD  = nums.length / Runtime.getRuntime().availableProcessors();
    	
    	SequentialMaxFinding sequentialMaxFinding = new SequentialMaxFinding();
    	long start = System.currentTimeMillis();
    	System.out.println("Seq Malx finding " +sequentialMaxFinding.sequentialMaxfinding(nums, nums.length) );
    	System.out.println("Time tasken " + (System.currentTimeMillis() - start) + "ms");
    	
    	ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    	ParallelMaxFinding parallelMaxFinding = new ParallelMaxFinding(nums, 0, nums.length);
    	 start = System.currentTimeMillis();
    	 System.out.println("MAx: " + forkJoinPool.invoke(parallelMaxFinding));
     	System.out.println("Time tasken for Parllel " + (System.currentTimeMillis() - start) + "ms");


    	
    	
     }
	private static int[] initNums() {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		int[] num = new int[30000000];
		for(int i=0; i <30000000 ; i++)
		{
			num[i] = random.nextInt(1000);
		}
		
		return num;
	}
}
