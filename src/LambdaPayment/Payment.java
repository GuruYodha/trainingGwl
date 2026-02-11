package LambdaPayment;

public class Payment {
	int amount;
	int paymentId;
	String status;
	

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment Receipt : [amount=" + amount + ", paymentId=" + paymentId + ", status=" + status + "]";
	}
	
}
//Create a Payment class
//paymentId
//amount
//status
//Use Predicate to validate payment (amount >= 0)
//use consumer to log payment
//use supplier to generate payment reference number
//use function to generate the receipt