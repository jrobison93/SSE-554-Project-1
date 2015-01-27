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
	
	public boolean compareInfo(BillingInfo bill)
	{
		return this.cardNumber == bill.cardNumber &&
				this.month == bill.month && 
				this.year == bill.year &&
				this.securityCode == bill.securityCode;
	}

}
