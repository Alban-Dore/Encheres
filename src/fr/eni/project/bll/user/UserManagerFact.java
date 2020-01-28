package fr.eni.project.bll.user;

/**
 * @author Alban
 * @category BLL Factory
 */
public class UserManagerFact {
	
	/**
	 * {Create new instance of Customer Manager}
	 * @see fr.eni.project.bll.user.UserManagerImpl
	 */
	public static UserManager getInstance() {
		return new UserManagerImpl();
	}
}
