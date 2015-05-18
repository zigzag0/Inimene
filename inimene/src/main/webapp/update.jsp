<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="ee.ttu.idu0020.inimene.Inimene"%>
<jsp:useBean id="inimene" scope="request"
	type="ee.ttu.idu0020.inimene.Inimene" />
<jsp:useBean id="errors" scope="request" type="java.util.Map" />
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
	margin-bottom: 10px;
}

td {
	text-align: left;
	padding: 4px 6px 4px 6px;
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
	<h1>
		<a href=".">Tagasi?</a>
	</h1>
	<br> Muuda inimese andmed:
	<br>

	<form method="post">
		<input type="hidden" name="id" value="<%=inimene.getId()%>" />
		<table>
			<tr>
				<td>Number:</td>
				<td><input type="text" name="inimene_number"
					value="<%=inimene.getNumber() == null ? "" : inimene.getNumber()%>" />
					<%
						if (errors.containsKey("inimene_number")) {
					%><font color="red"><%=errors.get("inimene_number")%></font> <%
 	}
 %></td>
			</tr>
			<tr>
				<td>Ees nimi:</td>
				<td><input type="text" name="inimene_name1"
					value="<%=inimene.getName1()%>" /> <%
 	if (errors.containsKey("inimene_name1")) {
 %><font color="red"><%=errors.get("inimene_name1")%></font> <%
 	}
 %></td>
			</tr>
			<tr>
				<td>Perekonna nimi:</td>
				<td><input type="text" name="inimene_name2"
					value="<%=inimene.getName2()%>" /> <%
 	if (errors.containsKey("inimene_name2")) {
 %><font color="red"><%=errors.get("inimene_name2")%></font> <%
 	}
 %></td>
			</tr>

			<tr>
				<td>Sünniaeg:</td>
				<td><input type="text" name="inimene_bday"
					value="<%=inimene.getBday() == null ? "" : new SimpleDateFormat(
					"yyyy-MM-dd").format(inimene.getBday())%>" />
					<%
						if (errors.containsKey("inimene_bday")) {
					%><font color="red"><%=errors.get("inimene_bday")%></font> <%
 	}
 %></td>
			</tr>
		</table>
		<input type="submit" value="Salvesta andmed..." />
	</form>

</body>
</html>