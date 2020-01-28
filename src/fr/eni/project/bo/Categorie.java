package fr.eni.project.bo;

public class Categorie {
	
	private Integer noCategorie;
	private String libelle;

	public Categorie() {
	}

	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer no_categorie) {
		this.noCategorie = no_categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categorie [no_categorie=" + noCategorie + ", libelle=" + libelle + "]";
	}

}
