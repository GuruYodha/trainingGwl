package LambdaPayment;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
public class Driver {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Payment Amount ");
	
		int amount=sc.nextInt();
		
		System.out.println("Enter Payment Id");
		
		int paymentId=sc.nextInt();
		
		Payment payment =new Payment();
		
		
		
		//1
		
		Predicate<Integer> validatePayment = amount1 -> amount1 >= 0;
		//2
				
		Consumer<Payment> logPayment = payment1 ->{
			payment1.setAmount(amount);
			payment.setStatus("Successful");
			payment.setPaymentId(paymentId);
		};
		
		//3
		
		Random rand = new Random();
		Supplier<String> generatePaymentReference = () -> {
			
			return "REF NO: "+rand.nextInt(100000)+1000;
		};
		
		//4
		Function<Integer,Integer> generateReceipt = (a)->{
			
			return rand.nextInt(100000)+1000;
		};
		

		
		if(validatePayment.test(amount)) {
			logPayment.accept(payment);
			System.out.println(generatePaymentReference.get());
			System.out.println("Receipt No: "+generateReceipt.apply(amount));
			System.out.println(payment);
			
		}else {
			System.out.println("Invalid Payment");
		}
		
	}

}
