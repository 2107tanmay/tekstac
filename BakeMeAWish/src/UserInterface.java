import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface{
    public static void main(String args[]) {
	   Scanner sc = new Scanner(System.in);
	   CakeOrder c = new CakeOrder();
	   	   
	   System.out.println("Enter number of cake orders to be added");
	   int count = sc.nextInt();
	   sc.nextLine();
	   
	   System.out.println("Enter the cake order details (Order Id: CakeCost)");
	   
	   while(count !=0) {
		   String s[] = (sc.nextLine()).split(":");
		   c.addOrderDetails(s[0], Double.parseDouble(s[1]));
		   count--;		   
	   }
	   
	   System.out.println("Enter the cost to search the cake orders");
	   Double cost = sc.nextDouble();
	   
	   Map<String, Double> m = c.findOrdersAboveSpecifiedCost(cost);
	   
	   if(m.isEmpty()) {
		   System.out.println("No cake orders found");
		   return;
	   }
	   else {
		   System.out.println("Cake Orders above the specified cost");
		   
		   for(Map.Entry<String, Double> s: m.entrySet()) {
			   System.out.println("Order ID: "+s.getKey());
			   System.out.println("Cake Cost: "+s.getValue());
		   }
	   }
	   
	   
	}
}