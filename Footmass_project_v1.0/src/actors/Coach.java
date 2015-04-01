package actors;

import footy.account;

public class Coach extends User {
	String name_coach;
	String club_affiliation;
	
	account my_acc;
	
	public Coach(String name_coach, String club_affiliation)
	{
		this.name_coach = name_coach;
		this.club_affiliation = club_affiliation;
		this.my_acc = new account(name_coach,name_coach);	//ACCOUNT PASSWORD IS SAME AS NAME;
	}

	public String getName_coach() {
		return name_coach;
	}

	public void setName_coach(String name_coach) {
		this.name_coach = name_coach;
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
