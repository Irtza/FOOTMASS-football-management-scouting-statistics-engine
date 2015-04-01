package footy;

import java.util.ArrayList;
import java.util.Iterator;

import factory_classes.userFactory;
import actors.Coach;

public class Coach_Register {
	private static Coach_Register coachregclass = null;
	
	static ArrayList<Coach> Coachreg = new ArrayList<Coach>(); //ONE TIME
	/*
	 * Follows Creator Pattern but uses a FACTORY for super class objects for object creation 
	 * 
	 * Add++++++ method uses the UserFactory to create generalized objects and casts them to specialize them.
	 * 
	 */

	private Coach_Register()
	{
		
	}
	public static Coach_Register getinstance() {
		// TODO Auto-generated method stub
		if (coachregclass == null)
		{
			coachregclass = new Coach_Register();
		}
		return coachregclass;
	}

	public void add_coach(String name_coach,String club_affiliation)
	{

		userFactory.getinstance(); //Static way to call a static method on a static object, no need for a declared reference
		Coach obj= (Coach) userFactory.getUser("Coach", name_coach, club_affiliation);

		//YOU ARE SETTING UP ITS ACCOUNT ASWELL
		Coachreg.add(obj);

		System.out.println(name_coach + " has been added to the club :" + club_affiliation);
		System.out.println(obj.getMy_acc().getAccount_name() + " is the username ");
	}
	public void edit_my_account_Coach(String name_coach, String club_affiliation,String username_new, String password_new)
	{
		account my_new_acc = new account(username_new,password_new);
		boolean check = true;
		Iterator<Coach> it = Coachreg.iterator();
		while(it.hasNext())
		{
			Coach searchobj = it.next();		
			if (searchobj.getName_coach().equals(name_coach) && searchobj.getClub_affiliation().equals(club_affiliation))
			{
				searchobj.setMy_acc(my_new_acc);
				check = true;
				System.out.println("Coach Found and editted !");
				break;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Coach not found");
		}

		System.out.println("edit of coach's account has been done");
	}

	public Coach getcoach(String name_coach,String club_affiliation) 
	{
		boolean check = true;
		Iterator<Coach> it = Coachreg.iterator();

		while(it.hasNext())
		{
			Coach searchobj = it.next();		
			if (searchobj.getName_coach().equals(name_coach) && searchobj.getClub_affiliation().equals(club_affiliation))
			{
				check = true;
				System.out.println("Coach found returning!");
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Coach not found");
			return null;
		}

		return null;
	}

	public Coach getcoach_acc(String username,String password)	throws NullPointerException
	{
		boolean check = true;
		Iterator<Coach> it = Coachreg.iterator();
		while(it.hasNext())
		{
			Coach searchobj = it.next();		
			if (searchobj.getMy_acc().getAccount_name().equals(username) && searchobj.getMy_acc().getAccount_password().equals(password))
			{
				check = true;
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			return null;
		}

		return null;
	}

	public boolean delete_Coach(String name_coach, String club_affiliation) 
	{
		boolean check = true;	
		Iterator<Coach> it = Coachreg.iterator(); 

		while (it.hasNext())
		{
			Coach delobj = it.next();

			if (delobj.getName_coach().equals(name_coach) && delobj.getClub_affiliation().equals(club_affiliation))
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
	public boolean auth_coach(account my_acc_arg)
	{
		boolean check = true;
		Iterator<Coach> it = Coachreg.iterator(); 
		while (it.hasNext())
		{
			Coach searchobj = it.next();
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
			System.out.println("There is no account in Coach reg");
			return false;
		}	
		System.out.println("There is no account in Coach reg");
		return false;
	}


}
