package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.sale.model.Amount;
import se.kth.iv1350.sale.model.Purchase;

class AmountTest {

	@Test
	void testMultiplier() {
		Amount firstValue = new Amount(2);
		Amount secondValue = new Amount(3);
		Amount total = firstValue.multiply(secondValue);
		assertEquals(6, total.getValue(), "Checks if total is correct when multiplying two Amounts");

	}
	
	@Test
	void testSubtraction() {
		Amount firstValue = new Amount(5);
		Amount secondValue = new Amount(3);
		Amount total = firstValue.subtract(secondValue);
		assertEquals(2, total.getValue(), "Checks if total is correct when subtracting an Amount from another Amount");
	}

	@Test
	void testAddition() {
		Amount firstValue = new Amount(5);
		Amount secondValue = new Amount(3);
		Amount total = firstValue.add(secondValue);
		assertEquals(8, total.getValue(), "Checks if total is correct when adding two different Amounts");
	}
	

	@Test
	void testMultipleActionsFloats() {
		Amount discount = new Amount(0.2);
		Amount total = new Amount(10);
		Amount discountMultiplier = new Amount(1);
		discountMultiplier = discountMultiplier.subtract(discount);	
		total = total.multiply(discountMultiplier);
		assertEquals(8, total.getValue(), "Checks if total is correct when adding two different Amounts");
	}
}
