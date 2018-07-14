package avinash.learn.executor.returnvalue;

import avinash.learn.executor.common.ResultListner;

public class SumObserver implements ResultListner<Integer>{

	private String taskId;
	public SumObserver(String taskId){
		this.taskId = taskId;
	}
	
	
	@Override
	public void notifyResult(Integer result) {
		System.out.println("Result for TaskId " + taskId + " == " + result);
		
	}

}
