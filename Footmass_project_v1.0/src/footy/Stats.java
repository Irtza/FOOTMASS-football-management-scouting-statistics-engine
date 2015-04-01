package footy;

public class Stats {
	
	float Passes_Attempted;
	float Passes_Completed; 
	float Tackles_Attempted;
	float Tackles_Completed;
	float Shots_Attempted;
	float Shots_on_Target;
	float Goals;
	float Saves;
	float Yellow_Cards_Awarded;
	float Red_Cards_awarded;
	float Fouls_Committed;
	float Matches_Played;
	//////////////non input stats///////////////////////////////////
	float passing_accuracy_percentage;
	float tackling_accuracy_percentage;
	float shooting_accuracy_percentage;
	
	float fouls_per_game;		//
	float goals_per_game;		//divide by matches
	
	float Saves_per_game;
	float Passes_Completed_per_game;
	float Tackles_Completed_per_game;
	float Shots_Attempted_per_game;
	
	///////////////////////////////////////////////
	public Stats()
	{
		Matches_Played = 0;
		Passes_Attempted = 0;
		Passes_Completed = 0;
		Tackles_Attempted =  0;
		Tackles_Completed =  0;
		Shots_Attempted =  0;
		Shots_on_Target =  0;
		Goals =  0;
		Saves =  0;
		Yellow_Cards_Awarded =  0;
		Red_Cards_awarded =  0;
		Fouls_Committed =  0;
		
		passing_accuracy_percentage = 0;
		tackling_accuracy_percentage = 0;
		shooting_accuracy_percentage = 0;
		
		fouls_per_game = 0 ;
		goals_per_game= 0 ;
		
		Saves_per_game = 0 ;
		Passes_Completed_per_game = 0 ;
		Tackles_Completed_per_game = 0;
		Shots_Attempted_per_game= 0;
	}
	public Stats(float passes_Attempted, float passes_Completed,
			float tackles_Attempted, float tackles_Completed, float shots_Attempted,
			float shots_on_Target, float goals, float saves,
			float yellow_Cards_Awarded, float red_Cards_awarded, float fouls_Committed, float matches_Played) {
		Matches_Played = matches_Played;
		Passes_Attempted = passes_Attempted;
		Passes_Completed = passes_Completed;
		Tackles_Attempted = tackles_Attempted;
		Tackles_Completed = tackles_Completed;
		Shots_Attempted = shots_Attempted;
		Shots_on_Target = shots_on_Target;
		Goals = goals;
		Saves = saves;
		Yellow_Cards_Awarded = yellow_Cards_Awarded;
		Red_Cards_awarded = red_Cards_awarded;
		Fouls_Committed = fouls_Committed;
		
		passing_accuracy_percentage = (passes_Completed / passes_Attempted) *100;
		tackling_accuracy_percentage = (tackles_Completed / tackles_Attempted) *100;
		shooting_accuracy_percentage = (shots_on_Target / shots_Attempted) *100;
		
		fouls_per_game = (fouls_Committed/matches_Played );
		goals_per_game= (goals / matches_Played);
		
		Saves_per_game = (saves / matches_Played) ;
		Passes_Completed_per_game = (passes_Completed / matches_Played);
		Tackles_Completed_per_game = (tackles_Completed / matches_Played);
		Shots_Attempted_per_game= (shots_Attempted / matches_Played);
		
		/*
		getPasses_Completed() / Passes_Attempted() ) *100 );
		this.setTackling_accuracy_percentage( (searchobj.getMy_stats().getTackles_Completed() / searchobj.getMy_stats().getTackles_Attempted() ) *100 );
		this.setShooting_accuracy_percentage(  (searchobj.getMy_stats().getShots_on_Target() / searchobj.getMy_stats().getShots_Attempted() )*100 );				
		
		this.setFouls_per_game(this / searchobj.getMy_stats().getMatches_Played() );	
		this.setGoals_per_game(searchobj.getMy_stats().getGoals() / searchobj.getMy_stats().getMatches_Played() );

		this.setSaves_per_game( searchobj.getMy_stats().getSaves() / searchobj.getMy_stats().getMatches_Played() );
		this.setPasses_Completed_per_game( searchobj.getMy_stats().getPasses_Completed() / searchobj.getMy_stats().getMatches_Played() );
		this.setTackles_Completed_per_game( searchobj.getMy_stats().getTackles_Completed() / searchobj.getMy_stats().getMatches_Played() );
		this.setShots_Attempted_per_game( searchobj.getMy_stats().getShots_Attempted() / searchobj.getMy_stats().getMatches_Played() );
		*/
	}
	
