package ThreadPractice;

public class NumberThread implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("current thread is: "+Thread.currentThread().getName()+" and number is: "+i);
		}
	}

}
