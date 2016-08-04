/* Name: Matt Allen & Robbie Syed
 * PROG3060
 * 07/07/16
 * Description: The Game bean
 * */
import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity @Table(name = "GAME", schema = "GPAULLEY")
public class Game 
{
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gameID;
	private int schedule;
	private Date gameDate;
	private Time gameTime;
	@ManyToOne
	@JoinColumn(name = "arena")
	private Arena arena;
	@ManyToOne
	@JoinColumn(name = "home")
	private Team home;
	@ManyToOne
	@JoinColumn(name = "visitor")
	private Team visitor;
	@Column(nullable = true)
	private Integer homeScore;
	@Column(nullable = true)
	private Integer visitorScore;
	@Column(name = "OT")
	private String overtime;
	@Column(name = "SO")
	private String shootOut;
		
	public Game() 
	{
		//Default empty constructor
	}

	// Getters and Setters for the Game Class
	
	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	
	public int getSchedule() 
	{
		return schedule;
	}

	public void setSchedule(int schedule) 
	{
		this.schedule = schedule;
	}

	public Date getGameDate() 
	{
		return gameDate;
	}

	public void setGameDate(Date gameDate) 
	{
		this.gameDate = gameDate;
	}

	public Time getGameTime()
	{
		return gameTime;
	}

	public void setGameTime(Time gameTime) 
	{
		this.gameTime = gameTime;
	}

	public Arena getArena() 
	{
		return arena;
	}

	public void setArena(Arena arena) 
	{
		this.arena = arena;
	}

	public Team getHome() 
	{
		return home;
	}

	public void setHome(Team home) 
	{
		this.home = home;
	}

	public Team getVisitor() 
	{
		return visitor;
	}

	public void setVisitor(Team visitor) 
	{
		this.visitor = visitor;
	}

	public Integer getHomeScore() 
	{
		return homeScore;
	}

	public void setHomeScore(Integer homeScore) 
	{
		this.homeScore = homeScore;
	}

	public Integer getVisitorScore() 
	{
		return visitorScore;
	}

	public void setVisitorScore(Integer visitorScore) 
	{
		this.visitorScore = visitorScore;
	}

	public String getOvertime() 
	{
		return overtime;
	}

	public void setOvertime(String overtime) 
	{
		this.overtime = overtime;
	}

	public String getShootOut() 
	{
		return shootOut;
	}

	public void setShootOut(String shootOut) 
	{
		this.shootOut = shootOut;
	}
}
