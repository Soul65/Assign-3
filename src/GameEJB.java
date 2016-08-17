import javax.ejb.Remote;

@Remote
public interface GameEJB 
{
	String gameStats(Team team, Game game);
}