package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import transactionParser.*;

public class ReadTests 
{
	InvoiceParser parser = new InvoiceParser("../res/transactions.xml");

	@Test
	public void testGetInvoiceCount() 
	{
		assertEquals(2, parser.countInvoices());
	}
	
	@Test
	public void testGetInvoices()
	{
		int invoices[] = {1000, 1001};
		
		assertEquals(invoices, parser.getInvoices());
	}
	
	@Test
	public void testGetProducts()
	{
		Product products[] = {new Product("Core Java, Volume I -- Fundamentals", 33.37, 1),
				new Product("Core Java, Volume II -- Advanced Features", 36.12, 1)};
		
		assertArrayEquals(products, parser.getProducts(1000));
	}
	
	@Test
	public void testGetShippingAddress()
	{
		Address address = new Address("John Robison", "750 Corder Road", "Warner Robins", "Georgia", 31088);
		
		assertEquals(address, parser.getShippingAddress(1000));
	}
	
	@Test
	public void testGetBillingAddress()
	{
		Address address = new Address("John Robison", "101 Fir Ct.", "Waleska", "Georgia", 30183);
		
		assertEquals(address, parser.getBillingAddress(1000));
	}
	
	@Test
	public void testGetBillingInfo()
	{
		BillingInfo info = new BillingInfo(123456789012345L, 8, 2017, 012);
		
		assertEquals(info, parser.getBillingInfo(1000));
	}

}
