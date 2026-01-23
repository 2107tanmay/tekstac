public class EntryUtility {
    public static boolean validateEmployeeId(String employeeId) throws InvalidEntryException {
        //Fill the code here
    	if(employeeId.length()!=10 || !employeeId.matches("^GOAIR/([0-9]{4})$")) {
    		throw new InvalidEntryException("Invalid entry details");
    	}
    	
	    return true;
    }
    
    public static boolean validateDuration(int duration) throws InvalidEntryException {
        //Fill the code here
    	if(duration>5 || duration<1) {
    		throw new InvalidEntryException("Invalid entry details");
    	}
	    return true;
    }
}