package se.kth.iv1350.sale.model;

/**
 * 
 * @author Sophie
 *
 */
public class Amount {

	private float value;
	/**
	 * 
	 * @param amount
	 */
	public Amount(int amount) {
		value = (float)amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public Amount(float amount) {
		value = amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public Amount(Amount amount) {
		value = amount.value;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void setValue(int amount) {
		value = (float)amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void setValue(float amount) {
		value = amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void setValue(Amount amount) {
		value = amount.getValue();
	}
	
	/**
	 * 
	 * @return
	 */
	public float getValue() {
		return value;
	}

}
