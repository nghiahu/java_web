package com.example.java_web;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UseServlet", value = "/UseServlet")
public class UseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = "Nguyễn Văn A";
        int age = 20;
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.getRequestDispatcher("/session01/Bai3/Bai3.jsp").forward(request, response);
    }

    public void destroy() {
    }
}