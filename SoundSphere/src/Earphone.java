import java.time.LocalDate;

public class Earphone {

	private String brandName;
	private LocalDate releaseDate;
	private double price;
	private double rating;

	public Earphone() {
		super();
	}

	public Earphone(String brandName, LocalDate releaseDate, double price, double rating) {
		super();
		this.brandName = brandName;
		this.releaseDate = releaseDate;
		this.price = price;
		this.rating = rating;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return brandName + "|" + releaseDate + "|" + price + "|" + rating;
	}
}
