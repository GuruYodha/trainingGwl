package VehiclePractice;

public class Vehicles {

int Rental_ID;
String CustomerName;
double TotalRentalCost;
int Days;
double BaseDailyRate;

VehicleStatus rentalstatus;
VehicleType vehicletype;
public Object id; 

public Vehicles(int rental_ID, String customerName, int days, double baseDailyRate,
		String rentalstatus, String vehicletype) throws InvalidVehicleTypeException {
	super();
	Rental_ID = rental_ID;
	CustomerName = customerName;
	Days = days;
	BaseDailyRate = baseDailyRate;
	try {
	this.rentalstatus = VehicleStatus.valueOf(rentalstatus.toUpperCase());
	this.vehicletype = VehicleType.valueOf(vehicletype.toUpperCase());
	}
	catch(Exception e) { 
	throw new InvalidVehicleTypeException("Invalid rental status or vehicle type...please provide valid values."); 
	} 
	
	ChargeCalculate();
	}
	
public void setRental_ID(int rental_ID) {
	Rental_ID = rental_ID;
}
public void setCustomerName(String customerName) {
	CustomerName = customerName;
}
public void setTotalRentalCost(double totalRentalCost) {
	TotalRentalCost = totalRentalCost;
}
public void setDays(int days) {
	Days = days;
}
public void setBaseDailyRate(double baseDailyRate) {
	BaseDailyRate = baseDailyRate;
}

public void ChargeCalculate() {
	switch(vehicletype) {
	
	//Total Charge = (Base Daily Rate × Number of Days)
    //+ Vehicle Type Increase
	
	case BIKE:
		TotalRentalCost = (BaseDailyRate * Days) + (BaseDailyRate * 0.10);
		 break;
		
	case CAR:
		TotalRentalCost = (BaseDailyRate * Days) + (BaseDailyRate * 0.25);
		 break;
		
	case TRUCK:
		TotalRentalCost = (BaseDailyRate * Days) + (BaseDailyRate * 0.35);
		 break;
		
	case VAN:
		TotalRentalCost = (BaseDailyRate * Days) + (BaseDailyRate * 0.20);
		 break;
	
	}
}

@Override
public String toString() {
	return "Vehicles [Rental_ID=" + Rental_ID + ", CustomerName=" + CustomerName + ", TotalRentalCost="
			+ TotalRentalCost + ", Days=" + Days + ", BaseDailyRate=" + BaseDailyRate + ", rentalstatus=" + rentalstatus
			+ ", vehicletype=" + vehicletype + "]";
}



}