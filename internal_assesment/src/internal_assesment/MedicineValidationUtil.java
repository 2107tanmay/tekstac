package internal_assesment;

public class MedicineValidationUtil {


	public boolean validateInputStructureString(String line) throws InvalidFormatException {
		String words[] = line.split(":");
			if( words.length != 4 || words[0].equals(null) || words[1].equals(null) || words[2].isBlank() || words[3].isBlank()) {
				throw new InvalidFormatException("Invalid input format");
			}
		return true;
	}
	
	public boolean validateMedicineID(String medid) throws InvalidMedicineException {
			if( medid.length() != 7 || !medid.matches("^([A-Z]{2})([0-9]{4})[A-Z]") ) {
				throw new InvalidMedicineException("Invalid medicine ID");
			}
		return true;
	}
	
	public boolean validateMedicineCategory(String category) throws InvalidMedicineException {
			String s[] = {"Antibiotic","Analgesic","Antacid","Supplement","Antipyretic","Antiseptic","Vaccine"};
			boolean flag = false;
			
			for(int i=0; i<s.length; i++) {
				if(category.equals(s[i])) {
					flag = true;
				}
			}
			if(flag==false) {
				throw new InvalidMedicineException("Invalid medicine category");
			}
		return true;
	}
	
	public boolean validateExpiryPeriod(int months) throws InvalidExpiryException {		
			if( months<6 || months>36 ) {
				throw new InvalidExpiryException("Invalid expiry period");
			}
		return true;
	}
	
	public boolean validateStockAndBusinessRules(String category, int months, int stock) throws BusinessRuleException {
			if(stock<1 || stock>1000) throw new BusinessRuleException("Invalid Stock count");
			if( (category.equals("Vaccine") && months>24 ) || (category.equals("Supplement") && months<12) ) throw new BusinessRuleException("Expiry not permitted for this medicine category");
		return true;
	}
	
}
