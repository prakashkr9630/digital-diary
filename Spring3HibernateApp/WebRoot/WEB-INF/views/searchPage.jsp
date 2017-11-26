<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Article list</title>
</head>
<body>

	<form method="POST" action="/sdnext/searchlist.html">
		<table>

			<tr>
				<td><select name="mode">
						<!-- <option value="title">--Select--</option> -->
						<option value="both">Title or Article</option>
						<option value="title">Title</option>
						<option value="article">Article</option>
						<option value="category">Category</option>
				</select></td>
				<td><input name="searchtext" /></td>
				<td colspan="2"><input type="submit" value="Search Article" /></td>
			</tr>
		</table>
	</form>




</body>
</html>
