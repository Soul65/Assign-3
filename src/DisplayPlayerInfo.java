/* Name: Matt Allen and Rob Syed
 * PROG3060
 * Assignment 2
 * Date: July 25, 2016
 * Description: Servlet that displays NHL player info
 * */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Servlet implementation class DisplayPlayers
 */
@WebServlet("/DisplayPlayerInfo")
public class DisplayPlayerInfo extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPlayerInfo() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url = "/PlayerInfo.jsp";
		HttpSession httpSession = request.getSession();						
		String rosterID = request.getParameter("rosterID");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NHLService");
		EntityManager em = emf.createEntityManager();
		
		try
		{
		    Roster roster = em.createQuery("FROM Roster WHERE rosterID = :rosterID", Roster.class).setParameter("rosterID", Integer.parseInt(rosterID)).getSingleResult();
		    httpSession.setAttribute("roster", roster);
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