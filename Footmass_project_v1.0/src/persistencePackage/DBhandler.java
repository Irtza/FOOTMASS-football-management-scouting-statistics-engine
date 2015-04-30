package persistencePackage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import actors.Coach;
import actors.Scout;
import actors.Team_Manager;
import actors.Transfer_agent;
import footy.Coach_Register;
import footy.Player;
import footy.Player_Pool;
import footy.Scout_Register;
import footy.Team_Manager_Register;
import footy.Transfer_Agent_Register;

public class DBhandler extends Persistence_Adapter {
	
 	public void load_player_pool(ArrayList<Player> poollist)
	{
		System.out.println("Loading ..., player pool from database");
		
		//Placeholder for result set
		
		String n_db = "";
		String c_db = "";
		String a_db = "";
		String p_db = "";
		float pa_db = 0;
		float pc_db = 0;
		float ta_db = 0;
		float tc_db = 0;
		float sa_db = 0;
		float sot_db = 0;
		float g_db = 0;
		float s_db = 0;
		float yc_db = 0;
		float rc_db = 0;
		float fc_db = 0;
		float mp_db = 0;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		//C:\Users\Irtaza Ali\workspace\Footmass_project_v1.0\data\Database
		//C:\Users\Irtaza Ali\workspace\Footmass_project_v1.0\data\Database
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:ucanaccess://..\\Footmass_project_v1.0\\data\\Database\\footmass_db.accdb");
			Statement statement = con.createStatement();
			
			String sql = "SELECT * FROM Player_Pool";
			ResultSet rs = statement.executeQuery(sql);
			//rs.absolute(1);
			System.out.println("results"); 
			
			while(rs.next())
			{
				n_db = rs.getString("name_player");
				c_db = rs.getString("club");
				a_db = rs.getString("age");
				p_db = rs.getString("position");
				
				pa_db = rs.getFloat("Passes_Attempted");
				pc_db = rs.getFloat("Passes_Completed");
				ta_db = rs.getFloat("Tackles_Attempted");
				tc_db = rs.getFloat("Tackles_Completed");
				sa_db = rs.getFloat("Shots_Attempted");
				sot_db = rs.getFloat("Shots_on_Target");
				g_db = rs.getFloat("Goals");
				s_db = rs.getFloat("Saves");
				yc_db = rs.getFloat("Yellow_Cards");
				rc_db = rs.getFloat("Red_Cards");
				fc_db = rs.getFloat("Fouls_Commited");
				mp_db = rs.getFloat("Matches_Played");
				
				Player_Pool.getinstance().add_player(n_db, c_db, a_db, p_db, pa_db, pc_db, ta_db, tc_db, sa_db, sot_db,g_db, s_db, yc_db,rc_db, fc_db,mp_db);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public void save_player_pool(ArrayList<Player> poolList) 
	{	
		System.out.println("Saving player pool in database!");

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		//C:\Users\Irtaza Ali\workspace\Footmass_project_v1.0\data\Database
		
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:ucanaccess://..\\Footmass_project_v1.0\\data\\Database\\footmass_db.accdb");
			Statement statement = con.createStatement();
			
			String sql = "TRUNCATE TABLE Player_Pool";
			statement.execute(sql);
			
			Iterator<Player> it = poolList.iterator();
		
			while(it.hasNext())
			{
				Player searchobj = it.next();
				String sql3 = "INSERT INTO Player_Pool(name_player,club,age,position,Passes_Attempted,Passes_Completed,Tackles_Attempted,Tackles_Completed,Shots_attempted,Shots_on_Target,Goals,Saves,Yellow_Cards,Red_Cards,Fouls_Commited, Matches_Played) values ('"+searchobj.getName_player()+"','"+searchobj.getClub_player()+"','"+searchobj.getAge_player()+"','"+searchobj.getPosition_player()+"' ,'"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"','"+0+"')";
				statement.execute(sql3);
			}
			
			}
		catch (SQLException e) {

			e.printStackTrace();
			System.out.println("sql exception aa gayi");
		}
	}
	
	public void load_scout_pool(ArrayList<Scout> Scoutreg) 
	{
		System.out.println("Loading .... Scouts from database");
		
		//Placeholders for result set
		String n_db = "";
		String c_db = "";
		String usr_db = "";
		String pass_db = "";
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		//C:\Users\Irtaza Ali\workspace\Footmass_project_v1.0\data\Database
		
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:ucanaccess://..\\Footmass_project_v1.0\\data\\Database\\footmass_db.accdb");
			Statement statement = con.createStatement();
			
			String sql = "SELECT * FROM Scout_Pool";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				n_db = rs.getString("name_scout");
				c_db = rs.getString("club_scout");
				usr_db = rs.getString("username");
				pass_db = rs.getString("password");
				Scout_Register.getinstance().add_Scout(n_db,c_db);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	
	public void save_scout_pool(ArrayList<Scout> Scoutreg)  
	{
	}
	public void load_transferagent_pool(ArrayList<Transfer_agent> agentreg) 
	{
		System.out.println("Loading .... Transfer agents from database");
		
		//Placeholders for result set
		String n_db = "";
		String c_db = "";
		String usr_db = "";
		String pass_db = "";
		
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		//C:\Users\Irtaza Ali\workspace\Footmass_project_v1.0\data\Database
		
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:ucanaccess://..\\Footmass_project_v1.0\\data\\Database\\footmass_db.accdb");
			Statement statement = con.createStatement();
			
			String sql = "SELECT * FROM Agent_Pool";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				n_db = rs.getString("name_agent");
				c_db = rs.getString("club_agent");
				usr_db = rs.getString("username");
				pass_db = rs.getString("password");
				
				try {
					Transfer_Agent_Register.getinstance().add_transfer_agent(n_db,c_db);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void save_transferagent_pool(ArrayList<Transfer_agent> agentreg) 
	{
	}
	public void load_teammanager_pool(ArrayList<Team_Manager> teammanregList) 
	{	
		System.out.println("Loading .... Team Mangers from database");
		
		//Placeholder for result set
		String n_db = "";
		String c_db = "";
		String usr_db = "";
		String pass_db = "";
		
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		//C:\Users\Irtaza Ali\workspace\Footmass_project_v1.0\data\Database
		
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:ucanaccess://..\\Footmass_project_v1.0\\data\\Database\\footmass_db.accdb");
			Statement statement = con.createStatement();
			
			String sql = "SELECT * FROM Manager_Pool";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				n_db = rs.getString("name_manager");
				c_db = rs.getString("club_manager");
				usr_db = rs.getString("username");
				pass_db = rs.getString("password");
				
				try {
					Team_Manager_Register.getInstance().add_team_manager(n_db,c_db);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void load_coach_pool(ArrayList<Coach> Coachreg) 
	{	
		System.out.println("Loading .... Coaches from database");
		//Placeholders for result set
		String n_db = "";
		String c_db = "";
		String usr_db = "";
		String pass_db = "";
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		//C:\Users\Irtaza Ali\workspace\Footmass_project_v1.0\data\Database
		
		try {
			java.sql.Connection con = DriverManager.getConnection("jdbc:ucanaccess://..\\Footmass_project_v1.0\\data\\Database\\footmass_db.accdb");
			Statement statement = con.createStatement();
			
			String sql = "SELECT * FROM Coach_Pool";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next())
			{
				n_db = rs.getString("name_coach");
				c_db = rs.getString("club_coach");
				usr_db = rs.getString("username");
				pass_db = rs.getString("password");
				
				try {
					Coach_Register.getinstance().add_coach(n_db,c_db);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save_coach_pool(ArrayList<Coach> Coachreg) 
	{
	}
}
