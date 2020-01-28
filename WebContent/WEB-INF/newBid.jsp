<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styleSignin.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>

<h1>JSP CREER ENCHERE</h1>

<label>Affichage pour la création d'une enchère</label>
<label>Diapo 7</label>

<!--  Ancré a gauche -->
<!--  + voir header ? -->
<br>
<label>ENI - Enchères</label>

<%@include file="logo.jsp" %>



<br>

<!--  Ancré a droite -->
<form action="${pageContext.request.contextPath}/NewBidServlet" method="POST">
<div>
<label for="article">Article: </label>
<input type="text" name="nomArticle">
</div>
<div>
<label for="description">Description: </label>
<input type="text" name="description">
</div>
<div>
<label for="categorie">Catégorie: </label>
<select id="categorie">
    <option value="all">Toutes</option>
    <option value="ameublement">Ameublement</option>
    <option value="informatique">Informatique</option>
    <option value="sport&Loisirs">Sport & Loisirs</option>
    <option value="vetement">Vêtement</option>
</select>
</div>
<div>
<label for="photo">Photo: </label>
<input type="file" name="photo">
</div>
<div>
<label for="miseAPrix">Mise à prix: </label>
<input type="text" name="miseAPrix">
</div>
<div>
<label for="dateDebutEnchere">Début de l'enchère: </label>
<input type="date" name="dateDebutEnchere">
</div>
<div>
<label for="dateFinEnchere">Fin de l'enchère: </label>
<input type="date" name="dateFinEnchere">
</div>



            <fieldset>
                <legend>Retrait</legend>
                <div>
                    <label for="rue">Rue:</label>
                    <input type="text" name="rue" placeholder="Adresse" required>
                </div>
                <div>
                    <label for="codePostal">Code postal:</label>
                    <input type="text" name="codePostal" placeholder="29000" required>
                </div>
                    <label for="ville">Ville:</label>
                    <input type="text" name="ville" placeholder="Ville" required>
                </div>    
            </fieldset>


	<input type="submit" name="BTCreer" value="Enregistrer">
	<input type="submit" name="BTCancel" value="Annuler">
</form>

</body>
</html>