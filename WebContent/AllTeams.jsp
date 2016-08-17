<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>NHL Teams</title>
	</head>
	<body>
	<h2>NHL Teams</h2>
		<table border="1">
			<tr>
				<th>Team Name</th>
			</tr>
			<c:forEach items="${Teams}" var="team">
				<tr>
					<td>
						<c:url value="./DisplayTeamInfo" var="teamUrl">
							<c:param name="teamID" value="${team.getTeamid()}"/>
							<c:param name="headCoach" value="${team.getStaff1().getFullName()}"/>
							<c:param name="asstCoach" value="${team.getStaff2().getFullName()}"/>
							<c:param name="manager" value="${team.getStaff3().getFullName()}"/>
							<c:param name="trainer" value="${team.getStaff4().getFullName()}"/>							
						</c:url>
						<a href="<c:url value="${teamUrl}"/>">${team.getTeamname()}</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	<h2>Arenas</h2>
		<table border="1">
			<tr>
				<th>Arena Name</th>
				<th>Street Address</th>
			</tr>
			<c:forEach items="${Arenas}" var="arena">
				<tr>
					<td><c:out value="${arena.getArenaname()}"></c:out></td>
					<td><c:out value="${arena.getStreetaddress()}"></c:out></td>
				</tr>
			</c:forEach>
		</table>	
	</body>
</html>