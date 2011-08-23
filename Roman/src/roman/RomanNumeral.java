package roman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumeral {
	
	public String convert(int n) {
		Map<Integer, String> conversions = new HashMap<Integer, String>();
		conversions.put(1,"I");
		conversions.put(5,"V");
		conversions.put(10,"X");
		
		StringBuilder retVal = new StringBuilder();
		List<Integer> keys = new ArrayList<Integer>(conversions.keySet());
		Collections.sort(keys);
		int i = keys.size();
		while(n > 0) {
			if (n >= 10) {
				retVal.append("X");
				n -= 10;
			} else if (n >= 5) {
				retVal.append("V");
				n -= 5;
			} else if (n == 4) {
				retVal.append("IV");
				n -= 4;
			} else {
				retVal.append("I");
				n--;
			}
		}
		return retVal.toString();
	}

}
