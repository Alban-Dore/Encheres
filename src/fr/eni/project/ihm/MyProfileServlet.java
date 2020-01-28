package fr.eni.project.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.project.ihm.modele.MyProfileModele;

/**
 * Servlet implementation class MyProfileServlet
 */
@WebServlet("/MyProfileServlet")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyProfileModele modele = new MyProfileModele();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyProfileServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/myProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "/WEB-INF/myProfile.jsp";
		
		if (request.getParameter("BTeditProfile")!=null) {
			page = request.getContextPath()+"/EditProfileServlet";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	
		
	}

}
