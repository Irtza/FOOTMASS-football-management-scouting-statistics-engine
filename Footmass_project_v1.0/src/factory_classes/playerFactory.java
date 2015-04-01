package factory_classes;

import footy.Player;
import footy.Stats;

public class playerFactory {
	private static playerFactory pobj=null;
	private playerFactory()
	{

	}
	public static playerFactory getinstance()
	{
		if(pobj==null)
		{
			pobj=new playerFactory();
		}
		return pobj;
	}

	public static Player makePlayer(String name_player,String club_affiliation,String age_player,String position_player,
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
			float Matches_Played){
		
		
		Player pobj = new Player(name_player,club_affiliation,age_player,position_player);
		Stats pstats = new Stats(Passes_Attempted,Passes_Completed,	Tackles_Attempted,Tackles_Completed,Shots_Attempted,Shots_on_Target,Goals,Saves,Yellow_Cards_Awarded,Red_Cards_awarded,	Fouls_Committed,Matches_Played);
		pobj.setMy_stats(pstats);
		return pobj;
	}

}
