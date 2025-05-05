<%@ page import="com.example.java_web.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>To-Do List</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            background: #f4f6f8;
        }
        .nav {
            background: #1976d2;
            padding: 12px 20px;
        }
        .nav a {
            color: white;
            margin-right: 15px;
            text-decoration: none;
            font-weight: bold;
        }
        .container {
            max-width: 800px;
            margin: 30px auto;
            background: white;
            padding: 20px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .add-form {
            margin-bottom: 20px;
        }
        .add-form input[type="text"] {
            padding: 10px;
            width: 70%;
            border: 1px solid #ccc;
            border-radius: 6px;
            margin-right: 10px;
        }
        .add-form input[type="submit"] {
            padding: 10px 20px;
            background-color: #43a047;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th {
            background: #1976d2;
            color: white;
            padding: 12px;
            text-align: left;
        }
        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .status-doing {
            color: #f57c00;
            font-weight: bold;
        }
        .status-completed {
            color: #388e3c;
            font-weight: bold;
        }
        a.action-link {
            color: #1976d2;
            text-decoration: underline;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="nav">
    <a href="#">Trang chủ</a>
    <a href="#">Liên hệ</a>
    <a href="#">Giỏ hàng</a>
    <a href="#">Tài khoản</a>
</div>

<div class="container">
    <div class="add-form">
        <form action="ToDoServlet" method="post">
            <input type="text" name="newJob" placeholder="Nhập công việc mới">
            <input type="submit" value="Thêm">
        </form>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Công việc</th>
            <th>Trạng thái</th>
            <th>Hành động</th>
        </tr>
        <%
            ArrayList<String> tasks = (ArrayList<String>) request.getAttribute("tasks");
            ArrayList<String> statuses = (ArrayList<String>) request.getAttribute("status");
            if (tasks != null && !tasks.isEmpty()) {
                for (int i = 0; i < tasks.size(); i++) {
                    String status = statuses.get(i);
                    String statusClass = "status-doing";
                    if ("Completed".equalsIgnoreCase(status)) {
                        statusClass = "status-completed";
                    }
        %>
        <tr>
            <td><%= i + 1 %></td>
            <td><%= tasks.get(i) %></td>
            <td class="<%= statusClass %>"><%= status %></td>
            <td><a class="action-link" href="ToDoServlet?taskId=<%= i %>">Chuyển trạng thái</a></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>
</body>
</html>
