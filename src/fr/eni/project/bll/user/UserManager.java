package fr.eni.project.bll.user;

import java.util.List;

import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionBLL;
import fr.eni.project.errors.ExceptionDAO;

/**
 * @author Alban
 * @category BLL Interface
 */
public interface UserManager {
	
	/**
	 * @param customer
	 * @return @param customer 
	 * @throws ExceptionDAO
	 * @throws ExceptionBLL
	 */
	public void createUser(User u) throws ExceptionDAO, ExceptionBLL;
	
	public User selectUser(User u) throws ExceptionDAO, ExceptionBLL;
	
	/**
	 * @param customer
	 * @throws ExceptionDAO
	 */
	public void updateUser(User u) throws ExceptionDAO, ExceptionBLL;
	
	/**
	 * @param customer
	 * @throws ExceptionDAO
	 */
	public void deleteUser(User u) throws ExceptionDAO, ExceptionBLL;
	
	/**
	 * @return {List of all Customers}
	 * @throws ExceptionDAO
	 * @throws ExceptionBLL
	 */
	public List<User> getAllUsers() throws ExceptionBLL; 
	
	/**
	 * @param identifiant
	 * @param pass
	 * @return
	 * @throws ExceptionBLL 
	 * @throws ExceptionDAO 
	 */
	public Boolean userExists (String identifiant, String pass) throws ExceptionBLL;
	
	/**
	 * @param identifiant
	 * @param pass
	 * @return
	 * @throws ExceptionDAO
	 * @throws ExceptionBLL
	 */
	public User connectUser(String identifiant, String pass) throws ExceptionDAO, ExceptionBLL;
	
	public boolean isAlphaNumeric(String pseudo); 
	
	public Boolean isGoodMail(String mail);
	
}
