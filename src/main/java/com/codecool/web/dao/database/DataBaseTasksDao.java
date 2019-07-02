package com.codecool.web.dao.database;

import com.codecool.web.dao.TaskDao;
import com.codecool.web.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBaseTasksDao extends AbstractDao implements TaskDao{

    public DataBaseTasksDao(Connection connection) {
        super(connection);
    }


    @Override
    public List<Task1> getTask1() throws SQLException {
        String sqlString = "SELECT Product_name AS Product, company_name AS Company FROM Products\n" +
            "INNER JOIN suppliers\n" +
            "ON Products.supplier_id = suppliers.supplier_id\n" +
            "ORDER BY Product ASC, Company ASC";
        List<Task1> resultList = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String product = resultSet.getString("Product");
                    String company = resultSet.getString("Company");
                    Task1 task1 = new Task1(product, company);
                    resultList.add(task1);
                }
            }
        }
        return resultList;
    }
    @Override
    public List<Task2> getTask2() throws SQLException{
        List<Task2> resultList = new ArrayList<>();
        String sqlString = "select company_name AS Company ,count(products.supplier_id) as number_of_products FROM products\n" +
        "inner join suppliers\n"+
        "on products.supplier_id = suppliers.supplier_id\n"+
        "group by suppliers.company_name\n"+
        "order by number_of_products desc , company asc";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlString)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    Integer numOfProducts = resultSet.getInt("number_of_products");
                    String company = resultSet.getString("company");
                    Task2 task2 = new Task2(company,numOfProducts);
                    resultList.add(task2);
                }
            }

        }
        return resultList;
    }
    @Override
    public List<Task3> getTask3()throws SQLException{
        List<Task3> resultList = new ArrayList<>();
        String sqlString = "select company_name AS Company ,count(products.supplier_id) as number_of_products FROM products\n" +
        "inner join suppliers\n"+
        "on products.supplier_id = suppliers.supplier_id\n"+
        "group by suppliers.company_name\n"+
        "having count(products.supplier_id)=5\n"+
        "order by number_of_products desc , company asc";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlString)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    String company = resultSet.getString("company");
                    Task3 task3 = new Task3(company);
                    resultList.add(task3);
                }
            }
        }
        return resultList;
    }
    @Override
    public List<Task4> getTask4()throws SQLException {
        List<Task4> resultList = new ArrayList<>();
        String sqlString = "SELECT company_name, ARRAY_AGG(orders.order_id) FROM customers\n" +
            "LEFT JOIN orders\n" +
            "ON customers.customer_id = orders.customer_id\n" +
            "GROUP BY company_name\n" +
            "ORDER BY company_name ASC";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String companyName = resultSet.getString("company_name");
                    Array a = resultSet.getArray("array_agg");
                    Short[] javaArray = (Short[])a.getArray();
                    List<Short> convertedList = Arrays.asList(javaArray);
                    Task4 task4 = new Task4(companyName,convertedList);
                    resultList.add(task4);
                }
            }
        }
        return resultList;
    }
    @Override
    public List<Task5> getTask5()throws SQLException{
        List<Task5> resultList = new ArrayList<>();
        String sqlString = "SELECT * FROM(\n" +
            "SELECT DISTINCT ON (company_name) company_name AS company, product_name AS product, unit_price AS price FROM suppliers\n" +
            "INNER JOIN products ON products.supplier_id = suppliers.supplier_id\n" +
            "ORDER BY company_name, price DESC ) As foo\n" +
            "ORDER BY price DESC, product, company";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlString)){
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    String company = resultSet.getString("company");
                    String product = resultSet.getString("product");
                    Float price = resultSet.getFloat("price");
                    Task5 task5 = new Task5(company,product,price);
                    resultList.add(task5);
                }
            }
        }
        return resultList;
    }
}
