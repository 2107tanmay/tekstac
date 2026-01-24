import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EarphoneUtil {

	public Stream<Earphone> getEarphonesByBrandName(Stream<Earphone> earphoneStream, String brandName) {
		//Fill the code here
		Stream<Earphone> s = earphoneStream.filter(brand -> brand.getBrandName().equals(brandName)); 
		//should output the brand object for the specified brand object where name is same as shown
		return s;
	}

	public List<Earphone> getEarphonesWithinPriceRange(Stream<Earphone> earphoneStream, double minimumPrice, double maximumPrice) {
		//Fill the code here
		List<Earphone> res = earphoneStream.filter(obj -> obj.getPrice()>=minimumPrice && obj.getPrice()<=maximumPrice).collect(Collectors.toList());
		return res;
	}
}
