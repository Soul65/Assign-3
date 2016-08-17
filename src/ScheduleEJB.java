import javax.ejb.Remote;

@Remote
public interface ScheduleEJB 
{
	String nextGame(Team team);
}