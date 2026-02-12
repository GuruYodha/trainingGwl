package VehiclePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VehicleMethods {
	Scanner sc=new Scanner(System.in);
	List<Vehicles> vl=new ArrayList<>();
	Map<Integer,Vehicles> vm= new HashMap<>();
	
	//1
	public void addRecord() {
		System.out.println("enter your ID");
		int id=sc.nextInt();
		sc.nextLine();
		if(vm.containsKey(id)) {
			System.out.println("Duplicate Exists");
			return;
		}else {
			System.out.println("enter your name");
			String name=sc.nextLine();
			System.out.println("enter your type CAR/BIKE/TRUCK/VAN");
			String type=sc.nextLine();
			System.out.println("enter your status RENTAL/ONGOING");
			String status=sc.nextLine();
			System.out.println("enter your Base");
			double Base=sc.nextDouble();
			System.out.println("enter the number of days");
			int days=sc.nextInt();
			try {
			Vehicles v1=new Vehicles(id,name,days,Base,status,type);
			vm.put(id,v1);
			vl.add(v1);
			}
			catch(InvalidVehicleTypeException e) {
				e.getMessage();
			}
		}
		
	}
	//2 locate rental
	
	public void locateRental() {
		System.out.println("enter your id");
		int id=sc.nextInt();
		if(vm.containsKey(id)) {
			System.out.println(vm.get(id));
		}
		else {
			System.out.println("ID does not exist");
			return;
		}
	}
	//3 display all ongoing
		public void displayAllOngoing() {
			for(Vehicles v:vl) {
				if(v.rentalstatus==VehicleStatus.ONGOING){
					System.out.println(v);
				}
			}
			
		}
	//4 group rentals
		public void groupRentalsByType() {
			Map<VehicleType,Integer> countMap = new HashMap<>();
			
			for(Vehicles v:vl) {
				countMap.put(v.vehicletype,countMap.getOrDefault(v.vehicletype,0)+1);
			}
			
			for(Map.Entry<VehicleType,Integer> entry:countMap.entrySet()) {
				System.out.println(entry.getKey()+" : "+entry.getValue());
			}
		}

	//5 Highest Rental Cost
		public void highest() {
			Vehicles max=null;
			
			for(Vehicles v:vl) {
				if(max==null||v.TotalRentalCost>max.TotalRentalCost) {
					max =v;
				}
			}
			System.out.println(max);
			
		}
	//6
		public void remove() {
			
				Iterator<Vehicles> it=vl.iterator();
				while(it.hasNext()) {
					Vehicles v=it.next();
					if(v.rentalstatus==VehicleStatus.COMPLETED) {
						it.remove();
						vm.remove(v.Rental_ID);
						System.out.println("Completed Rentals have been removed");
					} 
					else
					 {
						System.out.println("No Completed Rentals to remove");
						return;
					}
				}
				
			}
		} 
	


