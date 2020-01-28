package fr.eni.project.bll;

import fr.eni.project.bll.user.UserManager;
import fr.eni.project.bll.user.UserManagerFact;
import fr.eni.project.bo.User;
import fr.eni.project.errors.ExceptionBLL;
import fr.eni.project.errors.ExceptionDAO;

/**
 * @author Alban
 * @category Test de la BLL
 */
public class TestBLLCustomer {
	public static void main(String[] args) {

		//		-------------------------------------
		//		------	TEST BLL CUSTOMER -----------
		//		-------------------------------------
		
		UserManager manager = UserManagerFact.getInstance();
		User c1 = new User("Pseudo", "Nom", "Prénom", "Adresse@mail.com", "Num.Téléphone", "3 Rue de la brouette",
				29000, "Quimper", "Password");


		//		-------------------------------------
		//		---- INSERTION D'UN UTILISATEUR -----
		//		-------------------------------------
		System.out.println("***ajout toto - email toto@mail.com***");
		try {
			manager.createUser(new User("toto", "toto", "toto", "toto@mail.com", "0298933430",
					"3 Rue de le brouette", 29000, "Quimper", "toto"));
			System.out.println("ajout ok");
		} catch (ExceptionDAO | ExceptionBLL e) {
			System.out.println("---- " + e.getMessage());
		}


		//		-------------------------------------
		//	   TEST D'INSERTION SI PSEUDO DEJA UTILISE
		//		-------------------------------------
		System.out.println("***test sur le pseudo***");
		try {
			manager.createUser(new User("toto", "tata", "tata", "totaaa@mail.com", "0298933430",
					"3 Rue de le brouette", 29000, "Quimper", "toto"));
			System.out.println("ajout ok");
		} catch (ExceptionDAO | ExceptionBLL e) {
			System.out.println("---- " + e.getMessage());
		}


		//		-------------------------------------
		//		TEST D'INSERTION SI EMAIL DEJA UTILISE
		//		-------------------------------------
		System.out.println("***test sur l'email***");
		try {
			manager.createUser(new User("tato", "tata", "tata", "tota@mail.com", "0298933430",
					"3 Rue de le brouette", 29000, "Quimper", "toto"));
			System.out.println("ajout ok");
		} catch (ExceptionDAO | ExceptionBLL e) {
			System.out.println("---- " + e.getMessage());
		}


		//		-------------------------------------
		//	TEST D'INSERTION SI PSEUDO EN ALPHANUMERIQUE
		//		-------------------------------------
		System.out.println("***test caractères alphaNum***");
		try {
			manager.createUser(new User("taµ%ùté$^k", "tata", "tata", "totaa@mail.com", "0298933430",
					"3 Rue de le brouette", 29000, "Quimper", "toto"));
		} catch (ExceptionDAO | ExceptionBLL e) {
			System.out.println("---- " + e.getMessage());
		}

		System.out.println("***AFFICHAGE LISTE***");
			try {
				System.out.println(manager.getAllUsers().toString());
			} catch (ExceptionBLL e1) {
				System.out.println(e1.getMessage());
			}
		


		//		-------------------------------------
		//		------	TEST INSERTION C1 -----------
		//		-------------------------------------
		System.out.println("***test insertion C1***");
		try {
			manager.createUser(c1);
			System.out.println("ajout ok");
		} catch (ExceptionDAO | ExceptionBLL e) {
			System.out.println("---- " + e.getMessage());
		}
		

		//		-------------------------------------
		//		------- TEST MODIFICATION C1 --------
		//		-------------------------------------
		c1.setNom("Nouveau nom");
		c1.setPrenom("Nouveau prénom");
		c1.setCredit(18);
		System.out.println("***test modif***");
		try {
			manager.updateUser(c1);
			System.out.println("modif ok");
		} catch (ExceptionDAO | ExceptionBLL e) {
			System.out.println("---- " + e.getMessage());
		}

		
		System.out.println("***AFFICHAGE LISTE***");
		try {
			System.out.println(manager.getAllUsers().toString());
		} catch (ExceptionBLL e) {
			System.out.println(e.getMessage());
		}


		//		-------------------------------------
		//		-------- TEST SUPPRESSION C1 --------
		//		-------------------------------------
		System.out.println("***test suppression***");
		try {
			manager.deleteUser(c1);
			System.out.println("suppression ok");
		} catch (ExceptionDAO | ExceptionBLL e) {
			System.out.println("---- " + e.getMessage());
		}

		System.out.println("***AFFICHAGE LISTE***");
		try {
			System.out.println(manager.getAllUsers().toString());
		} catch (ExceptionBLL e) {
			System.out.println(e.getMessage());
		}


		//		-------------------------------------
		//		--------- TEST BLL ARTICLE ----------
		//		-------------------------------------
	}

}
