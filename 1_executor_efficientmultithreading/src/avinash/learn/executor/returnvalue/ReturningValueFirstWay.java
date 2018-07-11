package avinash.learn.executor.returnvalue;

public class ReturningValueFirstWay {

	public static void main(String[] args) {
    String currentThreadName = Thread.currentThread().getName();
    System.out.println("[ " + currentThreadName + " ] Main Thread starts Here");
		
    System.out.println("[ " + currentThreadName + " ] Main Thread Ends Here");

	}

}
