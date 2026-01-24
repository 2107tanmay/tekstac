import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Earphone> list = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Earphone obj = null;
        EarphoneUtil eu = new EarphoneUtil();
        
        System.out.println("Enter the number of earphones");
        int count = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the earphone details");
        
        for(int i=0; i<count; i++) {
        	String input[] = sc.nextLine().split(":");
        	String brand = input[0];
        	LocalDate date = LocalDate.parse(input[1],dtf);
        	double price = Double.parseDouble(input[2]);
        	double rating = Double.parseDouble(input[3]);
        	obj = new Earphone(brand,date,price,rating);
        	list.add(obj);
        }
        
        System.out.println("Enter the brand name");
        String name = sc.nextLine();
        List<Earphone> res = eu.getEarphonesByBrandName(list.stream(), name).toList();
        //we had to make this also as a list as the method working on strings will not return a null stream it will return a empty string 
        //so we need to check if our list is empty or no rather than nulll
        if(!res.isEmpty()) {
            System.out.println("Earphones by brand " + name + " are");
            res.forEach(s -> System.out.println(s));
        } else {
            System.out.println("No earphones found for the brand " + name);
        }
        
        System.out.println("Enter the minimum and maximum price range");
        double min = sc.nextDouble();
        double max = sc.nextDouble();
        List<Earphone> o = eu.getEarphonesWithinPriceRange(list.stream(), min, max);
        
        if(!o.isEmpty()) {
        	System.out.println("Earphones within the price range "+min+" to "+max+" are");
        	o.forEach( s -> System.out.println(s.toString()));
        }
        else {
        	System.out.println("No earphones found within the price range "+min+" to "+max);
        }
        
    }
}
