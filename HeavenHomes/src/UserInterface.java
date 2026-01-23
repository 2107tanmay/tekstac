import java.util.Scanner;

public class UserInterface {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
       //Fill the code here
       Apartment a = new Apartment();
        System.out.println("Enter number of details to be added");
        int count = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the details (Apartment number: Rent");
        
        for(int i=0; i<count; i++) {
        	String input = sc.nextLine();
        	String parts[] = input.split(":");
        	a.addApartmentDetails(parts[0], Double.parseDouble(parts[1]));
        }
        
        System.out.println("Enter the range to filer the details");
        double min = sc.nextDouble();
        sc.nextLine();
        double max = sc.nextDouble();
        sc.nextLine();
        
        if(a.findTotalRentOfApartmentsInTheGivenRange(min, max)==0) {
        	System.out.println("No apartments found in this range");
        	return;
        }
        
        System.out.println("Total Rent in the range"+min+" to "+max+" USD:"+a.findTotalRentOfApartmentsInTheGivenRange(min, max));
        
    }
}
