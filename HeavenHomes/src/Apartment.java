import java.util.Map;
import java.util.HashMap;

public class Apartment {

	private Map<String, Double> apartmentDetailsMap = new HashMap<String, Double>();

    public Map<String, Double> getApartmentDetailsMap() {
		return apartmentDetailsMap;
	}

	public void setApartmentDetailsMap(Map<String, Double> apartmentDetailsMap) {
		this.apartmentDetailsMap = apartmentDetailsMap;
	}
	
	public void addApartmentDetails(String apartmentNumber, double rent) {
        //Fill the code here
		apartmentDetailsMap.put(apartmentNumber, rent);
	}

	public double findTotalRentOfApartmentsInTheGivenRange(double minimumRent, double maximumRent) {
		//Fill the code here
		double sum = 0;
		sum = apartmentDetailsMap
			.entrySet()
			.stream()
			.filter(index -> (index.getValue() <= maximumRent) && (index.getValue() >= minimumRent))
			.mapToDouble(Map.Entry::getValue)
			.sum();
		if(sum>0) return sum;
		return 0;
	}

}
