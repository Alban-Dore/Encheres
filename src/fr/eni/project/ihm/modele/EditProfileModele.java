package fr.eni.project.ihm.modele;

public class EditProfileModele {

	private String error;
	private String message;

	public EditProfileModele() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "EditProfileModele [error=" + error + ", message=" + message + "]";
	}

	
}
