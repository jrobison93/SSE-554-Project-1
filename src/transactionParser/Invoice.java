package transactionParser;

public class Invoice 
{
	private Product products[];
	private Address shippingAddr;
	private Address billingAddr;
	private BillingInfo billingInfo;
	private int invoiceNumber;
	
	public Invoice(Product products[], Address shipping, Address billing, BillingInfo info, int num)
	{
		this.products = products;
		this.shippingAddr = shipping;
		this.billingAddr = billing;
		this.billingInfo = info;
		this.invoiceNumber = num;
	}

}
