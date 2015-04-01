package footy;

public class account {
	
	String account_name;
	String account_password;
	
	public account()
	{
		this.account_name = "guest";
		this.account_password = "guest";
	}
	public account(String account_name, String account_password)
	{
		this.account_name = account_name;
		this.account_password = account_password;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getAccount_password() {
		return account_password;
	}
	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}
}
