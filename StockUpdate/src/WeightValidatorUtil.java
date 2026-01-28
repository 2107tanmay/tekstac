public class WeightValidatorUtil {
    public boolean validateItemWeight(int itemWeight) throws InvalidWeightException {
            
    	if(!(itemWeight>=100 && itemWeight<=5000)) {
    		throw new InvalidWeightException("Invalid item weight");
    	}
    	
            return true;
        
    }
}
