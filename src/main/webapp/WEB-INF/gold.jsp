<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<!-- <h1>Ninja Gold</h1> -->
	<h1>Your Gold: <c:out value="${gold}"/></h1>
	<div class = "tasks">
		<div class = "task">
			<h2>Farm</h2>
			<h3>(earns 10-20 gold)</h3>
			<form action="/gold/process/m/farm" method="POST">
				<input type="submit" value="Find Gold!" name="farm">
			</form>
		</div>
		<div class = "task">
			<h2>Cave</h2>
			<h3>(earns 5-10 gold)</h3>
			<form action="/gold/process/m/cave" method="POST">
				<input type="submit" value="Find Gold!" name="cave">
			</form>
		</div>
		<div class = "task">
			<h2>House</h2>
			<h3>(earns 2-5 gold)</h3>
			<form action="/gold/process/m/house" method="POST">
				<input type="submit" value="Find Gold!" name="house">
			</form>
		</div>
		<div class = "task">
			<h2>Casino</h2>
			<h3>(earns/takes 0-50 gold)</h3>
			<form action="/gold/process/m/casino" method="POST">
				<input type="submit" value="Find Gold!" name="casino">
			</form>
		</div>
	</div>
	
	<div class = "log">
		<h1>Activities:</h1>
		<!-- <textarea rows="15" cols="250" readonly> -->
		<div class = "logbox">
			<c:forEach items="${ activities }" var="activity">
				<c:if test="${ activity.color == 'green' }">
					<p class = "green">${ activity.text }</p>
				</c:if>
				<c:if test="${ activity.color == 'red' }">
					<p class = "red">${ activity.text }</p>
				</c:if>
				<c:if test="${ activity.color == 'black' }">
					<p class = "black">${ activity.text }</p>
				</c:if>
			</c:forEach>
		</div>
		<!-- </textarea> -->
	</div>
	<form action="/gold/reset" method="POST">
		<input type="submit" value="Reset Your Life">
	</form>
</body>
</html>