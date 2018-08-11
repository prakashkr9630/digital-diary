<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Your skill</title>
<style type="text/css">
td {
	font-family: times new roman;
	font-size: 20pt;
}

input[type="radio"]{
  width: 30px; 
  height: 30px; 
}
input[type="text"]{
  width: 1000px; 
  height: 30px; 
}
</style>

</head>
<body>

<table>
		
		
		<form name="relatearticle" method="POST" action="/sdnext/validateanswerandnext.html">
		
	<c:if test="${!empty questions}">
				<tr bgcolor="#1AA904" >
					<td>${number}.</td>					
					<td><input type="hidden"  name="qnumber" value="${questions.id}"/>${questions.question}</td>
					<td><input type="hidden"  name="quest" value="${questions.question}"/></td>
					<td><input type="hidden"  name="currectoption" value="${questions.correctoption}"/></td>
					
				</tr>				
				<c:if test = "${fn:length(questions.correctoption) < 2 }">
				
				<%-- </c:if> --%>		
				<tr >
				<td></td>					
				<td>					
					<input type="radio"  name="useranswer" value="1"> Option 1<br>
					<input type="radio"  name="useranswer" value="2"> Option 2<br>
					<input type="radio"  name="useranswer" value="3"> Option 3<br>
					<input type="radio"  name="useranswer" value="4"> Option 4<br>
					<input type="radio"  name="useranswer" value="5"> Option 5<br>					
				</td>
					<td></td>										
				</tr>
				</c:if>
				<c:if test = "${fn:length(questions.correctoption) > 1 }">
				
				<%-- </c:if> --%>		
				<tr >
				<td></td>					
				<td>					
					<input type="text"  name="useranswer"> <br>
										
				</td>
					<td></td>										
				</tr>
				</c:if>
					<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Submit and Next" /></td>
			</tr>
				
			
		</c:if>
		
	</form>
		
		
		
		
		
	</table>


</body>
</html>