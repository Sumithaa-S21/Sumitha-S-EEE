package carRent;
public class Car {
	int carNo;
	String carModel;
	String avl;
	int deposite;
	Car(int nu,String name,String avl,int dep)
	{
		this.carNo=nu;
		this.carModel=name;
		this.avl=avl;
		this.deposite=dep;
	}
	public void displayCar()
	{
		System.out.println("Car Number: "+carNo+", Car Model: "+carModel+", Available: "+avl+", Deposite Amount: "+deposite);
	}
	public boolean set(int Id)
	{
		if(carNo==Id)
		{
			avl="yes";
			return true;
		}
		return false;
	}
	public int checkCar(int Id)
	{
		int f=0;
		if(carNo==Id&&avl.equals("yes"))
		{
			System.out.println("Car Number "+Id+" is Available");
			f=1;
		}
		return f;
	}
	public String booking(int id)
	{
		String s="";
		if(carNo==id)
		{
			avl="no";
			s=s+carNo+"/"+carModel+"/"+avl+"/"+deposite;
			System.out.println("Car Number "+id+" is succesfully Booked for the Rent");
		}
		return s;
	}

}
