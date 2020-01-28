package fr.eni.project.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alban
 * @category Object
 */

public class User {

	/**
	 * {values}
	 */
	private Integer noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private Integer codePostal;
	private String ville;
	private String motDePasse;
	private Integer credit;
	private String administrateur;
	
	private List<Enchere> list = new ArrayList<>();

	/**
	 * {Full Constructor}
	 * 
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 */
	
	public User(Integer noUtilisateur,String pseudo,String nom,String prenom,String email,String telephone,String rue,Integer codePostal,String ville,String motDePasse){
		this.noUtilisateur= noUtilisateur;
		this.pseudo=pseudo;
		this.nom = nom;
		this.prenom= prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 0;
		this.administrateur = "0";
		// TODO déterminer si on doit ajouter des options ou pas
		
	}
	public User(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			Integer codePostal, String ville, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 0;
		this.administrateur = "0";
	}

	
	public User(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			Integer codePostal, String ville, String motDePasse, Integer credit, String administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = 0;
		this.administrateur = "0";
	}

	/**
	 * {Create new Customer from Sign Up} {Constructor}
	 * 
	 * @param email
	 * @param administrateur
	 * @param rue
	 * @param noUtilisateur
	 * @param credit
	 * @param telephone
	 * @param prenom
	 * @param ville
	 * @param nom
	 * @param pseudo
	 * @param codePostal
	 * @param motDePasse
	 */
	public User(String email, String administrateur, String rue, Integer noUtilisateur, Integer credit,
			String telephone, String prenom, String ville, String nom, String pseudo, Integer codePostal,
			String motDePasse) {
		super();
		this.email = email;
		this.administrateur = administrateur;
		this.rue = rue;
		this.noUtilisateur = noUtilisateur;
		this.credit = credit;
		this.telephone = telephone;
		this.prenom = prenom;
		this.ville = ville;
		this.nom = nom;
		this.pseudo = pseudo;
		this.codePostal = codePostal;
		this.motDePasse = motDePasse;
		this.credit = 0;
		this.administrateur = "0";
	}

	/**
	 * {Empty Constructor}
	 */
	public User() {
		super();
		this.credit = 0;
		this.administrateur = "0";
	}
	
	/**
	 * {Getters & Setters}
	 */
	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(String administrateur) {
		this.administrateur = administrateur;
	}


	/*
	 * @see java.lang.Object #toString()
	 */
	@Override
	public String toString() {
		return "     *** Utilisateur ***\nn°" + noUtilisateur + "\nPseudo: " + pseudo + "\nNom: " + nom + "\nPrénom: " + prenom
				+ "\nE-mail: " + email + "\nTél: " + telephone + "\nAdresse: " + rue + "\n" + codePostal
				+ " " + ville + "\nPassword: " + motDePasse + "\nCrédit: " + credit + "\nAdmin: "
				+ administrateur + "\nMes ventes: " + list +"\n----------------";
	}

}
