package actors;

import footy.account;

public class Transfer_agent extends User {
	
	String name_transferAgent;
	String club_affiliation;

	account my_acc;

	public Transfer_agent(String name_transferAgent, String club_affiliation) {
		// TODO Auto-generated constructor stub
		this.name_transferAgent = name_transferAgent;
		this.club_affiliation = club_affiliation;
		this.my_acc = new account(name_transferAgent,name_transferAgent);	//ACCOUNT PASSWORD IS SAME AS NAME;
	}
	public String getName_transferAgent() {
		return name_transferAgent;
	}
	public void setName_transferAgent(String name_transferAgent) {
		this.name_transferAgent = name_transferAgent;
	}
	public String getClub_affiliation() {
		return club_affiliation;
	}
	public void setClub_affiliation(String club_affiliation) {
		this.club_affiliation = club_affiliation;
	}
	public account getMy_acc() {
		return my_acc;
	}
	public void setMy_acc(account my_acc) {
		this.my_acc = my_acc;
	}
}