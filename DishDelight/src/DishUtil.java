import java.util.List;
import java.util.stream.Stream;

public class DishUtil {

    public List<Dish> getDishesByCuisine(Stream<Dish> dishStream, String cuisine) {
        
        //Fill the code here
        
        return dishStream.filter(obj -> obj.getCuisine()
        		.equals(cuisine)).toList();
    }
}
