/**
 * 
 */
package fr.eni.project.bll.articlevendu;

import java.text.ParseException;

/**
 * @author adore2019
 *
 */
public class ArticleManagerFact {

	public static ArticleManager getInstanceFromDAO(){
		return new ArticleManagerImpl();
	}
	
	public static ArticleManager getInstance(){
		return new ArticleManagerMock();
	}
}
