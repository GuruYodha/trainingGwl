package ThreadPractice1;

public class VolatileDemo {
	static volatile boolean flag = false;

	public static void main(String[] args) {
			Thread t1 = new Thread(()-> {
				while(!flag) {
				}
				System.out.println("Flag value updated");
				},"Thread-1");

			Thread t2 = new Thread(()-> {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					flag = true;
					System.out.println("Flag value updated by:"+Thread.currentThread().getName());
					},"Thread-2");

					t1.start();
					t2.start();

}

}