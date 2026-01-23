public class GadgetValidatorUtil {
    public boolean validateGadgetID(String gadgetID) throws InvalidGadgetException {
        // Fill the code here
    	if(! gadgetID.matches("^[A-Z]([0-9]{3})$") ) throw new InvalidGadgetException("Invalid gadget ID");
        return true;
    }

    public boolean validateWarrantyPeriod(int period) throws InvalidGadgetException {
        // Fill the code here
    	if(period>36 || period<6) throw new InvalidGadgetException("Invalid warranty period");
        return true;
    }
}
