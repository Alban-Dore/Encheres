package fr.eni.project.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.project.bll.enchere.EnchereManager;
import fr.eni.project.bll.enchere.EnchereManagerFact;
import fr.eni.project.ihm.modele.WelcomeModele;

/**
 * Servlet implementation class WelcomeServ
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WelcomeModele modeleWelcome = new WelcomeModele();
	private ArticleManager articleManager = ArticleManagerFact.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// si l'utilisateur à cliqué sur déconnection
		
		// M.A.J. de la liste des enchères
		modeleWelcome.setLstArticle(articleManager.getAllArticle());
		if (request.getParameter("BTdeconnection") != null) {
			request.getSession().invalidate();
		}
		
		request.getSession().setAttribute("modeleWelcome", modeleWelcome);
		request.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "/WEB-INF/welcome.jsp";
		// M.A.J. de la liste des enchères
		modeleWelcome.setLstArticle(articleManager.getAllArticle());

		if (request.getParameter("BTok") != null) {
			page = "/SignInServlet";
		}

		request.getSession().setAttribute("modeleWelcome", modeleWelcome);
		response.sendRedirect(page);
	}

}
