<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styleSignin.css">
<title>Mon Profil</title>
</head>
<body>
<!--  Diapo 5 -->
	<%@include file="header.jsp" %>
	
	<form class="formulaire" action="${pageContext.request.contextPath}/EditProfileServlet" method="POST">
		<div class="champs">
			<div class="label_gauche">
				<label for="pseudo">Pseudo:</label> 
				<label for="nom">Nom: </label>
				<label for="prenom">Prénom:</label> 
				<label for="email">Email:</label>
				<label for="telephone">Téléphone:</label> 
				<label for="rue">Rue:</label> 
				<label for="codepostal">Code Postal:</label> 
				<label for="ville">Ville: </label>
			</div>

			<div class="label_droite">
				<label for="pseudo">${sessionScope.modele.user.pseudo}</label> 
				<label for="nom">${sessionScope.modele.user.nom}</label>
				<label for="prenom">${sessionScope.modele.user.prenom}</label> 
				<label for="email">${sessionScope.modele.user.email}</label>
				<label for="telephone">${sessionScope.modele.user.telephone}</label> 
				<label for="rue">${sessionScope.modele.user.rue}</label>
				<label for="codepostal">${sessionScope.modele.user.codePostal}</label> 
				<label for="ville">${sessionScope.modele.user.ville}</label>
			</div>
		</div>
		<div class="buttons">
			<input type="submit" class="boutonOk" name="BTeditProfile" value=" Modifier ">
		</div>
	</form>
</body>
</html>