package fr.eni.project.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.project.bll.user.UserManager;
import fr.eni.project.bll.user.UserManagerFact;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionBLL;
import fr.eni.project.errors.ExceptionDAO;
import fr.eni.project.ihm.modele.LoginModele;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager manager = UserManagerFact.getInstance();
	private LoginModele modele = new LoginModele();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = "WEB-INF/login.jsp";

		// TODO condition du login
		if (request.getParameterMap().isEmpty()) {

		} else {

		}
		// BTconnection=Valider

		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// page par défaut
		String page = request.getContextPath() + "/LoginServlet";
		// Set des données
		String identifiant = request.getParameter("identifiant");
		String pass = Crypter.Crypt(request.getParameter("pass"));
		
		if (request.getParameter("BTcreation") != null) {
			page = request.getContextPath() + "/SignInServlet";
		}
			try {
				if (manager.userExists(identifiant, pass)) {
					// si la personne à un compte alors on le log
					// on récupère celui qui vient de se logger
					User user;
					try {
						user = manager.connectUser(identifiant, pass);
						// on le sessionne
						modele.setUser(user);
						// on le dirige sur le welcome
						page = request.getContextPath() + "/WelcomeServlet";
						modele.setError(null);
						request.getSession().setAttribute("user", user);
					} catch (ExceptionBLL | ExceptionDAO e) {
						modele.setError(e.getMessage());
					}
				} else {
					modele.setError("Le compte " + identifiant + " n'existe pas");
				}
			} catch (ExceptionBLL e) {
				modele.setError(e.getMessage());
				
			}

		request.getSession().setAttribute("modele", modele);
		response.sendRedirect(page);
	}
}
