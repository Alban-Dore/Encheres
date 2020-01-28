package fr.eni.project.dal.categories;

import java.util.List;

import fr.eni.project.bo.Categorie;
import fr.eni.project.errors.ExceptionDAO;

public interface CategoriesDAO {

	public List<Categorie> getAllCategories() throws ExceptionDAO;
	
	public Categorie insertCategorie(Categorie categorie) throws ExceptionDAO;
	
	public void deleteCategorie(Categorie categorie) throws ExceptionDAO;
	
	public void modifyCategorie(Categorie categorie) throws ExceptionDAO;
}
