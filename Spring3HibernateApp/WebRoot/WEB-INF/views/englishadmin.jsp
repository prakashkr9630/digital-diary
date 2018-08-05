<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<table>
	<tr>
		<td>Syntax</td>
		<td><a href="<%=request.getContextPath()%>/addrule.html?id=Syntax">Add Rule</a></td>									
		<td><a href="<%=request.getContextPath()%>/addexample.html?id=Syntax">Add Example</a></td>
	</tr>							
	</table>
<hr>	

<table>
	<tr>
		<td>Noun</td>
		<td><a href="<%=request.getContextPath()%>/addrule.html">Add Rule</a></td>									
		<td><a href="<%=request.getContextPath()%>/addexample.html">Add Example</a></td>	
	</tr>
	</table>
<hr>	

</body>
</html>