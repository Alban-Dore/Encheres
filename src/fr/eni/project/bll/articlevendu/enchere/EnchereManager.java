package fr.eni.project.bll.articlevendu.enchere;

import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.Enchere;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionBLL;
import fr.eni.project.errors.ExceptionDAO;

public interface EnchereManager {

	public void ajouterEnchere(User user, ArticleVendu article, Enchere e) throws ExceptionBLL;

	public List<Enchere> getAllEnchere() throws ExceptionDAO;

	public List<Enchere> getAllEnchereFromArticle(ArticleVendu article) throws ExceptionDAO;


}
