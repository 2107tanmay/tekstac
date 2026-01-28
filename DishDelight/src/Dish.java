public class Dish {
    private String dishName;
    private String cuisine;
    private double price;
    private double rating;

    public Dish() {
        super();
    }

    public Dish(String dishName, String cuisine, double price, double rating) {
        this.dishName = dishName;
        this.cuisine = cuisine;
        this.price = price;
        this.rating = rating;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
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
        return dishName + "|" + cuisine + "|" + price + "|" + rating;
    }
}
