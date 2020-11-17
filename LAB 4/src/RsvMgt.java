import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RsvMgt {
	private List<Laptop> laptops = new ArrayList<>();
	
	private Map<String, Laptop> rsv = new HashMap<>();
	
	public List<Laptop> getListOfLaptop() {
		return this.laptops;
	}
	
	public void makeRsv(Cust c, Laptop laptop) {
		boolean found = false;
		List<Laptop> laptops = getListOfLaptop();
		for(int i = 0; i < laptops.size(); ++i) 
			if (laptops.get(i).getSerial().equals(laptop.getSerial())) {
			found = true;
			break;
		}
		if (!found) {
			throw new RuntimeException("Laptop not exist!");
		}
		rsv.put(c.getName(), laptop);
	}
	
	public Laptop getProdRsv(String custName) {
		return rsv.get(custName);
	}
	
	
	
}
