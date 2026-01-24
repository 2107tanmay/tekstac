package internal_assesment_v2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RentalUtility {
	
	private List<DvdRental> rentalList = new ArrayList<>();

	public List<DvdRental> getRentalList() {
		return rentalList;
	}

	public void setRentalList(List<DvdRental> rentalList) {
		this.rentalList = rentalList;
	}
	
	public void addRental(DvdRental rental) {
		rentalList.add(rental);
	}
	
	public int calculateTotalLateFee(Stream<DvdRental> rentals, LocalDate asOfDate) {
		int latefee =  rentals.mapToInt(
				rental -> {
					LocalDate effectiveEndDate;
					if(rental.getReturnDate() != null && rental.getReturnDate().isAfter(asOfDate)) {
						effectiveEndDate = rental.getReturnDate();
					}
					else {
						effectiveEndDate = asOfDate;
					}
					
					if(effectiveEndDate.isAfter(rental.getDueDate())) {
						long daysLate = ChronoUnit.DAYS.between(rental.getDueDate(), effectiveEndDate);
						return (int) (daysLate*rental.getDailyLateFee());
					}
					return 0;
				}
				
				).sum();
		return latefee;
	}
	
	public List<DvdRental> getOverdueRentals(Stream<DvdRental> rentals, LocalDate asOfDate) {
		return rentals.filter(				
				r -> (r.getReturnDate() == null) && (r.getDueDate().isBefore(asOfDate))			
				).collect(Collectors.toList());
	}
	
	public Map<String, Long> getMemberWiseRentalCount(Stream<DvdRental> rentals){
		
		return rentals.collect(Collectors.groupingBy(DvdRental:: getMemberName, 
				Collectors.counting()));
		
	}
	
}
