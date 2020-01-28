package fr.eni.project.dal.articles;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.errors.ExceptionDAO;

public class TestArticleDAO {

	public static void main(String[] args) throws ParseException, ExceptionDAO {
		ArticleDAO daoArticle = ArticleDAOFact.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//		ArticleVendu a1 = new ArticleVendu("test", "essaitest", sdf.parse("25/09/2019"), sdf.parse("30/10/2019"), 11.0, 20.0, 1, 1);
		//System.out.println(a1);
//		ArticleVendu a2 = new ArticleVendu("PC", "portable", sdf.parse("30/09/2019"), sdf.parse("30/10/2019"), 20.0, 30.0, 1, 1);
		//System.out.println(a2);

//		daoArticle.insertArticle(a1);
//		daoArticle.insertArticle(a2);
//		
//		System.out.println(daoArticle.getAllArticle());
//		
//		System.out.println(a1);
//		System.out.println(a2);

	}

}
