import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		if (input.length() != 10) {
			System.out.println("Invalid Input");
			return;
		}

		if (!input.matches("^([A-Z|0-9]{5})([1][0]|[0][0-9])([A-Z0-9]{3})$")) {
			System.out.println("Invalid Count");
			return;
		}

		if (!input.matches("^([A-Z0-9]{7})[A-Z]([0-9]{2})$")) {
			System.out.println("Invalid Seat Number");
			return;
		}

		int n = Integer.parseInt(input.substring(5, 7));
		int num = Integer.parseInt(input.substring(8, 10));
		for (int i = 0; i < n; i++) {
			System.out.print(input.charAt(7));
			System.out.print(num);
			num++;
			System.out.println();
		}

	}

}
