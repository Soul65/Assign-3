/* Name: Matt Allen & Robbie Syed
 * PROG3060
 * 07/20/16
 * Description: The Roster bean
 * */

import javax.persistence.*;

@Entity @Table(name = "ROSTER", schema = "GPAULLEY")
public class Roster 
{
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    rosterID;
    private String position;
    @ManyToOne
    @JoinColumn(name="team")
    private Team   team;
    @ManyToOne
    @JoinColumn(name="player")
    private Player player;
    private int    jersey;
    
    public Roster() 
	{
	}    
    
    public int getRosterID() 
	{
	    return rosterID;
	}
    
    public void setRosterID( int rosterID )
	{
	    this.rosterID = rosterID;
	}
    
    public String getPosition()
	{
	    return position;
	}
    
    public void setPosition( String newPosition )
	{
	    this.position = newPosition;
	}
    
    public int getJersey()
	{
	    return jersey;
	}
    
    public void setJersey( int newJersey )
	{
	    this.jersey = newJersey;
	}
        
    public Team getTeam()
	{
	    return team;
	}
    
    public void setTeam( Team newTeam )
	{
	    this.team = newTeam;
	}
    
    public Player getPlayer()
	{
	    return player;
	}
    
    public void setPlayer( Player newPlayer )
	{
	    this.player = newPlayer;
	}
    
}
