package footy;

import java.util.ArrayList;
import java.util.Iterator;

import factory_classes.userFactory;
import actors.Team_Manager;

public class Team_Manager_Register {
	
	private static Team_Manager_Register registerclass = null;
	
	static ArrayList<Team_Manager> teammanregList = new ArrayList<Team_Manager>(); //ONE TIME
	
	/*
	 * Follows Creator Pattern but uses a FACTORY for super class objects for object creation 
	 * 
	 * Add++++++ method uses the UserFactory to create generalized objects and casts them to specialize them.
	 * 
	 */
	private Team_Manager_Register()
	{
		
	}
	
	public static Team_Manager_Register getInstance() {
		// TODO Auto-generated method stub
		
		if (registerclass == null)
		{
			registerclass = new Team_Manager_Register();
		}
		return registerclass;
	}
	
	public void add_team_manager(String name_manager,String club_affiliation)
	{
		userFactory.getinstance(); //Static way to call a static method on a static object, no need for a declared reference
		Team_Manager obj= (Team_Manager) userFactory.getUser("Team Manager", name_manager, club_affiliation);
		teammanregList.add(obj);
		System.out.println(name_manager + " has been added to the club :" + club_affiliation);
		System.out.println(obj.getMy_acc().getAccount_name() + " is the username ");
	}
	public void edit_my_account(String name_manager, String club_affiliation,String username_new, String password_new)
	{
		account my_new_acc = new account(username_new,password_new);
		
		boolean check = true;
		Iterator<Team_Manager> it = teammanregList.iterator();
		while(it.hasNext())
		{
			Team_Manager searchobj = it.next();		
			if (searchobj.getName_manager().equals(name_manager) && searchobj.getClub_affiliation().equals(club_affiliation))
			{
				searchobj.setMy_acc(my_new_acc);
				check = true;
				System.out.println("Manager Found and editted !");
				break;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Manager not found");
		}
		
		System.out.println("edit my account has been done");
	}

	/*	
	public Team_Manager getteamManager(String name_manager,String club_affiliation)
	{
		boolean check = true;
		Iterator<Team_Manager> it = teammanregList.iterator();
		while(it.hasNext())
		{
			Team_Manager searchobj = it.next();		
			if (searchobj.getName_manager().equals(name_manager) && searchobj.getClub_affiliation().equals(club_affiliation))
			{
				check = true;
				System.out.println("Manager Found returning!");
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Manager not found");
			return null;
		}

		return null;
	}
*/
	public Team_Manager getteamManager(String username,String password)
	{
		boolean check = true;
		Iterator<Team_Manager> it = teammanregList.iterator();
		while(it.hasNext())
		{
			Team_Manager searchobj = it.next();		
			if (searchobj.getMy_acc().getAccount_name().equals(username) && searchobj.getMy_acc().getAccount_password().equals(password))
			{
				check = true;
				System.out.println("Manager Found returning!");
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Manager not found");
			return null;
		}

		return null;
	}
	public boolean delete_team_manager(String name_manager, String club_affiliation) 
	{
		boolean check = true;	
		Iterator<Team_Manager> it = teammanregList.iterator(); 
		while (it.hasNext())
		{
			Team_Manager delobj = it.next();
			
			if (delobj.getName_manager().equals(name_manager) && delobj.getClub_affiliation().equals(club_affiliation))
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
	
	public boolean auth_teamman(account my_acc_arg)
	{
		boolean check = true;
		Iterator<Team_Manager> it = teammanregList.iterator(); 
		while (it.hasNext())
		{
			Team_Manager searchobj = it.next();
			if (searchobj.getMy_acc().getAccount_name().equals(my_acc_arg.getAccount_name())   &&  searchobj.getMy_acc().getAccount_password().equals(my_acc_arg.getAccount_password()))
			{
				check = true;				
				return true;
			}
			else
				check = false; 
		}
		if (check == false)
		{
			return false;
		}	
		return false;
	}

}

// J option pane can also have club