package com.codecool.web.servlet;

import com.codecool.web.dao.database.DataBaseTasksDao;
import com.codecool.web.model.Task5;
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

@WebServlet({"/Task5"})
public class Task5Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task5> task5List = taskService.Task5Service();
            req.setAttribute("task5", task5List);
            req.getRequestDispatcher("Task5.jsp").forward(req, resp);
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
        Float price;

        String param1 = req.getParameter("text");
        String param2 = req.getParameter("dropdown");

        if (param2.equals("company")) {
            company = param1;
            product = "";
            price = Float.valueOf("0");

        } else if (param2.equals("product")) {
            company = "";
            product = param1;
            price = Float.valueOf("0");
        } else if (param2.equals("price")) {
            company = "";
            product = "";
            try {
                price = Float.valueOf(param1);
            } catch (NumberFormatException ex) {
                price = Float.valueOf("0");
            }
        } else {
            company = "";
            product = "";
            price = Float.valueOf("0");
        }
        resp.setContentType("text/html;charset=UTF-8");
        try (Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task5> task5List = taskService.Task5Service();
            TaskFilterService tfs = new TaskFilterService();
            List<Task5> filteredList = tfs.task5Filter(task5List, company, product, price);
            req.setAttribute("task5", filteredList);
            req.getRequestDispatcher("Task5.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ServiceException ex) {
            ex.printStackTrace();
        }

    }
}
