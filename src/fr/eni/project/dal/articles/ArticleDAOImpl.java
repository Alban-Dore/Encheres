package fr.eni.project.dal.articles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.User;
import fr.eni.project.dal.DBAccess.DBA;
import fr.eni.project.dal.DBAccess.DBAFact;
import fr.eni.project.errors.ExceptionDAO;

class ArticleDAOImpl implements ArticleDAO {
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?,?,?,?,?,?,?,?)";
	private static final String GETALL = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ARTICLES_VENDUS";
	private static final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article = ?";
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=? WHERE no_article =?";
	private static final String SELECT_BY_ID = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ARTICLES_VENDUS WHERE no_article=?";
	private static final String SELECT_BY_CATEGORIE = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur FROM ARTICLES_VENDUS WHERE no_categorie=?";
	private static final String SELECT_BY_NAME = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ARTICLES_VENDUS WHERE nom_article=?";
	private static final String SELECT_BY_USER_ENCHERE = "";
	
	DBA dba = DBAFact.getInstance();

	@Override
	public void insertArticle(ArticleVendu article) throws ExceptionDAO {
		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, article.getNomArticle());
			rqt.setString(2, article.getDescription());
			rqt.setDate(3, new java.sql.Date(article.getDateDebutEnchere().getTime()));
			rqt.setDate(4, new java.sql.Date(article.getDateFinEnchere().getTime()));
			rqt.setDouble(5, article.getPrixInitial());
			rqt.setDouble(6, article.getPrixVente());
			rqt.setInt(7, article.getNoUtilisateur());
			rqt.setInt(8, article.getNoCategorie());
			int nb = rqt.executeUpdate();
			if (nb > 0) {
				// R�cup�ration de l'identifiant
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					article.setNoArticle(rs.getInt(1));
				}
				System.out.println(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}
	}

	@Override
	public void updateArticle(ArticleVendu article) throws ExceptionDAO {

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(UPDATE);
			rqt.setString(1, article.getNomArticle());
			rqt.setString(2, article.getDescription());
			rqt.setDate(3, new java.sql.Date(article.getDateDebutEnchere().getTime()));
			rqt.setDate(4, new java.sql.Date(article.getDateFinEnchere().getTime()));
			rqt.setDouble(5, article.getPrixInitial());
			rqt.setDouble(6, article.getPrixVente());
			rqt.setInt(7, article.getNoUtilisateur());
			rqt.setInt(8, article.getNoCategorie());
			rqt.setInt(9, article.getNoArticle());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}
	}

	@Override
	public void deleteArticle(ArticleVendu article) throws ExceptionDAO {
		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(DELETE);
			rqt.setInt(1, article.getNoArticle());
			rqt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}

	}

	@Override
	public List<ArticleVendu> getAllArticle() throws ExceptionDAO {
		List<ArticleVendu> result = new ArrayList<>();

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(GETALL);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setNoUtilisateur(rs.getInt("no_utilisateur"));
				article.setNoCategorie(rs.getInt("no_categorie"));
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}
		return result;
	}

	@Override
	public List<ArticleVendu> selectByCategorie(Integer noCategorie) throws ExceptionDAO {
		List<ArticleVendu> result = new ArrayList<>();

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(SELECT_BY_CATEGORIE);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setNoUtilisateur(rs.getInt("no_utilisateur"));
				result.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}

		return result;
	}

	@Override
	public ArticleVendu selectById(Integer id) throws ExceptionDAO {
		ArticleVendu result = null;
		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(SELECT_BY_ID);
			rqt.setInt(1, id);
			ResultSet rs = rqt.executeQuery();
			if (rs.next()) {
				result.setNomArticle(rs.getString("nom_article"));
				result.setDescription(rs.getString("description"));
				result.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				result.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				result.setPrixInitial(rs.getInt("prix_initial"));
				result.setPrixInitial(rs.getInt("prix_vente"));
				result.setNoUtilisateur(rs.getInt("no_utilisateur"));
				result.setNoCategorie(rs.getInt("no_categorie"));
			} else {
				throw new ExceptionDAO("Pas d'article avec ce numéro");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}
		return result;
	}

	@Override
	public List<ArticleVendu> selectByName(String name) throws ExceptionDAO {
		List<ArticleVendu> result = new ArrayList<>();

		try (Connection con = dba.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(SELECT_BY_NAME);
			ResultSet rs = rqt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDateDebutEnchere(rs.getDate("date_debut_encheres"));
				article.setDateFinEnchere(rs.getDate("date_fin_encheres"));
				article.setPrixInitial(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setNoUtilisateur(rs.getInt("no_utilisateur"));
				article.setNoCategorie(rs.getInt("no_categorie"));
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Problème avec la base de données");
		}
		return result;
	}

	@Override
	public List<ArticleVendu> selectEnchereFromUser(User user) {
		// TODO selectEnchereFromUser DAO Tous les articles sur lequel l'utilisateur a
		// fait des encheres
		return null;
	}

}
