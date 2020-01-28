package fr.eni.project.ihm;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
import fr.eni.project.ihm.modele.SignInModele;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager manager = UserManagerFact.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/signin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SignInModele modeleSignin = new SignInModele();
		String page = request.getContextPath() + "/WEB-INF/signin.jsp";

		// Si on clique sur Annuler
		if (request.getParameter("BTcancel") != null) {
			page = request.getContextPath() + "/WelcomeServlet";
		}

		// Si on clique sur Créer
		if (request.getParameter("BTcreer") != null) {

			if (!request.getParameter("pseudo").isEmpty() && !request.getParameter("prenom").isEmpty()
					&& !request.getParameter("telephone").isEmpty() && !request.getParameter("codepostal").isEmpty()
					&& !request.getParameter("pass").isEmpty() && !request.getParameter("nom").isEmpty()
					&& !request.getParameter("email").isEmpty() && !request.getParameter("rue").isEmpty()
					&& !request.getParameter("ville").isEmpty()) {

				// TODO Conserver les données déjà tapées
				if (request.getParameter("pass").equals(request.getParameter("passconfirm"))) {
					// SET des attributs pour la création d'un Customer
					String pseudo = request.getParameter("pseudo");
					String prenom = request.getParameter("prenom");
					String telephone = request.getParameter("telephone");
					Integer codepostal = Integer.parseInt(request.getParameter("codepostal"));
					String pass = request.getParameter("pass");
					String nom = request.getParameter("nom");
					String email = request.getParameter("email");
					String rue = request.getParameter("rue");
					String ville = request.getParameter("ville");

					// Cryptage du password en SHA-256
					pass = Crypter.Crypt(pass);

					try {

						User user = new User(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, pass);
						manager.createUser(user);
						page = request.getContextPath() + "/WelcomeServlet";
						modeleSignin.setUser(user);
						request.getSession().removeAttribute(modeleSignin.getError());

					} catch (ExceptionDAO | ExceptionBLL e) {
						modeleSignin.setError(e.getMessage());
					}

				} else {
					modeleSignin.setError("Le mot de passe doit être identique.");
				}

			} else {
				modeleSignin.setError("Tous les champs sont obligatoire");
			}
		}

		request.getSession().setAttribute("modeleSignin", modeleSignin);
		response.sendRedirect(page);

	}

}
