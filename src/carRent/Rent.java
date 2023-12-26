package carRent;

public class Rent {
	int carNo;
	String carModel;
	String avl;
	int deposite;
	int rentPrice;
	int fine=0;
	String returnDate;
	String returnStatus;
	
	
	Rent(int nu,String name,String avl,int dep,int rent,String date)
	{
		this.carNo=nu;
		this.carModel=name;
		this.avl=avl;
		this.deposite=dep;
		this.rentPrice=rent;
		this.returnDate=date;
		this.returnStatus="Not Returned";
	}
	public void print()
	{
		System.out.println("Car Number: "+carNo+", Car Model: "+carModel+", Available: "+avl+", Deposit: "+deposite+", Rent Price: "+rentPrice+",Fine Amount: "+fine+", Return date: "+returnDate+", Return Status: "+returnStatus);
	}
	public boolean returncar(int Id,int f,int caution)
	{
		boolean v=false;
		if(carNo==Id)
		{
			if(caution!=0)
				avl="no";
			else
				avl="yes";
		returnStatus="Returned";
		deposite=caution;
		fine=f;
		v=true;
		}
		return v;
	}
}
