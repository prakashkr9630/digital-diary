<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

td {
	font-family: Arial;
	font-size: 15pt;
}

</style>

</head>
<body>





<table border="1"  >
<a href="<%=request.getContextPath()%>/englishadmin.html">Go Back To main Page</a>

Score : ${score}		
				<tr >
					<td></td>
					<td align="center"> Question</td>
					<td align="center"> Your answer</td>
					<td align="center"> Correct Answer answer</td>
					<td align="center"> Correct ?</td>					
				</tr>
		<c:if test="${!empty result}">
			<c:forEach items="${result}" var="result">
				<tr >
					<td></td>
					<td> <c:out value="${result.question}" /></td>
					<td> <c:out value="${result.useranser}" /></td>
					<td> <c:out value="${result.correctanswer}" /></td>
					<td > <c:out value="${result.iscorrect}" /></td>					
				</tr>
			</c:forEach>
		</c:if>
	</table>





</body>
</html>