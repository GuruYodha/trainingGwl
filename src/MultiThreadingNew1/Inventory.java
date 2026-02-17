package MultiThreadingNew1;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Inventory{
	
	private int stock=10;
	Random random = new Random();
	
	Runnable puchaseTask=()->{
		if(stock>0) {
			int quantity=random.nextInt(4)+1;
			synchronized(this) {
			if(stock>=quantity) {
				stock-=quantity;
				System.out.println(Thread.currentThread().getName()+" purchased "+quantity+" units. Remaining stock: "+stock);
			} else {
				System.out.println(Thread.currentThread().getName()+" failed to purchase. Not enough stock. Remaining stock: "+stock);
			}
		}
		}
	};
	
	public static void main(String[] args) {
		
		Inventory inventory = new Inventory();
		
//		Thread c1=new Thread(inventory.puchaseTask,"Customer-1");
//		Thread c2=new Thread(inventory.puchaseTask,"Customer-2");
//		Thread c3=new Thread(inventory.puchaseTask,"Customer-3");
//		Thread c4=new Thread(inventory.puchaseTask,"Customer-4");
//		Thread c5=new Thread(inventory.puchaseTask,"Customer-5");
//		
//		c1.start();
//		c2.start();
//		c3.start();
//		c4.start();
//		c5.start();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		
		for(int i=1;i<=5;i++) {
			executor.submit(inventory.puchaseTask);
		}
		executor.shutdown();
		
		 while (!executor.isTerminated()) {
	            // Wait for all tasks to finish
	        }
		 
		 System.out.println("Final stock: "+inventory.stock);
		 
	}
	
}
//You are developing an Inventory Management System for an e-commerce warehouse.
//The warehouse has a limited stock of a product. Multiple customers are trying to
//purchase the product at the same time.
//Your task is to implement a multithreaded program that ensures:
//Stock never becomes negative.
//No overselling happens.
//Proper synchronization is maintained.
//
//Requirements
//============
//Initial stock = 10 units
//Create 5 customer threads
//Each customer tries to purchase a random quantity between 1 and 4.
//If enough stock is available:
//Deduct stock
//Print success message
//If stock is insufficient:
//Print failure message
//Final stock should be printed at the end.