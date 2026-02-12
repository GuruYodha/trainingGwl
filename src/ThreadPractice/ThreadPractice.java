package ThreadPractice;

public class ThreadPractice {

	public static void main(String[] args) {
		
		Runnable r1 = ()->{
			for(int i=1;i<=5;i++) {
				System.out.println("current thread is: "+Thread.currentThread().getName()+" and number is: "+i);
			}
		};
		
		Thread t1 = new Thread(r1,"Thread-1");
		Thread t2 = new Thread(r1,"Thread-2");
		
		t1.start();
		t2.start();

	}

}
