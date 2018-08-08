<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<style type="text/css">
td {
	font-family: times new roman;
	font-size: 15pt;
}
</style>
</head>
<body>
<table align="center">
	<tr>
		<td><a href="<%=request.getContextPath()%>/test.html?id=">Take Test</a></td>
	</tr>

</table>
	<table>
		<tr>
			<td>Syntax</td>
			<td><a href="<%=request.getContextPath()%>/addrule.html?id=Syntax">Add Rule</a></td>
			<td><a href="<%=request.getContextPath()%>/addexample.html?id=Syntax">Add Question</a></td>
			<td><a href="<%=request.getContextPath()%>/test.html?id=Syntax">Test</a></td>
		</tr>

		<c:if test="${!empty rule}">
			<c:forEach items="${rule}" var="rule">
			<c:if test = "${rule.topic == 'Syntax' }">
			
				<tr bgcolor="#1AA904">
					<td></td>
					<td>${rule.id}# <c:out value="${rule.title}" /></td>
				</tr>
				<tr bgcolor="#648060">
					<td># ${rule.topic}</td>
					<td><pre><c:out value="${rule.ruletext}" /></pre></td>
				</tr>
				
				</c:if>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	
	<!-- for Noun -->
	<table>
		<tr>
			<td>Noun</td>
			<td><a href="<%=request.getContextPath()%>/addrule.html?id=Noun">Add Rule</a></td>
			<td><a href="<%=request.getContextPath()%>/addexample.html?id=Noun">Add Question</a></td>
			<td><a href="<%=request.getContextPath()%>/test.html?id=Noun">Test</a></td>
		</tr>

		<c:if test="${!empty rule}">
			<c:forEach items="${rule}" var="rule">
			<c:if test = "${rule.topic== 'Noun' }">
				<tr bgcolor="#1AA904">
					<td></td>
					<td>${rule.id} <c:out value="${rule.title}" /></td>
				</tr>
				<tr bgcolor="#648060">
					<td># ${rule.topic}</td>
					<td><pre><c:out value="${rule.ruletext}" /></pre></td>
				</tr></c:if>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<!-- Noun ends -->
	


	<!-- for Verb -->
	<table>
		<tr>
			<td>Verb</td>
			<td><a href="<%=request.getContextPath()%>/addrule.html?id=Verb">Add Rule</a></td>
			<td><a href="<%=request.getContextPath()%>/addexample.html?id=Verb">Add Question</a></td>
			<td><a href="<%=request.getContextPath()%>/test.html?id=Verb">Test</a></td>
		</tr>

		<c:if test="${!empty rule}">
			<c:forEach items="${rule}" var="rule">
			<c:if test = "${rule.topic== 'Verb' }">
				<tr bgcolor="#1AA904">
					<td></td>
					<td>${rule.id} <c:out value="${rule.title}" /></td>
				</tr>
				<tr bgcolor="#648060">
					<td># ${rule.topic}</td>
					<td><pre><c:out value="${rule.ruletext}" /></pre></td>
				</tr></c:if>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<!-- Verb ends -->
	
		<!-- for Adverb -->
	<table>
		<tr>
			<td>Adverb</td>
			<td><a href="<%=request.getContextPath()%>/addrule.html?id=Adverb">Add Rule</a></td>
			<td><a href="<%=request.getContextPath()%>/addexample.html?id=Adverb">Add Question</a></td>
			<td><a href="<%=request.getContextPath()%>/test.html?id=Adverb">Test</a></td>
		</tr>

		<c:if test="${!empty rule}">
			<c:forEach items="${rule}" var="rule">
			<c:if test = "${rule.topic== 'Adverb' }">
				<tr bgcolor="#1AA904">
					<td></td>
					<td>${rule.id} <c:out value="${rule.title}" /></td>
				</tr>
				<tr bgcolor="#648060">
					<td># ${rule.topic}</td>
					<td><pre><c:out value="${rule.ruletext}" /></pre></td>
				</tr></c:if>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<!-- Adverb ends -->
	
		<!-- for Adjective -->
	<table>
		<tr>
			<td>Adjective</td>
			<td><a href="<%=request.getContextPath()%>/addrule.html?id=Adjective">Add Rule</a></td>
			<td><a href="<%=request.getContextPath()%>/addexample.html?id=Adjective">Add Question</a></td>
			<td><a href="<%=request.getContextPath()%>/test.html?id=Adjective">Test</a></td>
		</tr>

		<c:if test="${!empty rule}">
			<c:forEach items="${rule}" var="rule">
			<c:if test = "${rule.topic== 'Adjective' }">
				<tr bgcolor="#1AA904">
					<td></td>
					<td>${rule.id} <c:out value="${rule.title}" /></td>
				</tr>
				<tr bgcolor="#648060">
					<td># ${rule.topic}</td>
					<td><pre><c:out value="${rule.ruletext}" /></pre></td>
				</tr></c:if>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<!-- Adjective ends -->
	
		<!-- for Preposition -->
	<table>
		<tr>
			<td>Preposition</td>
			<td><a href="<%=request.getContextPath()%>/addrule.html?id=Preposition">Add Rule</a></td>
			<td><a href="<%=request.getContextPath()%>/addexample.html?id=Preposition">Add Question</a></td>
			<td><a href="<%=request.getContextPath()%>/test.html?id=Preposition">Test</a></td>
		</tr>

		<c:if test="${!empty rule}">
			<c:forEach items="${rule}" var="rule">
			<c:if test = "${rule.topic== 'Preposition' }">
				<tr bgcolor="#1AA904">
					<td></td>
					<td>${rule.id} <c:out value="${rule.title}" /></td>
				</tr>
				<tr bgcolor="#648060">
					<td># ${rule.topic}</td>
					<td><pre><c:out value="${rule.ruletext}" /></pre></td>
				</tr></c:if>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<!-- Preposition ends -->
	
		<!-- for Article -->
	<table>
		<tr>
			<td>Article</td>
			<td><a href="<%=request.getContextPath()%>/addrule.html?id=Article">Add Rule</a></td>
			<td><a href="<%=request.getContextPath()%>/addexample.html?id=Article">Add Question</a></td>
			<td><a href="<%=request.getContextPath()%>/test.html?id=Article">Test</a></td>
		</tr>

		<c:if test="${!empty rule}">
			<c:forEach items="${rule}" var="rule">
			<c:if test = "${rule.topic== 'Article' }">
				<tr bgcolor="#1AA904">
					<td></td>
					<td>${rule.id} <c:out value="${rule.title}" /></td>
				</tr>
				<tr bgcolor="#648060">
					<td># ${rule.topic}</td>
					<td><pre><c:out value="${rule.ruletext}" /></pre></td>
				</tr></c:if>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<!-- Article ends -->
	
		<!-- for Mislenious -->
	<table>
		<tr>
			<td>Miscellaneous</td>
			<td><a href="<%=request.getContextPath()%>/addrule.html?id=Miscellaneous">Add Rule</a></td>
			<td><a href="<%=request.getContextPath()%>/addexample.html?id=Miscellaneous">Add Question</a></td>
			<td><a href="<%=request.getContextPath()%>/test.html?id=Miscellaneous">Test</a></td>			
		</tr>

		<c:if test="${!empty rule}">
			<c:forEach items="${rule}" var="rule">
			<c:if test = "${rule.topic== 'Miscellaneous' }">
				<tr bgcolor="#1AA904">
					<td></td>
					<td>${rule.id} <c:out value="${rule.title}" /></td>
				</tr>
				<tr bgcolor="#648060">
					<td># ${rule.topic}</td>
					<td><pre><c:out value="${rule.ruletext}" /></pre></td>
				</tr></c:if>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<!-- Miscellaneous ends -->

</body>
</html>