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
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- <script> -->
<script type="text/javascript">
    $(document).ready(function(){
    	
        $("input[type='radio']").click(function(){
        	var radioValue = $("input[id='answer']:checked").val();
            if(radioValue){
                alert("selected: " + radioValue);
            }
            
            
        });
        
    });
</script>


</head>
<body>

<table>
		

		<c:if test="${!empty questions}">
			<c:forEach items="${questions}" var="questions">					
				<tr bgcolor="#1AA904" >
					<td></td>
					<td>${questions.id}# <c:out value="${questions.question}" /></td>
				</tr>
				
						
				<tr >
					<td></td>					
				<!-- <td>
					<select name="useranswer" id="answer">
						<option value="1">Option 1</option>
						<option value="2">Option 2</option>
						<option value="3">Option 3</option>
						<option value="4">Option 4</option>
						<option value="5">Option 5</option>
					</select>
					</td> -->					
				<td>					
					<input type="radio" id="answer" name="${questions.id}" value="1"> Option 1<br>
					<input type="radio" id="answer" name="${questions.id}" value="2"> Option 2<br>
					<input type="radio" id="answer" name="${questions.id}" value="3"> Option 3<br>
					<input type="radio" id="answer" name="${questions.id}" value="4"> Option 4<br>
					<input type="radio" id="answer" name="${questions.id}" value="5"> Option 5<br>					
				</td>
					<td></td>					
					<%-- <td><button onclick="myFunction('${questions.correctoption}')">check Answer</button></td> --%>
					<!-- <td><input type="button" onclick=""            value="Get Value"></td> -->
				</tr>
			</c:forEach>
		</c:if>
	</table>


</body>
</html>