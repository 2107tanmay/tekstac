import java.time.LocalDate;
import java.time.Year;

public interface Room {
	public double calculateTotalBill(int nightsStayed, int joiningYear);
	public default int calculateMembershipYear(int joiningYear) {
		LocalDate current = LocalDate.now();
		int y = current.getYear();
		return y - joiningYear;
	}
		
}
