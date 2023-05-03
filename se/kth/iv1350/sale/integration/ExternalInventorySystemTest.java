package se.kth.iv1350.sale.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExternalInventorySystemTest {

	@Test
	void testItemIDValidityTrue() {
		int itemID = 2;
		ExternalInventorySystem invSys = new ExternalInventorySystem();
		assertTrue(invSys.getItemValidity(itemID), "Checks if itemID = 2 passes the validity check.");
	}
	
	@Test
	void testItemIDValidityFalse() {
		int itemID = 1;
		ExternalInventorySystem invSys = new ExternalInventorySystem();
		assertFalse(invSys.getItemValidity(itemID), "Checks if itemID = 1 fails the validity check.");
	}
}
