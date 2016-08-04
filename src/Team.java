/* Name: Matt Allen & Robbie Syed
 * PROG3060
 * 07/20/16
 * Description: The Team bean
 * */
import javax.persistence.*;

@Entity @Table(name = "TEAM", schema = "GPAULLEY")
public class Team
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String teamID;
	private String sponsor;
	private String teamName;
	@ManyToOne
	@JoinColumn(name="headCoach", insertable = false, updatable = false)
	private Staff headCoach;
	@ManyToOne
	@JoinColumn(name="asstCoach", insertable = false, updatable = false)
	private Staff asstCoach;
	@ManyToOne
	@JoinColumn(name="trainer", insertable = false, updatable = false)
	private Staff trainer;
	@ManyToOne
	@JoinColumn(name="manager", insertable = false, updatable = false)
	private Staff manager;
	private String website;
	
	public Team(){}
		
	public String getTeamID() 
	{
		return teamID;
	}
	
	public void setTeamID(String teamID) 
	{
		this.teamID = teamID;
	}
	
	public String getSponsor() 
	{
		return sponsor;
	}
	
	public void setSponsor(String sponsor) 
	{
		this.sponsor = sponsor;
	}
	
	public String getTeamName() 
	{
		return teamName;
	}
	
	public void setTeamName(String teamName) 
	{
		this.teamName = teamName;
	}
		
	public Staff getHeadCoach() 
	{
		return headCoach;
	}
	
	public void setHeadCoach(Staff headCoach) 
	{
		this.headCoach = headCoach;
	}
	
	public Staff getAsstCoach() 
	{
		return asstCoach;
	}
	
	public void setAsstCoach(Staff asstCoach) 
	{
		this.asstCoach = asstCoach;
	}
	
	public Staff getTrainer() 
	{
		return trainer;
	}
	
	public void setTrainer(Staff trainer) 
	{
		this.trainer = trainer;
	}
	
	public Staff getManager() 
	{
		return manager;
	}
	
	public void setManager(Staff manager) 
	{
		this.manager = manager;
	}	
	
	public String getWebsite() 
	{
		return website;
	}
	
	public void setWebsite(String website) 
	{
		this.website = website;
	}
}
