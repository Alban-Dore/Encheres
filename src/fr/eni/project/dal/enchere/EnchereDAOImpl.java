package fr.eni.project.dal.enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.Enchere;
import fr.eni.project.bo.User;
import fr.eni.project.dal.DBAccess.DBA;
import fr.eni.project.dal.DBAccess.DBAFact;
import fr.eni.project.errors.ExceptionDAO;

class EnchereDAOImpl implements EnchereDAO {

	private static final String INSERT = "INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?,?,?,?)";
	private static final String GETALL = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES";

	DBA dba = DBAFact.getInstance();

	@Override
	public void insertEnchere(User user, ArticleVendu article, Enchere enchere) throws ExceptionDAO {
		// select article where noArticle = article.getNuméro
		// et tu modifie cet article pour lui inserér une enchère
		// et on ajoute cette enchere dans la liste des enchere de cet article
		try (Connection con = dba.getConnection()){
			PreparedStatement rqt = con.prepareStatement(INSERT);
			//rqt.setInt(1, enchere.getNoUtilisateur());
			rqt.setInt(1, user.getNoUtilisateur());
			rqt.setInt(2, article.getNoArticle());
			rqt.setDate(3, new java.sql.Date(enchere.getDateEnchere().getTime()));
			rqt.setInt(4, enchere.getPrixEnchere());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}
	}

	@Override
	public List<Enchere> getAllEnchere() throws ExceptionDAO {
		List<Enchere> result = new ArrayList<>();

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(GETALL);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				Enchere enchere = new Enchere();
				enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setNoArticle(rs.getInt("no_article"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setPrixEnchere(rs.getInt("montant_enchere"));
				result.add(enchere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}
		return result;
	}

	@Override
	public List<Enchere> getAllEnchereFromArticle(ArticleVendu article) throws ExceptionDAO {
		// TODO implémenter getAllEnchereFromArticle DAO IMPL
		return null;
	}

}
