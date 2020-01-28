package fr.eni.project.dal.categories;

import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.Categorie;
import fr.eni.project.errors.ExceptionDAO;

class CategoriesDAOMock implements CategoriesDAO {
	
	private static int cpt = 0;
	private List<Categorie> lstCategorieDAL = new ArrayList<>();

	@Override
	public List<Categorie> getAllCategories() throws ExceptionDAO {
		return lstCategorieDAL;
	}

	@Override
	public Categorie insertCategorie(Categorie categorie) throws ExceptionDAO {
		categorie.setNoCategorie(cpt++);
		lstCategorieDAL.add(categorie);
		return null;
	}

	@Override
	public void deleteCategorie(Categorie categorie) throws ExceptionDAO {
		lstCategorieDAL.remove(categorie);

	}

	@Override
	public void modifyCategorie(Categorie categorie) throws ExceptionDAO {
		lstCategorieDAL.removeIf(c -> c.getNoCategorie() == categorie.getNoCategorie());
		lstCategorieDAL.add(categorie);
		
	}

}
