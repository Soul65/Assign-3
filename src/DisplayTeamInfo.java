/* Name: Matt Allen and Rob Syed
 * PROG3060
 * Assignment 2
 * Date: July 21, 2016
 * Description: Servlet that displays NHL team info
 * */

import java.io.IOException;
import java.util.List;

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
		    httpSession.setAttribute("Roster", roster);		    
			httpSession.setAttribute("Games", games);
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