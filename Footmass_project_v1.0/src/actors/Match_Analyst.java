package actors;
import footy.account;

public class Match_Analyst {
	account my_acc;
	
	public Match_Analyst(String username, String password)
	{
		System.out.println("Match analyst constructor username" + username+ "password "+password);
		this.my_acc = new account(username,password);
	}
	public account getMy_acc() {
		return my_acc;
	}
	public void setMy_acc(account my_acc) {
		this.my_acc = my_acc;
	}
	
}

