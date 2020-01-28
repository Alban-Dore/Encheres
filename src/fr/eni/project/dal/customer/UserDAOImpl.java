package fr.eni.project.dal.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.User;
import fr.eni.project.dal.DBAccess.DBA;
import fr.eni.project.dal.DBAccess.DBAFact;
import fr.eni.project.errors.ExceptionDAO;

class UserDAOImpl implements UserDAO {
	private static final String INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GETALL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS";
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String UPDATE = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur = ?";

	DBA dba = DBAFact.getInstance();

	// Insert of a new customer in the database.
	@Override
	public User insertCustomer(User customer) throws ExceptionDAO {

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, customer.getPseudo());
			rqt.setString(2, customer.getNom());
			rqt.setString(3, customer.getPrenom());
			rqt.setString(4, customer.getEmail());
			rqt.setString(5, customer.getTelephone());
			rqt.setString(6, customer.getRue());
			rqt.setInt(7, customer.getCodePostal());
			rqt.setString(8, customer.getVille());
			rqt.setString(9, customer.getMotDePasse());
			rqt.setInt(10, customer.getCredit());
			rqt.setString(11, customer.getAdministrateur());
			int nb = rqt.executeUpdate();
			if (nb > 0) {
				// R�cup�ration de l'identifiant
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					customer.setNoUtilisateur(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème d'insertion en Base de données");
		}
		return customer;
	}

	// Get the whole list of customers in the database.
	@Override
	public List<User> getAllCustomer() throws ExceptionDAO {
		List<User> result = new ArrayList<>();

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(GETALL);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				User customer = new User();
				customer.setNoUtilisateur(rs.getInt("no_utilisateur"));
				customer.setPseudo(rs.getString("pseudo"));
				customer.setNom(rs.getString("nom"));
				customer.setPrenom(rs.getString("prenom"));
				customer.setEmail(rs.getString("email"));
				customer.setTelephone(rs.getString("telephone"));
				customer.setRue(rs.getString("rue"));
				customer.setCodePostal(rs.getInt("code_postal"));
				customer.setVille(rs.getString("ville"));
				customer.setMotDePasse(rs.getString("mot_de_passe"));
				customer.setCredit(rs.getInt("credit"));
				customer.setAdministrateur(rs.getString("administrateur"));
				result.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème de récupération en Base de données");
			}
		return result;
	}

	// Delete a customer from the database.
	@Override
	public void deleteCustomer(User customer) throws ExceptionDAO {

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(DELETE);
			rqt.setInt(1, customer.getNoUtilisateur());
			rqt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème dde suppression en Base de données");
			}
	}

	// Apply changes on a customer in the database.
	@Override
	public void modifyCustomer(User customer) throws ExceptionDAO {

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(UPDATE);
			rqt.setString(1, customer.getPseudo());
			rqt.setString(2, customer.getNom());
			rqt.setString(3, customer.getPrenom());
			rqt.setString(4, customer.getEmail());
			rqt.setString(5, customer.getTelephone());
			rqt.setString(6, customer.getRue());
			rqt.setInt(7, customer.getCodePostal());
			rqt.setString(8, customer.getVille());
			rqt.setString(9, customer.getMotDePasse());
			rqt.setInt(10, customer.getCredit());
			rqt.setString(11, customer.getAdministrateur());
			rqt.setInt(12, customer.getNoUtilisateur());
			rqt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème de modification en Base de données");
			}
	}
}
