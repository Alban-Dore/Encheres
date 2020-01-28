/**
 * 
 */
package fr.eni.project.bo;

/**
 * @author Alban
 * @category Object
 */

public class Retrait {
	
	/**
	 * {values}
	 */
	Integer noArticle;
	String rue;
	Integer codePsotal;
	String ville;
	/**
	 * {Full Constructor}
	 * 
	 * @param noArticle
	 * @param rue
	 * @param codePsotal
	 * @param ville
	 */
	public Retrait(String rue, Integer codePsotal, String ville) {
		super();
		this.rue = rue;
		this.codePsotal = codePsotal;
		this.ville = ville;
	}
	
	
	
	public Retrait(Integer noArticle, String rue, Integer codePsotal, String ville) {
		super();
		this.noArticle = noArticle;
		this.rue = rue;
		this.codePsotal = codePsotal;
		this.ville = ville;
	}



	/**
	 * {Empty Constructor}
	 */
	public Retrait() {
		super();
	}

	/**
	 * {Getters & Setters}
	 */

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public Integer getCodePsotal() {
		return codePsotal;
	}
	public void setCodePsotal(Integer codePsotal) {
		this.codePsotal = codePsotal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "     *** Retrait ***\n" + rue + "\n" + codePsotal + " - " + ville;
	}
	
	
	
	

}
