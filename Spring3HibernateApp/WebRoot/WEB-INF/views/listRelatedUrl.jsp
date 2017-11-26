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

		
		<c:if test="${!empty relatedurl}">
		<h1><b>Related Url</b></h1>
		
	<table align="left" border="1">
		<tr>
			<!-- <th>Article ID</th> -->			
			<th>Url</th>			
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${relatedurl}" var="relurl">
			<tr>
				<%-- <td><c:out value="${relurl.id}"/></td> --%>				
				<td><c:out value="${relurl.url}"/></td>								
				<%-- <td align="center"><a href="${relurl.url}" target="_blank">View</a></td> --%>
				<td align="center"><a href="openUrl.html?url=${relurl.url}" target="_blank">View</a></td>				
			</tr>			
		</c:forEach>
	</table>
</c:if>




</body>
</html>