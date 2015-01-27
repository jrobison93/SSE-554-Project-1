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
	

}
