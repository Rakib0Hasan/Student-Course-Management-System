<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
<title>Help</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<header>
		<jsp:include page="common/header.jsp" />
	</header>
	
	<main>
		<aside class="left-sidebar">
			<p>This is left sidebar.</p>
		</aside>
		
		<section class="main-content">
			<h3>This is the help page.</h3>
		</section>
		
		<aside class="right-sidebar">
			<p>This is right sidebar</p>
		</aside>
	</main>
	
	<footer>
		<jsp:include page="common/footer.jsp" />
	</footer>
</body>
</html>