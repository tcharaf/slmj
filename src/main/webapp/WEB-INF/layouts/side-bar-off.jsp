<html xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:tiles="http://tiles.apache.org/tags-tiles" xmlns:spring="http://www.springframework.org/tags" xmlns:util="urn:jsptagdir:/WEB-INF/tags/util" >  

	<jsp:output doctype-root-element="HTML" doctype-system="about:legacy-compat" />

	<jsp:directive.page contentType="text/html;charset=UTF-8" />
	<jsp:directive.page pageEncoding="UTF-8" /> 

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>${applicationName}</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<script src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
		<link href='<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
		<tiles:insertAttribute name="head" ignore="true" />
	</head>

	<body>
		<div id="wrapper">
			<tiles:insertAttribute name="header" ignore="true" />
			<div id="main">
				<tiles:insertAttribute name="body"/> 
				<tiles:insertAttribute name="footer" ignore="true"/>
			</div>
		</div>
	</body>
</html>
