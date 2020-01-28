package fr.eni.project.ihm.modele;

import fr.eni.project.bo.User;

public class SignInModele {

	private String error;
	private User user;

	public SignInModele() {
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SignInModele [error=" + error + ", user=" + user + "]";
	}


	
}
