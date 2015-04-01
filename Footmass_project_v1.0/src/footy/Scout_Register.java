package footy;

import java.util.ArrayList;
import java.util.Iterator;

import factory_classes.userFactory;
import actors.Scout;

public class Scout_Register {

	private static Scout_Register scoutregclass = null; 
	
	static ArrayList<Scout> Scoutreg = new ArrayList<Scout>(); //ONE TIME
	
/*
 * Follows Creator Pattern but uses a FACTORY for super class objects for object creation 
 * 
 * Add++++++ method uses the UserFactory to create generalized objects and casts them to specialize them.
 * 
 */

	private Scout_Register()
	{
		
	}
	public static Scout_Register getinstance() 
	{
		// TODO Auto-generated method stub
		if(scoutregclass == null)
		{
			scoutregclass = new Scout_Register();
		}
		return scoutregclass;
	}
	
	public void add_Scout(String name_scout,String club_affiliation)
	{	
		userFactory.getinstance(); //Static way to call a static method on a static object, no need for a declared reference
		Scout obj= (Scout) userFactory.getUser("Scout", name_scout, club_affiliation);
		
		//YOU ARE SETTING UP ITS ACCOUNT ASWELL
		Scoutreg.add(obj);
		
		System.out.println(name_scout + " has been added to the club :" + club_affiliation);
		System.out.println(obj.getMy_acc().getAccount_name() + " is the username ");
	}
	public void edit_my_account_Scout(String name_scout, String club_affiliation,String username_new, String password_new)
	{
		account my_new_acc = new account(username_new,password_new);
		boolean check = true;
		Iterator<Scout> it = Scoutreg.iterator();
		while(it.hasNext())
		{
			Scout searchobj = it.next();		
			if (searchobj.getName_scout().equals(name_scout) && searchobj.getClub_affiliation().equals(club_affiliation))
			{
				searchobj.setMy_acc(my_new_acc);
				check = true;
				System.out.println("Scout Found and editted !");
				break;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Scout not found");
		}
		
		System.out.println("edit of scout's account has been done");
	}
	
	public Scout getscout(String username,String password) throws NullPointerException
	{
		boolean check = true;
		Iterator<Scout> it = Scoutreg.iterator();
		
		while(it.hasNext())
		{
			Scout searchobj = it.next();		
			if (searchobj.getMy_acc().getAccount_name().equals(username) && searchobj.getMy_acc().getAccount_password().equals(password))
			{
				check = true;
				System.out.println("Scout found returning!");
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Scout not found");
			System.out.println("throws ne catch it");
			return null;
		}
		return null;
	}
	
	public boolean delete_Scout(String name_scout, String club_affiliation) 
	{
		boolean check = true;	
		Iterator<Scout> it = Scoutreg.iterator(); 
		
		while (it.hasNext())
		{
			Scout delobj = it.next();
			
			if (delobj.getName_scout().equals(name_scout) && delobj.getClub_affiliation().equals(club_affiliation))
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
	public boolean auth_Scout(account my_acc_arg)
	{
		boolean check = true;
		Iterator<Scout> it = Scoutreg.iterator(); 
		while (it.hasNext())
		{
			Scout searchobj = it.next();
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
			System.out.println("There is no account in Scout reg");
			return false;
		}	
		System.out.println("There is no account in Scout reg");
		return false;
	}

}
