package se.kth.iv1350.sale.model;

/**
 * This class represents a numerical amount. Can handle positive and negative integers and decimals.
 */
public class Amount {

	private final float value;
	/**
	 * Intializes an Amount using an integer.
	 * @param amount The value to be stored in this Amount.
	 */
	public Amount(int amount) {
		value = (float)amount;
	}
	
	/**
	 * Intializes an Amount using a float.
	 * @param amount The value to be stored in this Amount.
	 */
	public Amount(float amount) {
		value = amount;
	}
	
	/**
	 * Intializes an Amount using a double.
	 * @param amount The value to be stored in this Amount.
	 */
	public Amount(double amount) {
		value = (float)amount;
	}
	
	/**
	 * Intializes an Amount using another Amount.
	 * @param amount The Amount to be copied to this Amount.
	 */
	public Amount(Amount amount) {
		value = amount.value;
	}
	
	/**
	 * Returns the value of this Amount as a float.
	 * @return The value.
	 */
	public float getValue() {
		return value;
	}

	/**
	 * Adds the value of another Amount.
	 * @param other The other Amount.
	 * @return A new Amount containing the result of the addition.
	 */
	public Amount add(Amount other) {
		return new Amount(this.value + other.value);
	}
	
	/**
	 * Subtracts the value of another Amount.
	 * @param other The other Amount.
	 * @return A new Amount containing the result of the subtraction.
	 */
	public Amount subtract(Amount other) {
		return new Amount(this.value - other.value);
	}
	
	/**
	 * Multiplies this Amount with another Amount.
	 * @param other The other Amount.
	 * @return A new Amount containing the result of the multiplication.
	 */
	public Amount multiply(Amount other) {
		return new Amount(this.value * other.value);
	}
	
	/**
	 * Inverts the value of the amount. A positive value becomes negative, and vice versa.
	 * @return An Amount with the inverted value of this Amount.
	 */
	public Amount invert() {
		return new Amount(-value);
	} 
}
