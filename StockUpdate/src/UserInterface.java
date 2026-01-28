import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WeightValidatorUtil obj = new WeightValidatorUtil();
        
        System.out.println("Enter the number of item entries");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=1; i<=n; i++) {
        	System.out.println("Enter item "+i+" details");
        	String input[] = sc.nextLine().split(":");
        	
        	try {
        		if(obj.validateItemWeight(Integer.parseInt(input[2]))) {
        			System.out.println("Stock successfully updated");
        		}
        	}
        	catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        }

    }
}
