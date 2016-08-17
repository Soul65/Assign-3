/* Name: Matt Allen and Rob Syed
 * PROG3060
 * Assignment 2
 * Date: July 21, 2016
 * Description: Servlet that displays NHL team info
 * */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayTeamInfo
 */
@WebServlet("/DisplayTeamInfo")
public class DisplayTeamInfo extends HttpServlet 
{
	@EJB
    GameEJB gameEJB;
	
	@EJB
    ScheduleEJB scheduleEJB;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTeamInfo() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url = "/TeamInfo.jsp";
		HttpSession httpSession = request.getSession();						
		String teamID = request.getParameter("teamID");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NHLService");
		EntityManager em = emf.createEntityManager();
		
		
		try
		{
		    List<Roster> roster = em.createQuery("FROM Roster WHERE team.id = :teamID ORDER BY jersey", Roster.class).setParameter("teamID", teamID).getResultList();
		    List<Game> games = em.createQuery("FROM Game WHERE (home.id = :team OR visitor.id = :team) AND homeScore != NULL", Game.class).setParameter("team", teamID).getResultList();
		    List<Game> scheduledGames = em.createQuery("FROM Game WHERE (home.id = :team OR visitor.id = :team) AND homeScore = NULL", Game.class).setParameter("team", teamID).getResultList();
		    Team team = em.createQuery("FROM Team WHERE teamID = :teamID", Team.class).setParameter("teamID", teamID).getSingleResult();
		    List<GameViewModel> gameVM = new ArrayList<GameViewModel>();
		    
		    for(Game game : games)
		    {
		    	GameViewModel currVM = new GameViewModel();
		    	currVM.setGame(game);		    	
		    	currVM.setScore(gameEJB.gameStats(team, game));
		    	
		    	gameVM.add(currVM);		    	
		    }

		    httpSession.setAttribute("NextGame", scheduleEJB.nextGame(team));
		    httpSession.setAttribute("Roster", roster);
			httpSession.setAttribute("Games", gameVM);
			httpSession.setAttribute("ScheduledGames", scheduledGames);
			httpSession.setAttribute("headCoach", request.getParameter("headCoach"));
			httpSession.setAttribute("asstCoach", request.getParameter("asstCoach"));
			httpSession.setAttribute("manager", request.getParameter("manager"));
			httpSession.setAttribute("trainer", request.getParameter("trainer"));
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
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}