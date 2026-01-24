package internal_assesment_v2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class UserInterface {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		RentalUtility ru = new RentalUtility();
		
		while(true) {
			System.out.println("Select an option:");
			System.out.print("\n1. Add DVD Rental"
					+ "\n2. Calculate Total Late Fee(as of date)"
					+ "\n3.Show Overdue Rentals(as of a date)"
					+ "\n4. Show Member-wise Rental Count"
					+ "\n5. Exit");
			int choice = sc.nextInt();
			sc.nextLine();
			
			
			switch(choice) {
			case 1 -> {
				
				System.out.println("Enter movie title:");
				String title = sc.nextLine();
				System.out.println("Enter member name");
				String name = sc.nextLine();
				System.out.println("Enter rent date (dd-MM-yyy)");
				LocalDate rent = LocalDate.parse(sc.nextLine(), dtf);
				System.out.println("Enter due date (dd-MM-yyyy)");
				LocalDate due = LocalDate.parse(sc.nextLine(), dtf);
				System.out.println("Enter return date (dd-MM-yyyy) or press Enter if not returned");
				String returndate = sc.nextLine();
				LocalDate returnd=null;
				if(!returndate.isBlank()) {returnd = LocalDate.parse(returndate, dtf);}
				System.out.println("Enter daily late fee");
				double fee = sc.nextDouble();
				sc.nextLine();
				
				DvdRental obj = new DvdRental(title, name, rent, due, returnd, fee); //creates objects with attributes
				ru.addRental(obj); //adds the object to our list
			}
			case 2 -> {
				
				if(ru.getRentalList().isEmpty()) {
					System.out.println("No rentals available, Please add entries");
					continue;
				}
				
				System.out.println("Enter as of date (dd-MM-yyyy");
				LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
				int fee = ru.calculateTotalLateFee(ru.getRentalList().stream(), date); //fetches our rental list and convert to stream for the input
				
				System.out.println("The total fee as "+date+" is Rs: "+fee);
				
			}
			case 3 -> {
				
				if(ru.getRentalList().isEmpty()) {
					System.out.println("No rentals available, Please add entries");
					continue;
				}
				
				System.out.println("Enter as of date (dd-MM-yyyy");
				LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
				
				List<DvdRental> overdue = ru.getOverdueRentals(ru.getRentalList().stream(), date);
				
				if(overdue.isEmpty()) {
					System.out.println("No overdue rentals as of "+date);
				}
				else {
					overdue.forEach(r -> System.out.println("Movie Title: "+r.getMovieTitle()+"\nMember Name: "+r.getMemberName()+"\nDate: "+date));
				}
				
			}
			case 4 -> {
				
				if(ru.getRentalList().isEmpty()) {
					System.out.println("No rentals available, Please add entries");
					continue;
				}
				
				Map<String,Long> map = ru.getMemberWiseRentalCount(ru.getRentalList().stream());
				
				for(Entry<String, Long> element: map.entrySet()) {
					System.out.println(element.getKey()+" : "+element.getValue());
				}
				
			}
			case 5 -> {
				System.out.println("Thank you for using the application");
				return;
			}
			
			}
		}
		
	}
	
}
