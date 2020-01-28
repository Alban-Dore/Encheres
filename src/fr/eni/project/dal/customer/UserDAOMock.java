package fr.eni.project.dal.customer;

import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionDAO;

class UserDAOMock implements UserDAO {

	private static int cpt = 0;
	private List<User> lstCustomer = new ArrayList<>();

	// Insert of a new customer in the list.
	@Override
	public User insertCustomer(User customer) throws ExceptionDAO {
		customer.setNoUtilisateur(cpt++);
		lstCustomer.add(customer);
		return null;
	}

	// Get the whole list of customers.
	@Override
	public List<User> getAllCustomer() throws ExceptionDAO {
		return lstCustomer;
	}

	// Delete a customer from the list.
	@Override
	public void deleteCustomer(User customer) throws ExceptionDAO {
		lstCustomer.remove(customer);
	}

	// Apply changes on a customer in the list.
	@Override
	public void modifyCustomer(User customer) throws ExceptionDAO {
		lstCustomer.removeIf(c -> c.getNoUtilisateur() == customer.getNoUtilisateur());
		lstCustomer.add(customer);
	}
}
