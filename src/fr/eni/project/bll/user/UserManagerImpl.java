package fr.eni.project.bll.user;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import fr.eni.project.bo.User;
import fr.eni.project.dal.customer.UserDAO;
import fr.eni.project.dal.customer.UserDAOFact;
import fr.eni.project.errors.ExceptionBLL;
import fr.eni.project.errors.ExceptionDAO;

/**
 * @author Alban
 * @category BLL Implementation
 */
class UserManagerImpl implements UserManager {

	UserDAO userDaoManager = UserDAOFact.getInstance();


	/*
	 * {Création et insertion d'un nouvel utilisateur dans la BDD}
	 * 
	 * @see fr.eni.project.bll.CustomerManager #insertCustomer	 * 
	 * @see fr.eni.project.dal.CustomerDAO #insertCustomer
	 */
	@Override
	public void createUser(User user) throws ExceptionDAO, ExceptionBLL {
		if (userDaoManager.getAllCustomer() != null) {

			// Vérifier si pseudo déjà présent
			if (userDaoManager.getAllCustomer().stream().filter(c -> user.getPseudo().equalsIgnoreCase(c.getPseudo()))
					.count() > 0) {
				throw new ExceptionBLL("Pseudo déjà utilisé");
			}

			// Vérifier si e-mail déjà utilisé
			else if (userDaoManager.getAllCustomer().stream()
					.filter(c -> user.getEmail().equalsIgnoreCase(c.getEmail())).count() > 0) {
				throw new ExceptionBLL("E-mail déjà utilisé");
			} else if (!isGoodMail(user.getEmail())) {
				throw new ExceptionBLL("E-mail incorrect");
			}

			// Vérifié si pseudo en alphanumérique
			else if (!isAlphaNumeric(user.getPseudo())) {
				throw new ExceptionBLL(
						"Votre pseudo ne peut seulement contenir que des majuscules, minuscules et chiffres");
			}

			// Si tout est Ok, insère dans la BDD
			else {

				try {
					userDaoManager.insertCustomer(user);
				} catch (Exception e) {
					throw new ExceptionBLL("Problème d'insertion dans la BLL");
				}
			}
		}
	}

	/* {select "user" from Utilisateurs}
	 * 
	 * @see fr.eni.project.bll.user.UserManager	#selectUser(fr.eni.project.bo.User)
	 */
	@Override
	public User selectUser(User user) throws ExceptionDAO, ExceptionBLL {
		// TODO Créer la méthode dans la DAO
//		userDaoManager.selectUser(user);
		return user;
	}

	
	/*
	 * {Modification de l'utilisateur "user" dans la BDD}
	 * 
	 * @see fr.eni.project.bll.CustomerManager #modifyCustomer
	 * @see fr.eni.project.dal.CustomerDAO #modifyCustomer
	 */
	@Override
	public void updateUser(User user) throws ExceptionDAO, ExceptionBLL {
		try {
			userDaoManager.modifyCustomer(user);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème d'insertion dans la BLL");
		}
	}

	/*
	 * {Suppression de l'utilisateur "customer" dans la BDD}
	 * 
	 * @see fr.eni.project.bll.CustomerManager #deleteCustomer
	 * @see fr.eni.project.dal.CustomerDAO #deleteCustomer
	 */
	@Override
	public void deleteUser(User user) throws ExceptionDAO, ExceptionBLL {
		try {
			userDaoManager.deleteCustomer(user);
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de suppression dans la BLL");
		}
	}

	

	/*
	 * {Récupération de la liste de tous les utilisateurs présent dans la BDD}
	 * 
	 * @see fr.eni.project.bll.CustomerManager #getAllCustomer
	 * @see fr.eni.project.dal.CustomerDAO #getAllCustomer
	 */
	@Override
	public List<User> getAllUsers() throws ExceptionBLL {
		try {
			return userDaoManager.getAllCustomer();
		} catch (Exception e) {
			throw new ExceptionBLL("Problème de récupération des utilisateurs dans la BLL");
		}
	}

	@Override
	public Boolean userExists(String identifiant, String pass) throws ExceptionBLL {
		Boolean flag = false;
		List<User> list = new ArrayList<>();
		try {
			list = userDaoManager.getAllCustomer();
		} catch (ExceptionDAO e) {
			throw new ExceptionBLL("Récupération de la liste impossible");
		}
		for (User u : list) {
			if (
		    ((identifiant.equals(u.getEmail())) && (pass).equals(u.getMotDePasse())) || 
		    ((identifiant.equals(u.getPseudo())) && (pass).equals(u.getMotDePasse()))){
				flag = true;
			}
		}
		return flag;
	}

	

	/* 
	 * Vérification si pseudo OU mail == identifiant
	 * ET SI pass == motDePasse de l'utilisateur
	 * 
	 * CONNECTE L'UTILISATEUR A SON COMPTE VIA SERVLET
	 * 
	 * @see fr.eni.project.bll.customer.CustomerManager
	 * #haveAccount(java.lang.String, java.lang.String)
	 */
	@Override
	public User connectUser(String identifiant, String pass) throws ExceptionDAO, ExceptionBLL {
		List<User> list = userDaoManager.getAllCustomer();
		User user = null;		
		
		if (list.stream()
		.filter(c-> (identifiant.equals(c.getNom())) && (pass).equals(c.getMotDePasse()) || 
			    (identifiant.equals(c.getEmail())) && (pass).equals(c.getMotDePasse()) || 
			    (identifiant.equals(c.getPseudo())) && (pass).equals(c.getMotDePasse()))
				.count() >0) {
			user = list.stream()
					.filter(c-> (identifiant.equals(c.getNom())) && (pass).equals(c.getMotDePasse()) || 
				    (identifiant.equals(c.getEmail())) && (pass).equals(c.getMotDePasse()) || 
				    (identifiant.equals(c.getPseudo())) && (pass).equals(c.getMotDePasse()))
			.collect(Collectors.toList())
			.get(0);
			System.out.println("user ManagerI => " + user);
		}
		else {
			throw new ExceptionBLL ("Identifiants incorrects");			
		}
		return user;
	}

	

	/**
	 * @param Pseudo
	 *            de l'utilisateur
	 * @return TRUE si pseudo en AlphaNumérique
	 */
	@Override
	public boolean isAlphaNumeric(String pseudo) {
		return pseudo.matches("^[a-zA-Z0-9]+$");
	}

	/**
	 * @param mail
	 * @return TRUE si mail de la forme xxx@xxx.xxx
	 */
	@Override
	public Boolean isGoodMail(String mail) {
		return Pattern
				.compile("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$")
				.matcher(mail)
				.matches();

		/*
		 * (EXPRESSION SIMPLIFIEE DE CE QUI SUIT) * String regex =
		 * "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		 * Pattern pattern = Pattern.compile(regex); Matcher matcher =
		 * pattern.matcher(mail); * return matcher.matches();
		 */
	}

}
