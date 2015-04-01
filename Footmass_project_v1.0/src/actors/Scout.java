package actors;

import footy.account;

public class Scout extends User {
	String name_scout;
	String club_affiliation;
	
	account my_acc;

	public Scout(String name_scout, String club_affiliation)
	{
		this.name_scout = name_scout;
		this.club_affiliation = club_affiliation;
		this.my_acc = new account(name_scout,name_scout);	//ACCOUNT PASSWORD IS SAME AS NAME;
	}
	
	public String getName_scout() {
		return name_scout;
	}

	public void setName_scout(String name_scout) {
		this.name_scout = name_scout;
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
