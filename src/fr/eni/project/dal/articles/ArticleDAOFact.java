package fr.eni.project.dal.articles;


public class ArticleDAOFact {
	public static ArticleDAO getInstance() {
		return new ArticleDAOMock();
	}
	public static ArticleDAO getInstanceFromDAO() {
		return new ArticleDAOImpl();
	}
}
