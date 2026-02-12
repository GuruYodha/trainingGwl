package MultithreadingBank;

public class BankAccountDriver {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount(20000);
		Runnable task1 = ()->bankAccount.withdraw(1800);
		Runnable task2 = ()->bankAccount.withdraw(2400);
		Thread t1 = new Thread(task1, "Thread-1");
		Thread t2 = new Thread(task2, "Thread-2");
		t1.start();
		t2.start();

		}
    
}
