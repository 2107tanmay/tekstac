import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dish obj;
        DishUtil du = new DishUtil();
        List<Dish> src = new ArrayList<>();
       System.out.println("Enter the number of dishes");
       int n = sc.nextInt(); sc.nextLine();
       
       System.out.println("Enter the dish details");
       for(int i=1; i<=n; i++) {
    	   String input[] = sc.nextLine().split(":");
    	   obj = new Dish(input[0],input[1],Double.parseDouble(input[2]),Double.parseDouble(input[3]));
    	   src.add(obj);
       }
        
       System.out.println("Enter the cuisine");
       String key = sc.nextLine();
       
       
       
       List<Dish> res = du.getDishesByCuisine(src.stream(), key);
       
       if(res.isEmpty()) {
    	   System.out.println("No dishes were found for the given cuisine "+key);
    	   return;
       }
       System.out.println("Dishes of cuisine "+key+" are");
       res.forEach(item -> System.out.println(item.toString()));
       
    }
}
