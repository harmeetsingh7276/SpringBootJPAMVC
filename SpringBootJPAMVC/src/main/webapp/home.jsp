<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="addAlien">
		<input type="text" name="aid"/>
		<input type="text" name="aname"/>
		<input type="submit" value="Submit"/>
	</form>
	GET Information
	
	<form action="getAlien">
		<input type="text" name="aid"/>
		<input type="submit" value="Submit"/>
	</form>
	Delete Information
	<form action="deleteAlien">
		<input type="text" name="aid"/>
		<input type="submit" value="Submit"/>
	</form>
	<form action="updateAlien">
		<input type="text" name="aid"/>
		<input type="text" name="aname"/>
		<input type="submit" value="Submit"/>
	</form>
	
</body>
</html>