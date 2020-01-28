/**
 * 
 */
package fr.eni.project.bll.articlevendu.retrait;

/**
 * @author adore2019
 *
 */
public class RetraitManagerFact {
	
	public static RetraitManager getInstance() {
		return new RetraitManagerImpl();
	}

}
