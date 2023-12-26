package carRent;

public class User {
	String username;
	String password;
	User(String s,String p)
	{
		this.username=s;
		this.password=p;
	}
	public boolean check(String user,String pass)
	{
		if(username.equals(user)&&password.equals(pass))
			return true;
		else
			return false;
	}
	

}
