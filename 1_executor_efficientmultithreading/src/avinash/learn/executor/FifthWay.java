package avinash.learn.executor;

import java.util.concurrent.TimeUnit;

public class FifthWay {
	public static void main(String[] args) {
      new Thread(new Runnable(){

		@Override
		public void run() {
			for (int i = 10; i > 0; i--) {
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}});
	}
}
