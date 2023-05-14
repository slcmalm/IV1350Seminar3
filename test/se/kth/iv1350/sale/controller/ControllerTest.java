package se.kth.iv1350.sale.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import se.kth.iv1350.sale.integration.ExternalSystemCreator;
import se.kth.iv1350.sale.model.Amount;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerTest {

	private ExternalSystemCreator externalSystems;
	private Controller contr;
	
	@BeforeEach
	public void initializeControllerTest() {
		externalSystems = new ExternalSystemCreator();
		contr = new Controller(externalSystems);
		contr.startNewSale();
	}
	
	@Test
	public void testRegisteringInvalidItemID() {
		contr.registerItem(1, 3);
		Amount total = contr.endSale();
		assertEquals(0, total.getValue(), "Checks if total stays at 0 when adding invalid item");
	}
	

	@Test
	public void testRegisteringValidItemID() {
		contr.registerItem(2, 2);
		Amount total = contr.endSale();
		assertEquals(10, total.getValue(), "Checks if total is correct when adding a valid item");
	}
	

	@Test
	public void testValidDiscount() {
		contr.registerItem(2, 2);
		int customerID = 1;
		Amount priceAfterDiscount = contr.getDiscount(customerID);
		assertEquals(9, priceAfterDiscount.getValue(), "Checks if total is correct when applying a valid discount");
	}
	

	@Test
	public void testInvalidDiscount() {
		contr.registerItem(2, 2);
		int customerID = 0;
		Amount priceAfterDiscount = contr.getDiscount(customerID);
		assertEquals(10, priceAfterDiscount.getValue(), "Checks if total is correct when applying an invalid discount");
	}
}
