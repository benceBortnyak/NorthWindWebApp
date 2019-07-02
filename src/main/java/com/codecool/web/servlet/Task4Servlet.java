package com.codecool.web.servlet;


import com.codecool.web.dao.database.DataBaseTasksDao;
import com.codecool.web.model.Task4;
import com.codecool.web.service.TaskFilterService;
import com.codecool.web.service.TaskService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleTaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/Task4"})
public class Task4Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task4> task1List = taskService.Task4Service();
            req.setAttribute("task4", task1List);
            req.getRequestDispatcher("Task4.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Short orderId;
        String company;

        String param1 = req.getParameter("text");
        String param2 = req.getParameter("dropdown");

        if (param2.equals("company")) {
            orderId = 0;
            company = param1;
        } else if (param2.equals("orderId")) {
            try {
                orderId = Short.valueOf(param1);
            } catch (NumberFormatException ex) {
                orderId = 0;
            }
            company = "";
        } else {
            orderId = 0;
            company = "";
        }

        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task4> task4List = taskService.Task4Service();
            TaskFilterService tfs = new TaskFilterService();
            List<Task4> filteredTaskList = tfs.task4Filter(task4List, orderId, company);
            req.setAttribute("task4", filteredTaskList);
            req.getRequestDispatcher("Task4.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }
    }
}
