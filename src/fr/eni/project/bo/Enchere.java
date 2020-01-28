/**
 * 
 */
package fr.eni.project.bo;

import java.util.Date;

/**
 * @author adore2019
 *
 */
public class Enchere {

	/**
	 * {values}
	 */
	Integer noUtilisateur;
	Integer noArticle;
	Date dateEnchere;
	Integer prixEnchere;

	/**
	 * {Empty Constructor}
	 */
	public Enchere() {
		super();
	}

	/**
	 * {Full Constructor}
	 * 
	 * 
	 */
	public Enchere(Date dateEcnhere, Integer prixEnchere) {
		super();
		this.dateEnchere = dateEcnhere;
		this.prixEnchere = prixEnchere;
	}
	

	public Enchere(Integer noUtilisateur, Integer noArticle, Date dateEcnhere, Integer prixEnchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEcnhere;
		this.prixEnchere = prixEnchere;
	}

	/**
	 * {Getters & Setters}
	 */


	public Date getDateEnchere() {
		return dateEnchere;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public void setDateEnchere(Date dateEcnhere) {
		this.dateEnchere = dateEcnhere;
	}

	public Integer getPrixEnchere() {
		return prixEnchere;
	}

	public void setPrixEnchere(Integer prixEnchere) {
		this.prixEnchere = prixEnchere;
	}

	@Override
	public String toString() {
		return "     *** Enchere ***\nDébut: " + dateEnchere + "\n" + prixEnchere + " points.";
	}
	

}
