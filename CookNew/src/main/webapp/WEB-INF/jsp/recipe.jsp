<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="recipe.html" method="POST">
		<table>
			<tr>
				<td><label>Country name:</label></td>
				<td><input type="text" name="countryName" value=""/></td>
			</tr>
			<tr>
				<td><label>Cook time:</label></td>
				<td><input type="text" name="cookTime" value=""/></td>
			</tr>
			<tr>
				<td><label>Recipe name:</label></td>
				<td><input type="text" name="recipeName" value=""/></td>
			</tr>
			<tr>
				<td><input type="submit"/>Submit</td>
			</tr>
		</table>
	</form:form>
	<c:forEach items="${recipes}" var="recipe">
		<p>Recipe: ${recipe.name}</p>
	</c:forEach>
</body>
</html>