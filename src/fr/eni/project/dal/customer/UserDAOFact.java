package fr.eni.project.dal.customer;

public class UserDAOFact {
	
	public static UserDAO getInstanceFromDAO() {
		return new UserDAOImpl();
	}

	public static UserDAO getInstance() {
		return new UserDAOMock();
	}
	
}
