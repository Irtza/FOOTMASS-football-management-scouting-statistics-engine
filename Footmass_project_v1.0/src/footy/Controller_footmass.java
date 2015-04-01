package footy;

import java.util.ArrayList;

import persistencePackage.Persistence_Adapter;
import actors.Coach;
import actors.Footmass_Admin;
import actors.Match_Analyst;
import actors.Scout;
import actors.Team_Manager;
import actors.Transfer_agent;
import footy.Player_Pool;

public class Controller_footmass 		//This class also follows A Singleton Pattern
{
	private static Controller_footmass controllerobj = null;	//Private Static reference,encapsulation ensures only once instance is created	
	
	//If we have time read the below argument from a properties file
	Persistence_Adapter Persistence_obj = Persistence_Adapter.getInstance("DB");
	
	//Getting instances from the Singleton Classes of these Registers
	Player_Pool pool_obj = Player_Pool.getinstance();
	Team_Manager_Register teamman_Register= Team_Manager_Register.getInstance();
	Transfer_Agent_Register agent_Register= Transfer_Agent_Register.getinstance();
	Scout_Register scout_Register = Scout_Register.getinstance();
	Coach_Register coach_Register = Coach_Register.getinstance();
	
	Transfer_Request_Register trans_Register;

	Footmass_Admin defaultadminuser;
	Match_Analyst defaultmatchanalyst;
	boolean returnstatus;
	
	private Controller_footmass()
	{
		trans_Register= new Transfer_Request_Register();

		defaultadminuser = new Footmass_Admin("admin","admin");	//only this user will be made with given username and password at start up
		defaultmatchanalyst = new Match_Analyst("analyst","analyst");	//only this user will be made with given username and password at start up
	}

	public static Controller_footmass getInstance()
	{
		if (controllerobj == null)
		{
			controllerobj = new Controller_footmass();	
		}
		return controllerobj;
	}

