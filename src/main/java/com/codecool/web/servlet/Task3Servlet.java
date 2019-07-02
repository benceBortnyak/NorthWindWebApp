package com.codecool.web.servlet;


import com.codecool.web.dao.database.DataBaseTasksDao;
import com.codecool.web.model.Task3;
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

@WebServlet({"/Task3"})
public class Task3Servlet extends AbstractServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task3> task1List = taskService.Task3Service();
            req.setAttribute("task3", task1List);
            req.getRequestDispatcher("Task3.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("text");

        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task3> task1List = taskService.Task3Service();
            TaskFilterService tfs = new TaskFilterService();
            List<Task3> filteredList = tfs.Task3Filter(task1List, param);
            req.setAttribute("task3", filteredList);
            req.getRequestDispatcher("Task3.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }

    }
}
