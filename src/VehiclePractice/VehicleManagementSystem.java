package VehiclePractice;

import java.util.Scanner;

public class VehicleManagementSystem {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		VehicleMethods vm=new VehicleMethods();
		while(true) {
			
			System.out.println("Welcome to Vehicle Management System");
			System.out.println("1.Add Record\n"
					+ "2.Locate Rental\n"
					+ "3.Display All ONGOING\n"
					+ "4.Group Rentals by Type\n"
					+ "5.Higest Base Rental\n"
					+ "6.Remove Completed Rentals\n"
					+ "7.Exit");
			int input=sc.nextInt();
			sc.nextLine();
			
			switch(input) {
			case 1:
				vm.addRecord();
				break;
			case 2:
				vm.locateRental();
				break;
			case 3:
				vm.displayAllOngoing();
				break;
			case 4:
				vm.groupRentalsByType();
				break;
			case 5:
				vm.highest();
				break;
			case 6:
				vm.remove();
				break;
			default:
                  System.out.println("Invalid choice. Try again!");
			}
		}

	}

}
