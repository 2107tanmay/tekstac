import java.util.Scanner;
 
public class UserInterface {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the username");
    	String username = sc.nextLine();
    	
    	if((username.length() != 8) || (!username.matches("^([A-Z]{4})[@](10[1-9]|11[1-5])$")) ) {
    		System.out.println(username+" is an invalid username");
    		return;
    	}
    	username = username.toLowerCase();
    	StringBuilder sb = new StringBuilder("TECH_");
    	int sum = 0;
    	for(int i=0; i<4; i++) {
    		sum += (int) username.charAt(i);
    	}
    	sb.append(sum);
    	
    	sb.append(username.charAt(6));
    	sb.append(username.charAt(7));
    	
    	System.out.println("Password: "+sb.toString());
    	
    }
}

