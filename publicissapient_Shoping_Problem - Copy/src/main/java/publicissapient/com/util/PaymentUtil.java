package publicissapient.com.util;

import java.util.Hashtable;
import java.util.Map;

import publicissapient.com.exception.InSufficientFundException;

public class PaymentUtil {
	
	private static Map<String,Double> hash = new Hashtable<>();
	static {
		hash.put("Abhishek", 10000d);
		hash.put("Ashish",2000d);
		hash.put("Shivam", 15000d);
	}
	
	public static Boolean ValidatePayment(String card,Double price) {
		if(!( price > hash.get(card))) {
			throw new InSufficientFundException();
		}
		return true;
	}
}
