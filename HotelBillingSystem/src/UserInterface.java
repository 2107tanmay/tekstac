import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Deluxe Room Details:");
        System.out.println("Guest Name: "); 
        String name = sc.nextLine();
        System.out.println("Rate per Night: ");
        double rate = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nights Stayed: ");
        int nights = sc.nextInt();
        sc.nextLine();
        System.out.println("Joining Year: ");
        int year = sc.nextInt();
        sc.nextLine();
        HotelRoom h1 = new HotelRoom("Deluxe",rate,name);
        
        System.out.println("Enter Suite Room Details:");
        System.out.println("Guest Name: "); 
        String name2 = sc.nextLine();
        System.out.println("Rate per Night: ");
        double rate2 = sc.nextDouble();
        sc.nextLine();
        System.out.println("Nights Stayed: ");
        int nights2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Joining Year: ");
        int year2 = sc.nextInt();
        sc.nextLine();
        HotelRoom h2 = new HotelRoom("Suite",rate,name);
        
        System.out.println("Room Summary:");
        System.out.println("Deluxe Room: "+h1.getGuestName()+", "+h1.getRatePerNight()+" per night, Membership: "+year+" years");
        System.out.println("Suite Room: "+h2.getGuestName()+", "+h2.getRatePerNight()+" per night, Membership: "+year2+" years");
        
        System.out.println("Total Bill:");
        System.out.println("For "+h1.getGuestName()+" (Deluxe): "+h1.calculateTotalBill(nights, year));
        System.out.println("For "+h2.getGuestName()+" (Suite): "+h2.calculateTotalBill(nights2, year2));
    }
}
