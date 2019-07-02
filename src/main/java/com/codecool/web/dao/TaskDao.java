package com.codecool.web.dao;

import com.codecool.web.model.*;

import java.sql.SQLException;
import java.util.List;

public interface TaskDao {





    public List<Task1> getTask1()throws SQLException;
    public List<Task2> getTask2()throws SQLException;
    public List<Task3> getTask3()throws SQLException;
    public List<Task4> getTask4()throws SQLException;
    public List<Task5> getTask5()throws SQLException;


}
