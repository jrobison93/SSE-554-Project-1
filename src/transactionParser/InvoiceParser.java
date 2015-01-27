package transactionParser;

/**
 * This class is responsible for reading in transactions through an XML format
 * for a book store.
 * 
 * 
 * @author John Robison
 *
 */

public class InvoiceParser 
{
	/**
	 * 
	 * @param filename The file that is to be parsed.
	 */
	public InvoiceParser(String filename)
	{
		
	}
	
	
	/**
	 * @return The count of invoices contained in the XML file.
	 */
	public int countInvoices()
	{
		return 0;
	}
	
	
	/**
	 * 
	 * @return A list of all invoices in the transactions file.
	 */
	public int[] getInvoices()
	{
		return null;
	}
	
	
	/**
	 * @param invoiceNum the associated invoice number.
	 * @return A list of all purchased products.
	 */
	public Product[] getProducts(int invoiceNum)
	{
		return null;
	}
	
	
	/**
	 * @param invoiceNum The associated invoice number.
	 * @return The shipping address associated with the invoice.
	 */
	public Address getShippingAddress(int invoiceNum)
	{
		return null;
	}
	
	/**
	 * @param invoiceNum The associated invoice number.
	 * @return The billing address associated with the invoice. 
	 */
	public Address getBillingAddress(int invoiceNum)
	{
		return null;
	}
	
	
	/**
	 * @param invoiceNum The associated invoice number.
	 * @return The billing information associated with the invoice. 
	 */
	public BillingInfo getBillingInfo(int invoiceNum)
	{
		return null;
	}

}
