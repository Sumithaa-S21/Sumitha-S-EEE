package carRent;

public class Customer {
	String custName;
	int custId;
	int carId;
	String mobileNo;
	String Address;
	
	Customer(String name,int n,String ph,String add)
	{
		this.custName=name;
		this.custId=n;
		this.carId=0;
		this.mobileNo=ph;
		this.Address=add;
	}
	public void displayCustomer()
	{
		System.out.println("Name: "+custName+", ID: "+custId+", Phone: "+mobileNo+", Address: "+Address);
	}
	public int checkCustomer(int id)
	{
		if(custId==id)
		{
			return 1;
		}
		return 0;
	}
}
