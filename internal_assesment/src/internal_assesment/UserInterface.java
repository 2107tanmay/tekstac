package internal_assesment;
import java.util.Scanner;

public class UserInterface {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		MedicineValidationUtil mv = new MedicineValidationUtil();
		
		System.out.println("Enter the number of medicine entries: ");
		int count = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<count; i++) {
			System.out.println("Enter the medicine "+i+" details: ");
			String input = sc.nextLine();
						
			try {
				mv.validateInputStructureString(input);
				
				String meds[] = input.split(":");
				
				mv.validateMedicineID(meds[0]);
				mv.validateMedicineCategory(meds[1]);
				mv.validateExpiryPeriod(Integer.parseInt(meds[2]));
				mv.validateStockAndBusinessRules(meds[1], Integer.parseInt(meds[2]), Integer.parseInt(meds[3]));
				
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				return;
			}
			
			System.out.println("Expiry accepted, stock updated");
			
		}
		
	}
}
