package fr.eni.project.dal.categories;

import fr.eni.project.bo.Categorie;
import fr.eni.project.errors.ExceptionDAO;

public class TestCategoriesDAO {

	public static void main(String[] args) throws ExceptionDAO {
		
		CategoriesDAO daoCategorie = CategoriesDAOFact.getInstance();
		
		//Impression de la liste en dur
		System.out.println("Liste Origine : " + daoCategorie.getAllCategories());
		
		//Creation de deux catégories
		Categorie c1 = new Categorie("testCat");
		Categorie c2 = new Categorie("essai");
		
		//Insertion des deux catégories
		daoCategorie.insertCategorie(c1);
		daoCategorie.insertCategorie(c2);
		
		//Impression de la liste avec les deux nouvelles catégories
		System.out.println("Liste ApInsert : " + daoCategorie.getAllCategories());
		
		//Suppression de la catégorie c2
		daoCategorie.deleteCategorie(c2);
		
		//Impression de la liste apres suppression de la categorie c2
		System.out.println("Liste ApDelc2 : " + daoCategorie.getAllCategories());
		
		//Modification de la categorie c1
		c1.setLibelle("testCATtest");
		daoCategorie.modifyCategorie(c1);
		
		//Impression de la liste apres modification de c1
		System.out.println("Liste ApModc1 : " + daoCategorie.getAllCategories());
		
	}
}
