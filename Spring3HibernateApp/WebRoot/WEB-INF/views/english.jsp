<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<style>
.button {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.logout {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
	position: fixed;
	right: 10px;
	top: 5px;
}
</style>
</head>
<body>
	<table>

		<tr>			
			<td><a href="<%=request.getContextPath()%>/englishadmin.html">
					<button class="button">Admin</button>
			</a></td>
			<td><a href="<%=request.getContextPath()%>/englishstudent.html">
					<button class="button">student</button>
			</a></td>
			
		</tr>

	</table>	
	<hr>
</body>
</html>