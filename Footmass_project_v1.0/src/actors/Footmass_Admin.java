package actors;
import footy.account;

public class Footmass_Admin
{
	account my_acc;
	
	public Footmass_Admin(String username, String password)
	{
		System.out.println("Footmass constructor paramerizrd username" + username+ "password "+password);
		this.my_acc = new account(username,password);
	}
	public account getMy_acc() {
		return my_acc;
	}
	public void setMy_acc(account my_acc) {
		this.my_acc = my_acc;
	}
}
