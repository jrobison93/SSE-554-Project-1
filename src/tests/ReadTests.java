package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import transactionParser.*;

public class ReadTests 
{
	String filePath = System.getProperty("user.dir") + "/src/res/transactions.xml";
	

	@Test
	public void testGetInvoiceCount() throws Exception
	{
		InvoiceParser parser = new InvoiceParser(filePath);
		assertEquals(2, parser.countInvoices());
	}
	
	@Test
	public void testGetInvoices() throws Exception
	{
		InvoiceParser parser = new InvoiceParser(filePath);
		int invoices[] = {1000, 1001};
		
		assertArrayEquals(invoices, parser.getInvoices());
	}
	
	@Test
	public void testGetProducts() throws Exception
	{
		InvoiceParser parser = new InvoiceParser(filePath);
		Product products[] = {new Product("Core Java, Volume I -- Fundamentals", 33.37, 1),
				new Product("Core Java, Volume II -- Advanced Features", 36.12, 1)};
		
		assertArrayEquals(products, parser.getProducts(1000));
	}
	
	@Test
	public void testGetShippingAddress() throws Exception
	{
		InvoiceParser parser = new InvoiceParser(filePath);
		Address address = new Address("John Robison", "750 Corder Road", "Warner Robins", "Georgia", 31088);
		
		assertEquals(address, parser.getShippingAddress(1000));
	}
	
	@Test
	public void testGetBillingAddress() throws Exception
	{
		InvoiceParser parser = new InvoiceParser(filePath);
		Address address = new Address("John Robison", "101 Fir Ct.", "Waleska", "Georgia", 30183);
		
		assertEquals(address, parser.getBillingAddress(1000));
	}
	
	@Test
	public void testGetBillingInfo() throws Exception
	{
		InvoiceParser parser = new InvoiceParser(filePath);
		BillingInfo info = new BillingInfo(123456789012345L, 8, 2017, 012);
		
		assertEquals(info, parser.getBillingInfo(1000));
	}

}
