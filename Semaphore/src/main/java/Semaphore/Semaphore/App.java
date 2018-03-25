package Semaphore.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 *
 */

enum Downloader {
	INSTANCE;
	private Semaphore semaphore = new Semaphore(3, true);

	public void downloaddata() {
		try {
			semaphore.acquire();
			download();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaphore.release();
		}

	}

	private void download() {
		// TODO Auto-generated method stub
		System.out.println("Download data from Web");

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class App {
	public static void main(String[] args) {
		ExecutorService  exeService =  Executors.newCachedThreadPool();
		for(int i=0 ; i < 12 ; i++)
		{
			exeService.execute(new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					Downloader.INSTANCE.downloaddata();			
				}
			});
		}
		
	}
}
