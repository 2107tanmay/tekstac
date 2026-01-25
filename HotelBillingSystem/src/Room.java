import java.time.LocalDate;
import java.time.Year;

public interface Room {
	public double calculateTotalBill(int nightsStayed, int joiningYear);
	public default int calculateMembershipYears(int joiningYear) {
        int currentYear = 2025;
        return currentYear - joiningYear;
    }
		
}
