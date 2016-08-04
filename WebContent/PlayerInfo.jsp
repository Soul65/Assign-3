<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Player Info</title>
	</head>
	<body>
	<h2>Player info for ${roster.getPlayer().getFullName()}</h2>
		<table border="1">
			<tr>
				<th>Jersey Number</th>
				<th>Last Name</th>
				<th>First Name</th>
				<th>Position</th>
				<th>Height</th>
				<th>Weight</th>
				<th>Hometown City</th>
				<th>State/Province</th>
				<th>Country</th>
				<th>School</th>
			</tr>
			<tr>
				<td>${roster.getJersey()}</td>
				<td>${roster.getPlayer().getLastName()}</td>
				<td>${roster.getPlayer().getFirstName()}</td>
				<td>${roster.getPosition()}</td>
				<td>${roster.getPlayer().getHeight()}</td>
				<td>${roster.getPlayer().getWeight()}</td>
				<td>${roster.getPlayer().getCity()}</td>
				<td>${roster.getPlayer().getStateProvince()}</td>
				<td>${roster.getPlayer().getCountry()}</td>
				<td>${roster.getPlayer().getSchool()}</td>
			</tr>
		</table>	
	</body>
</html>