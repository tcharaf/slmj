<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Categories Body</h1>
<c:forEach var="category" items="${categories}">
	<a href="/categories/${category.categoryPermalink}">${category.categoryName}</a>
</c:forEach>