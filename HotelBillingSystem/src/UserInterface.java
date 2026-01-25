import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        System.out.println("Enter Deluxe Room Details:");
        System.out.print("Guest Name: ");
        String name = sc.nextLine();
        System.out.print("Rate per Night: ");
        double rate = sc.nextDouble();
        System.out.print("Nights Stayed: ");
        int nights = sc.nextInt();
        System.out.print("Joining Year: ");
        int year = sc.nextInt();
        sc.nextLine();

        HotelRoom h1 = new HotelRoom("Deluxe", rate, name);

        System.out.println();
        System.out.println("Enter Suite Room Details:");
        System.out.print("Guest Name: ");
        String name2 = sc.nextLine();
        System.out.print("Rate per Night: ");
        double rate2 = sc.nextDouble();
        System.out.print("Nights Stayed: ");
        int nights2 = sc.nextInt();
        System.out.print("Joining Year: ");
        int year2 = sc.nextInt();

        HotelRoom h2 = new HotelRoom("Suite", rate2, name2);

        System.out.println();
        System.out.println("Room Summary:");

        System.out.println("Deluxe Room: " + h1.getGuestName());
        System.out.println(h1.getRatePerNight() + " pernight");
        System.out.println("Membership: " + h1.calculateMembershipYears(year) + " years");

        System.out.println("Suite Room: " + h2.getGuestName());
        System.out.println(h2.getRatePerNight() + " per night");
        System.out.println("Membership: " + h2.calculateMembershipYears(year2) + " years");

        System.out.println();
        System.out.println("Total Bill");

        System.out.println("For " + h1.getGuestName() + " (Deluxe): " +
                h1.calculateTotalBill(nights, year));

        System.out.println("For " + h2.getGuestName() + " (Suite): " +
                h2.calculateTotalBill(nights2, year2));
    }
}
