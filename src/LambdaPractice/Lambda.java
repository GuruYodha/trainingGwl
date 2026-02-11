package LambdaPractice;

import java.util.function.BiFunction;
import java.util.Scanner;
public class Lambda {

	public static void main(String[] args) {
		//Find out Max of two Numbers
		
		BiFunction<Integer,Integer,Integer> max = (a,b) -> (a>b)?a:b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers");
		Integer a = sc.nextInt();
		Integer b = sc.nextInt();
		System.out.println(
				max.apply(a,b));
		
	}

}
