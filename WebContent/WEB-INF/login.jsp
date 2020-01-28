<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styleSignin.css">
<title>Login</title>
</head>
<body>
	<%@include file="header.jsp" %>

	
	<h1>LOGIN</h1>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
		<div class="label_gauche">
			<label for="identifiant">Identifiant :</label>
			<label for="pass">Mot de passe :</label>
		</div>
		<div class="droite">
			<input type="text" name="identifiant">
			<input type="password" name="pass">
			<input type="submit" name="BTconnection" class="boutonOk" value=" Connection ">
			<input type="checkbox" name="SouviensToi">
			
		</div>
		<label for="SouviensToi">Se souvenir de moi</label>
		<a href="ForgetMdpServlet">Mot de passe oublié</a>
	</form>
	
	<form action="${pageContext.request.contextPath}/SignInServlet">
		<input type="submit" name="BTcreation" class="boutonCancel" value=" Créer un compte ">
	</form>
	<c:if test="${not empty modele.error}">
		<label class="error">${modele.error}</label>
	</c:if>
</body>
</html>