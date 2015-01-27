package transactionParser;

public class Product 
{
	private String description;
	private double price;
	private int quantity;
	
	public Product(String description, double price, int quantity)
	{
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}

}
