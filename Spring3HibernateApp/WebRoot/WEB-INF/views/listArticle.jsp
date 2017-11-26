<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.ParseException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article list</title>
</head>
<body>

<%@ include file = "header.jsp" %>

<c:if test="${!empty articles}">
		<h2>List Article</h2>
	<table align="left" border="1">
		<tr>
			<th>Article ID</th>
			<th>Date</th>			
			<th>Category</th>
			<th>Title</th>			
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${articles}" var="article">		
		<c:set var = "now" value = '<%=new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>'/>     
		<c:if test = "${article.date==now}">
			<tr bgcolor="#90EE90">
				<td><c:out value="${article.id}"/></td>
				<td><c:out value="${article.date}"/></td>
				<td><c:out value="${article.catname}"/></td>
				<td><c:out value="${article.title}"/></td>								
				<td align="center"><a href="edit.html?id=${article.id}">Edit</a> | <a href="delete.html?id=${article.id}">Delete</a> | <a href="view.html?id=${article.id}">View</a></td>
			</tr></c:if>														
			<c:if test="${article.date!=now}">			
			<tr bgcolor="#D3D3D3">
				<td><c:out value="${article.id}"/></td>
				<td><c:out value="${article.date}"/></td>
				<td><c:out value="${article.catname}"/></td>
				<td><c:out value="${article.title}"/></td>								
				<td align="center"><a href="edit.html?id=${article.id}">Edit</a> | <a href="delete.html?id=${article.id}">Delete</a> | <a href="view.html?id=${article.id}">View</a></td>
			</tr>
			</c:if>			
		</c:forEach>
	</table>
</c:if>
 
</body>
</html>
