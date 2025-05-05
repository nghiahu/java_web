package com.example.java_web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegisterTicketServlet", value = "/RegisterTicketServlet")
public class RegisterTicketServlet extends HttpServlet {
    private static final List<StudentTicket> registeredList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("registeredList", registeredList);
        request.getRequestDispatcher("/session01/Bai6.jsp").forward(request, response);
        request.getRequestDispatcher("/session01/Bai7.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("isSubmitted", true);

        String studentName = request.getParameter("studentName");
        String className = request.getParameter("className");
        String type = request.getParameter("type");
        String licensePlate = request.getParameter("licensePlate");

        if (studentName == null || studentName.isEmpty()
                || className == null || className.isEmpty()
                || type == null || type.isEmpty()
                || licensePlate == null || licensePlate.isEmpty()) {
            request.setAttribute("mess", "Đăng ký thất bại. Vui lòng nhập đầy đủ thông tin.");
        } else {
            StudentTicket ticket = new StudentTicket(studentName, className, type, licensePlate);
            registeredList.add(ticket);

            request.setAttribute("mess", "Đăng ký vé xe thành công!");
            request.setAttribute("studentName", studentName);
            request.setAttribute("className", className);
            request.setAttribute("type", type);
            request.setAttribute("licensePlate", licensePlate);
        }
        request.setAttribute("registeredList", registeredList);
        request.getRequestDispatcher("/session01/Bai6.jsp").forward(request, response);
    }
}
