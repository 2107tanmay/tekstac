import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
    	GadgetValidatorUtil obj = new GadgetValidatorUtil();
        Scanner sc = new Scanner(System.in);
        // Fill the code here
        System.out.println("Enter the number of gadget entries");
        int count = sc.nextInt();
        sc.nextLine();
        
        for(int i=1; i<=count; i++) {
        	System.out.println("Enter gadget "+i+" details");
        	String input[] = sc.nextLine().split(":");
        	
        	try {
        		if(obj.validateGadgetID(input[0]) && obj.validateWarrantyPeriod(Integer.parseInt(input[2]))) {
            		System.out.print("Warranty accepted, stock updated\n");
            	}
        	}
        	catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        }
        
    }
}
