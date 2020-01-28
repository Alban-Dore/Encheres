package fr.eni.project.ihm.modele;

import fr.eni.project.bo.User;

public class LoginModele {

	private User user;
	private String error;

	public LoginModele() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "LoginModele [user=" + user + ", error=" + error + "]";
	}



}
