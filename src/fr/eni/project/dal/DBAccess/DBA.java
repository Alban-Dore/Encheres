package fr.eni.project.dal.DBAccess;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBA {
	public Connection getConnection() throws SQLException;
}
