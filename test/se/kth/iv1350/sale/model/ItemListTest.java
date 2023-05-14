package se.kth.iv1350.sale.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemListTest {
	
	private ItemList list;
	private ItemDTO item;
	
	@BeforeEach
	void initItemListTest() {
		list = new ItemList();
		int itemID = 2;
		item = new ItemDTO(itemID, "Potato", "A starchy, all-purpose potato", new Amount (4), new Amount(0), new Amount (0.25));
	}

	@Test
	void testItemListLengthZeroItems() {
		list.addItem(item, 0);
		int length = list.getLength();
		assertEquals(0, length, "Checks if the length stays at zero when adding zero items");
	}
	
	@Test
	void testItemListLengthMultipleItems() {
		list.addItem(item, 4);
		list.addItem(item, 3);
		int length = list.getLength();
		assertEquals(7, length, "Checks if the length is correct when adding multiple items");
	}
	
	@Test
	void testItemListLengthNegativeItems() {
		list.addItem(item, -4);
		int length = list.getLength();
		assertEquals(0, length, "Checks if the length stays at zero when a negative quantity of items");
	}
}
