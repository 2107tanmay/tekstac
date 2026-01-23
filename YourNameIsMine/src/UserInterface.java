import java.util.Scanner;
 
public class UserInterface {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Enter the man name");
       String man = sc.nextLine();
       if(!check(man)) {System.out.print(man+" is an invalid name"); return;}
       
       System.out.println("Enter the woman name");
       String woman = sc.nextLine();
       
       if(!(check(man) && check(woman))) {System.out.print("Both "+man+" and "+woman+" are invalid names"); return;}
       
       if(!check(woman)) {System.out.print(woman+" is an invalid name"); return;}
       
       if(man.equalsIgnoreCase(woman)) {System.out.println(man+" and "+woman+" are made for each other"); 
    	   System.out.println("Compatibility value is 0"); return;}
       
       if(subsequence(man,woman) || subsequence(woman,man)) {
    	   System.out.println(man+" and "+woman+" are made for each other");
    	   System.out.println("Compatibility value is "+ (Math.max(man.length(),woman.length()) - Math.min(man.length(),woman.length())) ) ;
//    	   System.out.println("Compatibility Value is "+distance(man,woman));
       }
       else {
    	   System.out.println("Both "+man+" and "+woman+" are not made for each other");
    	   return;
       }
       
    }
    
//    public static int distance(String one, String two) {
//    	one = one.toLowerCase();
//    	two = two.toLowerCase();
//    	
//    	int m = one.length();
//    	int n = two.length();
//    	
//    	int[][] dp = new int[m+1][n+1];
//    	
//    }
    
    public static boolean subsequence(String small, String big) {
    	small = small.toLowerCase();
    	big = big.toLowerCase();
    	int i = 0;
    	int j =0;
    	
    	while(i<small.length()) {
    		if(small.charAt(i)==big.charAt(j)) {
    			i++; //will only move forward if a match is found
    		}
    		j++; //will iterate through the larger string
    	}
    	
    	return i==small.length(); //will be true only when the smaller string characters are all met by larger through loop and i is same as length of small
    }
    
    public static boolean check(String s) {
    	if(!s.matches("^[A-Za-z ]+$")) {
    		return false;
    	}
    	return true;
    }
}

