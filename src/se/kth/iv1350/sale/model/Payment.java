package se.kth.iv1350.sale.model;

/**
 * The Payment class handles a payment and is responsible for the receipt and the sale log.
 */
public class Payment {
	
	private SaleLog saleLog;
	private PurchaseDTO saleInfo;
	private Amount amountPaid;
	private Amount change;
	/**
	 * Initializes an instance of Payment.
	 * @param saleInfo The current Purchase.
	 */
	public Payment(PurchaseDTO saleInfo, Amount amountPaid) {
		saleLog = new SaleLog();
		this.saleInfo = saleInfo;
		this.amountPaid = amountPaid;
		change = amountPaid.subtract(saleInfo.runningTotal);
	}
	
	/**
	 * Returns the amount of change that is to be given to the customer.
	 * @param amountPaid The amount that the customer has provided to the cashier.
	 * @return The amount of change that the cashier should provide to the customer.
	 */
	public Amount getChangeAmount() {
		return change;
	}
	
	/**
	 * Creates and returns a receipt for the current purchase.
	 * @return The receipt.
	 */
	public ReceiptDTO getReceipt() {
		Receipt receipt = new Receipt(saleInfo, getPaymentDTO());
		return receipt.getReceiptDTO();
	}
	
	/**
	 * Logs the sale in the internal SaleLog.
	 */
	public void logSale() {
		saleLog.log(saleInfo, getPaymentDTO());
	}
	
	private PaymentDTO getPaymentDTO() {
		return new PaymentDTO(amountPaid, change);		
	}
	
}
