<%@ page import="ee.ttu.idu0020.inimene.Inimene"%>
<jsp:useBean id="inimesed" scope="request" type="java.util.List<Inimene>" />
<html>
<style>
body {
	font-family: Verdana, sans-serif;
}

h1 {
	font-size: 18px;
}

table {
	border-collapse: collapse;
}

tr#header {
	background-color: lightblue;
	font-weight: bold;
}

td {
	border: 1px solid black;
	text-align: left;
	padding: 0px 6px 0px 6px;
}

a {
	color: #00a3da;
	text-decoration: none;
}

a:hover {
	color: #bc0a0a;
}
</style>
<body>
	<h1>Tabel: Inimesed</h1>
	<br>
	<a href="log.txt">log.txt</a>
	<br>

	<table>
		<tr id="header">
			<td>Number</td>
			<td>Nimi</td>
			<td>Perekonnanimi</td>
			<td>Sünni aeg</td>
			<td>Muuda andmed</td>
		</tr>
		<%
			for (Inimene i : inimesed) {
		%>
		<tr>
			<td><%=i.getNumber() == null ? "" : i.getNumber()%></td>
			<td><%=i.getName1()%></td>
			<td><%=i.getName2()%></td>
			<td><%=i.getBday() == null ? "" : i.getBday()%></td>
			<td><a href="update?id=<%=i.getId()%>">Muuda</a> | <a href="delete?id=<%=i.getId()%>">Kustuta!</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<a href="add"><b>Lisa uue inimese...</b></a>
</body>
</html>
