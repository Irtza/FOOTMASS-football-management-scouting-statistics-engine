package footy;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import factory_classes.playerFactory;

/*
 * Player Factory is follows a Singelton implementation and thus is obtained in this way
 * Player Factory creates the Player objects 
 * The Player Pool Arraylist<player> stores the factory's products
 *
 */
public class Player_Pool 
{
	private static Player_Pool poolobj = null;	//Private Static reference,encapsulation ensures only once instance is created
	
	static ArrayList<Player> poolList = new ArrayList<Player>(); //ONE TIME
	
	private Player_Pool()
	{
		
	}	
	public static Player_Pool getinstance()
	{
		if (poolobj == null)
		{
			poolobj = new Player_Pool(); 
		}
		return poolobj;	
	}
	public void add_player(String name_player,String club_player,String age_player,String position_player,
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
			float Matches_Played)
	{
		playerFactory.getinstance(); //Static way to call a static method on a static object, no need for a declared reference
		Player obj= (Player) playerFactory.makePlayer(name_player, club_player, age_player, position_player,
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

		poolList.add(obj);						//add to player pool
		System.out.println("Player :" + name_player + "Club :" + club_player + " Age :" + age_player+ " pos :" + position_player +" has been added successfully");		
	}
	public boolean delete_player(String name_player , String club_player)
	{	
		System.out.println("namearg" +name_player+"Clubarg" +club_player);
		System.out.println("namexxx" +poolList.get(8).getName_player()+"Clubxxx" +poolList.get(8).getClub_player());
		
		boolean check = true;	
		
		Iterator<Player> it = poolList.iterator(); 
		while (it.hasNext())
		{
			Player delobj = it.next();
			if (delobj.getName_player().equals(name_player) && delobj.getClub_player().equals(club_player))
			{
				it.remove();
				JOptionPane.showMessageDialog(null,"Player : " + name_player + " was Deleted!","Success!",JOptionPane.INFORMATION_MESSAGE);
				check = true;
				return true;
			}
			else
				check = false; 
		}
		if (check == false)
			JOptionPane.showMessageDialog(null,"Player : " + name_player + " was not found","Not found",JOptionPane.ERROR_MESSAGE);
		return false;
	}
	public Player getplayer(String name_player,String club_player)
	{
		boolean check = true;
		Iterator<Player> it = poolList.iterator();
		while(it.hasNext())
		{
			Player searchobj = it.next();		
			if (searchobj.getName_player().equals(name_player) && searchobj.getClub_player().equals(club_player))
			{
				check = true;
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Player not found");
			return null;
		}

		return null;
	}

	public Player getplayer_generatereport(String name_player,String club_player)
	{
		boolean check = true;
		Iterator<Player> it = poolList.iterator();
		while(it.hasNext())
		{
			Player searchobj = it.next();		
			if (searchobj.getName_player().equals(name_player) && searchobj.getClub_player().equals(club_player))
			{
				searchobj.getMy_stats().setPassing_accuracy_percentage( (searchobj.getMy_stats().getPasses_Completed() / searchobj.getMy_stats().getPasses_Attempted() ) *100 );
				searchobj.getMy_stats().setTackling_accuracy_percentage( (searchobj.getMy_stats().getTackles_Completed() / searchobj.getMy_stats().getTackles_Attempted() ) *100 );
				searchobj.getMy_stats().setShooting_accuracy_percentage(  (searchobj.getMy_stats().getShots_on_Target() / searchobj.getMy_stats().getShots_Attempted() )*100 );				

				searchobj.getMy_stats().setFouls_per_game(searchobj.getMy_stats().getFouls_Committed() / searchobj.getMy_stats().getMatches_Played() );	
				searchobj.getMy_stats().setGoals_per_game(searchobj.getMy_stats().getGoals() / searchobj.getMy_stats().getMatches_Played() );

				searchobj.getMy_stats().setSaves_per_game( searchobj.getMy_stats().getSaves() / searchobj.getMy_stats().getMatches_Played() );
				searchobj.getMy_stats().setPasses_Completed_per_game( searchobj.getMy_stats().getPasses_Completed() / searchobj.getMy_stats().getMatches_Played() );
				searchobj.getMy_stats().setTackles_Completed_per_game( searchobj.getMy_stats().getTackles_Completed() / searchobj.getMy_stats().getMatches_Played() );
				searchobj.getMy_stats().setShots_Attempted_per_game( searchobj.getMy_stats().getShots_Attempted() / searchobj.getMy_stats().getMatches_Played() );

				check = true;
				return searchobj;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Player not found exception thrown GET_REPORT");
			return null;
		}

		System.out.println("Player not found exception thrown GET_REPORT");
		return null;
	}
	public Player getTeam_generatereport(String Club)
	{
		boolean check = true;
		ArrayList<Player> tempList=get_clublist(Club);
		Iterator<Player> it = tempList.iterator();
		Player commulativeplayer=new Player();
		float tempPasses_Attempted=0;
		float tempPasses_Completed=0; 
		float tempTackles_Attempted=0;
		float tempTackles_Completed=0;
		float tempShots_Attempted=0;
		float tempShots_on_Target=0;
		float tempGoals=0;
		float tempSaves=0;
		float tempYellow_Cards_Awarded=0;
		float tempRed_Cards_awarded=0;
		float tempFouls_Committed=0;
		float tempMatches_Played=0;
		int counter=0;
		while(it.hasNext())
		{
			Player searchobj = it.next();
			tempPasses_Attempted+=searchobj.getMy_stats().getPasses_Attempted();
			tempPasses_Completed+=searchobj.getMy_stats().getPasses_Completed(); 
			tempTackles_Attempted+=searchobj.getMy_stats().getTackles_Attempted();
			tempTackles_Completed+=searchobj.getMy_stats().getTackles_Completed();
			tempShots_Attempted+=searchobj.getMy_stats().getShots_Attempted();
			tempShots_on_Target+=searchobj.getMy_stats().getShots_on_Target();
			tempGoals+=searchobj.getMy_stats().getGoals();
			tempSaves+=searchobj.getMy_stats().getSaves();
			tempYellow_Cards_Awarded+=searchobj.getMy_stats().getYellow_Cards_Awarded();
			tempRed_Cards_awarded+=searchobj.getMy_stats().getRed_Cards_awarded();
			tempFouls_Committed+=searchobj.getMy_stats().getFouls_Committed();
			tempMatches_Played+=searchobj.getMy_stats().getMatches_Played();
			counter=counter+1;
			check = true;
		}
		commulativeplayer.getMy_stats().setPassing_accuracy_percentage( (tempPasses_Completed / tempPasses_Attempted) *100 );
		commulativeplayer.getMy_stats().setTackling_accuracy_percentage( (tempTackles_Completed / tempTackles_Attempted ) *100 );
		commulativeplayer.getMy_stats().setShooting_accuracy_percentage( (tempShots_on_Target / tempShots_Attempted)*100 );				

		commulativeplayer.getMy_stats().setFouls_per_game(tempFouls_Committed / tempMatches_Played);	
		commulativeplayer.getMy_stats().setGoals_per_game(tempGoals / tempMatches_Played);

		commulativeplayer.getMy_stats().setSaves_per_game( tempSaves / tempMatches_Played);
		commulativeplayer.getMy_stats().setPasses_Completed_per_game( tempPasses_Completed/tempMatches_Played);
		commulativeplayer.getMy_stats().setTackles_Completed_per_game( tempTackles_Completed/tempMatches_Played);
		commulativeplayer.getMy_stats().setShots_Attempted_per_game(tempShots_Attempted/tempMatches_Played);

		
		return commulativeplayer;
		
	}
	public boolean transferplayer(String name_player , String club_player, String targetclub)
	{
		boolean check = false;
		Iterator<Player> it = poolList.iterator();
		while(it.hasNext())
		{
			Player searchobj = it.next();		
			if (searchobj.getName_player().equals(name_player) && searchobj.getClub_player().equals(club_player))
			{
				check = true;
				searchobj.setClub_player(targetclub);
				System.out.println("Player Found");
				return check;
			}
			else
				check = false;
		}
		if (check == false)
		{
			System.out.println("Player not found");
			return check;
		}

		return check;
	}

	public ArrayList<Player> get_clublist(String requiredclub)
	{
		ArrayList<Player> clublist= new ArrayList<Player>();

		boolean check = false;
		Iterator<Player> it = poolList.iterator();

		while(it.hasNext())
		{
			Player searchobj = it.next();		
			if (searchobj.getClub_player().equals(requiredclub))
			{
				clublist.add(searchobj);
				check = true;
			}
		}
		if (check == false)
		{
			System.out.println(requiredclub + " Club not found");
			return null;			//handle exception
		}
		return clublist;
	}

	public ArrayList<Player> get_scoutlist(
			float min_passing_accuracy_percentage,float max_passing_accuracy_percentage,
			float min_tackling_accuracy_percentage,float max_tackling_accuracy_percentage,
			float min_shooting_accuracy_percentage,float max_shooting_accuracy_percentage,
			float min_fouls_per_game,float max_fouls_per_game,
			float min_goals_per_game,float max_goals_per_game,
			float min_Saves_per_game,float max_Saves_per_game, 
			float min_Passes_Completed_per_game,float max_Passes_Completed_per_game,
			float min_Tackles_Completed_per_game,float max_Tackles_Completed_per_game,
			float min_Shots_Attempted_per_game,float max_Shots_Attempted_per_game
			)
			{
		ArrayList<Player> scoutlist= new ArrayList<Player>();

		boolean check = false;
		Iterator<Player> it = poolList.iterator();

		while(it.hasNext())
		{
			System.out.println("Scoutinggg............");
			Player searchobj = it.next();		
			if ( (searchobj.getMy_stats().getPassing_accuracy_percentage() >= min_passing_accuracy_percentage && searchobj.getMy_stats().getPassing_accuracy_percentage() < max_passing_accuracy_percentage )
					|| (searchobj.getMy_stats().getTackling_accuracy_percentage() >= min_tackling_accuracy_percentage && searchobj.getMy_stats().getTackling_accuracy_percentage() < max_tackling_accuracy_percentage )
					|| (searchobj.getMy_stats().getShooting_accuracy_percentage() >= min_shooting_accuracy_percentage && searchobj.getMy_stats().getShooting_accuracy_percentage() < max_shooting_accuracy_percentage )
					|| (searchobj.getMy_stats().getFouls_per_game() >= min_fouls_per_game && searchobj.getMy_stats().getFouls_per_game() < max_fouls_per_game )
					|| (searchobj.getMy_stats().getGoals_per_game() >= min_goals_per_game && searchobj.getMy_stats().getGoals_per_game() < max_goals_per_game )
					|| (searchobj.getMy_stats().getSaves_per_game() >= min_Saves_per_game && searchobj.getMy_stats().getSaves_per_game() < max_Saves_per_game )
					|| (searchobj.getMy_stats().getPasses_Completed_per_game() >= min_Passes_Completed_per_game && searchobj.getMy_stats().getPasses_Completed_per_game() < max_Passes_Completed_per_game )
					|| (searchobj.getMy_stats().getTackles_Completed_per_game() >= min_Tackles_Completed_per_game && searchobj.getMy_stats().getTackles_Completed_per_game() < max_Tackles_Completed_per_game )
					|| (searchobj.getMy_stats().getShots_Attempted_per_game() >= min_Shots_Attempted_per_game && searchobj.getMy_stats().getShots_Attempted_per_game() < max_Shots_Attempted_per_game)
					)
			{
				scoutlist.add(searchobj);
				System.out.println("Scout has found a MATCH");
				check = true;
			}

		}
		if (check == false)
		{
			System.out.println("no matches found change search Heuristics");
			System.out.println("Throws Null exception!");
			return null;			//handle exception
		}
		return scoutlist;
			}
}
//Option Panes can have club as a display too. 