package transactionParser;

public class Address 
{
	private String name;
	private String street;
	private String city;
	private String state;
	private int zipcode;
	
	public Address(String name, String street, String city, String state, int zipcode)
	{
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public int getZipCode()
	{
		return zipcode;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
		{
			return false;
		}
		
		if(obj == null || obj.getClass() != this.getClass())
		{
			return false;
		}
		
		
		Address a = (Address)obj;
		
		return this.name.equals(a.name) &&
				this.street.equals(a.street) &&
				this.city.equals(a.city) &&
				this.state.equals(a.state) &&
				this.zipcode == a.zipcode;
		
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

}
