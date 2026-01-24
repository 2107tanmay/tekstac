package internal_assesment_v2;

import java.time.LocalDate;

public class DvdRental {
	private String movieTitle;
	private String memberName; 
	private LocalDate rentDate = null; 
	private LocalDate dueDate = null;
	private LocalDate returnDate = null;
	private double dailyLateFee;
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public LocalDate getRentDate() {
		return rentDate;
	}
	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public double getDailyLateFee() {
		return dailyLateFee;
	}
	public void setDailyLateFee(double dailyLateFee) {
		this.dailyLateFee = dailyLateFee;
	}
	public DvdRental(String movieTitle, String memberName, LocalDate rentDate, LocalDate dueDate, LocalDate returnDate,
			double dailyLateFee) {
		this.movieTitle = movieTitle;
		this.memberName = memberName;
		this.rentDate = rentDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.dailyLateFee = dailyLateFee;
	}
	
}
