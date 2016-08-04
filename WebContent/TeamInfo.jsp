<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Team Info</title>
	</head>
	<body>
		<h1><c:out value="${teamName}"/></h1>
		<h2><c:out value="Head Coach: ${headCoach}"/></h2>
		<h2><c:out value="Assistant Coach: ${asstCoach}"/></h2>
		<h2><c:out value="Manager: ${manager}"/></h2>
		<h2><c:out value="Trainer: ${trainer}"/></h2>
		<h2>Team Roster</h2>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Position</th>
				<th>Jersey Number</th>
			</tr>
			<c:forEach items="${Roster}" var="roster">
				<tr>
					<td>
						<c:url value="./DisplayPlayerInfo" var="rosterUrl">
							<c:param name="rosterID" value="${roster.getRosterID()}"/>
						</c:url>
						<a href="<c:url value="${rosterUrl}"/>">${roster.getPlayer().getFullName()}</a>
					</td>
					<td><c:out value="${roster.getPosition()}"/></td>
					<td><c:out value="${roster.getJersey()}"/></td>
				</tr>
			</c:forEach>
		</table>
		<h2>Games</h2>
		<table border="1">
			<tr>
				<th>GameDate</th>
				<th>GameTime</th>
				<th>Arena</th>
				<th>Home</th>
				<th>Visitor</th>
				<th>HomeScore</th>
				<th>VisitorScore</th>
				<th>Overtime</th>
				<th>ShootOut</th>
			</tr>
			<c:forEach items="${Games}" var="game">
				<tr>
					<td><c:out value="${game.getGameDate()}"/></td>
					<td><c:out value="${game.getGameTime()}"/></td>
					<td><c:out value="${game.getArena().getArenaName()}"/></td>
					<td><c:out value="${game.getHome().getTeamName()}"/></td>
					<td><c:out value="${game.getVisitor().getTeamName()}"/></td>
					<td><c:out value="${game.getHomeScore()}"/></td>
					<td><c:out value="${game.getVisitorScore()}"/></td>
					<td><c:out value="${game.getOvertime()}"/></td>
					<td><c:out value="${game.getShootOut()}"/></td>
				</tr>
			</c:forEach>
		</table>
		<h2>Scheduled Games</h2>
		<table border="1">
			<tr>
				<th>GameDate</th>
				<th>GameTime</th>
				<th>Arena</th>
				<th>Home</th>
				<th>Visitor</th>
			</tr>
			<c:forEach items="${ScheduledGames}" var="game">
				<tr>
					<td><c:out value="${game.getGameDate()}"/></td>
					<td><c:out value="${game.getGameTime()}"/></td>
					<td><c:out value="${game.getArena().getArenaName()}"/></td>
					<td><c:out value="${game.getHome().getTeamName()}"/></td>
					<td><c:out value="${game.getVisitor().getTeamName()}"/></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>