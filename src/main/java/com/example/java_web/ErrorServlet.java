package com.example.java_web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ErrorServlet", value = "/ErrorServlet")
public class ErrorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            response.getWriter().println("Kết quả: " + result);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Đã xảy ra lỗi trong quá trình xử lý: " + e.getMessage());
            request.getRequestDispatcher("/session01/Bai5/Bai5.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}