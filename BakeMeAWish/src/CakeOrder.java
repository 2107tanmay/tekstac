import java.util.Map;
import java.util.HashMap;

public class CakeOrder {

	private Map<String,Double> orderMap=new HashMap<String,Double>();

	public Map<String, Double> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, Double> orderMap) {
		this.orderMap = orderMap;
	}
	    
    public void addOrderDetails(String orderId, double cakeCost) {
		//Fill the code here
		orderMap.put(orderId, cakeCost);
	}
	
	public Map<String, Double> findOrdersAboveSpecifiedCost(double cakeCost) {
		//Fill the code here
		Map<String,Double> res = new HashMap<String, Double>();
		for(Map.Entry<String, Double> m: orderMap.entrySet()) {
			if(m.getValue()>cakeCost) {
				res.put(m.getKey(), m.getValue());
			}
		}
		return res;
	}


}
