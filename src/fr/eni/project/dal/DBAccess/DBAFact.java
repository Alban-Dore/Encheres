package fr.eni.project.dal.DBAccess;

//Use DBALocal when tests are done with TestDAO.
//Use DBAProd when using IHM (Tomcat).

public class DBAFact {
	public static DBA getInstance() {
		return new DBALocal();
	}
}
