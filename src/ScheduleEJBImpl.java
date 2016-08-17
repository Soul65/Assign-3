import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateful
public class ScheduleEJBImpl implements ScheduleEJB 
{
	@Override
	public String nextGame(Team team)
	{
		String nextGame = "";		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NHLService");
		EntityManager em = emf.createEntityManager();
		
		try
		{
			Game game = em.createQuery("FROM Game WHERE (home = :teamID OR vistor = :teamID) AND Homescore = NULL ORDER BY Gamedate", Game.class)
					.setParameter("teamID", team.getTeamid()).getResultList().get(0);
			nextGame = game.getGamedate().toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
			emf.close();
		}
		
		return nextGame;
	}
}