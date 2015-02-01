package transactionParser;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class InvoiceCreator 
{
	private DocumentBuilder builder;
	private Document doc;
	
	private String filename;
	
	public InvoiceCreator(String filename) throws ParserConfigurationException
	{
		this.filename = filename;
		
		DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
		builder = dbfactory.newDocumentBuilder();
	}
	
	public void createInvoices(ArrayList<Invoice> invoices) throws TransformerException
	{
		doc = builder.newDocument();
		doc.createElement("transactions");
		for( Invoice invoice : invoices)
		{
			doc.appendChild(createInvoice(invoice));
		}
		
		TransformerFactory tfactory = TransformerFactory.newInstance();
		Transformer transformer = tfactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filename));
		
		transformer.transform(source, result);
		
	}
	
	private Element createInvoice(Invoice invoice)
	{
		Element e = doc.createElement("invoice");
		
		e.appendChild(createTextElement("invoicenum", "" + invoice.getInvoiceNum()));
		e.appendChild(createProducts(invoice.getProducts()));
		e.appendChild(createAddress(invoice.getShippingAddress()));
		e.appendChild(createAddress(invoice.getBillingAddress()));
		e.appendChild(createBilling(invoice.getBillingInfo()));
		
		return e;
	}
	
	private Element createTextElement(String name, String text) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	private Element createProducts(Product producs[])
	{
		return null;
	}
	
	private Element createAddress(Address address)
	{
		return null;
	}
	
	private Element createBilling(BillingInfo info)
	{
		return null;
	}

}
