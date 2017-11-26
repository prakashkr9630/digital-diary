<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Article</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<form:form method="POST" action="/edit.html" commandName="article">
		<table>
			<tr>
				<td><form:label path="id">Category:</form:label></td>
				<td><form:input path="catname" value="${article.catname}" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="id">ID:</form:label></td>
				<td><form:input path="id" value="${article.id}" readonly="true" /></td>
				<td><form:input path="date" value="${article.date}" readonly="true"/></td>				
			</tr>

			<tr>
				<td><form:label path="title">Title:</form:label></td>
				<td><form:input path="title" value="${article.title}" size="50" readonly="true"/></td>
				
															
				<td><a href="htmlview.html?id=${article.id}" target="_blank">Html view</a></td>																
			</tr>

			<tr>
				<td><form:label path="articletext"><!-- Article: --></form:label></td>
				<td><form:textarea path="articletext" rows="30" cols="100" readonly="true"/></td>
				<td><%@ include file="listRelatedArticle.jsp"%></td>												
			</tr>			
			<tr>
			<td></td>
			<td></td>
				<td><%@ include file="listRelatedUrl.jsp"%></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>
