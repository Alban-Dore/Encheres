package fr.eni.project.dal.enchere;

import java.text.ParseException;
import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.Enchere;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionDAO;

public interface EnchereDAO {

	public void insertEnchere(User user, ArticleVendu article, Enchere e) throws ParseException, ExceptionDAO ;	

	public List<Enchere> getAllEnchere() throws ExceptionDAO;
	
	public List<Enchere> getAllEnchereFromArticle(ArticleVendu article) throws ExceptionDAO;

	
}
