package factory_classes;

import actors.Coach;
import actors.Scout;
import actors.Team_Manager;
import actors.Transfer_agent;
import actors.User;

/*
 * 
 *	Footmass admin will ONLY use this class. 
 *	Footmass admin will ONLY be creating users 
 *	As a USER is a complex object. 
 *	A User Factory will be creating USER objects
 *	
 */


public class userFactory {
	//Creates objects for user accounts on footmass.
	private static userFactory uobj=null;
	private userFactory()
	{
		
	}
	public static userFactory getinstance()
	{
		if(uobj==null)
		{
			uobj=new userFactory();
		}
		return uobj;
	}
	
	public static User getUser(String criteria,String name,String club_affiliation) throws NullPointerException
	  {
		//YOU ARE SETTING UP ITS ACCOUNTS ASWELL Composition
		
	    if ( criteria.equals("Team Manager") )   	
	      return new Team_Manager(name,club_affiliation);
	    else if ( criteria.equals("Transfer Agent") )
	      return new Transfer_agent(name,club_affiliation);
	    else if ( criteria.equals("Scout") )
	      return new Scout(name,club_affiliation);
	    else if ( criteria.equals("Coach") )
		      return new Coach(name,club_affiliation);
	 
	    return null;
	  }
}
