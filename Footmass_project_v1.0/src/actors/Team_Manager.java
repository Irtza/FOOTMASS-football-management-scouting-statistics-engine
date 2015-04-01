package actors;
import footy.account;

public class Team_Manager extends User {
	String name_manager;
	String club_affiliation;
	
	account my_acc;		 					
	
	public Team_Manager(String name_manager, String club_affiliation)
	{
		this.name_manager = name_manager;
		this.club_affiliation = club_affiliation;
		this.my_acc = new account(name_manager,name_manager);	//ACCOUNT PASSWORD IS SAME AS NAME;
	}
	
	public account getMy_acc() {
		return my_acc;
	}
	public void setMy_acc(account my_acc) {
		this.my_acc = my_acc;
	}
	public String getName_manager() {
		return name_manager;
	}
	public String getClub_affiliation() {
		return club_affiliation;
	}
	public void setClub_affiliation(String club_affiliation) {
		this.club_affiliation = club_affiliation;
	}
}