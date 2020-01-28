package fr.eni.project.dal;

import fr.eni.project.bo.User;
import fr.eni.project.dal.customer.UserDAO;
import fr.eni.project.dal.customer.UserDAOFact;
import fr.eni.project.errors.ExceptionDAO;

public class TestDAO {

	public static void main(String[] args) throws ExceptionDAO {

		// Use Mock or Implementation.
		UserDAO dao = UserDAOFact.getInstance();

		// Create new Customers.
		User c1 = new User("toto", "Cerien", "Jean", "cerien@gmel.com", "02.98.57.57.57", "rue Projet", 29000,
				"Quimper", "toto", 0, "0");

		User c2 = new User("tata", "Cerien", "Helene", "helen@gmel.com", "02.98.53.53.53", "rue Essai", 29000,
				"Quimper", "toto", 0, "0");
		
		User c3 = new User("alpha", "Cetrop", "Jean", "cetrop@yaou.com", "02.98.00.00.00", "rue Test", 29200,
				"Brest", "toto", 0, "0");

		// Add customers (list or database).
		dao.insertCustomer(c1);
		dao.insertCustomer(c2);
		dao.insertCustomer(c3);
	
		// Print the customers list.
		System.out.println(dao.getAllCustomer());
	
		// Delete the customer (c1).
		dao.deleteCustomer(c2);
	
		// Print the customers list.
		System.out.println(dao.getAllCustomer());
		
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		//Modify customer c1 to become administrator
		c1.setPseudo("toto");
		c1.setNom("Cerien");
		c1.setPrenom("Jean");
		c1.setEmail("cerien@gmel.com");
		c1.setTelephone("02.98.57.57.57");
		c1.setRue("rue Projet");
		c1.setCodePostal(29000);
		c1.setVille("Quimper");
		c1.setMotDePasse("toto");
		c1.setCredit(0);
		c1.setAdministrateur("1");
		c1.setNoUtilisateur(c1.getNoUtilisateur());
		
		dao.modifyCustomer(c1);
		
		// Print the customers list.
		System.out.println(dao.getAllCustomer());
		
		
	}
}
