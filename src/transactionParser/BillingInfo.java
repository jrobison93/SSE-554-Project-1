package transactionParser;

public class BillingInfo 
{
	private long cardNumber;
	private int month;
	private int year;
	private int securityCode;
	
	public BillingInfo(long cardNumber, int month, int year, int securityCode)
	{
		this.cardNumber = cardNumber;
		this.month = month;
		this.year = year;
		this.securityCode = securityCode;
	}
	
	public long getCardNumber()
	{
		return cardNumber;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getSecurityCode()
	{
		return securityCode;
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
		
		
		BillingInfo b = (BillingInfo)obj;
		
		return this.cardNumber == b.cardNumber &&
				this.month == b.month && 
				this.year == b.year &&
				this.securityCode == b.securityCode; 
		
	}
	
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

}
