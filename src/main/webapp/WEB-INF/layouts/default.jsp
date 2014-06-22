<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<title>${applicationName}</title>
		<link href='<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet"></link>
		<link href='<c:url value="/resources/styles/offcanvas.css"/>' rel="stylesheet"></link>
		<tiles:insertAttribute name="head" ignore="true" />
	</head>

	<body>
		<tiles:insertAttribute name="header" ignore="true" />
		<div class="container">
			<tiles:insertAttribute name="body"/> 
			<tiles:insertAttribute name="footer" ignore="true"/>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
		<script src='<c:url value="/resources/scripts/offcanvas.js"/>'></script>
	</body>
</html>