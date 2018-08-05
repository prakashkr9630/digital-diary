<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add rules for this topic</title>
<STYLE TYPE="text/css">
td {
	font-family: Arial;
	font-size: 15pt;
}

input {
	font-family: Arial;
	font-size: 15pt;
}

textarea {
	font-family: imes New Roman;
	font-size: 20pt;
}
</STYLE>
</head>
<body>
	<form name="relatearticle" method="POST"
		action="/sdnext/addrulefortopic.html">

		<p>
			<font size="10"><%=request.getParameter("id")%>;</font>
			<td><input  name="title" /></td>
			
		</p>
		<hr>
		
		<table>
			<tr>
				<td>Topic</td>
				<td><input name="topic" value="<%=request.getParameter("id")%>" readonly="true"/></td>
									
			</tr>
			<tr>
				<td></td>
				<td><textarea name="ruletext" rows="10" cols="90"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Add this Rule" /></td>
			</tr>
		</table>
	</form>


</body>
</html>