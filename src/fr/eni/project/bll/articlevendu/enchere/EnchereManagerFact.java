package fr.eni.project.bll.articlevendu.enchere;

public class EnchereManagerFact {
	
	public static EnchereManager getInstanceFromDAO() {
		return new EnchereManagerImpl();
	}

	public static EnchereManager getInstance() {
		return new EnchereManagerMock();
	}
}
