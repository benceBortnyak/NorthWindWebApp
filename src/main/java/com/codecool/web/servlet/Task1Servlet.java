package com.codecool.web.servlet;

import com.codecool.web.dao.database.DataBaseTasksDao;
import com.codecool.web.model.Task1;
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

@WebServlet({"/Task1"})
public class Task1Servlet extends AbstractServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task1> task1List = taskService.Task1Service();
            req.setAttribute("task1", task1List);
            req.getRequestDispatcher("Task1.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String company;
        String product;

        String param = req.getParameter("text");
        String param2 = req.getParameter("dropdown");

        if (param2.equals("product")) {
            company = "";
            product = param;
        } else if (param2.equals("company")) {
            product = "";
            company = param;
        } else {
            product = "";
            company = "";
        }
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task1> task1List = taskService.Task1Service();
            TaskFilterService tfs = new TaskFilterService();
            List<Task1> filteredTasks = tfs.Task1Filter(task1List, product, company);
            req.setAttribute("task1", filteredTasks);
            req.getRequestDispatcher("Task1.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }

    }
}
