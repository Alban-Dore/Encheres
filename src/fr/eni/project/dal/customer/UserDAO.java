package fr.eni.project.dal.customer;

import java.util.List;

import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionDAO;

public interface UserDAO {
	
	public User insertCustomer(User customer) throws ExceptionDAO;

	public List<User> getAllCustomer() throws ExceptionDAO;
	
	public void deleteCustomer(User customer) throws ExceptionDAO;
	
	public void modifyCustomer(User customer) throws ExceptionDAO;

}
