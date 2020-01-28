package fr.eni.project.dal.settings;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class JdbcTools {
//	private static Connection con;
//
//	public static Connection getConnection() throws SQLException {
//		try {
//			Class.forName(Settings.getProperty("driverjdbc"));
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		if (con == null) {
//			con = DriverManager.getConnection(Settings.getProperty("url"), Settings.getProperty("user"),
//					Settings.getProperty("password"));
//		}
//		return con;
//	}
//
//	public static void closeConnection() throws SQLException {
//		if (con != null) {
//			con.close();
//			con = null;
//		}
//	}

	private static DataSource dataSource;

	/**
	 * Au chargement de la classe, la DataSource est recherchée dans l'arbre JNDI
	 */
	static {
		Context context;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			//dataSource = (DataSource) context.lookup(context.);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}

	/**
	 * Cette méthode retourne une connection opérationnelle issue du pool de
	 * connexion vers la base de données.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}