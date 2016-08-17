import javax.ejb.Stateful;

@Stateful
public class GameEJBImpl implements GameEJB 
{
	@Override
	public String gameStats(Team team, Game game)
	{
		String stats = "";
		
		if(Integer.toString(game.getHomescore()) != "")
		{
			if(game.getHome() == team)
			{
				stats = Integer.toString(game.getHomescore())
						+ '-'
						+ Integer.toString(game.getVisitorscore());
			}
			else
			{
				stats = Integer.toString(game.getHomescore())
						+ '-'
						+ Integer.toString(game.getVisitorscore());
			}
		}
		
		if(game.getOt() == "Y")
		{
			stats += "(OT)";
		}
		
		return stats;
	}
}