package carRent;
import java.util.Scanner;
import java.util.ArrayList;
public class Main_Rentpage {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		User access=new User("Raj","123");
		ArrayList<Customer> custDetails=new ArrayList<Customer>();
		ArrayList<Car> carDetails=new ArrayList<Car>();
		ArrayList<Rent> carRent=new ArrayList<Rent>();
		int entry=1;
		while(entry==1)
		{
			System.out.println("Enter your Username");
			String s=scan.next();
			System.out.println("Enter your password");
			String p=scan.next();
			int exit;
			int c;
			if(access.check(s,p))
			{
				exit=1;
				while(exit==1)
				{
					System.out.println("Enter 1 to add Customer data");
					System.out.println("Enter 2 to add Car data");
					System.out.println("Enter 3 to add to a car in rented");
					System.out.println("Enter 4 to returned a car in rented");
					System.out.println("Enter 5 to display the Customer List");
					System.out.println("Enter 6 to display the Car List");
					System.out.println("Enter 7 to display the Rented Car List");
					System.out.println("Enter 8 to edit the Car List");
					System.out.println("Enter 0 to exit the dashboard");
					c=scan.nextInt();
					if(c==1)
                    {
    					System.out.println("Enter Customer Name");
                    	String name=scan.next();
                    	System.out.println("Enter Customer ID");
        				int no=scan.nextInt();
        				System.out.println("Enter Customer Mobile no");
        				String ph=scan.next();
        				System.out.println("Enter Customer Address");
        				String add=scan.next();
        				custDetails.add(new Customer(name,no,ph,add));
                    	System.out.println("If you enter any other data please enter 1 otherwise 0");
                    	exit=scan.nextInt();
                    }
					else if(c==2)
                    {
                    	System.out.println("Enter Car ID");
                    	int carnu=scan.nextInt();
                    	System.out.println("Enter Car Model");
                    	String mod=scan.next();
                    	System.out.println("Enter the Availablitiy or not");
                    	String avl=scan.next();
                    	System.out.println("Enter Caution deposite amount");
                    	int amount=scan.nextInt();
                    	carDetails.add(new Car(carnu,mod,avl,amount));
                    	System.out.println("If you enter any other data please enter 1 otherwise 0");
                    	exit=scan.nextInt();
                    }
					else if(c==3)
					{
						int available=0;
						int rprice=0;
						String rdate;
						int Id=0;
						int cId=0;
						String values="";
						int custname=0;
						boolean flag=false;
						while(available==0)
						{
							System.out.println("Enter Car Number");
							Id=scan .nextInt();						
							System.out.println("Enter the Customer Id");
							cId=scan.nextInt();
							for(Customer detail:custDetails)
							{
								custname=detail.checkCustomer(cId);
								if(custname==1)
									break;
							}
							for(Car detail:carDetails)
							{
								available=detail.checkCar(Id);
								if(available==1)
									break;
							}
							if(available==0)
							System.out.println("Please enter the available car number");
							if(custname==0)
							{
								System.out.println("You are not a member please add a member");
								exit=0;}
						}
						if(available==1&&custname==1)
						{
							System.out.println("Enter the return date(dd-mm-yyyy)and the rental Price");
							rdate=scan.next();
							rprice=scan.nextInt();
							for(Car detail:carDetails)
							{
								values=detail.booking(Id);
								if(!values.isEmpty())
								{
									break;
								}
							}
							String bookeddetail[]=values.split("/");
							int bookedcarnumber=Integer.parseInt(bookeddetail[0]);
							int bookedcardeposite=Integer.parseInt(bookeddetail[3]);
						carRent.add(new Rent(bookedcarnumber,bookeddetail[1],bookeddetail[2],bookedcardeposite,rprice,rdate));
						System.out.println("If you enter any other data please enter 1 otherwise 0");
                    	exit=scan.nextInt();
						}
					}
					else if(c==4)
					{
						boolean rvalue=false;
						System.out.println("Enter the car Number to return");
						int returncarId=scan.nextInt();
						System.out.println("Enter the Fine amount");
						int fine=scan.nextInt();
						System.out.println("Enter the caution deposite amount");
						int depo=scan.nextInt();
						for(Rent detail:carRent)
						{
							rvalue=detail.returncar(returncarId,fine,depo);
							if(rvalue)
								break;
						}
						if(rvalue)
						System.out.println("Successfully returned a car");
						System.out.println("If you enter any other data please enter 1 otherwise 0");
                    	exit=scan.nextInt();
					}
					else if(c==5)
					{
						for(Customer detail:custDetails)
						{
							detail.displayCustomer();
						}
						System.out.println("If you enter any other data please enter 1 otherwise 0");
                    	exit=scan.nextInt();
					}
					else if(c==6)
					{
						for(Car detail:carDetails)
						{
							detail.displayCar();
						}
						System.out.println("If you enter any other data please enter 1 otherwise 0");
                    	exit=scan.nextInt();
					}
					else if(c==7)
					{
						for(Rent detail:carRent)
						{
							detail.print();
						}
						System.out.println("If you enter any other data please enter 1 otherwise 0");
                    	exit=scan.nextInt();
					}
					else if(c==8)
					{
						boolean ret=false;
						System.out.println("Enter the availablity after service car number");
                        int editcar=scan.nextInt();
                        for(Car detail:carDetails)
                        {
                        	ret=detail.set(editcar);
                        	if(ret)
                        		break;
                        }
					}
					else if(c==0)
					{
						exit=0;
					}
					else
					{
						System.out.println("Enter the valid Number");
					}
				}
				entry=0;
			}
			else
			{
				entry=1;
				System.out.println("Enter the correct UserName and Password");
			}
		}
  	}
}