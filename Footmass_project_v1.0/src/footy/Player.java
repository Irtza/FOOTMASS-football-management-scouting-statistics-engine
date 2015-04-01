package footy;


public class Player {
	String name_player;
	String club_player;
	String age_player;
	String position_player;
	
	Stats my_stats;
	
	public Stats getMy_stats() {
		return my_stats;
	}

	public void setMy_stats(Stats my_stats) {
		this.my_stats = my_stats;
	}

	public Player()
	{
		this.name_player = null;
		this.club_player = null ;
		this.age_player = null;
		this.position_player = null ;
		this.my_stats = new Stats();
	}
	
	public Player(String name_param,String club_param,String age_param,String position_param) 
	{
		this.name_player = name_param;
		this.club_player = club_param;
		this.age_player = age_param;
		this.position_player = position_param ;
		this.my_stats = new Stats();
	}
	
	public String getName_player() {
		return name_player;
	}

	public void setName_player(String name_player) {
		this.name_player = name_player;
	}

	public void setClub_player(String club_player) {
		this.club_player = club_player;
	}

	public void setAge_player(String age_player) {
		this.age_player = age_player;
	}

	public void setPosition_player(String position_player) {
		this.position_player = position_player;
	}

	public String getClub_player() {
		return club_player;
	}

	public String getAge_player() {
		return age_player;
	}

	public String getPosition_player() {
		return position_player;
	}
	
	
}