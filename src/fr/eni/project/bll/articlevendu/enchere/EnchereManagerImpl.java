package fr.eni.project.bll.articlevendu.enchere;

import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.Enchere;
import fr.eni.project.bo.User;
import fr.eni.project.dal.articles.ArticleDAO;
import fr.eni.project.dal.articles.ArticleDAOFact;
import fr.eni.project.dal.enchere.EnchereDAO;
import fr.eni.project.dal.enchere.EnchereDAOFact;
import fr.eni.project.errors.ExceptionBLL;
import fr.eni.project.errors.ExceptionDAO;

class EnchereManagerImpl implements EnchereManager {

	EnchereDAO daoEnchere = EnchereDAOFact.getInstanceFromDAO();
	ArticleDAO daoArticle = ArticleDAOFact.getInstanceFromDAO();

	@Override
	public void ajouterEnchere(User user, ArticleVendu article, Enchere e) throws ExceptionBLL {
		
		try {
			for (ArticleVendu a : daoArticle.getAllArticle()) {
				if (a.getNoArticle() == article.getNoArticle()) {
					try {
						daoEnchere.insertEnchere(user, article, e);
					} catch (Exception e1) {
						throw new ExceptionBLL("Problème d'ajout d'enchère dans la BLL");
					}
				}			
			}
		} catch (ExceptionDAO e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}


	@Override
	public List<Enchere> getAllEnchere() throws ExceptionDAO {
		return daoEnchere.getAllEnchere();
	}


	@Override
	public List<Enchere> getAllEnchereFromArticle(ArticleVendu article) throws ExceptionDAO {
		return daoEnchere.getAllEnchereFromArticle(article);
	}
	

}
