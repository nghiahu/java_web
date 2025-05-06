package com.example.java_web;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
    private ArrayList<Task> taskList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskId = request.getParameter("taskId");
        if (taskId != null && !taskId.isEmpty()) {
            int index = Integer.parseInt(taskId);
            if (index >= 0 && index < taskList.size()) {
                taskList.get(index).setCompleted(true);
            }
        }
        request.setAttribute("tasks", taskList);
        request.getRequestDispatcher("/session01/Bai8.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String newTask = request.getParameter("newJob");
        if (newTask != null && !newTask.isEmpty()) {
            taskList.add(new Task(newTask));
        }
        request.setAttribute("tasks", taskList);
        request.getRequestDispatcher("/session01/Bai8.jsp").forward(request, response);
    }
}