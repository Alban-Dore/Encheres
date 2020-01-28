package fr.eni.project.ihm.modele;

import fr.eni.project.bo.User;

public class MyProfileModele {
	private User user;

	public MyProfileModele() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "MyProfileModele [user=" + user + "]";
	}

}
