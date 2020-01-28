
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="styleSignin.css">
<title>Insert title here</title>
</head>
<body>

<%@include file="header.jsp" %>
	
	
	<h1>Mon profil</h1>
	
	  <label class="error">${modeleSignin.error}</label>
      <form class="formulaire" action="${pageContext.request.contextPath}/SignInServlet" method="POST">
      	
        <div class="champs">
             <div class="label_gauche">
                   <label for="pseudo">Pseudo : </label>
                   <label for="prenom">Prénom :</label>
                   <label for="telephone">Téléphone :</label>
                   <label for="codepostal">Code Postal :</label>
                    <label for="pass">Password :</label>
            </div>

             <div class="gauche">
                    <input tabindex=1 class="input" type="text" name="pseudo" autofocus="autofocus">
                    <input tabindex=3 class="input" type="text" name="prenom">
                    <input tabindex=5 class="input" type="text" name="telephone">
                    <input tabindex=7 class="input" type="number" name="codepostal">
                    <input tabindex=9 class="input" type="password" name="pass">
              </div>

              <div class="label_droite">
                     <label for="nom">Nom :</label>
                     <label for="email">Email :</label>
                     <label for="rue">Rue :</label>
                     <label for="ville">Ville :</label>
                     <label for="passconfirm">Confirmation :</label>
              </div>
              <div class="droite">
                    <input tabindex=2 class="input" type="text" name="nom" value="">
                    <input tabindex=4 class="input" type="email" name="email" value="">
                    <input tabindex=6 class="input" type="text" name="rue" value="">
                    <input tabindex=8 class="input" type="text" name="ville" value="">
                    <input tabindex=10 class="input" type="password" name="passconfirm" value="">
              </div>
        </div>
              <div class="buttons">
                    <input tabindex=12 type="submit" class="bt boutonCancel" name="BTcreer" value=" Créer ">
                    <input tabindex=11 type="submit" class="bt boutonOk" name="BTcancel" value=" Annuler ">
              </div>
      </form>
	
</body>
</html>