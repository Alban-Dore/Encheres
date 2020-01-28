package fr.eni.project.dal.categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.Categorie;
import fr.eni.project.dal.DBAccess.DBA;
import fr.eni.project.dal.DBAccess.DBAFact;
import fr.eni.project.errors.ExceptionDAO;

class CategoriesDAOImpl implements CategoriesDAO {

	private static final String GETALL = "SELECT no_categorie, libelle FROM CATEGORIES";
	private static final String INSERT = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	private static final String DELETE = "DELETE FROM CATEGORIES WHERE no_categorie = ?";
	private static final String UPDATE = "UPDATE CATEGORIES SET libelle=? WHERE no_categorie = ?";

	DBA dba = DBAFact.getInstance();

	@Override
	public List<Categorie> getAllCategories() throws ExceptionDAO {

		List<Categorie> result = new ArrayList<>();

		try (Connection con = dba.getConnection()){
			PreparedStatement rqt = con.prepareStatement(GETALL);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				result.add(categorie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème de récupération des données dans la DAL");
		}
		return result;
	}

	@Override
	public Categorie insertCategorie(Categorie categorie) throws ExceptionDAO {

		try (Connection con = dba.getConnection()){
			PreparedStatement rqt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, categorie.getLibelle());
			int nb = rqt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					categorie.setNoCategorie(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème d'insertion des données dans la DAL");
		}

		return categorie;
	}

	@Override
	public void deleteCategorie(Categorie categorie) throws ExceptionDAO {

		try (Connection con = dba.getConnection()){
			PreparedStatement rqt = con.prepareStatement(DELETE);
			rqt.setInt(1, categorie.getNoCategorie());
			rqt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème de suppression des données dans la DAL");
		}
		
	}

	@Override
	public void modifyCategorie(Categorie categorie) throws ExceptionDAO {

		try (Connection con = dba.getConnection()){
			PreparedStatement rqt = con.prepareStatement(UPDATE);
			rqt.setString(1, categorie.getLibelle());
			rqt.setInt(2, categorie.getNoCategorie());
			rqt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème de modification des données dans la DAL");
		}
		
	}
}
