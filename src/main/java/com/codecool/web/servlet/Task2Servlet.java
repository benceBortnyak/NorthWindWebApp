package com.codecool.web.servlet;

import com.codecool.web.dao.database.DataBaseTasksDao;
import com.codecool.web.model.Task1;
import com.codecool.web.model.Task2;
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

@WebServlet({"/Task2"})
public class Task2Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try(Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task2> task2List = taskService.Task2Service();
            req.setAttribute("task2",task2List);
            req.getRequestDispatcher("Task2.jsp").forward(req,resp);
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ServiceException ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer products;
        String product;

        String param = req.getParameter("text");
        String param2 = req.getParameter("dropdown");

        if (param2.equals("product")){
            products = 0;
            product = param;
        }else if (param2.equals("products")){
            try {
                products = Integer.valueOf(param);
            }catch (NumberFormatException ex ){
                products = 0;
            }
            product = "";
        }else {
            products = 0;
            product = "";
        }

        resp.setContentType("text/html;charset=UTF-8");
        try(Connection connection = getConnection(req.getServletContext())) {
            DataBaseTasksDao taskDao = new DataBaseTasksDao(connection);
            TaskService taskService = new SimpleTaskService(taskDao);
            List<Task2> task2List = taskService.Task2Service();
            TaskFilterService tfs = new TaskFilterService();
            List<Task2> filteredTasks =  tfs.Task2Filter(task2List,product,products);
            req.setAttribute("task2",filteredTasks);
            req.getRequestDispatcher("Task2.jsp").forward(req,resp);
        }catch (SQLException ex){
            ex.printStackTrace();
        }catch (ServiceException ex){
            ex.printStackTrace();
        }

    }
}
