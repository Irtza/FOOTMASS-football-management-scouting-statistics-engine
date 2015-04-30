package persistencePackage;

import java.util.ArrayList;

import actors.Coach;
import actors.Scout;
import actors.Team_Manager;
import actors.Transfer_agent;
import footy.Player;

//This class needs to handle stuff from the properties file
//This Class follows A singleton pattern as we need its instance only once\
//This wouldn't have the redundancy in the data

public class Persistence_Adapter {

	private static Persistence_Adapter generic_Static_Persistence_obj = null;	//Private Static reference,encapsulation ensures only once instance is created			
	String config;

	protected Persistence_Adapter() {					
		config = "DB";		//Default persistence type
	}	
	protected Persistence_Adapter(String config_arg) {
		config = config_arg;
	}

	public static Persistence_Adapter getInstance(String config_arg) {
		
		// Singleton pattern and Adapter Pattern
		if (generic_Static_Persistence_obj == null)
		{
			if (config_arg == "DB")
			{
				generic_Static_Persistence_obj = new DBhandler();
			}
			
			if (config_arg == "FILE")
			{
			System.out.println("Writing to a file");
			}
			
			if (config_arg == "Cloud")
			{
				System.out.println("Going to the clouds");
				
			}
			/*
			 * 
			 * 
			 * Code can be Extendible here if a new persistence method is used in the future
			 * 
			 * 
			 * 
			 */
		}
		return generic_Static_Persistence_obj;
	}
	
	//POLYMORPHIC CALLS
	public void load_player_pool(ArrayList<Player> poolList) 
	{	
	}
	
	public void save_player_pool(ArrayList<Player> poolList) 
	{	
	}
	
	public void load_scout_pool(ArrayList<Scout> Scoutreg) 
	{	
	}
	
	public void save_scout_pool(ArrayList<Scout> Scoutreg) 
	{
	}
	
	public void load_coach_pool(ArrayList<Coach> Coachreg) 
	{	
	}
	
	public void save_coach_pool(ArrayList<Coach> Coachreg) 
	{
	}
	public void load_transferagent_pool(ArrayList<Transfer_agent> agentreg) 
	{	
	}
	
	public void save_transferagent_pool(ArrayList<Transfer_agent> agentreg) 
	{
	}
	public void load_teammanager_pool(ArrayList<Team_Manager> teammanregList) 
	{	
	}
	
	public void save_teammanager_pool(ArrayList<Team_Manager> teammanregList) 
	{
	}
}
