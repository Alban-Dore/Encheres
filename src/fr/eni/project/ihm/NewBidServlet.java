package fr.eni.project.ihm;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.project.bll.articlevendu.ArticleManager;
import fr.eni.project.bll.articlevendu.ArticleManagerFact;
import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.User;

/**
 * Servlet implementation class NewBidServlet
 */
@WebServlet("/NewBidServlet")
public class NewBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager vmanager = ArticleManagerFact.getInstanceFromDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewBidServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/newBid.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getContextPath()+"/NewBidServlet";
		
		if(request.getParameter("BTCancel")!=null) {
			//Si on cancel on reviens sur la page welcome.jsp en passant par la servlet WelcomeServlet
			page = request.getContextPath()+"/WelcomeServlet";
		}
		
		if(request.getParameter("BTCreer")!=null) {
			//si on le valide
			//Article
			String nom = request.getParameter("nomArticle");
			String desc = request.getParameter("description");
			Integer noCategorie = 2;
			String categorie = request.getParameter("categorie");
			Integer prixInitial=10;
			try {
				prixInitial = Integer.parseInt(request.getParameter("miseAPrix"));
				System.out.println(prixInitial);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
			
			
			// vendeur
			User vendeur = (User) request.getSession().getAttribute("user");
			Integer noUtilisateur = vendeur.getNoUtilisateur();
			
			// les dates
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateDebutVente = null;
			Date dateFinVente = null;
			try {
				dateDebutVente = sdf.parse(request.getParameter("dateDebutEnchere"));
				dateFinVente = sdf.parse(request.getParameter("dateFinEnchere"));
			} catch (ParseException e) {
				// TODO gérer error à partir du modele
//				modele.setError(e.getMessage());
				e.printStackTrace();
			}
			
			// le retrait
			String rue = request.getParameter("rue");
			Integer codePostal = Integer.parseInt(request.getParameter("codePostal"));
			String ville = request.getParameter("ville");
							

			ArticleVendu article = new ArticleVendu(nom, desc, dateDebutVente, dateFinVente, prixInitial, null, noUtilisateur, noCategorie);
			vmanager.createArticle(article);
		}
		response.sendRedirect(page);
	}

}
