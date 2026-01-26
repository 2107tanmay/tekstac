import java.util.Scanner;

public class UserInterface {
public static void main(String args[]) 
{
	Scanner sc=new Scanner(System.in);
	//Fill the code here
	System.out.println("Enter student details");
	System.out.println("Enter Student Id:");
	int id = sc.nextInt(); sc.nextLine();
	System.out.println("Enter Student Name:");
	String name = sc.nextLine();
	System.out.println("Enter Department Name:");
	String dept = sc.nextLine();
	System.out.println("Enter Gender:");
	String gender = sc.nextLine();
	System.out.println("Enter Category:");
	String category = sc.nextLine();
	if(!category.equals("SportsStudent")) {
		System.out.println("Invalid category entered");
		return;
	}
	System.out.println("Enter College Fee");
	double fee = sc.nextDouble(); sc.nextLine();
	System.out.println("Enter Sport Name:");
	String sname = sc.nextLine();
	System.out.println("Enter Level:");
	String level = sc.nextLine();
	
	SportsStudent ss = new SportsStudent(id,name,dept,gender,category,fee,sname,level);
	
	if(ss.calculateTotalFee() != -1) {
	System.out.println("Total College Fee including Sports fee is: "+ss.calculateTotalFee());
	}
	else {
		System.out.println("Invalid sports details");
	}
	
    }
}
