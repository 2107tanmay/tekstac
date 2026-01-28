import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookCabMain {

	private Map<String, Date> bookingMap = new HashMap<String, Date>();

	public Map<String, Date> getBookingMap() {
		return bookingMap;
	}

	public void setBookingMap(Map<String, Date> bookingMap) {
		this.bookingMap = bookingMap;
	}

	public List<String> findCabBookingIdsForTheBookingDate(Date date) {

		// Fill the code here
		

		return bookingMap.entrySet()
				.stream()
				.filter(obj -> obj.getValue().equals(date))
				.map(obj -> obj.getKey())
				.collect(Collectors.toList());
	}

}
