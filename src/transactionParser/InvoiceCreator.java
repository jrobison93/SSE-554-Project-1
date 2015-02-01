package transactionParser;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

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
		Element e = doc.createElement("transactions");
		for( Invoice invoice : invoices)
		{
			e.appendChild(createInvoice(invoice));
		}
		
		doc.appendChild(e);
		
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
		e.appendChild(createAddress(invoice.getShippingAddress(), "shippinginfo"));
		e.appendChild(createAddress(invoice.getBillingAddress(), "billinginfo"));
		e.appendChild(createBilling(invoice.getBillingInfo()));
		
		return e;
	}
	
	private Element createTextElement(String name, String text) 
	{
		Text t = doc.createTextNode(text);
		Element e = doc.createElement(name);
		e.appendChild(t);
		
		return e;
		
	}

	private Element createProducts(Product products[])
	{
		Element e = doc.createElement("products");
		
		for(Product product : products)
		{
			e.appendChild(createProduct(product));
		}
		
		return e;
	}
	
	private Element createProduct(Product product)
	{
		Element e = doc.createElement("product");
		
		e.appendChild(createTextElement("description", product.getDescription()));
		e.appendChild(createTextElement("price", "" + product.getPrice()));
		e.appendChild(createTextElement("quantity", "" + product.getQuantity()));
		
		return e;
	}
	
	private Element createAddress(Address address, String tag)
	{
		Element e = doc.createElement(tag);
		
		e.appendChild(createTextElement("name", address.getName()));
		e.appendChild(createTextElement("street", address.getStreet()));
		e.appendChild(createTextElement("city", address.getCity()));
		e.appendChild(createTextElement("state", address.getState()));
		e.appendChild(createTextElement("zip", "" + address.getZipCode()));
		
		return e;
	}
	
	private Element createBilling(BillingInfo info)
	{
		Element e = doc.createElement("paymentinfo");
		
		e.appendChild(createTextElement("cardnum", "" + info.getCardNumber()));
		
		Element exp = doc.createElement("expdate");
		exp.appendChild(createTextElement("month", "" + info.getMonth()));
		exp.appendChild(createTextElement("year", "" + info.getYear()));
		e.appendChild(exp);
		
		e.appendChild(createTextElement("securitycode", String.format("%03d", info.getSecurityCode())));
		
		return e;
	}

}
