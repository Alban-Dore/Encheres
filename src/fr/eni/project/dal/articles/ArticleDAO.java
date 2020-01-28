package fr.eni.project.dal.articles;

import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionDAO;

public interface ArticleDAO {

	public void insertArticle(ArticleVendu article) throws ExceptionDAO;
	public void updateArticle(ArticleVendu article) throws ExceptionDAO;
	public void deleteArticle(ArticleVendu article) throws ExceptionDAO;
	
	public List<ArticleVendu> getAllArticle() throws ExceptionDAO;
	public List<ArticleVendu> selectByCategorie(Integer noCategorie) throws ExceptionDAO;
	public List<ArticleVendu> selectById(Integer id) throws ExceptionDAO;
	public List<ArticleVendu> selectByName(String name) throws ExceptionDAO;
	public List<ArticleVendu> selectEnchereFromUser(User user) throws ExceptionDAO;
	
}
