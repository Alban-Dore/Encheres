package fr.eni.project.dal.categories;

public class CategoriesDAOFact {
	

	public static CategoriesDAO getInstanceFromDAO() {
		return new CategoriesDAOImpl();
	}
	
	public static CategoriesDAO getInstance() {
		return new CategoriesDAOMock();
	}

}
