<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="styleSignin.css">
<title>Editer Profil</title>
</head>
<body>

<%@include file="header.jsp" %>

	<h1>Mon profil</h1>
	
	  <label class="error">${modeleEP.error}</label>
	  
	  <label class="message">${modeleEP.message}</label>
	  
      <form class="formulaire" action="${pageContext.request.contextPath}/EditProfileServlet" method="POST">
      	
        <div class="champs">
             <div class="label_gauche">
                   <label for="pseudo">Pseudo : </label>
                   <label for="prenom">Prénom :</label>
                   <label for="telephone">Téléphone :</label>
                   <label for="codepostal">Code Postal :</label>
                   <label for="pass">Mot de pass actuel :</label>
                   <label for="newpass">Nouveau mot de passe :</label>
             </div>
                   
             <div class="gauche">
                    <input class="input" type="text" name="pseudo" autofocus="autofocus" value="${sessionScope.modele.user.pseudo}">
                    <input class="input" type="text" name="prenom" value="${sessionScope.modele.user.prenom}">
                    <input class="input" type="text" name="telephone" value="${sessionScope.modele.user.telephone}">
                    <input class="input" type="text" name="codepostal" value="${sessionScope.modele.user.codePostal}">
                    <input class="input" type="password" name="pass" value="">
                    <input class="input" type="password" name="newPass" value="">
              </div>

              <div class="label_droite">
                     <label for="nom">Nom :</label>
                     <label for="email">Email :</label>
                     <label for="rue">Rue :</label>
                     <label for="ville">Ville :</label>
                     <label style="visibility: hidden">P</label>
                     <label for="passconfirm">Confirmation :</label>
              </div>
              <div class="droite">
                    <input class="input" type="text" name="nom" value="${sessionScope.modele.user.nom}">
                    <input class="input" type="text" name="email" value="${sessionScope.modele.user.email}">
                    <input class="input" type="text" name="rue" value="${sessionScope.modele.user.rue}">
                    <input class="input" type="text" name="ville" value="${sessionScope.modele.user.ville}">
                    <input class="input"  style="visibility: hidden" name="pass" value="hidden">
                    <input class="input" type="password" name="passConfirm" value="">
              </div>
        </div>
        <label for="credit">Crédit 	${sessionScope.modele.user.credit} </label>
             
              <div class="buttons">
                    <input type="submit" class="boutonOk" name="BTconfirmEdit" value=" Enregistrer ">
                    <input type="submit" class="boutonCancel" name="BTdeleteAccount" value=" Supprimer mon compte ">
              </div>
              
      </form>

</body>
</html>