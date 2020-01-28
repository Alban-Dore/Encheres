<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="logo">
		<%@include file="logo.jsp" %>
	</div>
	<div class="titre">
		<h1>ENI Ench�re</h1>
	</div>
	
	<div class="liens">		
		<!-- Affich� si non logg� -->
		<c:if test="${sessionScope.modele.user==null}">
			<a href="${pageContext.request.contextPath}/SignInServlet">S'inscrire</a>
			<a href="${pageContext.request.contextPath}/LoginServlet">Se Connecter</a>
		</c:if>
		<!-- Affich� si logg� -->
		<c:if test="${sessionScope.modele.user!=null}">
			<a href="${pageContext.request.contextPath}/NewBidServlet">Vendre un article</a>
			<a href="${pageContext.request.contextPath}/MyProfileServlet">Mon profil</a>
			<a href="${pageContext.request.contextPath}/WelcomeServlet?BTdeconnection">D�connection</a>
		</c:if>
	</div>
</header>