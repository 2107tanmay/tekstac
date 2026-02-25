import java.time.LocalDate;

public class AircraftMaintenance {


	public boolean validateLicenseNumber(String licenseNumber)
			throws InvalidEngineeringException {
        //Fill the code here 
		if(!licenseNumber.matches("^AME([0-9]{5})$")) throw new InvalidEngineeringException("Invalid license number: "+licenseNumber);
		return true;
	}

	public boolean validateExperience(int years)
			throws InvalidEngineeringException {

		//Fill the code here 
		if(years<2 || years>40) throw new InvalidEngineeringException("Invalid experience years: "+years);
		return true;
	}

	public boolean validateDepartment(String department)
			throws InvalidEngineeringException {

		//Fill the code here 
		if(!(department.equals("Mechanical")||department.equals("Avionics")||department.equals("Electrical")||department.equals("Structural"))) throw new InvalidEngineeringException("Invalid department: "+department);
		return true;
	}

	public boolean validateAircraftType(String aircraftType)
			throws InvalidAircraftException {

		//Fill the code here 
		if(!(aircraftType.equals("er")||aircraftType.equals("go")||aircraftType.equals("ate"))) throw new InvalidAircraftException("Invalid aircraft type: "+aircraftType);
		return true;
	}

	public boolean validateAircraftAge(LocalDate serviceDate)
			throws InvalidAircraftException {

		//Fill the code here 
		int age = LocalDate.now().getYear() - serviceDate.getYear();
		if(age>25) throw new InvalidAircraftException("Aircraft age exceeds limit: "+age);
		return true;
	}

	public boolean validateNotSunday(LocalDate serviceDate)
			throws InvalidAircraftException {

		//fill the code here
		if(serviceDate.getDayOfWeek().getValue()==7) throw new InvalidAircraftException("Maintenance not allowed on Sunday: "+serviceDate);
		
		return true;
	}

	public boolean validateServiceDate(LocalDate serviceDate)
			throws InvalidAircraftException {		
			
	    //Fill the code here 
		if(serviceDate.isAfter(LocalDate.now())) throw new InvalidAircraftException("Future service date not allowed: "+serviceDate);
		return true;
		
	}

	public boolean validateFlightHours(int flightHours)
			throws InvalidMaintenanceException {

		//Fill the code here 
		if(flightHours%50 != 0) throw new InvalidMaintenanceException("Flight hours must be multiple of 50: "+flightHours);
		return true;
	}

	public boolean validateMaintenanceEligibility(String maintenanceType, int flightHours)
			throws InvalidMaintenanceException {

		//Fill the code here 
		if(maintenanceType.equals("Major") && flightHours<1000) throw new InvalidMaintenanceException("Major maintenance requires greater than or equal to 1000 hours");
		else if(maintenanceType.equals("Overhaul") && flightHours<3000) throw new InvalidMaintenanceException("Overhaul requires greater than or equal to 3000 hours");

		return true;
	}

	public boolean validateLeapYearService(LocalDate serviceDate) throws InvalidMaintenanceException {

		//Fill the code here 
		if(serviceDate.isLeapYear()) throw new InvalidMaintenanceException("Service year "+serviceDate.getYear()+" falls in a leap year. Maintenance requires additional compliance review.");
		return true;
	}

	public double calculateMaintenanceCost(String aircraftType,String maintenanceType,int laborHours,
			boolean sparePartsRequired) {

		//Fill the code here 
		double cost =0;
		
		if(maintenanceType.equals("Minor")) cost=5000;
		else if(maintenanceType.equals("Major")) cost = 15000;
		else if(maintenanceType.equals("Overhaul")) cost = 30000;
		
		double labour = laborHours*1000;
		
		double spare=0;
		
		if(sparePartsRequired) spare=10000;
		
		double multiplier = 0;
		
		if(aircraftType.equals("Passenger")) multiplier = 1.2;
		else if(aircraftType.equals("Cargo")) multiplier = 1.5;
		else if(aircraftType.equals("Others")) multiplier = 1.0;
		
		return (cost+labour+spare)*multiplier;
	}
}
