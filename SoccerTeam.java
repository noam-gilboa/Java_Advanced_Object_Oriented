/**
 * This class implements a simple soccer team 
 *@author EECS2030 - F23
 *
 */
public class SoccerTeam {

	/**
	 * This is the default constructors. 
	 * At most 11 player can play this team. 
	 * At most there are 4 roles players can have.
	 * Noam Gilboa
	 */
	private Player[] player;
	private Coach coach;
	
	private SoccerTeam() {
		this.player = new Player[11];
		this.coach = Coach.getInstance();
	}
	
	/**
	 * This is the overloaded constructor for this class
	 * @param player is an array containing all the players who entered the team.
	 * @param coach is the coach that trains the team's players.
	 */
	
	private SoccerTeam (Player [] player, Coach coach) {
		this.player = new Player[player.length];
		for (int i =0;i< player.length; i++  ) {
			player[i] = Player.getInstance(player[i]);
		}
		this.coach =Coach.getInstance(coach);

		
	}
	
	/**
	 * This is the copy constructor for this class
	 * @param team is an object of SoccerTeam, whose component is deeply copied into 
	 * the component of this object.
	 */
	private SoccerTeam (SoccerTeam team) {
		new SoccerTeam(team.player, team.coach);
	
	}
	
	/**
	 * This is a static factory method
	 * @return IT returns an object of SoccerTeam
	 */
	public static SoccerTeam getInstance() {
		return new SoccerTeam();
		
	}
	/**
	 * This is a static factory method
	 * @param player is an array that contains players.
	 * @param coach is a coach of the team
	 * @return It returns an object of SoccerTeam made using the input parameters.
	 */
	public static SoccerTeam getInstance(Player [] player, Coach coach) {
		return new SoccerTeam(player,coach);
		
	}
	
	/**
	 * This is a static factory method
	 * @param team is an object of SoccerTeam
	 * @return it returns an object of SoccerTeam made using the input parameter. 
	 */
	public static SoccerTeam getInstance(SoccerTeam team) {
		return new SoccerTeam(team.player, team.coach);
		
	}

	/**
	 * This is the getter method for the player list.
	 * @return returns an array containing all the players of this team. 
	 */
	public Player[] getPlayers() {
		return this.player;
		
	}
	
	/**
	 * This is the getter method for the coach attribute.
	 * @return Returns an object of coach containing all the components of this team's coach.
	 */

	public Coach getCoach() {
		return this.coach;
		
	}
	
	/**
	 * This is the setter method for the player attribute, which deeply copies 
	 * the input parameter into the player attribute of this object. 
	 * @param player is an array of Player, whose elements are copied in the player attribute of this object.
	 */
	
	public void setPlayers(Player [] player) {
		this.player = new Player[player.length];
		for (int i =0;i< player.length; i++  ) {
			this.player[i] = Player.getInstance(player[i]);
			String new_name = new String(player[i].getName());
			this.player[i].setName(new_name);
		}
		
	}
	
	/**
	 * This is the setter method for the coach attribute, which deeply copies 
	 * the input parameter into the coach attribute of this object.
	 * @param coach is an object of Coach, whose attributes are copied in the coach attribute of this object.
	 */
	public void setCoach(Coach coach) {
		this.coach = Coach.getInstance(coach);
		
	}

}

/**
 * 
 * This class implements all a player requires to play in this team. 
 * A player has a number, a name, and a role. A role can be either defense, central, striker, or goal keeper. 
 * these roles can be represented by the characters 'd', 'c', 's', or 'g'
 *
 */
class Player {

	
	/**
	 * This is the overloaded constructor for this class
	 * @param num
	 * @param name
	 * @param role
	 */
	private int num;
	private String name;
	private char role;
	
	private Player(int num, String name, char role) {
		this.num = num;
		this.name = name;
		this.role = role;

	}

	
	/**
	 * This is the copy constructor for this class
	 * @param player
	 */
	private Player(Player player) {
		this.name = new String(player.name);
		this.num = player.num;
		this.role = player.role;
		
	}
	
	/**
	 * This is a static factory method.
	 * @return It returns an object of Player
	 */
	public static Player getInstance() {
		return new Player(0, "",'\0');
		
	}
	
	/**
	 * This is a static factory method
	 * @param num is the player number
	 * @param name is the name of player
	 * @param role is the role of the player in the team
	 * @return It returns an object of player, which is made by the two input variables. 
	 */
	public static Player getInstance(int num, String name, char role) {
		return new Player(num,name,role);
		
	}
	
	/**
	 * This is a static factory method
	 * @param player is an object of player
	 * @return it returns an object of player that is made using the input parameter. 
	 */
	public static Player getInstance(Player player) {
		return new Player(player);
		
	}

	/**
	 * This is the getter method for attribute name
	 * @return returns the value of attribute name
	 */
	public String getName() {
		return this.name;
		
	}
	
	/**
	 * This is the getter method for attribute role
	 * @return returns the reference to attribute role.
	 */
	public char getRole() {
		return this.role;
		
	}
	
	/**
	 * This is the setter method for attribute name
	 * @param name is the value that is used to initialize name attribute
	 */
	public void setName(String name) {
		this.name = name;
		
	}
	
	/**
	 * This is the setter method for attribute role
	 * @param role is the object, whose reference is used to initialize attribute role.
	 */
	public void setRole(char role) {
		 this.role = role;
	}
	
}

/**
 * This class represent the coach that trains the team's players.
 * A coach has a name, a number of years of experience, and a level of expertise. 
 * The level of expertise can be represented by one of the strings: "high", "average", or "beginner".
 */
class Coach{
	
	/**
	 * This is the overloaded constructor.
	 * @param name is the name of the coach.
	 * @param yearsExp is the number of years of experience of the coach.
	 * @param level is the level of experience of the coach.
	 */
	private String name;
	private int yearsExp;
	private String level;
	
	private Coach(String name, int yearsExp, String level) {
		this.name = new String(name);
		this.yearsExp = yearsExp;
		this.level = new String(level);

	}
	
	/**
	 * This is a static factory method that initializes the attributes to their default values. 
	 * @return It returns an Coach object.
	 */
	public static Coach getInstance() {
		return new Coach("",0,"");
	
	}
	
	/**
	 * This is a static factory method
	 * @param name is the name of the coach.
	 * @param yearsExp is the number of years of experience of the coach.
	 * @param level is the level of experience of the coach.
	 * @return it returns a Coach object.
	 */
	public static Coach getInstance(String name, int yearsExp, String level) {
		return new Coach(name, yearsExp, level);
	
	}
	
	/**
	 * This is the copy constructor.
	 * @param coach is an object of Coach that is used to initialize this object.
	 */
	private Coach(Coach coach) {
		new Coach(coach.name, coach.yearsExp, coach.level);
		
		
	}
	
	public static Coach getInstance(Coach coach) {
		return new Coach(coach.name, coach.yearsExp, coach.level);
		
	}
	public String getName() {
		return this.name;

	}
	public int getYearsExp() {
		return this.yearsExp;

	}
	public String getLevel() {
		return this.level;
	}
}

	

