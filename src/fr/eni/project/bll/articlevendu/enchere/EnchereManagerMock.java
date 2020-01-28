/**
 * 
 */
package fr.eni.project.bll.articlevendu.enchere;

import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.Enchere;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionDAO;

/**
 * @author adore2019
 *
 */
public class EnchereManagerMock implements EnchereManager {
	
	List<Enchere> listEnchere = new ArrayList<>();	

	@Override
	public void ajouterEnchere(User user, ArticleVendu article, Enchere e) {
					listEnchere.add(e);
	}

	@Override
	public List<Enchere> getAllEnchere() throws ExceptionDAO {
		return listEnchere;
	}

	@Override
	public List<Enchere> getAllEnchereFromArticle(ArticleVendu article) throws ExceptionDAO {
		List<Enchere> list = new ArrayList<>();
		for (Enchere enchere : listEnchere) {
			if (enchere.getNoArticle()  == article.getNoArticle()) {
				list.add(enchere);
			}
		}
		return list;
	}

}
