import java.time.LocalDate;

public class Tablet {
	private String name;
	private String brand;
	private LocalDate expiryDate;
	private int mg;
	private double pricePerTablet;
	
	public Tablet() {
		super();
	}

	public Tablet(String name, String brand, LocalDate expiryDate, int mg, double pricePerTablet) {
		super();
		this.name = name;
		this.brand = brand;
		this.expiryDate = expiryDate;
		this.mg = mg;
		this.pricePerTablet = pricePerTablet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getMg() {
		return mg;
	}

	public void setMg(int mg) {
		this.mg = mg;
	}

	public double getPricePerTablet() {
		return pricePerTablet;
	}

	public void setPricePerTablet(double pricePerTablet) {
		this.pricePerTablet = pricePerTablet;
	}
	 
	@Override
	    public String toString() {
	        return name + "|" + brand + "|" + expiryDate + "|" + mg + "|" + pricePerTablet;
	}
	
}
