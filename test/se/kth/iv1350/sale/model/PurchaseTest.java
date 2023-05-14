package se.kth.iv1350.sale.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.sale.model.Amount;
import se.kth.iv1350.sale.model.DiscountDTO;
import se.kth.iv1350.sale.model.ItemDTO;
import se.kth.iv1350.sale.model.Purchase;

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
		purchase.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(20), new Amount(25), new Amount(0.25)), 2, true);
		Amount runningTotal = purchase.getRunningTotal();
		assertEquals(50, runningTotal.getValue(), "Checks if runningTotal is correct when the purchase contains multiple items");
	}
	
	@Test
	void getRunningTotalIfDiscountSet() {
		Purchase purchase = new Purchase();
		purchase.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(20), new Amount(25), new Amount(0.25)), 2, true);
		purchase.setDiscount(new DiscountDTO(new Amount((float)0.5), "Test discount"));
		Amount runningTotal = purchase.getRunningTotal();
		assertEquals(25, runningTotal.getValue(), "Checks if runningTotal is correct when the purchase has a discount");
	}	

	@Test
	void getTotalVATIfDiscountSet() {
		Purchase purchase = new Purchase();
		purchase.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(20), new Amount(25), new Amount(0.25)), 2, true);
		purchase.setDiscount(new DiscountDTO(new Amount((float)0.5), "Test discount"));
		Amount totalVAT = purchase.getTotalVAT();
		assertEquals(5, totalVAT.getValue(), "Checks if the total VAT is correct when the purchase has a discount");
	}	
}
