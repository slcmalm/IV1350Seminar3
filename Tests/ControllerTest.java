package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import se.kth.iv1350.sale.controller.Controller;
import se.kth.iv1350.sale.integration.ExternalSystemCreator;
import se.kth.iv1350.sale.model.Amount;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControllerTest {

	private ExternalSystemCreator externalSystems;
	private Controller contr;
	
	@BeforeAll
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
}
