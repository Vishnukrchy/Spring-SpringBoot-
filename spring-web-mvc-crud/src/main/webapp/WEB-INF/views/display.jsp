<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>IMAGE</th>
			<th colspan="2">ACTION</th>
		</tr>
		<a:forEach var="user1" items="${user}">
		<tr>
			<td>${user1.getId()}</td>
			<td>${user1.getName()}</td>
			<td>${user1.getEmail()}</td>
			<td><img alt="userImage" src="data:image/png;base64,${user1.dispImage}"></td>
			<td><a href="delete?id=${user1.getId()}">Delete</a></td>
			<td><a href="update?id=${user1.getId()}">Update</a></td>
		</tr>
		</a:forEach>
	</table>


</body>
</html>