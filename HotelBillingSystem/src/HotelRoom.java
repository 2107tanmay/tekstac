import java.time.LocalDate;

public class HotelRoom implements Room {
    private String roomType;
    private double ratePerNight;
    private String guestName;

    public HotelRoom(String roomType, double ratePerNight, String guestName) {
        this.roomType = roomType;
        this.ratePerNight = ratePerNight;
        this.guestName = guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getRatePerNight() {
        return ratePerNight;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRatePerNight(double ratePerNight) {
		this.ratePerNight = ratePerNight;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

        // Override the calculateTotalBill() method
	@Override
	 public double calculateTotalBill(int nightsStayed, int joiningYear) {
        double total = nightsStayed * ratePerNight;
        int membershipYears = calculateMembershipYears(joiningYear);
        if (membershipYears > 3) {
            total = total * 0.9;
        }
        return Math.round(total);
    }
	
}
