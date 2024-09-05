<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add New Car!</h1>
<form action="InsertCar" method="post">
	CAR NAME: <input type="text" name="c_name"><br><br>
	CAR MODEL: <input type="text" name="c_model"><br><br>
	CAR COLOR: <input type="text" name="c_color"><br><br>
	CAR PRICE: <input type="text" name="c_price"><br><br>
	<input type="submit" value="Submit">
</form>
</body>
</html>