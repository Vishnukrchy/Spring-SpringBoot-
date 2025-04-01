<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="d" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<d:form action="updateUser" method="post" modelAttribute="user" enctype="multipart/form-data">
	
			<d:label path="id">ID:</d:label><br>
			<d:input path="id" name="id"/><br>
			
			<d:label path="name">NAME:</d:label><br>
			<d:input path="name" name="name"/><br>
			
			<d:label path="email">Email:</d:label><br>
			<d:input path="email" name="email"/><br>
			
			<d:label path="image">Image:</d:label><br>
			<d:input type="file" path="image" name="image"/><br>
	
			<button type="submit">update</button>
	</d:form>
</body>
</html>