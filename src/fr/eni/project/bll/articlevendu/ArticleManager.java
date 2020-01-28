/**
 * 
 */
package fr.eni.project.bll.articlevendu;

import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionBLL;

/**
 * @author adore2019
 *
 */
public interface ArticleManager {
		
	public void createArticle(ArticleVendu article) throws ExceptionBLL;
	public void updateArticle(ArticleVendu article) throws ExceptionBLL;
	public void deleteArticle(ArticleVendu article) throws ExceptionBLL;
	
	public List<ArticleVendu> getAllArticle() throws ExceptionBLL;
	public List<ArticleVendu> selectByCategorie(Integer noCategorie) throws ExceptionBLL ;
	public List<ArticleVendu> selectById(Integer id) throws ExceptionBLL ;
	public List<ArticleVendu> selectByName(String name) throws ExceptionBLL ;
	public List<ArticleVendu> selectEnchereFromUser(User user) throws ExceptionBLL ;
	
	public String getCategorie(Integer id);
	
	
}
