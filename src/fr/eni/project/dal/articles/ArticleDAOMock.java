package fr.eni.project.dal.articles;

import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionDAO;

class ArticleDAOMock implements ArticleDAO {

	private static int cpt = 0;
	private List<ArticleVendu> lstArticle = new ArrayList<>();

	@Override
	public void insertArticle(ArticleVendu article) throws ExceptionDAO {
		article.setNoArticle(cpt++);
		lstArticle.add(article);
	}

	@Override
	public List<ArticleVendu> getAllArticle() throws ExceptionDAO {
		return lstArticle;
	}

	@Override
	public void deleteArticle(ArticleVendu article) throws ExceptionDAO {
		lstArticle.remove(article);

	}

	@Override
	public void updateArticle(ArticleVendu article) throws ExceptionDAO {
		for (ArticleVendu articleVendu : lstArticle) {
			if (articleVendu.getNoArticle() == article.getNoArticle()) {
				articleVendu = article;
			}
		}
		
	}

	@Override
	public List<ArticleVendu> selectByCategorie(Integer noCategorie) {
		List<ArticleVendu> listByCategorie = new ArrayList<>();
		for (ArticleVendu article : lstArticle) {
			if (article.getNoCategorie()== noCategorie) {
				listByCategorie.add(article);
			}
		}
		return listByCategorie;
	}

	@Override
	public List<ArticleVendu> selectById(Integer noArticle) {
		List<ArticleVendu> listById = new ArrayList<>();
		for (ArticleVendu article : lstArticle) {
			if (article.getNoArticle()== noArticle) {
				listById.add(article);
			}
		}
		return listById;
	}

	@Override
	public List<ArticleVendu> selectByName(String name) {
		List<ArticleVendu> listByName = new ArrayList<>();
		for (ArticleVendu article : lstArticle) {
			if (article.getNomArticle().contains(name)) {
				listByName.add(article);
			}
		}
		return listByName;
	}

	@Override
	public List<ArticleVendu> selectEnchereFromUser(User user) {
		List<ArticleVendu> listByEnchere = new ArrayList<>();
		for (ArticleVendu article : lstArticle) {
			if (article.getNoUtilisateur() == user.getNoUtilisateur()) {
				listByEnchere.add(article);
			}
		}
		return listByEnchere;
	}
}
