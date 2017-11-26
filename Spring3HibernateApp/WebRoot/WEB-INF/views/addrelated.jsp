<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Related Article</title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function()
	{
		$('.relateurl').hide();
		$('#relateurl').click(function()
		{
			$('.relatearticle').slideUp('slow');
			$('.relateurl').slideDown('slow');
		});
		$('#relatearticle').click(function()
		{
			$('.relateurl').slideUp('slow');
			$('.relatearticle').slideDown('slow');
		});	
	});
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h4>Add Related Article</h4>
	<table>
			<tr bgcolor="#FF4500">
				<td>
					<%if (request.getAttribute("error") != null) {%> Error:<%=request.getAttribute("error")%><%}%>																
				</td>
			</tr>
	</table>
	<div id="content">
		<div>
			<h1>Relate Article/URL</h1>
			<form name="myform" method="post" action="">
				<input type="radio" name="option" id="relatearticle" checked="checked" />
						 <span class="option">Link Article</span> 
				<input type="radio" name="option" id="relateurl" /> <span class="option">Link URL</span>										
			</form>
			<br/>
		</div>
	
	<div class="relatearticle">
	  <div class="detail">Link Article to another Article</div>
		<form name="relatearticle" method="POST" action="/sdnext/relateArticle.html">
				<table>
					<tr>
						<td>Source Article:</td>
						<td><input name="s_article" /></td>
					</tr>
					<tr>
						<td>Destination Article:</td>
						<td><input name="d_article" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Related Article" /></td>
					</tr>
				</table>
			</form>
	</div>
	
	
	<div class="relateurl">
		<div class="detail">Link URL to article</div>			
		<form name="relatearticle" method="POST" action="/sdnext/relateUrl.html">
				<table>
					<tr>
						<td>Source Article:</td>
						<td><input name="s_article" /></td>
					</tr>
					<tr>
						<td>URL:(Add https://)</td>
						<td><input name="url_id" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Relate Url" /></td>
					</tr>
				</table>
			</form>
				
	</div>
	

	</div>
	
<%-- 	<form method="POST" action="/sdnext/relateArticle.html">		
		<table>
			<tr>
				<td>Source Article:</td>
				<td><input name="s_article"/></td>
			</tr>
			<tr>
				<td>Destination Article:</td>
				<td><input name="d_article" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Related Article" /></td>
			</tr>
		</table>
	</form> --%>
	
	
	
</body>
</html>