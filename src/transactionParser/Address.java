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
	
	public boolean compareAddresses(Address address)
	{
		return this.name == address.name &&
				this.street == address.street &&
				this.city == address.city &&
				this.state == address.state &&
				this.zipcode == address.zipcode;
		
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
