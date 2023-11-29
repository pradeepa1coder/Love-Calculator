<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<form:form modelAttribute="u" action="process" method="post">
	Your NAME: <form:input path="fname" name="fname" /><br><br>
    Others NAME: <form:input path="sname" name="sname" /><br><br>
		<br>
		<br>
		<br>
		<form:button>GET OUTPUT</form:button>
	</form:form>

</body>
</html>