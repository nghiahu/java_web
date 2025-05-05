<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 05/05/2025
  Time: 11:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${isSubmitted}">
    <h2>${mess}</h2>
</c:if>
<form action="RegisterTicketServlet" method="post">
    <p ></p>
    <p>Họ và tên:</p>
    <input type="text" name="studentName">
    <p>Lớp:</p>
    <input type="text" name="className"> <br>
    <label>Loại xe:</label>
    <select name="type">
        <option value="Xe đạp">Xe đạp</option>
        <option value="Xe máy">Xe máy</option>
    </select>
    <p>Biển số xe:</p>
    <input type="text" name="licensePlate">
    <input type="submit" value="Đăng ký">
</form>
<%java.util.List<com.example.java_web.StudentTicket> list =
        (java.util.List<com.example.java_web.StudentTicket>) request.getAttribute("registeredList");
if (list != null && !list.isEmpty()) {
%>
<h3>Danh sách học sinh đã đăng ký:</h3>
<table border="1" cellpadding="5">
    <tr>
        <th>Họ và tên</th>
        <th>Lớp</th>
        <th>Loại xe</th>
        <th>Biển số xe</th>
    </tr>
    <%
        for (com.example.java_web.StudentTicket ticket : list) {
    %>
    <tr>
        <td><%= ticket.getStudentName() %></td>
        <td><%= ticket.getClassName() %></td>
        <td><%= ticket.getType() %></td>
        <td><%= ticket.getLicensePlate() %></td>
    </tr>
    <%
        }
    %>
</table>
<%
} else {
%>
<p>Chưa có học sinh nào đăng ký.</p>
<%
    }
%>
</body>
</html>
