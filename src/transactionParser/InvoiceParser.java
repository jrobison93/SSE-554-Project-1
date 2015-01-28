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