	 public void startup()	//MAKES ALL THE GODDAM REGISTERS and the one time operations
	{
		//Load persistence
		Persistence_obj.load_player_pool(Player_Pool.poolList);
		Persistence_obj.load_teammanager_pool(Team_Manager_Register.teammanregList);
		Persistence_obj.load_transferagent_pool(Transfer_Agent_Register.agentreg);
		Persistence_obj.load_scout_pool(Scout_Register.Scoutreg);
		Persistence_obj.load_coach_pool(Coach_Register.Coachreg);		
		
		//if persistence crashes you can add some data from the code directly
		//Make some Players, some scouts, some transfer agents and some Team Managers on start-up
		/*
		add_player("p1", "c1", "16", "GK");
		add_player("p11", "c1", "16", "GK");
		add_player("p12", "c1", "16", "GK");
		add_player("p13", "c1", "16", "GK");
		add_player("p14", "c1", "16", "GK");

		add_player("p2", "c2", "16", "GK");
		add_player("p21", "c2", "16", "GK");
		add_player("p21", "c2", "16", "GK");
		add_player("p22", "c2", "16", "GK");
		add_player("p23", "c2", "16", "GK");
		add_player("p24", "c2", "16", "GK");

		add_player("p3", "c3", "16", "GK");
		add_player("p31", "c3", "16", "GK");
		add_player("p32", "c3", "16", "GK");
		add_player("p33", "c3", "16", "GK");
		add_player("p34", "c3", "16", "GK");

		add_player("p4", "c4", "16", "GK");
		add_player("p41", "c4", "16", "GK");
		add_player("p42", "c4", "16", "GK");
		add_player("p43", "c4", "16", "GK");
		add_player("p44", "c4", "16", "GK");

		add_player("p5", "c5", "16", "GK");
		add_player("p51", "c5", "16", "GK");
		add_player("p52", "c5", "16", "GK");
		add_player("p53", "c5", "16", "GK");
		add_player("p54", "c5", "16", "GK");

		add_team_manager("tman1", "c1");
		add_team_manager("tman2", "c2");
		add_team_manager("tman3", "c3");
		add_team_manager("tman4", "c4");
		add_team_manager("tman5", "c5");
		 
		
		add_transfer_agent("Andy","Arsenal");
		add_transfer_agent("James","Aston Villa");
		add_transfer_agent("David","Cardiff");
		add_transfer_agent("Davidson","Chelsea");
		add_transfer_agent("Harley","Crystal Palace");
		add_transfer_agent("Harlem","Everton");
		add_transfer_agent("Haris","Fulham");
		add_transfer_agent("Harrison","Hull City");
		add_transfer_agent("Henry","Liverpool");
		add_transfer_agent("Louis","Manchester City");
		add_transfer_agent("Luke","Manchester United");
		add_transfer_agent("Drake","Newcastle United");
		add_transfer_agent("Fred","Norwich City");
		add_transfer_agent("Jo", "Southampton");
		add_transfer_agent("Steve","Stoke City");
		add_transfer_agent("Bruce","Sunderland");
		add_transfer_agent("Jack","Swansea City");
		add_transfer_agent("McCarthy","Totenham Hotspur");
		add_transfer_agent("Mick","West Bromwich Albion");
		add_transfer_agent("Pallacios","West Ham United");
		/*
		add_Scout("Andy","Arsenal");
		add_Scout("James","Aston Villa");
		add_Scout("David","Cardiff");
		add_Scout("Davidson","Chelsea");
		add_Scout("Harley","Crystal Palace");
		add_Scout("Harlem","Everton");
		add_Scout("Haris","Fulham");
		add_Scout("Harrison","Hull City");
		add_Scout("Henry","Liverpool");
		add_Scout("Louis","Manchester City");
		add_Scout("Luke","Manchester United");
		add_Scout("Drake","Newcastle United");
		add_Scout("Fred","Norwich City");
		add_Scout("Jo", "Southampton");
		add_Scout("Steve","Stoke City");
		add_Scout("Bruce","Sunderland");
		add_Scout("Jack","Swansea City");
		add_Scout("McCarthy","Totenham Hotspur");
		add_Scout("Mick","West Bromwich Albion");
		add_Scout("Pallacios","West Ham United");

		add_coach("Andy","Arsenal");
		add_coach("James","Aston Villa");
		add_coach("David","Cardiff");
		add_coach("Davidson","Chelsea");
		add_coach("Harley","Crystal Palace");
		add_coach("Harlem","Everton");
		add_coach("Haris","Fulham");
		add_coach("Harrison","Hull City");
		add_coach("Henry","Liverpool");
		add_coach("Louis","Manchester City");
		add_coach("Luke","Manchester United");
		add_coach("Drake","Newcastle United");
		add_coach("Fred","Norwich City");
		add_coach("Jo", "Southampton");
		add_coach("Steve","Stoke City");
		add_coach("Bruce","Sunderland");
		add_coach("Jack","Swansea City");
		add_coach("McCarthy","Totenham Hotspur");
		add_coach("Mick","West Bromwich Albion");
		add_coach("Pallacios","West Ham United");
		*/
		System.out.println("==================TESTING UI================");
	}
	
	//all auths
	public boolean auth_footmass(String username, String password) 
	{
		account check_my_account = new account();	//check this account
		check_my_account.setAccount_name(username);
		check_my_account.setAccount_password(password);

		System.out.println("controller username "+check_my_account.getAccount_name() + "password " + check_my_account.getAccount_password());
		System.out.println("controller username "+defaultadminuser.getMy_acc().getAccount_name()+ "password "  + defaultadminuser.getMy_acc().getAccount_password());

		if (defaultadminuser.getMy_acc().getAccount_name().equals(check_my_account.getAccount_name())  &&  defaultadminuser.getMy_acc().getAccount_password().equals(check_my_account.getAccount_password()))
		{
			return true;
		}
		else
			return false;
	}
	public boolean auth_matchanalyst(String username, String password) 
	{
		account check_my_account = new account();	//check this account
		check_my_account.setAccount_name(username);
		check_my_account.setAccount_password(password);

		if (defaultmatchanalyst.getMy_acc().getAccount_name().equals(check_my_account.getAccount_name())  &&  defaultmatchanalyst.getMy_acc().getAccount_password().equals(check_my_account.getAccount_password()))
		{
			return true;
		}
		else
			return false;
	}

