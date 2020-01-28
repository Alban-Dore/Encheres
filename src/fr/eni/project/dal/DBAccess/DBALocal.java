package fr.eni.project.dal.DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import fr.eni.project.dal.settings.Settings;

//Use DBALocal when tests are done with TestDAO.

class DBALocal implements DBA {

	public Connection getConnection() throws SQLException {
		try {
			Class.forName(Settings.getProperty("driverjdbc"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(Settings.getProperty("url"), Settings.getProperty("user"),
				Settings.getProperty("password"));
	}
}
