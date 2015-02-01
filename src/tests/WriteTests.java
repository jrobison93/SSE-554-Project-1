package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import org.junit.After;
import org.junit.Before;
import org.junit.Assert.*;
import org.junit.Test;

import transactionParser.Address;
import transactionParser.BillingInfo;
import transactionParser.Invoice;
import transactionParser.InvoiceCreator;
import transactionParser.InvoiceParser;
import transactionParser.Product;

public class WriteTests 
{
	private String testFile = System.getProperty("user.dir") + "/src/res/test.xml";
	private String compFile = System.getProperty("user.dir") + "/src/res/transactions.xml";
	
	private InvoiceParser testParser;
	private InvoiceParser compParser;
	
	private int invoiceNum = 1000;
	
	
	@Before
	public void createTransaction() throws Exception
	{
		compParser = new InvoiceParser(compFile);
		
		InvoiceCreator creator = new InvoiceCreator(testFile);
		
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		
		Product products[] = new Product[]
				{
					new Product("Core Java, Volume I -- Fundamentals", 33.37, 1),
					new Product("Core Java, Volume II -- Advanced Features", 36.12, 1)
				};
		
		Address shipping = new Address("John Robison", "750 Corder Road", "Warner Robins", "Georgia", 31088);
		Address billing = new Address("John Robison", "101 Fir Ct.", "Waleska", "Georgia", 30183);
		
		BillingInfo info = new BillingInfo(123456789012345L, 8, 2017, 12);
		
		invoices.add(new Invoice(products, shipping, billing, info, invoiceNum));
		
		creator.createInvoices(invoices);
		
		testParser = new InvoiceParser(testFile);
	}
	
	@Test
	public void testCompareProducts() throws XPathExpressionException
	{
		assertArrayEquals(compParser.getProducts(invoiceNum), testParser.getProducts(invoiceNum));
	}
	
	@Test
	public void testCompareShippingAddress() throws XPathExpressionException
	{
		assertEquals(compParser.getShippingAddress(invoiceNum), testParser.getShippingAddress(invoiceNum));
	}
	
	@Test
	public void testCompareBillingAddress() throws XPathExpressionException
	{
		assertEquals(compParser.getBillingAddress(invoiceNum), testParser.getBillingAddress(invoiceNum));
	}
	
	@Test
	public void testCompareBillingInfo() throws XPathExpressionException
	{
		assertEquals(compParser.getBillingInfo(invoiceNum), testParser.getBillingInfo(invoiceNum));
	}
	
	
	@After
	public void deleteFile()
	{
		File file = new File(testFile);
		file.delete();
		
	}

}