	////////////Access Functions//////////////////////

	public float getPasses_Attempted()
	{
		return Passes_Attempted;
	}
	public float getMatches_Played() {
		return Matches_Played;
	}
	public void setMatches_Played(int matches_Played) {
		Matches_Played += matches_Played;
	}
	public void setPasses_Attempted(int passes_Attempted) {
		Passes_Attempted += passes_Attempted;
	}
	public float getPasses_Completed() {
		return Passes_Completed;
	}
	public void setPasses_Completed(int passes_Completed) {
		Passes_Completed += passes_Completed;
	}
	public float getTackles_Attempted() {
		return Tackles_Attempted;
	}
	public void setTackles_Attempted(int tackles_Attempted) {
		Tackles_Attempted += tackles_Attempted;
	}
	public float getTackles_Completed() {
		return Tackles_Completed;
	}
	public void setTackles_Completed(int tackles_Completed) {
		Tackles_Completed += tackles_Completed;
	}
	public float getShots_Attempted() {
		return Shots_Attempted;
	}
	public void setShots_Attempted(int shots_Attempted) {
		Shots_Attempted += shots_Attempted;
	}
	public float getShots_on_Target() {
		return Shots_on_Target;
	}
	public void setShots_on_Target(int shots_on_Target) {
		Shots_on_Target += shots_on_Target;
	}
	public float getGoals() {
		return Goals;
	}
	public void setGoals(int goals) {
		Goals += goals;
	}
	public float getSaves() {
		return Saves;
	}
	public void setSaves(int saves) {
		Saves += saves;
	}
	public float getYellow_Cards_Awarded() {
		return Yellow_Cards_Awarded;
	}
	public void setYellow_Cards_Awarded(int yellow_Cards_Awarded) {
		Yellow_Cards_Awarded += yellow_Cards_Awarded;
	}
	public float getRed_Cards_awarded() {
		return Red_Cards_awarded;
	}
	public void setRed_Cards_awarded(int red_Cards_awarded) {
		Red_Cards_awarded += red_Cards_awarded;
	}
	public float getFouls_Committed() {
		return Fouls_Committed;
	}
	public void setFouls_Committed(int fouls_Committed) {
		Fouls_Committed += fouls_Committed;
	}

	public float getPassing_accuracy_percentage() {
		return passing_accuracy_percentage;
	}

	public void setPassing_accuracy_percentage(float passing_accuracy_percentage) {
		this.passing_accuracy_percentage = passing_accuracy_percentage;
	}

	public float getTackling_accuracy_percentage() {
		return tackling_accuracy_percentage;
	}

	public void setTackling_accuracy_percentage(float tackling_accuracy_percentage) {
		this.tackling_accuracy_percentage = tackling_accuracy_percentage;
	}

	public float getShooting_accuracy_percentage() {
		return shooting_accuracy_percentage;
	}

	public void setShooting_accuracy_percentage(float shooting_accuracy_percentage) {
		this.shooting_accuracy_percentage = shooting_accuracy_percentage;
	}

	public float getFouls_per_game() {
		return fouls_per_game;
	}

	public void setFouls_per_game(float fouls_per_game) {
		this.fouls_per_game = fouls_per_game;
	}

	public float getGoals_per_game() {
		return goals_per_game;
	}

	public void setGoals_per_game(float goals_per_game) {
		this.goals_per_game = goals_per_game;
	}

	public float getSaves_per_game() {
		return Saves_per_game;
	}

	public void setSaves_per_game(float saves_per_game) {
		Saves_per_game = saves_per_game;
	}

	public float getPasses_Completed_per_game() {
		return Passes_Completed_per_game;
	}

	public void setPasses_Completed_per_game(float passes_Completed_per_game) {
		Passes_Completed_per_game = passes_Completed_per_game;
	}

	public float getTackles_Completed_per_game() {
		return Tackles_Completed_per_game;
	}

	public void setTackles_Completed_per_game(float tackles_Completed_per_game) {
		Tackles_Completed_per_game = tackles_Completed_per_game;
	}

	public float getShots_Attempted_per_game() {
		return Shots_Attempted_per_game;
	}
	
	public void setShots_Attempted_per_game(float shots_Attempted_per_game) {
		Shots_Attempted_per_game = shots_Attempted_per_game;
	}
	
}