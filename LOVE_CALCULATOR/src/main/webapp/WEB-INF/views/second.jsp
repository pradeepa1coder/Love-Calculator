<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RESULT PAGE</title>
</head>
<body>
	<div align="center">
		<h1>Hii ${fname} , Results Are Predicted Below :</h1>

		<h2>${fname}
			and ${sname} will become <u>${result}</u> !!!
		</h2>

		<h3>If you wish to receive the results via email, please click on
			the "Send To Email" button.</h3>


		<form action="takeemail" method="post">
			<button type="submit">Send To Email</button>
		</form>


	</div>

	<br>
	<h4 align="left">
		Check with others <a href="takenames" style="color: green;">CLICK</a>
	</h4>

</body>
</html>