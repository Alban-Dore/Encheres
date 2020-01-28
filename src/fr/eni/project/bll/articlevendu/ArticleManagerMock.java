/**
 * 
 */
package fr.eni.project.bll.articlevendu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.eni.project.bo.ArticleVendu;
import fr.eni.project.bo.User;

/**
 * @author adore2019
 *
 */
public class ArticleManagerMock implements ArticleManager {
	
	List<ArticleVendu> list = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public ArticleManagerMock(){
		try {
			list.add(new ArticleVendu(1, "Crayon bleu multicolore", "Crayon bleu mais multicolore pour faire joli", sdf.parse("20/09/2019"), sdf.parse("28/09/2019"), 150, null, 1, 2));
			list.add(new ArticleVendu(2, "25 Pièces d'or", "25 PO pour que Bibiche puisse acheter sa monture lvl 40", sdf.parse("29/09/2019"), sdf.parse("30/09/2019"), 10, null, 2, 2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	@Override
	public void createArticle(ArticleVendu article) {
		list.add(article);
	}

	@Override
	public void updateArticle(ArticleVendu article) {
		list.removeIf(e->e.getNoArticle()==article.getNoArticle());
		list.add(article);
	}

	@Override
	public void deleteArticle(ArticleVendu article) {
		list.remove(article);
	}

	@Override
	public List<ArticleVendu> getAllArticle() {
		return list;
	}

	@Override
	public List<ArticleVendu> selectByCategorie(Integer noCategorie) {
		List<ArticleVendu> listByCategorie = new ArrayList<>();
		for (ArticleVendu article : list) {
			if (article.getNoCategorie()== noCategorie) {
				listByCategorie.add(article);
			}
		}
		return listByCategorie;
	}

	@Override
	public List<ArticleVendu> selectById(Integer noArticle) {
		List<ArticleVendu> listById = new ArrayList<>();
		for (ArticleVendu article : list) {
			if (article.getNoArticle()== noArticle) {
				listById.add(article);
			}
		}
		return listById;
	}

	@Override
	public List<ArticleVendu> selectByName(String name) {
		List<ArticleVendu> listByName = new ArrayList<>();
		for (ArticleVendu article : list) {
			if (article.getNomArticle().contains(name)) {
				listByName.add(article);
			}
		}
		return listByName;
	}

	@Override
	public List<ArticleVendu> selectEnchereFromUser(User user) {
		List<ArticleVendu> listByEnchere = new ArrayList<>();
		for (ArticleVendu article : list) {
			if (article.getNoUtilisateur() == user.getNoUtilisateur()) {
				listByEnchere.add(article);
			}
		}
		return listByEnchere;
	}

	@Override
	public String getCategorie(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
