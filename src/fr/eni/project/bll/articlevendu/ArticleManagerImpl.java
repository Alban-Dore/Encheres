/**
 * 
 */
package fr.eni.project.bll.articlevendu;

import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.User;
import fr.eni.project.dal.articles.ArticleDAO;
import fr.eni.project.dal.articles.ArticleDAOFact;
import fr.eni.project.dal.categories.CategoriesDAO;
import fr.eni.project.dal.categories.CategoriesDAOFact;
import fr.eni.project.errors.ExceptionBLL;

/**
 * @author adore2019
 *
 */
class ArticleManagerImpl implements ArticleManager {
	
	ArticleDAO aManager = ArticleDAOFact.getInstance();
	CategoriesDAO cManager = CategoriesDAOFact.getInstance();

	@Override
	public void createArticle(ArticleVendu article) throws ExceptionBLL {
		try {
			aManager.insertArticle(article);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème d'insertion dans la BLL");
		}
	}

	@Override
	public void updateArticle(ArticleVendu article) throws ExceptionBLL {
		try {
			aManager.updateArticle(article);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de modification dans la BLL");
		}
	}
	@Override
	public void deleteArticle(ArticleVendu article) throws ExceptionBLL {
		try {
			aManager.deleteArticle(article);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de suppression dans la BLL");
		}
	}

	@Override
	public List<ArticleVendu> getAllArticle() throws ExceptionBLL {
		try {
			return aManager.getAllArticle();
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de récupération listArticle dans la BLL");
		}
	}

	@Override
	public List<ArticleVendu> selectByCategorie(Integer noCategorie) throws ExceptionBLL {
		try {
			return aManager.selectByCategorie(noCategorie);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de récupération listArticle dans la BLL");
		}
	}

	@Override
	public List<ArticleVendu> selectById(Integer id) throws ExceptionBLL  {
		try {
			return aManager.selectById(id);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de récupération listArticle dans la BLL");
		}
	}

	@Override
	public List<ArticleVendu> selectByName(String name) throws ExceptionBLL {
		try {
			return aManager.selectByName(name);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de récupération listArticle dans la BLL");
		}
	}

	@Override
	public List<ArticleVendu> selectEnchereFromUser(User user) throws ExceptionBLL {
		try {
			return aManager.selectEnchereFromUser(user);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de récupération listArticle dans la BLL");		
			}
	}

	@Override
	public String getCategorie(Integer id) {
		cManager.
		
		String cate = "";
		
		return cate;
	}
	
	

}
