/* Name: Matt Allen and Rob Syed
 * PROG3060
 * Assignment 1
 * Date: 06/16/16
 * Description: Servlet that displays all the NHL teams
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
 * Servlet implementation class DisplayHome
 */
@WebServlet("/DisplayHome")
public class DisplayHome extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayHome() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url = "/AllTeams.jsp";
		HttpSession httpSession = request.getSession();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NHLService");
		EntityManager em = emf.createEntityManager();
		
		try
		{
		    List<Team> teams = em.createQuery("FROM Team", Team.class).getResultList();
		    List<Arena> arenas = em.createQuery("FROM Arena ORDER BY ARENANAME", Arena.class).getResultList();		    
		    
		    httpSession.setAttribute("Teams", teams);
		    httpSession.setAttribute("Arenas", arenas);
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