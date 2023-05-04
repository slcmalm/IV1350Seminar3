package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.sale.integration.ExternalInventorySystem;

class ExternalInventorySystemTest {

	@Test
	void testItemIDValidityTrue() {
		int itemID = 2;
		ExternalInventorySystem invSys = new ExternalInventorySystem();
		assertTrue(invSys.getItemValidity(itemID), "Checks if a valid itemID passes the validity check.");
	}
	
	@Test
	void testItemIDValidityFalse() {
		int itemID = 0;
		ExternalInventorySystem invSys = new ExternalInventorySystem();
		assertFalse(invSys.getItemValidity(itemID), "Checks if an invalid itemID fails the validity check.");
	}
}
