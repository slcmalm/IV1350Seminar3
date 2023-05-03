package se.kth.iv1350.sale.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseTest {

	@Test
	void getRunningTotalIfZeroItems() {
		Purchase purchase = new Purchase();
		Amount runningTotal = purchase.getRunningTotal();
		assertEquals(0, runningTotal.getValue(), "Checks if runningTotal is zero when the purchase contains no items");
	}
	

	@Test
	void getRunningTotalIfTwoItems() {
		Purchase purchase = new Purchase();
		purchase.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(25), new Amount(20), new Amount(20)), 2);
		Amount runningTotal = purchase.getRunningTotal();
		assertEquals(50, runningTotal.getValue(), "Checks if runningTotal is correct when the purchase contains multiple items");
	}
	
	@Test
	void getRunningTotalIfDiscountSet() {
		Purchase purchase = new Purchase();
		purchase.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(25), new Amount(20), new Amount(20)), 2);
		purchase.setDiscount(new DiscountDTO(new Amount(10), "Test discount"));
		Amount runningTotal = purchase.getRunningTotal();
		assertEquals(40, runningTotal.getValue(), "Checks if runningTotal is correct when the purchase has a discount");
	}

}
