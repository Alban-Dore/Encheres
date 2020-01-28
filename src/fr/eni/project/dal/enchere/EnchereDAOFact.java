package fr.eni.project.dal.enchere;

public class EnchereDAOFact {

	public static EnchereDAO getInstance() {
		return new EnchereDAOMock();
	}
	public static EnchereDAO getInstanceFromDAO() {
		return new EnchereDAOImpl();
	}
}
