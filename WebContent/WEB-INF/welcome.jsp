<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="styleSignin.css">
		<title>Welcome</title>
	</head>
<body>
	<!-- Include de header -->
	<%@include file="header.jsp"%>

	<h2>Welcome</h2>

	<form action="#" method="GET">

		<label>Filtres: </label> <br> 
		
		<input type="search" id="site-search" name="searchBox" aria-label="Rechercher"> 
		<input type="submit" name="BTsearch" value="Rechercher"> <br> <label>Catégorie:</label>
		
		<select id="categorie">
			<option value="">Toutes</option>
			<option value="ameublement">Ameublement</option>
			<option value="informatique">Informatique</option>
			<option value="sport&Loisirs">Sport & Loisirs</option>
			<option value="vetement">Vêtement</option>
		</select> <br> <br> <br>

		<!--  LORS DE CLIQUE SUR ACHATS METTRE CHECKBOX MES VENTES EN DISABLE -->
		<!--  METTRE CHECKBOX MES VENTES EN DISABLE -->
		<!--  ET INVERSEMENT -->


		<!-- 	VERIF SI UTILISATEUR EST LOG OU NON	 -->
		<c:if test="${modele.user!=null}">
 
			Achats<input type="radio" name="radio">


			<br>


			<div>
				<input type="checkbox" name="achatOuvertes"> 
				<label for="ouvertes"> enchères ouvertes</label>
			</div>
			
			<div>
				<input type="checkbox" name="achatEnCours"> 
				<label for="enCours"> mes enchères en cours</label>
			</div>
			
			<div>
				<input type="checkbox" name="achatRemportes">
				<label for="remportes"> mes enchères remportées</label>
			</div>


			<br>
			<br>


			Mes ventes<input type="radio" name="radio">


			<br>



			<div>
				<input type="checkbox" name="ventesEnCours"> 
				<label for="ventesEnCours"> mes ventes en cours</label>
			</div>
			
			<div>
				<input type="checkbox" name="ventesNonDebuteez">
				<label for="ventesNonDebuteez"> ventes non débutées</label>
			</div>
			
			<div>
				<input type="checkbox" name="ventesTerminees"> <label
					for="ventesTerminees"> ventes terminées</label>
			</div>

		</c:if>
	</form>
	<div class="articlelist">
		<c:forEach var="article" items="${modeleWelcome.lstArticle }">
			<div class="article">
				<p> numéro article : ${article.noArticle}</p>
				<p> nom article : ${article.nomArticle}</p>
				<p> description : ${article.description}</p>
				<p> date début Enchère : ${article.dateDebutEnchere}</p>
				<p> date fin Enchère : ${article.dateFinEnchere}</p>
				<p> Prix initial : ${article.prixInitial}</p>
				<p> Prix de Vente : ${article.prixVente}</p>
				<p> Numéro utilisateur : ${article.noUtilisateur}</p>
				<p> Numéro de catégorie : ${article.noCategorie}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>