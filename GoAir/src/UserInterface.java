import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    //Fill the code here
        EntryUtility eu = new EntryUtility();
        System.out.println("Enter the number of entries");
        int count = sc.nextInt();
        sc.nextLine();
        
        for(int i=1; i<=count; i++) {
        	System.out.println("Enter entry "+i+" details");
        	String input = sc.nextLine();
        	String parts[] = input.split(":");
        	
        	try {
        		if( eu.validateEmployeeId(parts[0]) && eu.validateDuration(Integer.parseInt(parts[2]))) {
        			System.out.println("Valid entry details");
        		}
        	}
        	catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        }
        
    }
}
