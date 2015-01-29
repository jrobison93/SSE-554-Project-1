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
	
	@Override
	public boolean equals(Object obj)
	{
		
		if(obj == this)
		{
			return true;
		}
		
		if(obj == null || obj.getClass() != this.getClass())
		{
			return false;
		}
		
		
		Product p = (Product)obj;
		
		return this.description.equals(p.description) &&
				this.price == p.price &&
				this.quantity == p.quantity; 
		
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

}
