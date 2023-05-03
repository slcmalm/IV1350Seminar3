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
	public Payment(PurchaseDTO saleInfo) {
		saleLog = new SaleLog();
		this.saleInfo = saleInfo;
		amountPaid = new Amount(0);
		change = new Amount(0);
	}
	
	/**
	 * Calculates the amount of change that is to be given to the customer.
	 * @param amountPaid The amount that the customer has provided to the cashier.
	 * @return The amount of change that the cashier should provide to the customer.
	 */
	public Amount getChangeAmount(Amount amountPaid) {
		this.amountPaid = amountPaid;
		change = new Amount(amountPaid.getValue()-saleInfo.runningTotal.getValue());
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
	 * 
	 */
	public void logSale() {
		saleLog.log(saleInfo, getPaymentDTO());
	}
	
	private PaymentDTO getPaymentDTO() {
		return new PaymentDTO(amountPaid, change);		
	}
}
