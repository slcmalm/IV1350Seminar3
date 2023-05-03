package se.kth.iv1350.sale.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemListTest {

	@Test
	void testLengthIfItemQuantityZero() {
		ItemList list = new ItemList();
		list.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(25), new Amount(20), new Amount(20)), 0);
		int length = list.getLength();
		assertEquals(0, length, "Checks if length stays at 0 when adding item quantity of 0");
	}
	
	@Test
	void testLengthIfItemQuantityThree() {
		ItemList list = new ItemList();		
		list.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(25), new Amount(20), new Amount(20)), 3);
		int length = list.getLength();
		assertEquals(3, length, "Checks if length is correct when the quantity of items added is larger than zero");

	}
	
	@Test
	void testCorrectTotalPriceOneItem() {
		ItemList list = new ItemList();
		list.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(25), new Amount(20), new Amount(20)), 1);
		Amount total = list.getTotalPrice();
		assertEquals(25, total.getValue(), "Checks if totalPrice is correct when the list consist of one item");
	}
	
	@Test
	void testCorrectTotalPriceTwoItems() {
		ItemList list = new ItemList();
		list.addItem(new ItemDTO(1, "Item 1", "This is a test item", new Amount(25), new Amount(20), new Amount(20)), 2);
		Amount total = list.getTotalPrice();
		assertEquals(50, total.getValue(), "Checks if totalPrice is correct when the list contains multiple items");
	}
}
