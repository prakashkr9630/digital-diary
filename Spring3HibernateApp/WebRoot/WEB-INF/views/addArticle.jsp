<%@page import="com.ibm.icu.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Article</title>
<script>
	function counter(msg) {
		document.getElementById('counter_div').innerHTML = msg.value.length;
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2>Add Article</h2>

	<form:form method="POST" action="/sdnext/save.html"
		commandName="article">
		
		<%if (request.getAttribute("error") != null) {%>
			Error:<%=request.getAttribute("error")%>
		<%}%>
		<table>
			<tr>
				<td><form:label path="id">Category:</form:label></td>
				<td><select name="catname">
						<c:forEach items="${cats}" var="cat">
							<option value="${cat.name}">${cat.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><form:label path="id">ID:</form:label></td>
				<td><form:input path="id" value="${article.id}" readonly="true" /></td>
				<td><form:label path="date" value="${article.date}"
						readonly="true" />Date:<%=new SimpleDateFormat("dd.MM.yy").format(new Date())%></td>

			</tr>
			<tr>
				<td><form:label path="title">Title:</form:label></td>
				<td><form:input path="title" value="${article.title}" size="50" /></td>
				<td><div id="counter_div" align="right"></div></td>
			</tr>			
			<tr>
				<td></td>
				<td><form:textarea path="articletext"
						value="${article.articletext}" rows="30" cols="110"
						onkeyup="counter(this);" /></td>

			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Submit Article" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>