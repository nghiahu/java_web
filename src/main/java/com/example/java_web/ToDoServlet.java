package com.example.java_web;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArrayList<String> tasks = new ArrayList<>();
    private ArrayList<String> status = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        if (taskId != null && !taskId.isEmpty()) {
            int index = Integer.parseInt(taskId);
            if (index >= 0 && index < status.size()) {
                status.set(index, "Completed");
            }
        }
        request.setAttribute("tasks", tasks);
        request.setAttribute("status", status);
        request.getRequestDispatcher("/session01/Bai8.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String newTask = request.getParameter("newJob");
        if (newTask != null && !newTask.isEmpty()) {
            tasks.add(newTask);
            status.add("Doing");
        }
        request.setAttribute("tasks", tasks);
        request.setAttribute("status", status);
        request.getRequestDispatcher("/session01/Bai8.jsp").forward(request, response);
    }
}