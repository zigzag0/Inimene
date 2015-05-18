<%@ page import="ee.ttu.idu0020.inimene.Inimene" %>
<jsp:useBean id="inimesed" scope="request" type="java.util.List<Inimene>" />
<html>
<body>
<h1>Inimesed</h1>
<br>

<table>
<tr>
    <th>Number</th><th>Nimi</th><th>Perekonnanimi</th><th>Sunniaeg</th>
</tr>
<%
for(Inimene i: inimesed) {
%>
    <tr>
        <td><%= i.getNumber() %></td><td><%= i.getName1() %></td><td><%= i.getName2() %></td><td><%= i.getBday() %></td>
    </tr>
<%
}
 %>
</table>
</body>
</html>
