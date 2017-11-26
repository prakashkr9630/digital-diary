<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
div {
    border: 1px solid black;
    //background-color: lightblue;
    padding-top: 50px;
    padding-right: 30px;
    padding-bottom: 50px;
    padding-left: 80px;
}

some {
    border: 1px solid red;
    background-color: red;
    padding-top: 10px;
    padding-right: 30px;
    padding-bottom: 10px;
    padding-left: 10px;
}
</style>
<title>Html View for Id: ${article.id}</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<div>
		<some>${article.title}</some>
		<br>
		<br><br><br><br>	
		<%-- ${article.articletext} --%>						
		<pre><c:out value="${article.articletext}"/></pre>		      		 				
	</div>





</body>
</html>