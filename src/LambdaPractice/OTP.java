package LambdaPractice;
import java.util.Random;
import java.util.function.Supplier;
public class OTP {

	public static void main(String[] args) {
		//Generate OTP of 6 digits
		Random rand = new Random();
		
		Supplier<Integer>otp=()->{
			int num=rand.nextInt(1000000);
			if(num>99999) {
				return num;
			}
			else {
				return num+100000;
			}
		};
		
		for(;;) {
			
		System.out.println("The OTP is "+otp.get());
		}
	}

}
