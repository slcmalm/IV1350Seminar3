package se.kth.iv1350.sale.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.sale.integration.ExternalInventorySystem;
import se.kth.iv1350.sale.model.Amount;
import se.kth.iv1350.sale.model.ItemDTO;

class ExternalInventorySystemTest {
	
	private ExternalInventorySystem invSys;
	
	@BeforeEach
	void initializeInventoryTests() {	
		invSys = new ExternalInventorySystem();
	}
	
	@Test
	void testValidityValidItem() {
		int itemID = 2;
		assertTrue(invSys.getItemValidity(itemID), "Checks if a valid itemID passes the validity check.");
	}
	
	@Test
	void testValidityInvalidItem() {
		int itemID = 0;
		assertFalse(invSys.getItemValidity(itemID), "Checks if an invalid itemID fails the validity check.");
	}
	
	@Test
	void getItemTest() {
		int itemID = 2;
		ItemDTO item = new ItemDTO(itemID, "Potato", "A starchy, all-purpose potato", new Amount (4), new Amount(0), new Amount (0.25));
		String itemStr = item.toString();
		String returnedItemStr = invSys.getItem(itemID).toString();
		boolean expResult = true;
		boolean itemsAreEqual = itemStr.equals(returnedItemStr);
		assertEquals(expResult, itemsAreEqual, "Checks if the inventory system returns the correct item.");
	}
}