	public boolean auth_teamman(String username , String password)
	{
		account check_my_account = new account();	//check this account
		check_my_account.setAccount_name(username);
		check_my_account.setAccount_password(password);

		return teamman_Register.auth_teamman(check_my_account);
	}	
	public boolean auth_transferagent(String username, String password)
	{
		account check_my_account = new account();	//check this account
		check_my_account.setAccount_name(username);
		check_my_account.setAccount_password(password);

		return agent_Register.auth_transferagent(check_my_account);
	}
	public boolean auth_Scout(String username,String password)
	{
		account check_my_account = new account();	//check this account
		check_my_account.setAccount_name(username);
		check_my_account.setAccount_password(password);

		return scout_Register.auth_Scout(check_my_account);
	}
	public boolean auth_coach(String username,String password)  
	{
		account check_my_account = new account();	//check this account
		check_my_account.setAccount_name(username);
		check_my_account.setAccount_password(password);

		return coach_Register.auth_coach(check_my_account);
	}

	public Transfer_agent gettransferagent(String username,String password)  throws NullPointerException 
	{
		return agent_Register.gettransferagent(username, password);
	}
	public void add_transfer_agent(String name_transferAgent,String club_affiliation)
	{
		agent_Register.add_transfer_agent(name_transferAgent, club_affiliation);
	}
	public boolean delete_transferagent(String name_transferAgent, String club_affiliation) 
	{
		return agent_Register.delete_transferagent(name_transferAgent, club_affiliation);
	}
	public void edit_my_account_transferagent(String name_tranferAgent, String club_affiliation,String username_new, String password_new)
	{
		agent_Register.edit_my_account_transferagent(name_tranferAgent, club_affiliation, username_new, password_new);
	}	
	//Player controller methods
	public void add_player(String name_player, String club_player, String age_player, String position_player,
			float Passes_Attempted,
			float Passes_Completed,
			float Tackles_Attempted,
			float Tackles_Completed,
			float Shots_Attempted,
			float Shots_on_Target,
			float Goals,
			float Saves,
			float Yellow_Cards_Awarded,
			float Red_Cards_awarded,
			float Fouls_Committed,
			float Matches_Played
			)  throws NullPointerException
	{
		pool_obj.add_player(name_player, club_player, age_player, position_player,
				Passes_Attempted,
				Passes_Completed,
				Tackles_Attempted,
				Tackles_Completed,
				Shots_Attempted,
				Shots_on_Target,
				Goals,
				Saves,
				Yellow_Cards_Awarded,
				Red_Cards_awarded,
				Fouls_Committed,
				Matches_Played);
	}
	public boolean delete_player(String name_player,String club_player)
	{
		System.out.println("Debugging delete controller");
		return pool_obj.delete_player(name_player, club_player);
	}
	public Player getplayer(String name_player,String club_player)   throws NullPointerException
	{
		Player retobj = new Player();		//parameterized constructor
		try{
			retobj = pool_obj.getplayer(name_player, club_player);
			return retobj;

		} catch(NullPointerException ne){
			System.out.println("No Player found !");
		}
		finally
		{
			return retobj;
		}
	}
	public ArrayList<Player> get_clublist(String requiredclub)  throws NullPointerException
	{
		return pool_obj.get_clublist(requiredclub);
	}
	public Player getTeam_generatereport(String Club)
	{
		return pool_obj.getTeam_generatereport(Club);
	}
	//Team Manager controller methods
	public Team_Manager getteamManager(String username,String password)   throws NullPointerException
	{
		return teamman_Register.getteamManager(username, password);
	}
	/*
	public Team_Manager getteamManager(String name_manager,String club_affiliation)
	{
		return teamman_Register.getteamManager(name_manager, club_affiliation);
	}
	 */
	public void add_team_manager(String name_manager ,String club_affiliation) 
	{
		teamman_Register.add_team_manager(name_manager, club_affiliation);
	}
	public boolean delete_team_manager(String name_manager ,String club_affiliation) 
	{
		return teamman_Register.delete_team_manager(name_manager, club_affiliation);
	}
	public void edit_my_account_manager(String name_manager, String club_affiliation,String username_new, String password_new) throws NullPointerException
	{
		teamman_Register.edit_my_account(name_manager,club_affiliation,username_new,password_new);
	}
	//TeamManger controller methods for Generating Reports
	public Player getplayer_generatereport(String name_player,String club_player)  throws NullPointerException
	{
		return pool_obj.getplayer_generatereport(name_player,club_player);
	}
	//Team manager Controller Methods FOR TRANSFER REQUEST REGISTER
	public void add_transfer_req(Player ptbtobj , String type, String targetclub) 
	{
		trans_Register.add_transfer_req(ptbtobj, type, targetclub);
	}
	public ArrayList<Transfer_Request> get_transfer_requests_unspecified()  throws NullPointerException
	{
		return trans_Register.get_transfer_requests_unspecified();
	}
	public ArrayList<Transfer_Request> get_transfer_req(String club_manager)	throws NullPointerException
	{
		return trans_Register.get_transfer_req(club_manager);
	}
	public boolean delete_transfer_req(String name_player , String club_player)
	{
		return trans_Register.delete_transfer_req(name_player, club_player);
	}
	//Agent Controller Methods FOR TRANSFER REQUEST REGISTER
	public Transfer_Request get_transfer_req_for_a_player(String name_player) throws NullPointerException
	{
		return trans_Register.get_transfer_req_for_a_player(name_player);
	}
	public boolean transferplayer(String name_player , String club_player, String targetclub)
	{
		return pool_obj.transferplayer(name_player, club_player, targetclub);
	}
	//Scout controller methods
	public Scout getscout(String name_scout,String club_affiliation) throws NullPointerException
	{
		return scout_Register.getscout(name_scout, club_affiliation);
	}
	public void add_Scout(String name_scout,String club_affiliation)
	{
		scout_Register.add_Scout(name_scout, club_affiliation);
	}
	public boolean delete_Scout(String name_scout, String club_affiliation) 
	{
		return scout_Register.delete_Scout(name_scout, club_affiliation);
	}
	public void edit_my_account_Scout(String name_scout, String club_affiliation,String username_new, String password_new)
	{
		scout_Register.edit_my_account_Scout(name_scout, club_affiliation, username_new, password_new);
	}
	////// Scout controller method for player pool list
	public ArrayList<Player> get_scoutlist(float min_passing_accuracy_percentage,float max_passing_accuracy_percentage,float min_tackling_accuracy_percentage,float max_tackling_accuracy_percentage,float min_shooting_accuracy_percentage,float max_shooting_accuracy_percentage,float min_fouls_per_game,float max_fouls_per_game,float min_goals_per_game,float max_goals_per_game,float min_Saves_per_game,float max_Saves_per_game, float min_Passes_Completed_per_game,float max_Passes_Completed_per_game,float min_Tackles_Completed_per_game,float max_Tackles_Completed_per_game,float min_Shots_Attempted_per_game,float max_Shots_Attempted_per_game) throws NullPointerException
	{
		return pool_obj.get_scoutlist(min_passing_accuracy_percentage, max_passing_accuracy_percentage, min_tackling_accuracy_percentage, max_tackling_accuracy_percentage, min_shooting_accuracy_percentage, max_shooting_accuracy_percentage, min_fouls_per_game, max_fouls_per_game, min_goals_per_game, max_goals_per_game, min_Saves_per_game, max_Saves_per_game, min_Passes_Completed_per_game, max_Passes_Completed_per_game, min_Tackles_Completed_per_game, max_Tackles_Completed_per_game, min_Shots_Attempted_per_game, max_Shots_Attempted_per_game);		
	}
	//coach controller methods
	public Coach getcoach(String name_coach,String club_affiliation) throws NullPointerException
	{
		return coach_Register.getcoach(name_coach, club_affiliation);
	}
	public Coach getcoach_acc(String username,String password)	throws NullPointerException
	{
		return coach_Register.getcoach_acc(username, password);
	}
	public void add_coach(String name_coach,String club_affiliation)
	{
		coach_Register.add_coach(name_coach, club_affiliation);
	}
	public boolean delete_Coach(String name_coach, String club_affiliation) 
	{
		return coach_Register.delete_Coach(name_coach, club_affiliation);
	}
	public void edit_my_account_Coach(String name_coach, String club_affiliation,String username_new, String password_new)
	{
		coach_Register.edit_my_account_Coach(name_coach, club_affiliation, username_new, password_new);
	}		
	//////////////////////////////////////////////////////////
	/*
	Search_by_characteristics(Min_passing_accuracy_percentage,Max_passing_accuracy_percentage,Min_saves_accuracy_percentage,Max_saves_accuracy_percentage,      Min_shooting_accuracy_percentage,Max_shooting_accuracy_percentage,         Min_tackling_accuracy_percentage,Max_tackling_accuracy_percentage,Min_goals_per_game,Max_goals_per_game,Min_assists_per_game,Max_assists_per_game)
	 */
	///////////////

	public void save_all() {
		//Persistence_obj.save_player_pool(Player_Pool.poolList);
	}
}