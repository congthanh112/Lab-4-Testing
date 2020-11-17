
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


/* 
 	* Story: developing a module in a laptop selling system
 	* Feature: Customer want to make reservation for a laptop
 	* Background: There Customer and Laptop
 	
 	* Scenario 1 
 		* given system with no laptop available
 		* when customer make reservation
 		* there should be no reservation to be stored
 	* Scenario 2 
 		* given system with 2 laptops
 		* when customer make reservation for a laptop
 		* the correct reservation should be stored
  	* Scenario 3 
 		* given system with 2 laptops
 		* when customer make reservation for a laptop
 		* the last reservation should be stored
   	* Scenario 4
 		* given system with 2 laptops
 		* when customer make reservation for an unexisted laptop
 		* an exception should be thrown
 */


class RstTest {
	
	@Mock
	private RsvMgt mgt;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
    

	@Test
	void testScene1() {
		org.mockito.BDDMockito.given(mgt.getListOfLaptop())
		.willReturn(Collections.emptyList());
		assertNull(mgt.getProdRsv("abcd"));
	}
	
	@Test
	void testScene2() {
		
		Laptop l1 = Mockito.spy(new Laptop("lp01", 1000, "2019", ""));
		Laptop l2 = Mockito.spy(new Laptop("lp02", 2000, "2020", ""));
		RsvMgt spyTemp = Mockito.spy(new RsvMgt());
		
		Mockito.doReturn(Arrays.asList(l1, l2)).when(spyTemp).getListOfLaptop();
		
		Cust c = new Cust(12L, "CongThanh", "unknown", "123456789");
		
		spyTemp.makeRsv(c, l1);
		assertNotNull(spyTemp.getProdRsv(c.getName()));
		assertEquals(spyTemp.getProdRsv(c.getName()).getSerial(), l1.getSerial());
	}
	
	@Test
	void testScene3() {
		
		Laptop l1 = Mockito.spy(new Laptop("lp01", 1000, "2019", ""));
		Laptop l2 = Mockito.spy(new Laptop("lp02", 2000, "2020", ""));
		RsvMgt spyTemp = Mockito.spy(new RsvMgt());
		
		Mockito.doReturn(Arrays.asList(l1, l2)).when(spyTemp).getListOfLaptop();
		
		Cust c = new Cust(12L, "CongThanh", "unknown", "123456789");
		
		spyTemp.makeRsv(c, l1);
		spyTemp.makeRsv(c, l2);
		assertNotNull(spyTemp.getProdRsv(c.getName()));
		assertEquals(spyTemp.getProdRsv(c.getName()).getSerial(), l2.getSerial());
	}
	
	@Test
	void testScene4 () {
		
		Laptop l1 = Mockito.spy(new Laptop("lp01", 1000, "2020", ""));
		Laptop l2 = Mockito.spy(new Laptop("lp02", 2000, "2019", ""));
		Laptop l3 = Mockito.spy(new Laptop("lp03", 3000, "2019", ""));

		RsvMgt spyTemp = Mockito.spy(new RsvMgt());
		
		Mockito.doReturn(Arrays.asList(l1, l2)).when(spyTemp).getListOfLaptop();
		
		Cust c = new Cust(12L, "CongThanh", "unknown", "123456789");
		
		Exception ex = assertThrows(RuntimeException.class, () -> spyTemp.makeRsv(c, l3));
		assertEquals(ex.getMessage(), "Laptop not exist!");
	}


}