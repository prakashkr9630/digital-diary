<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%if (request.getAttribute("error") != null) {%>
			Error:<%=request.getAttribute("error")%>
		<%}%>

		
		<c:if test="${!empty related}">
		<h1><b>Related Content</b></h1>
		<!-- <h2>List Article</h2> -->
	<table align="left" border="1">
		<tr>
			<th>Article ID</th>
			<!-- <th>Date</th>		 -->	
			<!-- <th>Category</th> -->
			<th>Title</th>			
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${related}" var="article">
			<tr>
				<td><c:out value="${article.id}"/></td>
				<%-- <td><c:out value="${article.date}"/></td> --%>
				<%-- <td><c:out value="${article.catname}"/></td> --%>
				<td><c:out value="${article.title}"/></td>								
				<td align="center"><a href="view.html?id=${article.id}">View</a></td>
			</tr>
			
		</c:forEach>
	</table>
</c:if>




</body>
</html>