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
import fr.eni.project.ihm.modele.EditProfileModele;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager manager = UserManagerFact.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProfileServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EditProfileModele modele = new EditProfileModele();
		String page = request.getContextPath() + "/EditProfileServlet";

		if (request.getParameter("BTconfirmEdit") != null) {
			// si on clique sur enregistrer
			System.out.println((User) request.getSession().getAttribute("user"));
			System.out.println(request.getParameter("pass"));
			System.out.println(request.getSession().getAttribute("user"));

			if (((User) request.getSession().getAttribute("user")).getMotDePasse()
					.equals(Crypter.Crypt(request.getParameter("pass")))) {

				try {
					// Set des paramètres
					String pseudo = request.getParameter("pseudo");
					String nom = request.getParameter("nom");
					String prenom = request.getParameter("prenom");
					String email = request.getParameter("email");
					String telephone = request.getParameter("telephone");
					String rue = request.getParameter("rue");
					Integer codePostal = Integer.parseInt(request.getParameter("codepostal"));
					String ville = request.getParameter("ville");
					String newPass = request.getParameter("newPass");
					String passConfirm = request.getParameter("passConfirm");
					Integer id = ((User) request.getSession().getAttribute("user")).getNoUtilisateur();

					if (newPass.equalsIgnoreCase(passConfirm)) {
						// Cryptage des password
						passConfirm = Crypter.Crypt(passConfirm);

						// appel de la modification par la BLL
						manager.updateUser(new User(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
								passConfirm));

						modele.setMessage("L'utilisateur : " + nom + " " + prenom + " a bien été modifié.");
					} else {
						modele.setError("Vos mots de passes ne correspondent pas.");
					}
				} catch (ExceptionDAO | ExceptionBLL e) {
					modele.setError(e.getMessage());
				}
			} else {
				modele.setError(
						"Désolé mais vous ne pouvez pas modifier cette utilisateur car Mot de passe actuel ne correspond pas");
			}
		}

		if (request.getParameter("BTdeleteAccount") != null) {
			// si on clique sur supprimer

			// vérifier que l'ancien mot de passe correspond bien
			if (request.getParameter("pass")
					.equals(((User) request.getSession().getAttribute("user")).getMotDePasse())) {
				// si c'est validé alors on le supprime
				try {
					// j'efface le client
					manager.deleteUser((User) request.getSession().getAttribute("user"));
					// je suis déconnecté
					request.getSession().invalidate();
					// et rediriger sur l'accueil
					page = request.getContextPath() + "/WelcomeServlet";

				} catch (ExceptionDAO | ExceptionBLL e) {
					modele.setError(e.getMessage());
				}
			} else {
				modele.setError("Le mot de passe entrée dans Mot de Passe actuelle n'est pas valide");
			}

		}
		request.getSession().setAttribute("modeleEP", modele);
		// request.getRequestDispatcher(page).forward(request, response);
		response.sendRedirect(page);
	}

}
