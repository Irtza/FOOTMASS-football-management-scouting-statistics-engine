package footy;
import java.util.ArrayList;
import java.util.Iterator;

import factory_classes.userFactory;
import actors.Transfer_agent;

public class Transfer_Agent_Register {
	
	private static Transfer_Agent_Register regobj1 = null ;
	
	static ArrayList<Transfer_agent> agentreg = new ArrayList<Transfer_agent>(); //ONE TIME
	
	/*
	 * Follows Creator Pattern but uses a FACTORY for super class objects for object creation 
	 * 
	 * Add++++++ method uses the UserFactory to create generalized objects and casts them to specialize them.
	 * 
	 */
	
	private Transfer_Agent_Register()
	{
		
	}
	public static Transfer_Agent_Register getinstance()
	{
		if (regobj1 == null)
		{
			regobj1 = new Transfer_Agent_Register();
		}
		return regobj1;		
	}
	public void add_transfer_agent(String name_transferAgent,String club_affiliation)
	{
		userFactory.getinstance(); //Static way to call a static method on a static object, no need for a declared reference
		Transfer_agent obj2= (Transfer_agent) userFactory.getUser("Transfer Agent", name_transferAgent, club_affiliation);
		//YOU ARE SETTING UP ITS ACCOUNT ASWELL
		agentreg.add(obj2);
		
		System.out.println(name_transferAgent + " has been added to the club :" + club_affiliation);
		System.out.println(obj2.getMy_acc().getAccount_name() + " is the username ");
	}
	public void edit_my_account_transferagent(String name_transferAgent, String club_affiliation,String username_new, String password_new)
	{
		account my_new_acc = new account(username_new,password_new);
		boolean check = true;
		Iterator<Transfer_agent> it = agentreg.iterator();
		while(it.hasNext())
		{
			Transfer_agent searchobj = it.next();		
			if (searchobj.getName_transferAgent().equals(name_transferAgent) && searchobj.getClub_affiliation().equals(club_affiliation))
			{
				searchobj.setMy_acc(my_new_acc);
				check = true;
				System.out.println("Agent claire Found and editted !");
				break;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Agent not found");
		}
		
		System.out.println("edit my account has been done");
	}
	
/*	public Transfer_agent gettransferagent(String name_transferAgent,String club_affiliation) 
	{
		boolean check = true;
		Iterator<Transfer_agent> it = agentreg.iterator();
		
		while(it.hasNext())
		{
			Transfer_agent searchobj = it.next();		
			if (searchobj.getName_transferAgent().equals(name_transferAgent) && searchobj.getClub_affiliation().equals(club_affiliation))
			{
				check = true;
				System.out.println("Agent Found returning!");
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Agent not found");
			return null;
		}

		return null;
	}
	*/
	public Transfer_agent gettransferagent(String username,String password) 
	{
		boolean check = true;
		Iterator<Transfer_agent> it = agentreg.iterator();
		
		while(it.hasNext())
		{
			Transfer_agent searchobj = it.next();		
			if (searchobj.getMy_acc().getAccount_name().equals(username) && searchobj.getMy_acc().getAccount_password().equals(password))
			{
				check = true;
				System.out.println("Transfer Agent Found returning!");
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Transfer Agent not found");
			return null;
		}

		return null;
	}

	public boolean delete_transferagent(String name_transferAgent, String club_affiliation) 
	{
		boolean check = true;	
		Iterator<Transfer_agent> it = agentreg.iterator(); 
		
		while (it.hasNext())
		{
			Transfer_agent delobj = it.next();
			
			if (delobj.getName_transferAgent().equals(name_transferAgent) && delobj.getClub_affiliation().equals(club_affiliation))
			{
				it.remove();
				check = true;
				return true;
			}
			else
				check = false;
		}
		
		if (check == false)
			return false;
		return false;
	}
	public boolean auth_transferagent(account my_acc_arg)
	{
		boolean check = true;
		Iterator<Transfer_agent> it = agentreg.iterator(); 
		while (it.hasNext())
		{
			Transfer_agent searchobj = it.next();
			if (searchobj.getMy_acc().getAccount_name().equals(my_acc_arg.getAccount_name())   &&  searchobj.getMy_acc().getAccount_password().equals(my_acc_arg.getAccount_password()))
			{
				System.out.println("Access granted ");
				check = true;				
				return true;
			}
			else
				check = false; 
		}
		if (check == false)
		{
			System.out.println("There is no account in Agent reg");
			return false;
		}	
		System.out.println("There is no account in Agent reg");
		return false;
	}

}