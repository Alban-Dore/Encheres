<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="logo">
		<%@include file="logo.jsp" %>
	</div>
	<div class="titre">
		<h1>ENI Enchère</h1>
	</div>
	
	<div class="liens">		
		<!-- Affiché si non loggé -->
		<c:if test="${sessionScope.modele.user==null}">
			<a href="${pageContext.request.contextPath}/SignInServlet">S'inscrire</a>
			<a href="${pageContext.request.contextPath}/LoginServlet">Se Connecter</a>
		</c:if>
		<!-- Affiché si loggé -->
		<c:if test="${sessionScope.modele.user!=null}">
			<a href="${pageContext.request.contextPath}/NewBidServlet">Vendre un article</a>
			<a href="${pageContext.request.contextPath}/MyProfileServlet">Mon profil</a>
			<a href="${pageContext.request.contextPath}/WelcomeServlet?BTdeconnection">Déconnection</a>
		</c:if>
	</div>
</header>