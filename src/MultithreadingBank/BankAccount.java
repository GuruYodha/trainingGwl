package MultithreadingBank;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }



    	public synchronized void withdraw(double amount) {
    		for(int i = 0; i<3; i++) {
    		if(amount < balance) {
    		balance = balance - amount;
    		System.out.println(Thread.currentThread()
    		.getName()+" withdrawing:"+amount);
    		System.out.println("Remaining Balance: "+
    		balance);
    		}
    		else
    		System.out.println("Insufficient Balance");

    		}
        }
    
    public double getBalance() {
        return balance;
    }
}

