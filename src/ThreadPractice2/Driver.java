package ThreadPractice2;

public class Driver {

	public static void main(String[] args) {
		
		SharedResource resource = new SharedResource();
		
		Thread producerThread = new Thread(()-> {
			resource.producer("Hello World!", true);
		},"this is the Producer-Thread");
		
		Thread consumerThread = new Thread(()-> {
			resource.consumer();
		},"this is the Consumer-Thread");
		
		producerThread.start();
		try {
			producerThread.join(); // Wait for producer to finish before starting consumer
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumerThread.start();
	}

}
