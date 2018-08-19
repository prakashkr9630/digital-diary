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
	font-family: times new roman;
	font-size: 20pt;
}
qa{
font-size: 40px;
 background-color: teal;
}

qp{
font-size: 25px;
 background-color: red;
}
</STYLE>
</head>

	<c:if test="${!empty status}">
	<qa> Example saved successfully &#10004; 
	<%-- <a href="<%=request.getContextPath()%>/englishadmin.html">Go Back to Rules Page</a> --%>	
	</c:if>
	
	<c:if test="${!empty error}">
	<qp>	${error}</qp>
	</c:if>


<b>Example:  [{"question":"this is question","correctoption":"A", "comment":"some comment"}]   (format before submitting)</b>
<a href="<%=request.getContextPath()%>/englishadmin.html">Go Back To main Page</a>
<body>
	<form name="relatearticle" method="POST" action="/sdnext/addexamplefortopic.html">
		

		<p>
			<font size="10"><%=request.getParameter("id")%></font>						
		</p>
		<hr>
		
		<table>
			<tr>
				<td></td>
				<td>Question sets</td>
				<td><input type="hidden" name="topic" value="<%=request.getParameter("id")%>" /></td>
				<%-- <td><input  name="topic" value="<%=request.getParameter("id")%>" /></td> --%>									
			</tr>
			
			<tr>
				<td></td>
				<td><textarea name="questionset" rows="5" cols="90"   ></textarea></td>
			</tr>				
			
			<tr>							
				<td colspan="2"><input type="submit" value="Add these Question" /></td>
			</tr>
		</table>
	</form>


</body>
</html>