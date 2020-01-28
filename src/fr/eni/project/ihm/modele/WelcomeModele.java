package fr.eni.project.ihm.modele;

import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.ArticleVendu;

public class WelcomeModele {

	List<ArticleVendu> lstArticle = new ArrayList<>();

	public WelcomeModele() {
	}

	public List<ArticleVendu> getLstArticle() {
		return lstArticle;
	}

	public void setLstArticle(List<ArticleVendu> lstArticle) {
		this.lstArticle = lstArticle;
	}

	@Override
	public String toString() {
		return "WelcomeModele [lstArticle=" + lstArticle + "]";
	}


}
