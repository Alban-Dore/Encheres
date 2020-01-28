<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="header.jsp" %>
</head>
<body>

<h1>JSP LIST ENCHERES</h1>
<label>Affichage de la liste d'enchères</label>
<br>
<label>Diapo 1 + Diapo 4 (condition)</label>

<br>
<!--  CSS A METTRE EN PLACE -->
<!--  CSS A METTRE EN PLACE -->
<!--  CSS A METTRE EN PLACE -->
<br>



<form action="#" method="GET">

<label>Filtres: </label>

<br>

<input type="search" id="site-search" name="searchBox" aria-label="Rechercher">
<input type="submit" name="searchBox" value="Rechercher">

<br>

<label>Catégorie:</label>
<select id="categorie">
    <option value="">Toutes</option>
    <option value="ameublement">Ameublement</option>
    <option value="informatique">Informatique</option>
    <option value="sport&Loisirs">Sport & Loisirs</option>
    <option value="vetement">Vêtement</option>
</select>

<br>
<br>
<br>

<!--  LORS DE CLIQUE SUR ACHATS METTRE CHECKBOX MES VENTES EN DISABLE -->
<!--  METTRE CHECKBOX MES VENTES EN DISABLE -->
<!--  ET INVERSEMENT -->

Achats<input type="radio" name="radio">

<br>

<div>
  <input type="checkbox" name="achatOuvertes">
  <label for="ouvertes">
enchères ouvertes</label>
</div>
<div>
  <input type="checkbox" name="achatEnCours">
  <label for="enCours">
mes enchères en cours</label>
</div>
<div>
  <input type="checkbox" name="achatRemportes">
  <label for="remportes">
mes enchères remportées</label>
</div>


<br>
<br>


Mes ventes<input type="radio" name="radio">

<br>

<div>
  <input type="checkbox" name="ventesEnCours">
  <label for="ventesEnCours">
mes ventes en cours</label>
</div>
<div>
  <input type="checkbox" name="ventesNonDebuteez">
  <label for="ventesNonDebuteez">
ventes non débutées</label>
</div>
<div>
  <input type="checkbox" name="ventesTerminees">
  <label for="ventesTerminees">
ventes terminées</label>
</div>
</form>

<br>

<label>*** Ici s'affichera la liste des enchères ***</label>
</body>
</html>