/**
 * 
 */
package fr.eni.project.bo;

import java.util.Date;

/**
 * @author adore2019
 *
 */
public class ArticleVendu {
	
	Integer noArticle;
	String nomArticle;
	String description;
	Date dateDebutEnchere;
	Date dateFinEnchere;
	Integer prixInitial;
	Integer prixVente;
	Integer noUtilisateur;
	Integer noCategorie;
	
	
	
	
	

	public ArticleVendu(String nomArticle, String description, Date dateDebutEnchere, Date deateFinEnchere,
			Integer prixInitial, Integer prixVente, Integer noUtilisateur, Integer noCategorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = deateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Date dateDebutEnchere,
			Date deateFinEnchere, Integer prixInitial, Integer prixVente, Integer noUtilisateur, Integer noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = deateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}
	public ArticleVendu() {
		super();
	}
	
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Integer noCategorie,
			Integer prixInitial) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.prixInitial = prixInitial;
		this.noCategorie = noCategorie;	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(Date deateFinEnchere) {
		this.dateFinEnchere = deateFinEnchere;
	}

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", deateFinEnchere=" + dateFinEnchere + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
				+ noCategorie + "]";
	}

	
	
	

}
