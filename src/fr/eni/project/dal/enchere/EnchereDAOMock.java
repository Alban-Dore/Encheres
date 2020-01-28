package fr.eni.project.dal.enchere;

import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.Enchere;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionDAO;


class EnchereDAOMock implements EnchereDAO {

	List<Enchere> lstEncheres = new ArrayList<>();

	@Override
	public void insertEnchere(User user, ArticleVendu article, Enchere enchere) throws ExceptionDAO {
		lstEncheres.add(enchere);
	}

	@Override
	public List<Enchere> getAllEnchere() throws ExceptionDAO {
		return lstEncheres;
	}

	@Override
	public List<Enchere> getAllEnchereFromArticle(ArticleVendu article) throws ExceptionDAO {
		List<Enchere> list = new ArrayList<>();
		for (Enchere enchere : lstEncheres) {
			if (enchere.getNoArticle() == article.getNoArticle()) {
				list.add(enchere);
			}
		}
		return list;
	}
}
