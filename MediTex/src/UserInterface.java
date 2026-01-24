import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TabletUtil tu = new TabletUtil();
        List<Tablet> list = new ArrayList<>();
        System.out.println("Enter the number of tablets");
        int count = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the tablet details");
        for(int i=0; i<count; i++) {
        	String input[] = sc.nextLine().split(":");
        	String name = input[0];
        	String brand = input[1];
        	LocalDate date = LocalDate.parse(input[2],dtf);
        	int mg = Integer.parseInt(input[3]);
        	double price = Double.parseDouble(input[4]);
        	list.add(new Tablet(name,brand,date,mg,price));
        }
        
        System.out.println("Enter the brand name");
        String brand = sc.nextLine();
        List<Tablet> res = tu.retrieveTabletsByBrand(list.stream(), brand);
        
        if(res.isEmpty()) {
        	System.out.println("No tablets found for the brand "+brand);
        }
        else {
        	System.out.println("Tablets by brand "+brand+" are");
        	res.forEach(obj -> System.out.println(obj.toString()));
        }
        
        System.out.println("Enter the minimum mg");
        int mg = sc.nextInt();
        sc.nextLine();
        List<String> str = tu.getTabletsAboveMg(list.stream(), mg);
        
        if(str.isEmpty()) {
        	System.out.println("No tablets found with a minimum mg of "+mg);
        }
        else {
        	System.out.println("Tablets with a minimum mg of "+mg+" are");
        	str.forEach(obj -> System.out.println(obj));
        }
        

    }
}
