<%@ page import="ee.ttu.idu0020.inimene.Inimene" %>
<jsp:useBean id="inimesed" scope="request" type="java.util.List<Inimene>" />
<html>
<body>
<h1>Inimesed</h1>
<br>

<table>
<tr>
    <th>Brand</th><th>Model</th><th>Yield</th><th>Price</th>
</tr>
<%
for(Inimene i: inimesed) {
%>
    <tr>
        <td><%= i.getName1() %></td><td><%= i.getName2() %></td><td><%= i.getNumber() %></td><td><%= i.getBday() %></td>
    </tr>
<%
}
 %>
</table>
</body>
</html>
