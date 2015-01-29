package transactionParser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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
	private DocumentBuilder builder;
	private XPath path;
	private Document doc;
	
	/**
	 * 
	 * @param filename The file that is to be parsed.
	 */
	public InvoiceParser(String filename) throws IOException, SAXException, ParserConfigurationException
	{
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		builder = dbfactory.newDocumentBuilder();
		
		XPathFactory xpfactory = XPathFactory.newInstance();
		path = xpfactory.newXPath();
		
		File f = new File(filename);
		doc = builder.parse(f);
		
	}
	
	
	/**
	 * @return The count of invoices contained in the XML file.
	 */
	public int countInvoices() throws XPathExpressionException
	{
		return Integer.parseInt(path.evaluate("count(/transactions/invoice)", doc));
	}
	
	
	/**
	 * 
	 * @return A list of all invoices in the transactions file.
	 * @throws XPathExpressionException 
	 */
	public int[] getInvoices() throws XPathExpressionException
	{
		int invoices[] = new int[countInvoices()];
		for(int i = 0; i < invoices.length; i++)
		{
			String temp = path.evaluate("/transactions/invoice[" + (i + 1) + "]/invoicenum", doc);
			invoices[i] = Integer.parseInt(temp);
		}
		
		return invoices;
	}
	
	
	/**
	 * @param invoiceNum the associated invoice number.
	 * @return A list of all purchased products.
	 * @throws XPathExpressionException 
	 */
	public Product[] getProducts(int invoiceNum) throws XPathExpressionException
	{
		int invoices[] = getInvoices();
		
		for(int i = 0; i < invoices.length; i++)
		{
			if(invoices[i] == invoiceNum)
			{
				int productCount = Integer.parseInt(path.evaluate("count(/transactions/invoice[" + (i + 1) + "]/products/product)", doc));
				Product products[] = new Product[productCount];
				
				for(int j = 0; j < productCount; j++)
				{
					String description = path.evaluate("/transactions/invoice[" + (i + 1) + "]/products/product[" + (j + 1) + "]/description", doc);
					double price = Double.parseDouble(path.evaluate("/transactions/invoice[" + (i + 1) + "]/products/product[" + (j + 1) + "]/price", doc));
					int quantity = Integer.parseInt(path.evaluate("/transactions/invoice[" + (i + 1) + "]/products/product[" + (j + 1) + "]/quantity", doc));
					
					products[j] = new Product(description, price, quantity);
				}
				
				return products;
			}
		}
		return null;
	}
	
	
	/**
	 * @param invoiceNum The associated invoice number.
	 * @return The shipping address associated with the invoice.
	 * @throws XPathExpressionException 
	 */
	public Address getShippingAddress(int invoiceNum) throws XPathExpressionException
	{
		int invoices[] = getInvoices();
		
		for(int i = 0; i < invoices.length; i++)
		{
			if(invoices[i] == invoiceNum)
			{
				String name = path.evaluate("/transactions/invoice[" + (i + 1) + "]/shippinginfo/name", doc);
				String street = path.evaluate("/transactions/invoice[" + (i + 1) + "]/shippinginfo/street", doc);
				String city = path.evaluate("/transactions/invoice[" + (i + 1) + "]/shippinginfo/city", doc);
				String state = path.evaluate("/transactions/invoice[" + (i + 1) + "]/shippinginfo/state", doc);
				int zip = Integer.parseInt(path.evaluate("/transactions/invoice[" + (i + 1) + "]/shippinginfo/zip", doc));
				
				return new Address(name, street, city, state, zip);
				
			}
		}
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
